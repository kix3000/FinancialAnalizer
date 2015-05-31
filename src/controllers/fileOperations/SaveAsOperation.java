package controllers.fileOperations;

import controllers.MainSceneController;
import javafx.stage.FileChooser;
import models.Budget;
import models.bargains.Expense;

import java.io.*;
import java.time.LocalDate;
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
            oos.writeObject(mainSceneController.getProgramDatabase().getBanksFromDatabase());
            oos.writeObject(mainSceneController.getProgramDatabase().getPaymentMethodsFromDatabase());

            ArrayList<Budget> budgets = mainSceneController.getProgramDatabase().getBudgetsFromDatabase();
            ArrayList<String> descriptions = new ArrayList<String>();
            ArrayList<Double> plannedExpends = new ArrayList<Double>();
            ArrayList<String> placeFiltrs = new ArrayList<String>();
            ArrayList<String> methodPaymentFiltrs = new ArrayList<String>();
            ArrayList<LocalDate> startDateFiltrs = new ArrayList<LocalDate>();
            ArrayList<LocalDate> finishDateFiltrs = new ArrayList<LocalDate>();

            for (Budget budget:budgets) {
                descriptions.add(budget.getDescription());
                plannedExpends.add(budget.getPlannedExpended());
                placeFiltrs.add(budget.getFiltrByPlace());
                methodPaymentFiltrs.add(budget.getFiltrByMethodPayment());
                startDateFiltrs.add(budget.getFiltrByStartDate());
                finishDateFiltrs.add(budget.getFiltrByFinishDate());
            }

            oos.writeObject(descriptions);
            oos.writeObject(plannedExpends);
            oos.writeObject(placeFiltrs);
            oos.writeObject(methodPaymentFiltrs);
            oos.writeObject(startDateFiltrs);
            oos.writeObject(finishDateFiltrs);

            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
