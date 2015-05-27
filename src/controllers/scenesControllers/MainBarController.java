package controllers.scenesControllers;

import controllers.MainSceneController;
import controllers.MainWindowController;
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
    @FXML private MenuItem showBanksMenuItem;
    @FXML private MenuItem addExpensesMenuItem;
    @FXML private MenuItem addBudgetsMenuItem;
    @FXML private MenuItem addBanksMenuItem;

    public MainBarController(MainSceneController mainSceneController){
        this.mainSceneController = mainSceneController;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        showExpensesMenuItem.setOnAction( e-> mainSceneController.showExpensesView());

        showBudgetsMenuItem.setOnAction(e -> mainSceneController.showBudgetsView());

        showBanksMenuItem.setOnAction(e -> mainSceneController.setShowBanksView());

        addExpensesMenuItem.setOnAction(e -> mainSceneController.showAddExpensesWindow());

        addBudgetsMenuItem.setOnAction(e -> mainSceneController.showAddBudgetsWindow());

        addBanksMenuItem.setOnAction(e -> mainSceneController.showAddBanksWindow());

        exitMenuItem.setOnAction( e -> MainWindowController.closeProgram());
    }
}
