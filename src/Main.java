
import javafx.application.Application;
import javafx.stage.Stage;
import views.MainScene;

public class Main extends Application{

    private Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Financial Analizer v0.1");
        this.primaryStage.setOnCloseRequest(e -> System.exit(0));

        this.primaryStage.setScene(new MainScene());

        this.primaryStage.show();

    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }
}