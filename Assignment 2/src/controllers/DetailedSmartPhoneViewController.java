package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import models.SmartPhone;
import utilities.SceneSwitcher;
import java.text.DecimalFormat;

import java.io.IOException;
import java.util.ArrayList;

public class DetailedSmartPhoneViewController {

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

    /**
     * This is the button to go to the homepage.
     */
    @FXML
    public void homePage(ActionEvent event) throws IOException
    {
        SceneSwitcher.changeScenes(event, "views/dashboardView.fxml", "Mako - Home Page");
    }

    /**
     * This is the method to transfer the phone data from the list to DetailedSmartPhone view.
     */
    public void transferPhoneData(SmartPhone selectedSmartPhone)
    {
        //This is something that will help us round the values.
        DecimalFormat screenSizeFormat = new DecimalFormat("0.0");
        DecimalFormat priceFormat = new DecimalFormat("0.00");

        //Setting all of the text fields to be un-editable.
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

        for (TextField textField : textFields)
        {
            textField.setEditable(false);
        }

        //Setting the values into the text boxes.
        manufacturerTextField.setText(selectedSmartPhone.getManufacturer());
        modelTextField.setText(selectedSmartPhone.getModel());
        priceTextField.setText(String.valueOf(priceFormat.format(selectedSmartPhone.getPrice())));
        serialNumberTextField.setText(String.valueOf(selectedSmartPhone.getSerialNum()));
        screenSizeTextField.setText(String.valueOf(screenSizeFormat.format(selectedSmartPhone.getScreenSizeInch())));
        cameraTextField.setText(String.valueOf(selectedSmartPhone.getCameraMp()));
        operatingSystemTextField.setText(selectedSmartPhone.getOperatingSystem());
        memoryTextField.setText(String.valueOf(selectedSmartPhone.getMemoryGb()));
        colourTextField.setText(selectedSmartPhone.getColour());
    }
}
