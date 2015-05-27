package controllers;

import controllers.scenesControllers.MainBarController;
import controllers.scenesControllers.ShowBudgetsController;
import controllers.scenesControllers.ShowExpensesController;
import controllers.windowControllers.AddBudgetsWindowController;
import controllers.windowControllers.AddExpensesWindowController;
import controllers.windowControllers.ShowExpenseWindowController;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import models.*;
import models.bargains.Expense;
import views.*;
import java.net.URL;
import java.util.ResourceBundle;


public class MainSceneController implements Initializable{

    private ProgramDatabase programDatabase;

    private FxmlFileLoader<Pane> mainSceneView;
    private FxmlFileLoader<MenuBar> mainBarView;
    private FxmlFileLoader<Pane> showExpensesView;
    private FxmlFileLoader<Pane> showBudgetsView;

    private MainWindowController mainWindowController;
    private MainBarController mainBarController;
    private ShowExpensesController showExpensesController;
    private ShowBudgetsController showBudgetsController;

    private AddExpensesWindowController addExpensesWindowController;
    private AddBudgetsWindowController addBudgetsWindowController;
    private ShowExpenseWindowController showExpenseWindowController;

    @FXML BorderPane mainSceneBorderPane;

    public MainSceneController(FxmlFileLoader<Pane> mainSceneView, MainWindowController mainWindowController) throws Exception {

        this.mainSceneView = mainSceneView;
        this.mainWindowController = mainWindowController;

        programDatabase = new ProgramDatabase(this);

        mainBarController = new MainBarController(this);
        showExpensesController = new ShowExpensesController(this);
        showBudgetsController = new ShowBudgetsController(this);

        showExpensesView = new FxmlFileLoader<Pane>(showExpensesController,"/views/ShowExpensesView.fxml");
        showBudgetsView = new FxmlFileLoader<Pane>(showBudgetsController,"/views/ShowBudgetsView.fxml");
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

    public ProgramDatabase getProgramDatabase(){
        return programDatabase;
    }

    public void showExpensesView() {

        mainSceneBorderPane.setCenter(showExpensesView.getObject());

    }

    public void showBudgetsView() {

        mainSceneBorderPane.setCenter(showBudgetsView.getObject());

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

    public void addExpenseToDatabase(Expense expense){
        programDatabase.addExpenseToDatabase(expense);
        showExpensesController.setData(programDatabase.getExpensesFromDatabase());

        showBudgetsController.setData(programDatabase.getBudgetsFromDatabase());
    }

    public void addBudgetToDatabase(Budget budget){
        programDatabase.addBudgetToDatabase(budget);
        showBudgetsController.setData(programDatabase.getBudgetsFromDatabase());
    }

}
