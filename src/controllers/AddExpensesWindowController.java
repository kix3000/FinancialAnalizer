package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Expense;
import views.AddExpensesWindowView;

public class AddExpensesWindowController extends Stage {

    MainSceneController mainSceneController;
    AddExpensesWindowView addExpensesWindowView;

    @FXML private Button addExpenseButton;
    @FXML private TextField amountField;
    @FXML private TextField placeField;
    @FXML private TextField descriptionField;

    public AddExpensesWindowController(MainSceneController mainSceneController) throws Exception{
        super();

        this.mainSceneController = mainSceneController;
        addExpensesWindowView = new AddExpensesWindowView(this);
        this.setTitle("Add new expense");
        this.setOnCloseRequest(e -> this.close());
        this.setScene(addExpensesWindowView.getScene());

        addExpenseButton.setOnAction( e-> addExpenseToTable());

        this.show();
    }

    private void addExpenseToTable() {

        double amount = new Double(amountField.getText());
        String place = placeField.getText();
        String description = descriptionField.getText();
        mainSceneController.addExpenseToTable(new Expense(amount,place,description));
    }

}
