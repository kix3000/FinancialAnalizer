package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import models.Expense;
import models.ExpenseDatabase;
import views.MainBarView;
import views.MainSceneView;
import views.ShowBudgetsView;
import views.ShowExpensesView;
import java.net.URL;
import java.util.ResourceBundle;


public class MainSceneController implements Initializable{

    private MainSceneView mainSceneView;
    private MainBarView mainBarView;

    private ExpenseDatabase expenseDatabase;

    private ShowExpensesView showExpensesView;

    private MainWindowController mainWindowController;
    private MainBarController mainBarController;
    private ShowExpensesController showExpensesController;
    private ShowBudgetsController showBudgetsController;

    private AddExpensesWindowController addExpensesWindowController;
    private ShowExpenseWindowController showExpenseWindowController;



    @FXML BorderPane borderPane;

    public MainSceneController() {

    }

    public MainSceneController(MainSceneView mainSceneView, MainWindowController mainWindowController) throws Exception {

        this.mainSceneView = mainSceneView;
        this.mainWindowController = mainWindowController;

        expenseDatabase = new ExpenseDatabase(this);

        mainBarController = new MainBarController(this);
        showExpensesController = new ShowExpensesController(this);
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

    public void showAddExpensesWindow() {

        if(addExpensesWindowController == null || addExpensesWindowController.isShowing() == false) {
            try {
                addExpensesWindowController = new AddExpensesWindowController(this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void showExpenseWindow(Expense expense) {
        if(showExpenseWindowController == null || showExpenseWindowController.isShowing() == false) {
            try {
                showExpenseWindowController = new ShowExpenseWindowController(this, expense);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void addExpenseToDatabase(Expense expense){
        expenseDatabase.addExpenseToDatabase(expense);
        showExpensesController.setData(expenseDatabase.getExpensesFromDatabase());
    }

}
