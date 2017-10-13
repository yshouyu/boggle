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
        BoggleModel model = new BoggleModel();
        BoggleView view = new BoggleView(model);
        new BoggleController(view,model);

        primaryStage.setScene(view.getScene());
        primaryStage.setTitle("Boggle Game");
        primaryStage.show();
    }
}
