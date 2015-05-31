package controllers.fileOperations;

import controllers.MainSceneController;
import database.ProgramDatabase;
import javafx.stage.FileChooser;
import models.Bank;
import models.Budget;
import models.bargains.Expense;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

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

            mainSceneController.getProgramDatabase().getExpensesFromDatabase().clear();
            mainSceneController.getProgramDatabase().getExpensesFromDatabase().addAll((ArrayList<Expense>)ois.readObject());

            mainSceneController.getProgramDatabase().getBanksFromDatabase().clear();
            mainSceneController.getProgramDatabase().getBanksFromDatabase().addAll((ArrayList<Bank>)ois.readObject());

            mainSceneController.getProgramDatabase().getPaymentMethodsFromDatabase().clear();
            mainSceneController.getProgramDatabase().getPaymentMethodsFromDatabase().addAll((ArrayList<String>)ois.readObject());

            mainSceneController.getProgramDatabase().getBudgetsFromDatabase().clear();
            ArrayList<String> descriptions = (ArrayList<String>)ois.readObject();
            ArrayList<Double> plannedExpends = (ArrayList<Double>)ois.readObject();
            ArrayList<String> placeFiltrs = (ArrayList<String>)ois.readObject();
            ArrayList<String> methodPaymentFiltrs = (ArrayList<String>)ois.readObject();
            ArrayList<LocalDate> startDateFiltrs = (ArrayList<LocalDate>)ois.readObject();
            ArrayList<LocalDate> finishDateFiltrs = (ArrayList<LocalDate>)ois.readObject();

            for (String description : descriptions) {
                int index = descriptions.indexOf(description);
                Budget newBudget = new Budget(mainSceneController,description);
                newBudget.setPlannedExpended(plannedExpends.get(index));
                newBudget.setFiltrByPlace(placeFiltrs.get(index));
                newBudget.setFiltrByMethodPayment(methodPaymentFiltrs.get(index));
                newBudget.setFiltrByFinishDate(startDateFiltrs.get(index));
                newBudget.setFiltrByFinishDate(finishDateFiltrs.get(index));

                mainSceneController.getProgramDatabase().getBudgetsFromDatabase().add(newBudget);
            }

            mainSceneController.refreshTables();

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
