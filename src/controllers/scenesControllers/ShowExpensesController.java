package controllers.scenesControllers;

import controllers.MainSceneController;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import models.bargains.Expense;
import java.net.URL;
import java.util.ResourceBundle;

public class ShowExpensesController implements Initializable{

    private MainSceneController mainSceneController;

    @FXML private ObservableList<Expense> expensesTableData;
    @FXML private TableView expensesTableView;

    public ShowExpensesController(MainSceneController mainSceneController) {
        this.mainSceneController = mainSceneController;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        expensesTableView.setRowFactory(tv -> {

            TableRow<Expense> row = new TableRow<>();

            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    Expense rowData = row.getItem();
                    mainSceneController.showExpenseWindow(rowData);
                }
            });

            return row ;


        });
    }

    public void setData(ObservableList<Expense> ed){
        expensesTableData.clear();
        expensesTableData.addAll(ed);
    }
}
