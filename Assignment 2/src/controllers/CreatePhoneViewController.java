package controllers;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import models.Phone;
import utilities.DBUtility;
import utilities.SceneSwitcher;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CreatePhoneViewController{

    @FXML
    private TextField manufacturerTextField;

    @FXML
    private TextField modelTextField;

    @FXML
    private TextField priceTextField;

    @FXML
    private TextField serialNumberTextField;

    @FXML
    private TextField screenSizeTextField;

    @FXML
    private TextField cameraTextField;

    @FXML
    private TextField operatingSystemTextField;

    @FXML
    private TextField memoryTextField;

    @FXML
    private TextField colourTextField;

    @FXML
    private Label successMessage;

    @FXML
    public void addPhone() {

        try
        {
            Phone newPhone = new Phone(manufacturerTextField.getText(),
                    modelTextField.getText(),
                    Double.parseDouble(priceTextField.getText()),
                    Integer.parseInt(serialNumberTextField.getText()),
                    Double.parseDouble(screenSizeTextField.getText()),
                    Integer.parseInt(cameraTextField.getText()),
                    operatingSystemTextField.getText(),
                    Integer.parseInt(memoryTextField.getText()),
                    colourTextField.getText());

            successMessage.setText(DBUtility.insertPhoneIntoDB(newPhone));
        }
        catch (Exception error)
        {
            error.printStackTrace();
        }
    }

    public void homePage(ActionEvent event) throws IOException {
        SceneSwitcher.changeScenes(event, "views/dashboardView.fxml", "Mako - Home Page");
    }
}

