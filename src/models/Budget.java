package models;

import controllers.MainSceneController;
import models.bargains.Expense;

public class Budget {

    private MainSceneController mainSceneController;

    private String description;
    private double totalExpended;
    private double plannedExpended;

    private String placeFiltr;

    public Budget(MainSceneController mainSceneController, String description) {
        this.mainSceneController = mainSceneController;
        this.description = description;
    }

    public double getPlannedExpended() {
        return plannedExpended;
    }

    public String getDescription() {
        return description;
    }

    public void setPlannedExpended(double plannedExpended) {
        this.plannedExpended = plannedExpended;
    }

    public double getTotalExpended() {

        totalExpended = 0;

        for (Expense expense : mainSceneController.getProgramDatabase().getExpensesFromDatabase()){

            if(placeFiltr == null){
                totalExpended += expense.getAmount();
            }
            else if(placeFiltr != null && expense.getPlace().equals(placeFiltr)){
                totalExpended += expense.getAmount();
            }

        }

        return totalExpended;
    }

    public void setFiltrByPlace(String placeFiltr) {
        this.placeFiltr = placeFiltr;
    }

    public String getFiltrByPlace() {
        return placeFiltr;
    }
}
