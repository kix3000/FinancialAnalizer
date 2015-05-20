package models;

import controllers.MainSceneController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ExpenseDatabase {

    ObservableList<Expense> expensesDatabase;
    MainSceneController mainSceneController;

    public ExpenseDatabase(MainSceneController mainSceneController) {
        this.mainSceneController = mainSceneController;
        expensesDatabase = FXCollections.observableArrayList();
    }

    public void addExpenseToDatabase(Expense e) {
        expensesDatabase.add(e);
    }

    public ObservableList<Expense> getExpensesFromDatabase() {
        return expensesDatabase;
    }
}
