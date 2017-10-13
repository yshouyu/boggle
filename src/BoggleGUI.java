import javafx.application.Application;
import javafx.stage.Stage;

/**
 * class BoggleGUI
 */
public class BoggleGUI extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        BoggleView view = new BoggleView();
        new BoggleController(view);

        primaryStage.setScene(view.getScene());
        primaryStage.setTitle("Boggle Game");
        primaryStage.show();
    }
}
