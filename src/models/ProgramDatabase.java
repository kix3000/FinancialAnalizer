package models;

import controllers.MainSceneController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.bargains.Expense;

public class ProgramDatabase {

    private MainSceneController mainSceneController;

    private ObservableList<Budget> budgetsDatabase;
    private ObservableList<Expense> expensesDatabase;
    private ObservableList<Bank> bankDatabase;
    private ObservableList<String> paymentMethods;

    public ProgramDatabase(MainSceneController mainSceneController) {

        this.mainSceneController = mainSceneController;

        budgetsDatabase = FXCollections.observableArrayList();
        expensesDatabase = FXCollections.observableArrayList();
        bankDatabase = FXCollections.observableArrayList();
        paymentMethods = FXCollections.observableArrayList();
        addPaymentMethodToDatabase("Cash");

    }

    public void addBudgetToDatabase(Budget budget) {
        budgetsDatabase.add(budget);
    }

    public ObservableList<Budget> getBudgetsFromDatabase() {
        return budgetsDatabase;
    }

    public void addExpenseToDatabase(Expense e) {
        expensesDatabase.add(e);
    }

    public ObservableList<Expense> getExpensesFromDatabase() {
        return expensesDatabase;
    }

    public void addBankToDatabase(Bank bank) {
        bankDatabase.add(bank);
        addPaymentMethodToDatabase(bank.getName() + ": Transfer");

        if(bank.getIsCardPayable()){
            addPaymentMethodToDatabase(bank.getName() + ": Card");
        }

    }

    public ObservableList<Bank> getBanksFromDatabase() {
        return bankDatabase;
    }

    public ObservableList<String> getPaymentMethodsFromDatabase() {
        return paymentMethods;
    }

    private void addPaymentMethodToDatabase(String paymentMethod) {
        paymentMethods.add(paymentMethod);
    }
}
