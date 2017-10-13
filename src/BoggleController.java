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

    private static String allWordsFilename = "OpenEnglishWordList.txt";
    private static String diceWordsFilename = "DiceWords.txt";

    public BoggleController(BoggleView view,BoggleModel model) {
        this.model = model;
        this.view = view;

        allWords = ReadDataUtils.readData(allWordsFilename);

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
    }
}
