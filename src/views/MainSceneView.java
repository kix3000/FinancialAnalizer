package views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.net.URL;


public class MainSceneView {

    private Scene scene;
    private final static URL fxmlUrl = MainSceneView.class.getResource("/views/MainSceneView.fxml");
    private FXMLLoader fxmlLoader;

    public MainSceneView(Object controller) throws Exception{

        //super(FXMLLoader.load(MainSceneView.class.getResource("/views/MainSceneView.fxml")),600,400);
        fxmlLoader = new FXMLLoader(fxmlUrl);
        fxmlLoader.setController(controller);
        scene = new Scene(fxmlLoader.load(), 600,400);
    }

    public Scene getScene() {
        return scene;
    }

}
