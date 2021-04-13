package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import models.SmartPhone;
import utilities.DBUtility;
import utilities.SceneSwitcher;

import java.io.IOException;
import java.util.ArrayList;

public class CreateSmartPhoneViewController {

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

        if (fieldsArePopulated())
        {
            try
            {
                SmartPhone newSmartPhone = new SmartPhone(manufacturerTextField.getText(),
                        modelTextField.getText(),
                        Double.parseDouble(priceTextField.getText()),
                        Integer.parseInt(serialNumberTextField.getText()),
                        Double.parseDouble(screenSizeTextField.getText()),
                        Integer.parseInt(cameraTextField.getText()),
                        operatingSystemTextField.getText(),
                        Integer.parseInt(memoryTextField.getText()),
                        colourTextField.getText());

                successMessage.setText(DBUtility.insertPhoneIntoDB(newSmartPhone));
            }
            catch (Exception error)
            {
                error.printStackTrace();
            }
        }

        else
        {
            successMessage.setText("Failure!");
        }
    }

    public void homePage(ActionEvent event) throws IOException {
        SceneSwitcher.changeScenes(event, "views/dashboardView.fxml", "Mako - Home Page");
    }

    private boolean fieldsArePopulated()
    {
        boolean ok = true;

        ArrayList<TextField> textFields = new ArrayList<>();
        textFields.add(manufacturerTextField);
        textFields.add(modelTextField);
        textFields.add(priceTextField);
        textFields.add(serialNumberTextField);
        textFields.add(screenSizeTextField);
        textFields.add(cameraTextField);
        textFields.add(operatingSystemTextField);
        textFields.add(memoryTextField);
        textFields.add(colourTextField);

        for (TextField textfield : textFields)
        {
            if (textfield.getText().isEmpty())
            {
                ok = false;
            }
        }

        return ok;
    }
}

