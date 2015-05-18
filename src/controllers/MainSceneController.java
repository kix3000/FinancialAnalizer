package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import models.Expense;
import views.MainBarView;
import views.MainSceneView;
import views.ShowBudgetsView;
import views.ShowExpensesView;
import java.net.URL;
import java.util.ResourceBundle;


public class MainSceneController implements Initializable{

    private MainSceneView mainSceneView;
    private MainBarView mainBarView;

    private ShowExpensesView showExpensesView;

    private MainWindowController mainWindowController;
    private MainBarController mainBarController;
    private ShowExpensesController showExpensesController;
    private ShowBudgetsController showBudgetsController;

    @FXML BorderPane borderPane;

    public MainSceneController() {

    }

    public MainSceneController(MainSceneView mainSceneView, MainWindowController mainWindowController) throws Exception {

        this.mainSceneView = mainSceneView;
        this.mainWindowController = mainWindowController;

        mainBarController = new MainBarController(this);
        showExpensesController = new ShowExpensesController();
        showBudgetsController = new ShowBudgetsController();

        showExpensesView = new ShowExpensesView(showExpensesController);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        if(mainBarView == null)
        try {
            mainBarView = new MainBarView(mainBarController);
            borderPane.setTop(mainBarView.getPane());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void showExpensesView() {

           borderPane.setCenter(showExpensesView.getPane());


    }

    public void showBudgetsView() {
        try {
            borderPane.setCenter(new ShowBudgetsView(showBudgetsController).getPane());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void TableTest() {
        ObservableList<Expense> list = FXCollections.observableArrayList();
        list.add(new Expense(2.41,"Lidl","Elo"));
        showExpensesController.setData(list);
    }
}
