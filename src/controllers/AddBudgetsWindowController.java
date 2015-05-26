package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Budget;
import views.AddBudgetsWindowView;

public class AddBudgetsWindowController extends Stage {

    private MainSceneController mainSceneController;
    private AddBudgetsWindowView addBudgetsWindowView;

    @FXML private Button addBudgetButton;
    @FXML private TextField descriptionField;
    @FXML private TextField plannedField;

    public AddBudgetsWindowController(MainSceneController mainSceneController) throws Exception{
        super();

        this.mainSceneController = mainSceneController;
        addBudgetsWindowView = new AddBudgetsWindowView(this);

        this.setTitle("Add new budget");
        this.setOnCloseRequest(e -> this.close());
        this.setScene(addBudgetsWindowView.getScene());

        addBudgetButton.setOnAction( e-> addBudget());

        this.show();
    }

    private void addBudget() {

        double planned = new Double(plannedField.getText());
        String description = descriptionField.getText();
        Budget newBudget = new Budget(mainSceneController, description);
        newBudget.setPlannedExpended(planned);

        mainSceneController.addBudget(newBudget);
    }
}
