package controllers.windowControllers;

import controllers.MainSceneController;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.bargains.Expense;
import views.FxmlFileLoader;

public class ShowExpenseWindowController extends Stage {

    private MainSceneController mainSceneController;
    private FxmlFileLoader<Pane> showExpenseWindowView;

    @FXML Text amountField;
    @FXML Text placeField;
    @FXML Text paymentMethodField;
    @FXML Text descriptionField;

    public ShowExpenseWindowController(MainSceneController mainSceneController, Expense expense) throws Exception{
        super();

        this.mainSceneController = mainSceneController;
        showExpenseWindowView = new FxmlFileLoader<Pane>(this,"/views/ShowExpenseWindowView.fxml",300,200);

        this.setTitle("Show expense");
        this.setOnCloseRequest(e -> this.close());

        amountField.setText(String.valueOf(expense.getAmount()));
        placeField.setText(expense.getPlace());
        paymentMethodField.setText(expense.getPaymentMethod());
        descriptionField.setText(expense.getDescription());

        this.setScene(showExpenseWindowView.getScene());
        this.show();
    }



}