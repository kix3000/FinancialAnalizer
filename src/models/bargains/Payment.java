package models.bargains;

import java.time.LocalDate;

public abstract class Payment {

    private LocalDate date;
    private double amount;
    private String place;
    private String description;

    public Payment(LocalDate date, double amount, String place, String description) {
        this.date = date;
        this.amount = amount;
        this.place = place;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public String getPlace() {
        return place;
    }
}
