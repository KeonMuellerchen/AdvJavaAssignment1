package Views;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneChanger {

    /**
     * This method will accept the title of the new scene, the .fxml file name
     * and location and the ActionEvent that triggered this method to be called
     */
    public static  void changeScenes(ActionEvent event, String viewName, String title) throws IOException {

        Parent root = FXMLLoader.load(new Object(){}.getClass().getResource(viewName));
        Scene scene = new Scene(root);

        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();

        primaryStage.setScene(scene);
        primaryStage.setTitle(title);
        primaryStage.show();
    }//end of changeScenes
}//end of SceneChanger
