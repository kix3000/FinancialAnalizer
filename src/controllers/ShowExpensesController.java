package controllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.BargainDate;
import models.Expense;

import java.net.URL;
import java.util.ResourceBundle;

public class ShowExpensesController implements Initializable{

    @FXML private ObservableList<Expense> expensesTableData;

    public ShowExpensesController() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setData(ObservableList<Expense> ed){
        expensesTableData.addAll(ed);
    }
}
