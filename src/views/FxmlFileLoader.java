package views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.net.URL;

public class FxmlFileLoader<FxmlType> {

    private FxmlType fxmlObject;
    private Scene fxmlScene;

    public FxmlFileLoader(Object controller, String urlString) throws Exception{

        URL fxmlUrl = FxmlFileLoader.class.getResource(urlString);
        FXMLLoader fxmlLoader = new FXMLLoader(fxmlUrl);
        fxmlLoader.setController(controller);
        fxmlObject = fxmlLoader.load();
    }

    public FxmlFileLoader(Object controller, String urlString,  double width, double height) throws Exception {
        this(controller,urlString);

        fxmlScene = new Scene((Parent)fxmlObject,width,height);

    }

    public FxmlType getObject(){
        return fxmlObject;
    }

    public Scene getScene(){
        return fxmlScene;
    }
}
