package controllers.scenesControllers;

import controllers.MainSceneController;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import models.Budget;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ShowBudgetsController implements Initializable {

    private MainSceneController mainSceneController;

    @FXML private ObservableList<Budget> budgetsTableData;
    @FXML private TableView budgetsTableView;

    public ShowBudgetsController(MainSceneController mainSceneController) {
        this.mainSceneController = mainSceneController;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*
        budgetsTableView.setRowFactory(tv -> {

            TableRow<Budget> row = new TableRow<>();

            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    Budget rowData = row.getItem();
                    mainSceneController.showExpenseWindow(rowData);
                }
            });

            return row ;



        });
        */
    }

    public void setData(ArrayList<Budget> budgets){
        budgetsTableData.clear();
        budgetsTableData.addAll(budgets);
    }
}
