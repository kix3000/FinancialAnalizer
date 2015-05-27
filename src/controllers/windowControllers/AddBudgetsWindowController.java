package controllers.windowControllers;

import controllers.MainSceneController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import models.Budget;
import views.FxmlFileLoader;

public class AddBudgetsWindowController extends Stage {

    private MainSceneController mainSceneController;
    private FxmlFileLoader<Pane> addBudgetsWindowView;

    @FXML private Button addBudgetButton;
    @FXML private TextField descriptionField;
    @FXML private TextField plannedField;

    public AddBudgetsWindowController(MainSceneController mainSceneController) throws Exception{
        super();

        this.mainSceneController = mainSceneController;
        addBudgetsWindowView = new FxmlFileLoader<Pane>(this,"/views/AddBudgetsWindowView.fxml",300,200);

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

        mainSceneController.addBudgetToDatabase(newBudget);
    }
}
