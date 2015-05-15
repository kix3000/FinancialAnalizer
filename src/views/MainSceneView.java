package views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class MainSceneView extends Scene {

    public MainSceneView() throws Exception{

        super(FXMLLoader.load(MainSceneView.class.getResource("MainSceneView.fxml")));
    }

}
