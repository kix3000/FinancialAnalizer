package controllers.windowControllers;

import controllers.MainSceneController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import models.Bank;
import views.FxmlFileLoader;

public class AddBanksWindowController extends Stage {

    private MainSceneController mainSceneController;
    private FxmlFileLoader<Pane> addBanksWindowView;

    @FXML private Button addBankButtpm;
    @FXML private TextField nameField;
    @FXML private CheckBox isCardPayableField;

    public AddBanksWindowController(MainSceneController mainSceneController) throws Exception{
        super();

        this.mainSceneController = mainSceneController;
        addBanksWindowView = new FxmlFileLoader<Pane>(this,"/views/AddBanksWindowView.fxml",300,200);

        this.setTitle("Add new bank");
        this.setOnCloseRequest(e -> this.close());
        this.setScene(addBanksWindowView.getScene());

        addBankButtpm.setOnAction( e-> addBank());

        this.show();
    }

    private void addBank() {

        String name = nameField.getText();
        Boolean isCardPayable = isCardPayableField.isSelected();

        Bank newBank = new Bank(name,isCardPayable);

        mainSceneController.addBankToDatabase(newBank);
    }
}
