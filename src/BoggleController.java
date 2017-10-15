import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * class BoggleController
 */
public class BoggleController {

    private BoggleView view;

    private List<String> allWords;

    private List<String> diceWords;

    private List<String> gridList = new ArrayList<String>();

    private DiceGenerate diceGenerate;

    private static String allWordsFilename = "resources/OpenEnglishWordList.txt";
    private static String diceWordsFilename = "resources/DiceWords.txt";

    private boolean gameRunning;

    private GameTimer timer;

    private int totalTime = 180;

    private boolean firstGame = true;

    private int score;

    private List<String> guessWordList;

    private int gridSide = 4;

    public BoggleController(BoggleView view) {
        this.view = view;
        allWords = ReadDataUtils.readData(allWordsFilename);
        diceWords = ReadDataUtils.readData(diceWordsFilename);
        diceGenerate = new DiceGenerate(diceWords);
        initListener();
        timer = new GameTimer();
        guessWordList = new ArrayList<String>();
    }

    /**
     * init listener of all components
     */
    private void initListener() {
        //submit button handler
        view.addSubmitButtonHandler(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                view.hideTip();
                String text = view.getTextFieldString();
                if(!guessWordList.contains(text)){
                    if (!allWords.contains(text.toLowerCase()) || !containsWords(text.toUpperCase())) {
                        view.showTip();
                    }else {
                        view.appendTextToTextArea(text);
                        guessWordList.add(text);
                        score += text.length();
                        view.setScore(score);
                    }
                }
                view.setTextField("");
                if(gameRunning){
                    view.setDicePaneDisable(false);
                    view.setDicePaneAvaliable(true);
                }

            }
        });

        view.addResetGameButtonHandler(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println(view.getChoichBoxValue());

                if("4 * 4".equals(view.getChoichBoxValue())){
                    gridList = diceGenerate.shakeDice(16);
                    view.initDiceGrid(4);
                    gridSide = 4;
                }else {
                    gridList = diceGenerate.shakeDice(25);
                    view.initDiceGrid(5);
                    gridSide = 5;
                }
                addDiceButtonAction();
                view.setGridDiceValue(gridList);
                view.init();
                timer.restart();
                if(firstGame){
                    new Thread(timer).start();
                    firstGame = false;
                }
                score = 0;
                guessWordList = new ArrayList<String>();
            }
        });
    }

    /**
     * check the text whether in gridlist
     *
     * @param text the text
     * @return true if contains
     */
    private boolean containsWords(String text) {
        for (int i = 0; i < text.length(); i++) {
            String temp = String.valueOf(text.charAt(i));
            if (!gridList.contains(temp)) {
                return false;
            }
        }
        return true;
    }

    private void addDiceButtonAction(){
        view.addDiceGridHandler(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(gameRunning){
                    DiceButton button = (DiceButton) event.getSource();
                    view.appendToTextField(button.getText());
                    button.setAvailable(false);
                    view.setDicePaneDisable(true);

                    int row = button.getRow();
                    int column = button.getColumn();
                    for (int i = row - 1; i <= row + 1; i++) {
                        if (i >= 0 && i < gridSide) {
                            for (int j = column - 1; j <= column + 1; j++) {
                                if (j >= 0 && j < gridSide) {
                                    view.enabledDiceGridButton(i,j);
                                }
                            }
                        }
                    }
                }
            }
        });
    }

    /**
     * Game timer
     */
    private class GameTimer implements Runnable{

        /**
         * Restart game
         */
        public void restart(){
            totalTime = 180;
        }

        @Override
        public void run() {
            gameRunning = true;
            while(totalTime >0){
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        view.setTime(totalTime/60 +":"+ String.format("%02d", (totalTime%60)));
                    }
                });
                totalTime --;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Sleep error");
                }
                //if time over
                if(!gameRunning) {
                    break;
                }
            }
            gameRunning = false;
            firstGame = true;
            if(totalTime <= 0){
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        view.stopGame();
                    }
                });

            }
        }
    }
}
