package views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import java.net.URL;

public class ShowExpenseWindowView {

    private Scene scene;
    private final static URL fxmlUrl = MainSceneView.class.getResource("/views/ShowExpenseWindowView.fxml");
    private FXMLLoader fxmlLoader;

    public ShowExpenseWindowView(Object controller) throws Exception{

        fxmlLoader = new FXMLLoader(fxmlUrl);
        fxmlLoader.setController(controller);
        scene = new Scene(fxmlLoader.load(), 300,200);
    }

    public Scene getScene() {
        return scene;
    }

}
