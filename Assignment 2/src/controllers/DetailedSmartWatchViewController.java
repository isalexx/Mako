package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import models.SmartWatch;
import utilities.SceneSwitcher;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class DetailedSmartWatchViewController {

    @FXML
    private TextField manufacturerTextField;

    @FXML
    private TextField modelTextField;

    @FXML
    private TextField priceTextField;

    @FXML
    private TextField serialNumberTextField;

    @FXML
    private TextField diameterTextField;

    @FXML
    private TextField finishTextField;

    @FXML
    private Label successMessage;

    @FXML
    private CheckBox heartRateSensCheckBox;

    /**
     * This is the button to go to the homepage.
     */
    @FXML
    public void homePage(ActionEvent event) throws IOException
    {
        SceneSwitcher.changeScenes(event, "views/dashboardView.fxml", "Mako - Home Page");
    }

    /**
     * This is the method to retrieve data from an arraylist into DetailedSmartWatch view.
     */
    public void transferSmartWatchData(SmartWatch selectedSmartWatch)
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
        textFields.add(diameterTextField);
        textFields.add(finishTextField);


        for (TextField textField : textFields)
        {
            textField.setEditable(false);
        }
        heartRateSensCheckBox.setDisable(true);

        //Setting the values into the text boxes.
        manufacturerTextField.setText(selectedSmartWatch.getManufacturer());
        modelTextField.setText(selectedSmartWatch.getModel());
        priceTextField.setText(String.valueOf(priceFormat.format(selectedSmartWatch.getPrice())));
        serialNumberTextField.setText(String.valueOf(selectedSmartWatch.getSerialNum()));
        diameterTextField.setText(String.valueOf(selectedSmartWatch.getDiameterMm()));
        finishTextField.setText(selectedSmartWatch.getFinish());
        heartRateSensCheckBox.setSelected(selectedSmartWatch.getHeartRateSens());
    }

}

