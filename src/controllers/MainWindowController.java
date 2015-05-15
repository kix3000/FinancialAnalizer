package controllers;

import javafx.stage.Stage;
import views.MainSceneView;

public class MainWindowController extends Stage{

    private Stage primaryStage;

    MainSceneView mainSceneView;

    public MainWindowController(Stage primaryStage) {

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Financial Analizer v0.1");
        this.primaryStage.setOnCloseRequest(e -> System.exit(0));
        scenesInit();
        this.primaryStage.setScene(mainSceneView);
        this.primaryStage.show();
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    private void scenesInit() {

        try {
            mainSceneView = new MainSceneView();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
