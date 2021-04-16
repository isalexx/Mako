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

    /**
     * This is the button to add a new phone into the database using the data from the text fields.
     */
    @FXML
    public void addPhone() {

        if (fieldsArePopulated())
        {
            try
            {
                //Creating a new smart phone object using the text fields values.
                SmartPhone newSmartPhone = new SmartPhone(manufacturerTextField.getText(),
                        modelTextField.getText(),
                        Double.parseDouble(priceTextField.getText()),
                        Integer.parseInt(serialNumberTextField.getText()),
                        Double.parseDouble(screenSizeTextField.getText()),
                        Integer.parseInt(cameraTextField.getText()),
                        operatingSystemTextField.getText(),
                        Integer.parseInt(memoryTextField.getText()),
                        colourTextField.getText());

                //This is the method to insert the phone into the database, and it also returns a success message (or failure)
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

    /**
     * This is the button to go to the homepage.
     */
    public void homePage(ActionEvent event) throws IOException {
        SceneSwitcher.changeScenes(event, "views/dashboardView.fxml", "Mako - Home Page");
    }

    /**
     * This is a method to check the fields were populated. If they arent, tells the user the insertion failed.
     */
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

