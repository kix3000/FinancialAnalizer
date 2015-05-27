package models;

import controllers.MainSceneController;
import models.bargains.Expense;

public class Budget {

    private MainSceneController mainSceneController;

    private String description;
    private double totalExpended;
    private double plannedExpended;

    public Budget(MainSceneController mainSceneController, String description) {
        this.mainSceneController = mainSceneController;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public double getPlannedExpended() {
        return plannedExpended;
    }

    public void setPlannedExpended(double plannedExpended) {
        this.plannedExpended = plannedExpended;
    }

    public double getTotalExpended() {

        totalExpended = 0;

        for (Expense expense : mainSceneController.getProgramDatabase().getExpensesFromDatabase()){
            totalExpended += expense.getAmount();
        }
        return totalExpended;
    }

}
