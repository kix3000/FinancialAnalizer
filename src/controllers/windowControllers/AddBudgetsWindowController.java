package controllers.windowControllers;

import controllers.MainSceneController;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import models.Budget;
import views.FxmlFileLoader;

import java.time.LocalDate;

public class AddBudgetsWindowController extends Stage {

    private MainSceneController mainSceneController;
    private FxmlFileLoader<Pane> addBudgetsWindowView;

    @FXML private Button addBudgetButton;
    @FXML private TextField descriptionField;
    @FXML private TextField plannedField;
    @FXML private CheckBox isFiltredByPlaceField;
    @FXML private TextField placeFiltrField;
    @FXML private CheckBox isFiltredByPaymentMethodField;
    @FXML private ChoiceBox paymentMethodFiltrField;
    @FXML private CheckBox isFiltredByStartDateField;
    @FXML private DatePicker startDateField;
    @FXML private CheckBox isFiltredByFinishDateField;
    @FXML private DatePicker finishDateField;

    @FXML private ObservableList<String> paymentMethods;

    public AddBudgetsWindowController(MainSceneController mainSceneController) throws Exception{
        super();

        this.mainSceneController = mainSceneController;
        addBudgetsWindowView = new FxmlFileLoader<Pane>(this,"/views/AddBudgetsWindowView.fxml",300,200);

        this.setTitle("Add new budget");
        this.setOnCloseRequest(e -> this.close());
        this.setScene(addBudgetsWindowView.getScene());

        paymentMethods.addAll(mainSceneController.getProgramDatabase().getPaymentMethodsFromDatabase());
        addBudgetButton.setOnAction( e-> addBudget());

        this.show();
    }

    private void addBudget() {

        double planned = new Double(plannedField.getText());
        String description = descriptionField.getText();
        Boolean isFiltredByPlace = isFiltredByPlaceField.isSelected();
        String placeFiltr = placeFiltrField.getText();
        Boolean isFiltredByPaymentMethod = isFiltredByPaymentMethodField.isSelected();
        String paymentMethodFiltr = (String)paymentMethodFiltrField.getValue();
        Boolean isFiltredByStartDate = isFiltredByStartDateField.isSelected();
        LocalDate startDate = startDateField.getValue();
        Boolean isFiltredByFinishDate = isFiltredByFinishDateField.isSelected();
        LocalDate finishDate = finishDateField.getValue();

        Budget newBudget = new Budget(mainSceneController, description);
        newBudget.setPlannedExpended(planned);

        if(isFiltredByPlace) {
            newBudget.setFiltrByPlace(placeFiltr);
        }

        if(isFiltredByPaymentMethod) {
            newBudget.setFiltrByMethodPayment(paymentMethodFiltr);
        }

        if(isFiltredByStartDate){
            newBudget.setFiltrByStartDate(startDate);
        }

        if(isFiltredByFinishDate){
            newBudget.setFiltrByFinishDate(finishDate);
        }

        mainSceneController.addBudgetToDatabase(newBudget);
    }
}
