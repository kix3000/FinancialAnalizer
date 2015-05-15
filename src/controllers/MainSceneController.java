package controllers;

import javafx.fxml.FXML;

public class MainSceneController {

        @FXML
        private void newClicked() {
            System.out.println("New clicked!");
        }

        @FXML
        private void exitClicked() {
            MainWindowController.closeProgram();
        }
}
