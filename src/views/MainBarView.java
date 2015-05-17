package views;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.MenuBar;

import java.net.URL;

public class MainBarView {

    private MenuBar menuBar;
    private final static URL fxmlUrl = MainSceneView.class.getResource("/views/MainBarView.fxml");

    public MainBarView(Object controller) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(fxmlUrl);
        fxmlLoader.setController(controller);
        menuBar = fxmlLoader.load();
    }

    public MenuBar getPane(){
        return menuBar;
    }
}
