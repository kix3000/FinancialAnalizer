package controllers;

import javafx.stage.Stage;
import views.MainSceneView;

public class MainWindowController extends Stage{

    private Stage primaryStage;
    private MainSceneView mainSceneView;
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
            mainSceneView = new MainSceneView(mainSceneController);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void closeProgram() {
        System.exit(0);
    }

}
