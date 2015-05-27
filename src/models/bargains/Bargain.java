package models.bargains;

import models.BargainDate;

import java.util.Calendar;


public abstract class Bargain {

    private BargainDate date;
    private double amount;
    private String place;
    private String description;

    public Bargain(double amount, String place, String description) {
        date = new BargainDate();
        date.set(2015,Calendar.JULY,27);

        this.amount = amount;
        this.place = place;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public BargainDate getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public String getPlace() {
        return place;
    }
}
