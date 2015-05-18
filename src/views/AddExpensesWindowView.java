package views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import java.net.URL;


public class AddExpensesWindowView {

    private Scene scene;
    private final static URL fxmlUrl = MainSceneView.class.getResource("/views/AddExpensesWindowView.fxml");
    private FXMLLoader fxmlLoader;

    public AddExpensesWindowView(Object controller) throws Exception{

        fxmlLoader = new FXMLLoader(fxmlUrl);
        fxmlLoader.setController(controller);
        scene = new Scene(fxmlLoader.load(), 300,200);
    }

    public Scene getScene() {
        return scene;
    }

}
