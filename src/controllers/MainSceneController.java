package controllers;

import javafx.fxml.FXML;
import views.MainSceneView;

public class MainSceneController {

    private MainSceneView mainSceneView;
    private MainWindowController mainWindowController;

    public MainSceneController() {

    }

    public MainSceneController(MainSceneView mainSceneView, MainWindowController mainWindowController) {

        this.mainSceneView = mainSceneView;
        this.mainWindowController = mainWindowController;

    }

    @FXML private void newClicked() {
        System.out.println("New clicked!");
    }

    @FXML private void exitClicked() {
        MainWindowController.closeProgram();
    }
}
