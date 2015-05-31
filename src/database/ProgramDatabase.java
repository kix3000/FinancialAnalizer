package database;

import controllers.MainSceneController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Bank;
import models.Budget;
import models.bargains.Expense;

import java.io.Serializable;
import java.util.ArrayList;

public class ProgramDatabase implements Serializable{

    private MainSceneController mainSceneController;

    private ArrayList<Budget> budgetsDatabase;
    private ArrayList<Expense> expensesDatabase;
    private ArrayList<Bank> bankDatabase;
    private ArrayList<String> paymentMethods;

    public ProgramDatabase(MainSceneController mainSceneController) {

        this.mainSceneController = mainSceneController;

        budgetsDatabase = new ArrayList<Budget>();
        expensesDatabase = new ArrayList<Expense>();
        bankDatabase = new ArrayList<Bank>();
        paymentMethods =  new ArrayList<String>();
        addPaymentMethodToDatabase("Cash");

    }

    public void addBudgetToDatabase(Budget budget) {
        budgetsDatabase.add(budget);
    }

    public ArrayList<Budget> getBudgetsFromDatabase() {
        return budgetsDatabase;
    }

    public void addExpenseToDatabase(Expense e) {
        expensesDatabase.add(e);
    }

    public ArrayList<Expense> getExpensesFromDatabase() {
        return expensesDatabase;
    }

    public void addBankToDatabase(Bank bank) {
        bankDatabase.add(bank);
        addPaymentMethodToDatabase(bank.getName() + ": Transfer");

        if(bank.getIsCardPayable()){
            addPaymentMethodToDatabase(bank.getName() + ": Card");
        }

    }

    public ArrayList<Bank> getBanksFromDatabase() {
        return bankDatabase;
    }

    public ArrayList<String> getPaymentMethodsFromDatabase() {
        return paymentMethods;
    }

    private void addPaymentMethodToDatabase(String paymentMethod) {
        paymentMethods.add(paymentMethod);
    }
}
