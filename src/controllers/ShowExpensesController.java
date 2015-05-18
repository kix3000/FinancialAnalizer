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

    @FXML private TableColumn colDate;
    @FXML private TableColumn colAmount;
    @FXML private TableColumn colPlace;
    @FXML private TableColumn colDescription;
    @FXML private ObservableList<Expense> tablelist;

    public ShowExpensesController() {



    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String[] variableNames = { "date", "amount", "place", "description" };

        int i=0;

        colDate.setCellValueFactory(new PropertyValueFactory<Expense, Double>(variableNames[i++]));
        colAmount.setCellValueFactory(new PropertyValueFactory<Expense, String>(variableNames[i++]));
        colPlace.setCellValueFactory(new PropertyValueFactory<Expense, String>(variableNames[i++]));
        colDescription.setCellValueFactory(new PropertyValueFactory<Expense, BargainDate>(variableNames[i++]));

        tablelist.add(new Expense(6.66,"Biedronka","lol"));
    }

    public void setData(ObservableList<Expense> ed){
        tablelist.addAll(ed);
    }
}
