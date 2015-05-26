package controllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import models.Budget;
import models.BudgetsData;
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
    private BudgetsData budgetsData;

    private ShowExpensesView showExpensesView;
    private ShowBudgetsView showBudgetsView;

    private MainWindowController mainWindowController;
    private MainBarController mainBarController;
    private ShowExpensesController showExpensesController;
    private ShowBudgetsController showBudgetsController;

    private AddExpensesWindowController addExpensesWindowController;
    private AddBudgetsWindowController addBudgetsWindowController;
    private ShowExpenseWindowController showExpenseWindowController;


    @FXML BorderPane borderPane;

    public MainSceneController() {

    }

    public MainSceneController(MainSceneView mainSceneView, MainWindowController mainWindowController) throws Exception {

        this.mainSceneView = mainSceneView;
        this.mainWindowController = mainWindowController;

        expenseDatabase = new ExpenseDatabase(this);
        budgetsData = new BudgetsData(this);


        mainBarController = new MainBarController(this);
        showExpensesController = new ShowExpensesController(this);
        showBudgetsController = new ShowBudgetsController(this);

        showExpensesView = new ShowExpensesView(showExpensesController);
        showBudgetsView = new ShowBudgetsView(showBudgetsController);
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

            borderPane.setCenter(showBudgetsView.getPane());

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

    public void showAddBudgetsWindow() {

        if(addBudgetsWindowController == null || addBudgetsWindowController.isShowing() == false) {
            try {
                addBudgetsWindowController = new AddBudgetsWindowController(this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void addExpenseToDatabase(Expense expense){
        expenseDatabase.addExpenseToDatabase(expense);
        showExpensesController.setData(expenseDatabase.getExpensesFromDatabase());

        showBudgetsController.setData(budgetsData.getBudgetsFromDatabase());
    }

    public ObservableList<Expense> getExpensesFromDatabase(){
        return expenseDatabase.getExpensesFromDatabase();
    }

    public void addBudget(Budget budget){
        budgetsData.addBudget(budget);
        showBudgetsController.setData(budgetsData.getBudgetsFromDatabase());
    }

}
