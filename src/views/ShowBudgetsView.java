package views;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import java.net.URL;


public class ShowBudgetsView {

    private Pane pane;
    private final static URL fxmlUrl = MainSceneView.class.getResource("/views/ShowBudgetsView.fxml");

    public ShowBudgetsView(Object controller) throws Exception{

        FXMLLoader loader = new FXMLLoader(fxmlUrl);
        loader.setController(controller);
        pane = loader.load();
    }

    public Pane getPane(){
        return pane;
    }

}