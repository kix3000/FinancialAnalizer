package controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import views.MainSceneView;
import views.ShowExpensesView;

import java.net.URL;
import java.util.ResourceBundle;


public class MainSceneController implements Initializable {

    private MainSceneView mainSceneView;
    private MainWindowController mainWindowController;

    @FXML MenuItem showExpensesMenuItem;

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

    @FXML private void viewExpensesClicked() {

        /*
        try {
            mainWindowController.getPrimaryStage().setScene(new ShowExpensesView());
        } catch (Exception e) {
            e.printStackTrace();
        }
        */

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {


        showExpensesMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                try {
                    mainWindowController.getPrimaryStage().setScene(new ShowExpensesView(this).getScene());
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        });
    }
}
