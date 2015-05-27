package models;

import controllers.MainSceneController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.bargains.Expense;

public class ProgramDatabase {

    private MainSceneController mainSceneController;
    private ObservableList<Budget> budgetsDatabase;
    private ObservableList<Expense> expensesDatabase;

    public ProgramDatabase(MainSceneController mainSceneController) {

        this.mainSceneController = mainSceneController;

        budgetsDatabase = FXCollections.observableArrayList();
        expensesDatabase = FXCollections.observableArrayList();

    }

    public void addBudgetToDatabase(Budget budget) {
        budgetsDatabase.add(budget);
    }

    public ObservableList<Budget> getBudgetsFromDatabase() {
        return budgetsDatabase;
    }

    public void addExpenseToDatabase(Expense e) {
        expensesDatabase.add(e);
    }

    public ObservableList<Expense> getExpensesFromDatabase() {
        return expensesDatabase;
    }

}
