package models.bargains;

import java.io.Serializable;
import java.time.LocalDate;

public class Expense extends Payment implements Serializable{

    private String paymentMethod;

    public Expense(LocalDate date, double amount, String place, String paymentMethod, String description) {
        super(date, amount, place, description);
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
