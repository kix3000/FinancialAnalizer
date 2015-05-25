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
        budgetsDatabase.add(new Budget(mainSceneController, "Main Budget"));
    }


    public ObservableList<Budget> getBudgetsFromDatabase() {
        return budgetsDatabase;
    }
}
