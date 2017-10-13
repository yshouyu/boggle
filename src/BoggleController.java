import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.List;

/**
 * class BoggleController
 */
public class BoggleController {

    private BoggleModel model;

    private BoggleView view;

    private List<String> allWords;

    private List<String> diceWords;

    private DiceGenerate diceGenerate;

    private static String allWordsFilename = "resources/AllWords.txt";
    private static String diceWordsFilename = "resources/DiceWords.txt";

    public BoggleController(BoggleView view,BoggleModel model) {
        this.model = model;
        this.view = view;

        allWords = ReadDataUtils.readData(allWordsFilename);
        diceWords = ReadDataUtils.readData(diceWordsFilename);
        diceGenerate = new DiceGenerate(diceWords);
        initListener();
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
                view.appendTextToTextArea(text);
                if(!allWords.contains(text.toUpperCase())){
                    view.showTip();
                }
            }
        });

        view.addResetGameButtonHandler(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                List<String> gridList = diceGenerate.shakeDice();
                view.setGridDiceValue(gridList);
                view.init();
            }
        });
    }
}
