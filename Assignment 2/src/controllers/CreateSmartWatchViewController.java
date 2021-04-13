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

    @FXML
    void addWatch(ActionEvent event)
    {
        if (fieldsArePopulated())
        {
            try
            {
                SmartWatch newSmartWatch = new SmartWatch(manufacturerTextField.getText(),
                        modelTextField.getText(),
                        Double.parseDouble(priceTextField.getText()),
                        Integer.parseInt(serialNumberTextField.getText()),
                        heartRateSensCheckBox.isSelected(),
                        Integer.parseInt(diameterTextField.getText()),
                        finishTextField.getText()
                );

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

    @FXML
    public void homePage(ActionEvent event) throws IOException
    {
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

