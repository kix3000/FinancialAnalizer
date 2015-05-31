package controllers.fileOperations;

import controllers.MainSceneController;
import javafx.stage.FileChooser;
import models.bargains.Expense;

import java.io.*;
import java.util.ArrayList;


public class SaveAsOperation {

    private MainSceneController mainSceneController;

    public SaveAsOperation(MainSceneController mainSceneController) {

        this.mainSceneController = mainSceneController;

        FileChooser fileChooser = new FileChooser();

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("SAV files (*.sav)", "*.sav");
        fileChooser.getExtensionFilters().add(extFilter);

        File file = fileChooser.showSaveDialog(mainSceneController.getMainWindowController().getPrimaryStage());

        if(file != null) {
            saveFile(file);
        }
    }

    private void saveFile(File file) {

        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(mainSceneController.getProgramDatabase().getExpensesFromDatabase());

            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
