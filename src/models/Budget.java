package models;

import controllers.MainSceneController;
import models.bargains.Expense;

import java.io.Serializable;
import java.time.LocalDate;

public class Budget implements Serializable {

    private MainSceneController mainSceneController;

    private String description;
    private double totalExpended;
    private double plannedExpended;

    private String placeFiltr;
    private String methodPaymentFiltr;
    private LocalDate startDateFiltr;
    private LocalDate finishDateFiltr;

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

            Boolean placeFiltrMatched = false;
            Boolean methodPaymentFiltrMatched = false;
            Boolean startDateFiltrMatched = false;
            Boolean finishDateFiltrMatched = false;

            if(placeFiltr != null && expense.getPlace().equals(placeFiltr)){
                placeFiltrMatched = true;
            }
            if(methodPaymentFiltr != null && expense.getPaymentMethod().equals(methodPaymentFiltr)){
                methodPaymentFiltrMatched = true;
            }
            if(startDateFiltr != null && expense.getDate().isAfter(startDateFiltr)){
                startDateFiltrMatched = true;
            }
            if(finishDateFiltr != null && expense.getDate().isAfter(finishDateFiltr)){
                finishDateFiltrMatched = true;
            }

           if((placeFiltr == null || placeFiltrMatched)&&(methodPaymentFiltr == null || methodPaymentFiltrMatched)&&(startDateFiltr == null || startDateFiltrMatched)&&(finishDateFiltr == null || finishDateFiltrMatched)){
                totalExpended += expense.getAmount();
            }

        }

        return totalExpended;
    }

    public void setFiltrByPlace(String placeFiltr) {
        this.placeFiltr = placeFiltr;
    }

    public void setFiltrByMethodPayment(String methodPaymentFiltr){
        this.methodPaymentFiltr = methodPaymentFiltr;
    }

    public void setFiltrByStartDate(LocalDate startDateFiltr) {
        this.startDateFiltr = startDateFiltr;
    }

    public void setFiltrByFinishDate(LocalDate finishDateFiltr) {
        this.finishDateFiltr = finishDateFiltr;
    }

    public String getFiltrByPlace() {
        return placeFiltr;
    }

    public String getFiltrByMethodPayment(){
        return methodPaymentFiltr;
    }

    public LocalDate getFiltrByStartDate() {
        return startDateFiltr;
    }

    public LocalDate getFiltrByFinishDate() {
        return finishDateFiltr;
    }


}
