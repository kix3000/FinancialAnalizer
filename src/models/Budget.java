package models;

import controllers.MainSceneController;

import java.util.ArrayList;

public class Budget {

    private MainSceneController mainSceneController;

    private double totalExpended;
    private double plannedExpended;

    public Budget(MainSceneController mainSceneController) {
        this.mainSceneController = mainSceneController;
    }

    public double getPlannedExpended() {
        return plannedExpended;
    }

    public void setPlannedExpended(double plannedExpended) {
        this.plannedExpended = plannedExpended;
    }

    public double getTotalExpended() {

        totalExpended = 0;

        for (Expense expense : mainSceneController.getExpensesFromDatabase()){
            totalExpended += expense.getAmount();
        }
        return totalExpended;
    }
}
