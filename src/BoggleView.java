import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.List;


/**
 * class BoggleView
 */
public class BoggleView {

    private BorderPane rootPane;

    private GridPane dicePane;

    private DiceButton[][] diceGrid;

    private int grid = 4;

    private Pane controlPane;

    private TextArea textArea;

    private Label timerLabel;

    private Button resetGameButton;

    private HBox infoPane;

    private Label currentWordLabel;

    private TextField currentWordTextField;

    private Button submitButton;

    private Label tipLabel;

    private Label scoreLabel;

    private ChoiceBox<String> stringChoiceBox;

    public BoggleView() {
        initComponent();
    }

    /**
     *
     */
    private void initComponent() {
        rootPane = new BorderPane();

        initDicePane();
        initControlPane();
        initInfoPane();
        rootPane.setCenter(dicePane);
        rootPane.setRight(controlPane);
        rootPane.setBottom(infoPane);
    }

    private void initInfoPane() {
        infoPane = new HBox();
        infoPane.setAlignment(Pos.CENTER);
        infoPane.setBorder(new Border(new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.MEDIUM)));
        infoPane.setPadding(new Insets(20, 20, 20, 20));
        infoPane.setSpacing(20);

        HBox hBox1 = new HBox();
        hBox1.setPadding(new Insets(10, 20, 10, 20));
        hBox1.setBorder(new Border(new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.THIN)));
        currentWordLabel = new Label("Current Word:");
        currentWordLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        currentWordLabel.setPrefSize(150, 50);
        currentWordTextField = new TextField();
        currentWordTextField.setPrefSize(150, 50);
        currentWordTextField.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        hBox1.getChildren().addAll(currentWordLabel, currentWordTextField);

        submitButton = new Button("Submit Word");
        submitButton.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        submitButton.setPrefSize(200, 50);
        tipLabel = new Label("No this Word.");
        tipLabel.setTextFill(Color.RED);
        tipLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        tipLabel.setPrefSize(100, 50);
        tipLabel.setVisible(false);

        HBox hBox2 = new HBox();
        hBox2.setSpacing(10);
        hBox2.setPadding(new Insets(10, 20, 10, 20));
        hBox2.getChildren().addAll(submitButton, tipLabel);


        scoreLabel = new Label("score");
        scoreLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        scoreLabel.setPrefSize(80, 50);
        scoreLabel.setBorder(new Border(new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.THIN)));
        scoreLabel.setContentDisplay(ContentDisplay.CENTER);

        infoPane.getChildren().addAll(hBox1, hBox2, scoreLabel);

    }

    private void initControlPane() {
        controlPane = new Pane();
        controlPane.setBorder(new Border(new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.MEDIUM)));
        ;

        textArea = new TextArea();
        textArea.setPrefSize(180, 250);


        timerLabel = new Label("3:00");
        timerLabel.setPrefSize(180, 80);
        timerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 50));
        timerLabel.setBorder(new Border(new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.MEDIUM)));

        resetGameButton = new Button("Reset Game");
        resetGameButton.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        resetGameButton.setPrefSize(200, 50);

        stringChoiceBox = new ChoiceBox<String>();
        stringChoiceBox.setItems(FXCollections.observableArrayList("4 * 4","5 * 5"));
        stringChoiceBox.setValue("4 * 4");
        stringChoiceBox.setPrefSize(200, 20);

        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(20, 20, 20, 20));
        vBox.getChildren().addAll(textArea, timerLabel, resetGameButton,stringChoiceBox);
        controlPane.getChildren().add(vBox);
    }

    private void initDicePane() {
        dicePane = new GridPane();
        dicePane.setVgap(10);
        dicePane.setHgap(10);
        dicePane.setPrefSize(400, 400);
        dicePane.setBorder(new Border(new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.MEDIUM)));
        ;
        diceGrid = new DiceButton[grid][grid];
        initDiceGrid(4);
        dicePane.setPadding(new Insets(20, 20, 20, 20));
    }

    public Scene getScene() {
        return new Scene(rootPane, 800, 600);
    }

    public void addSubmitButtonHandler(EventHandler<ActionEvent> handler) {
        submitButton.setOnAction(handler);
    }

    public void addResetGameButtonHandler(EventHandler<ActionEvent> handler) {
        resetGameButton.setOnAction(handler);
    }

    public void addDiceGridHandler(EventHandler<ActionEvent> handler) {
        for (int i = 0; i < grid; i++) {
            for (int j = 0; j < grid; j++) {
                diceGrid[i][j].setOnAction(handler);
            }
        }
    }

    public void appendTextToTextArea(String text) {
        textArea.appendText(text + "\n");
    }

    public String getTextFieldString() {
        return currentWordTextField.getText();
    }

    /**
     * show tip
     */
    public void showTip() {
        tipLabel.setVisible(true);
    }

    /**
     * hide tip
     */
    public void hideTip() {
        tipLabel.setVisible(false);
    }

    /**
     * Reset Score
     *
     * @param score the value
     */
    public void setScore(int score) {
        scoreLabel.setText(String.valueOf(score));
    }

    /**
     * append text
     * @param text the value
     */
    public void appendToTextField(String text){
        currentWordTextField.appendText(text);
    }

    /**
     * Reset time
     *
     * @param time the value of time
     */
    public void setTime(String time) {
        timerLabel.setText(time);
    }

    /**
     * set dice pane value
     *
     * @param gridList the list of grid
     */
    public void setGridDiceValue(List<String> gridList) {
        int index = 0;
        for (Node node : dicePane.getChildren()) {
            Button temp = (Button) node;
            temp.setText(gridList.get(index++));
        }
    }

    /**
     * init this view
     */
    public void init() {
        timerLabel.setText("3:00");
        scoreLabel.setText("0");
        currentWordTextField.setText("");
        currentWordTextField.setEditable(true);
        submitButton.setDisable(false);
        textArea.setText("");
        setDicePaneAvaliable(true);
        setDicePaneDisable(false);
    }

    /**
     * stop game
     */
    public void stopGame() {
        currentWordTextField.setEditable(false);
        submitButton.setDisable(true);
        setDicePaneDisable(true);
    }

    /**
     *
     * @param status
     */
    public void setDicePaneDisable(boolean status){
        for (Node node : dicePane.getChildren()) {
            Button temp = (Button) node;
            temp.setDisable(status);
        }
    }

    /**
     * Enable a button
     * @param row
     * @param column
     */
    public void enabledDiceGridButton(int row,int column){
        if(diceGrid[row][column].isAvailable()){
            diceGrid[row][column].setDisable(false);
        }
    }

    public void setDicePaneAvaliable(boolean avaliable) {
        for (Node node : dicePane.getChildren()) {
            DiceButton temp = (DiceButton) node;
            temp.setAvailable(avaliable);
        }
    }

    public void setTextField(String text) {
        currentWordTextField.setText("");
    }

    public String getChoichBoxValue(){
        return stringChoiceBox.getValue();
    }

    public void initDiceGrid(int gridSide) {
        dicePane.getChildren().clear();
        diceGrid = new DiceButton[gridSide][gridSide];
        grid = gridSide;
        int side = gridSide == 5 ? 70:100;
        int fontSize = gridSide == 5 ? 30 : 40;
        for (int i = 0; i < gridSide; i++) {
            for (int j = 0; j < gridSide; j++) {
                diceGrid[i][j] = new DiceButton("");
                diceGrid[i][j].setFont(Font.font("Arial", FontWeight.BOLD, fontSize));
                diceGrid[i][j].setFocusTraversable(false);
                diceGrid[i][j].setPrefSize(side, side);
                diceGrid[i][j].setRow(i);
                diceGrid[i][j].setColumn(j);
                dicePane.add(diceGrid[i][j], i, j);
            }
        }
    }
}
