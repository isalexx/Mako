package utilities;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneSwitcher
{
    public static void changeScenes(ActionEvent event, String pathToFXML, String windowTitle) throws IOException
    {
        Parent root = FXMLLoader.load(SceneSwitcher.class.getClassLoader().getResource(pathToFXML));
        Scene scene = new Scene(root);

        //get the stage from the event that was passed in
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.setTitle(windowTitle);
        stage.show();
    }
}
