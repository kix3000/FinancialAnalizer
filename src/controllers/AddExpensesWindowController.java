package controllers;

import javafx.stage.Stage;
import views.AddExpensesWindowView;

public class AddExpensesWindowController extends Stage {

    AddExpensesWindowView addExpensesWindowView;

    public AddExpensesWindowController() throws Exception{
        super();

        addExpensesWindowView = new AddExpensesWindowView(this);
        this.setTitle("Add new expense");
        this.setOnCloseRequest(e -> this.close());
        this.setScene(addExpensesWindowView.getScene());
        this.show();
    }
}
