package models.bargains;

public class Expense extends Payment {

    private String paymentMethod;

    public Expense(double amount, String place, String paymentMethod, String description) {
        super(amount, place, description);
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
