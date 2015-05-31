package controllers;

import controllers.fileOperations.OpenOperation;
import controllers.fileOperations.SaveAsOperation;
import controllers.scenesControllers.MainBarController;
import controllers.scenesControllers.ShowBanksController;
import controllers.scenesControllers.ShowBudgetsController;
import controllers.scenesControllers.ShowExpensesController;
import controllers.windowControllers.AddBanksWindowController;
import controllers.windowControllers.AddBudgetsWindowController;
import controllers.windowControllers.AddExpensesWindowController;
import controllers.windowControllers.ShowExpenseWindowController;
import database.ProgramDatabase;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import models.*;
import models.bargains.Expense;
import views.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class MainSceneController implements Initializable{

    private ProgramDatabase programDatabase;

    private FxmlFileLoader<Pane> mainSceneView;
    private FxmlFileLoader<MenuBar> mainBarView;
    private FxmlFileLoader<Pane> showExpensesView;
    private FxmlFileLoader<Pane> showBudgetsView;
    private FxmlFileLoader<Pane> showBanksView;

    private MainWindowController mainWindowController;
    private MainBarController mainBarController;
    private ShowExpensesController showExpensesController;
    private ShowBudgetsController showBudgetsController;
    private ShowBanksController showBanksController;

    private AddExpensesWindowController addExpensesWindowController;
    private AddBudgetsWindowController addBudgetsWindowController;
    private ShowExpenseWindowController showExpenseWindowController;
    private AddBanksWindowController addBanksWindowController;

    @FXML BorderPane mainSceneBorderPane;

    public MainSceneController(FxmlFileLoader<Pane> mainSceneView, MainWindowController mainWindowController) throws Exception {

        this.mainSceneView = mainSceneView;
        this.mainWindowController = mainWindowController;

        programDatabase = new ProgramDatabase(this);

        mainBarController = new MainBarController(this);
        showExpensesController = new ShowExpensesController(this);
        showBudgetsController = new ShowBudgetsController(this);
        showBanksController = new ShowBanksController(this);

        showExpensesView = new FxmlFileLoader<Pane>(showExpensesController,"/views/ShowExpensesView.fxml");
        showBudgetsView = new FxmlFileLoader<Pane>(showBudgetsController,"/views/ShowBudgetsView.fxml");
        showBanksView = new FxmlFileLoader<Pane>(showBanksController,"/views/ShowBanksView.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        if(mainBarView == null)
        try {
            mainBarView = new FxmlFileLoader<MenuBar>(mainBarController,"/views/MainBarView.fxml");
            mainSceneBorderPane.setTop(mainBarView.getObject());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public MainWindowController getMainWindowController() {
        return mainWindowController;
    }

    public ProgramDatabase getProgramDatabase(){
        return programDatabase;
    }

    public void openView() {
        new OpenOperation(this);
    }

    public void saveAsView(){
        new SaveAsOperation(this);
    }

    public void showExpensesView() {

        mainSceneBorderPane.setCenter(showExpensesView.getObject());

    }

    public void showBudgetsView() {

        mainSceneBorderPane.setCenter(showBudgetsView.getObject());

    }

    public void setShowBanksView() {

        mainSceneBorderPane.setCenter(showBanksView.getObject());

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

    public void showAddExpensesWindow() {

        if(addExpensesWindowController == null || addExpensesWindowController.isShowing() == false) {
            try {
                addExpensesWindowController = new AddExpensesWindowController(this);
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

    public void showAddBanksWindow() {
        if(addBanksWindowController == null || addBanksWindowController.isShowing() == false) {
            try {
                addBanksWindowController = new AddBanksWindowController(this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void addAllExpensesToDatabase(ArrayList<Expense> expenses) {
        for (Expense expense : expenses) {
            programDatabase.addExpenseToDatabase(expense);
        }

        showExpensesController.setData(programDatabase.getExpensesFromDatabase());

        showBudgetsController.setData(programDatabase.getBudgetsFromDatabase());
    }
    public void addExpenseToDatabase(Expense expense){
        programDatabase.addExpenseToDatabase(expense);
        showExpensesController.setData(programDatabase.getExpensesFromDatabase());

        showBudgetsController.setData(programDatabase.getBudgetsFromDatabase());
    }

    public void addBudgetToDatabase(Budget budget){
        programDatabase.addBudgetToDatabase(budget);
        showBudgetsController.setData(programDatabase.getBudgetsFromDatabase());
    }

    public void addBankToDatabase(Bank bank){
        programDatabase.addBankToDatabase(bank);
        showBanksController.setData(programDatabase.getBanksFromDatabase());
    }

}
