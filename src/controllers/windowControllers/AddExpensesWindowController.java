package controllers.windowControllers;

import controllers.MainSceneController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import models.bargains.Expense;
import views.FxmlFileLoader;

public class AddExpensesWindowController extends Stage {

    private MainSceneController mainSceneController;
    private FxmlFileLoader<Pane> addExpensesWindowView;

    @FXML private Button addExpenseButton;
    @FXML private TextField amountField;
    @FXML private TextField placeField;
    @FXML private TextField descriptionField;

    public AddExpensesWindowController(MainSceneController mainSceneController) throws Exception{
        super();

        this.mainSceneController = mainSceneController;
        addExpensesWindowView = new FxmlFileLoader<Pane>(this,"/views/AddExpensesWindowView.fxml",300,200);
        this.setTitle("Add new expense");
        this.setOnCloseRequest(e -> this.close());
        this.setScene(addExpensesWindowView.getScene());

        addExpenseButton.setOnAction( e-> addExpenseToDatabase());

        this.show();
    }

    private void addExpenseToDatabase() {

        double amount = new Double(amountField.getText());
        String place = placeField.getText();
        String description = descriptionField.getText();
        mainSceneController.addExpenseToDatabase(new Expense(amount,place,description));
    }

}
