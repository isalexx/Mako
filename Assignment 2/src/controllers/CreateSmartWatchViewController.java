package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import models.SmartWatch;
import utilities.DBUtility;
import utilities.SceneSwitcher;

import java.io.IOException;
import java.util.ArrayList;

public class CreateSmartWatchViewController {

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
    private CheckBox heartRateSensCheckBox;

    @FXML
    private Label successMessage;

    /**
     * This is the button to add a new watch into the database using the data from the text fields.
     */
    @FXML
    void addWatch(ActionEvent event)
    {
        if (fieldsArePopulated())
        {
            try
            {
                //Making new smart watch object using values from text fields.
                SmartWatch newSmartWatch = new SmartWatch(manufacturerTextField.getText(),
                        modelTextField.getText(),
                        Double.parseDouble(priceTextField.getText()),
                        Integer.parseInt(serialNumberTextField.getText()),
                        heartRateSensCheckBox.isSelected(),
                        Integer.parseInt(diameterTextField.getText()),
                        finishTextField.getText()
                );

                //This is the method to insert the watch into the database, and it also returns a success message (or failure)
                successMessage.setText(DBUtility.insertSmartWatchIntoDB(newSmartWatch));
            }
            catch (Exception error)
            {
                error.printStackTrace();
            }
        }

        else
            successMessage.setText("Failure!");
    }

    /**
     * This is the button to go back to the home page.
     */
    @FXML
    public void homePage(ActionEvent event) throws IOException
    {
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
        textFields.add(diameterTextField);
        textFields.add(finishTextField);

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

