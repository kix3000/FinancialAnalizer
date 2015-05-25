package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import java.net.URL;
import java.util.ResourceBundle;

public class MainBarController implements Initializable {

    private MainSceneController mainSceneController;

    @FXML private MenuItem exitMenuItem;
    @FXML private MenuItem showBudgetsMenuItem;
    @FXML private MenuItem showExpensesMenuItem;
    @FXML private MenuItem addExpensesMenuItem;
    @FXML private MenuItem addBudgetsMenuItem;

    public MainBarController(MainSceneController mainSceneController){
        this.mainSceneController = mainSceneController;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        showExpensesMenuItem.setOnAction( e-> mainSceneController.showExpensesView());

        showBudgetsMenuItem.setOnAction(e -> mainSceneController.showBudgetsView());

        addExpensesMenuItem.setOnAction(e -> mainSceneController.showAddExpensesWindow());

        addBudgetsMenuItem.setOnAction(e -> mainSceneController.showAddBudgetsWindow());

        exitMenuItem.setOnAction( e -> MainWindowController.closeProgram());
    }
}
