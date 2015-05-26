package models;

import controllers.MainSceneController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BudgetsData {

    private MainSceneController mainSceneController;

    private ObservableList<Budget> budgetsDatabase;

    public BudgetsData(MainSceneController mainSceneController) {
        this.mainSceneController = mainSceneController;

        budgetsDatabase = FXCollections.observableArrayList();
    }

    public void addBudget(Budget budget) {
        budgetsDatabase.add(budget);
    }

    public ObservableList<Budget> getBudgetsFromDatabase() {
        return budgetsDatabase;
    }
}
