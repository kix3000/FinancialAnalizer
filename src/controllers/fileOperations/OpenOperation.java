package controllers.fileOperations;

import controllers.MainSceneController;
import javafx.stage.FileChooser;
import models.bargains.Expense;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class OpenOperation {

    private MainSceneController mainSceneController;

    public OpenOperation(MainSceneController mainSceneController) {
        this.mainSceneController = mainSceneController;

        FileChooser fileChooser = new FileChooser();

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("SAV files (*.sav)", "*.sav");
        fileChooser.getExtensionFilters().add(extFilter);

        File file = fileChooser.showOpenDialog(mainSceneController.getMainWindowController().getPrimaryStage());

        openFile(file);
    }

    private void openFile(File file) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            mainSceneController.addAllExpensesToDatabase((ArrayList<Expense>)ois.readObject());

            ois.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
