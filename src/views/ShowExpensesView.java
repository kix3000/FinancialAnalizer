package views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import java.net.URL;

public class ShowExpensesView {

    private Scene scene;
    private final static URL fxmlUrl = MainSceneView.class.getResource("/views/ShowExpensesView.fxml");

    public ShowExpensesView(Object controller) throws Exception{

        //super(FXMLLoader.load(MainSceneView.class.getResource("/views/ShowExpensesView.fxml")),600,400);
        FXMLLoader loader = new FXMLLoader(fxmlUrl);
        loader.setController(controller);
        scene = new Scene(loader.load(),600, 400);
    }

    public Scene getScene(){
        return scene;
    }

}
