package controllers.scenesControllers;

import controllers.MainSceneController;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import models.Bank;
import java.net.URL;
import java.util.ResourceBundle;

public class ShowBanksController implements Initializable{

    private MainSceneController mainSceneController;

    @FXML private ObservableList<Bank> banksTableData;
    @FXML private TableView banksTableView;

    public ShowBanksController(MainSceneController mainSceneController) {
        this.mainSceneController = mainSceneController;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*
        banksTableView.setRowFactory(tv -> {

            TableRow<Expense> row = new TableRow<>();

            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    Expense rowData = row.getItem();
                    mainSceneController.showExpenseWindow(rowData);
                }
            });

            return row ;


        });
        */
    }

    public void setData(ObservableList<Bank> bank){
        banksTableData.clear();
        banksTableData.addAll(bank);
    }
}
