package controllers;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import views.FxmlFileLoader;

public class MainWindowController extends Stage{

    private Stage primaryStage;
    private FxmlFileLoader<Pane> mainSceneView;
    private MainSceneController mainSceneController;

    public MainWindowController(Stage primaryStage) {

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Financial Analizer v0.1");
        this.primaryStage.setOnCloseRequest(e -> closeProgram());
        initScenes();
        this.primaryStage.setScene(mainSceneView.getScene());
        this.primaryStage.show();

    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    private void initScenes() {

        try {

            mainSceneController = new MainSceneController(mainSceneView, this);
            mainSceneView = new FxmlFileLoader<Pane>(mainSceneController,"/views/MainSceneView.fxml",600,400);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void closeProgram() {
        System.exit(0);
    }

}
