package controllers.windowControllers;

import controllers.MainSceneController;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import models.bargains.Expense;
import views.FxmlFileLoader;

import java.time.LocalDate;

public class AddExpensesWindowController extends Stage {

    private MainSceneController mainSceneController;
    private FxmlFileLoader<Pane> addExpensesWindowView;

    @FXML private Button addExpenseButton;
    @FXML private DatePicker dateField;
    @FXML private TextField amountField;
    @FXML private TextField placeField;
    @FXML private TextField descriptionField;
    @FXML private ChoiceBox paymentMethodField;
    @FXML private ObservableList<String> paymentMethods;

    public AddExpensesWindowController(MainSceneController mainSceneController) throws Exception{
        super();

        this.mainSceneController = mainSceneController;
        addExpensesWindowView = new FxmlFileLoader<Pane>(this,"/views/AddExpensesWindowView.fxml",300,200);
        this.setTitle("Add new expense");
        this.setOnCloseRequest(e -> this.close());
        this.setScene(addExpensesWindowView.getScene());

        paymentMethods.addAll(mainSceneController.getProgramDatabase().getPaymentMethodsFromDatabase());
        addExpenseButton.setOnAction( e-> addExpenseToDatabase());

        this.show();
    }

    private void addExpenseToDatabase() {

        LocalDate date = dateField.getValue();
        double amount = new Double(amountField.getText());
        String place = placeField.getText();
        String description = descriptionField.getText();
        String paymentMethod = (String)paymentMethodField.getValue();

        mainSceneController.addExpenseToDatabase(new Expense(date, amount,place,paymentMethod,description));
    }

}
