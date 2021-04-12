package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import models.Phone;
import models.SmartWatch;
import utilities.DBUtility;
import utilities.SceneSwitcher;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DashboardViewController implements Initializable {

    @FXML
    private Label smartPhonesLabel;

    @FXML
    private ListView<Phone> smartPhoneListView;

    @FXML
    private Label smartWatchesLabel;

    @FXML
    private ListView<SmartWatch> smartWatchListView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        try {
            smartWatchListView.getItems().addAll(DBUtility.getWatchesFromDB());
            smartPhoneListView.getItems().addAll(DBUtility.getPhonesFromDB());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        smartPhonesLabel.setText("Smart Phones: " + smartPhoneListView.getItems().size());
        smartWatchesLabel.setText("Smart Watches: " + smartWatchListView.getItems().size());
    }

    @FXML
    private void AddNewPhoneButton(ActionEvent event) throws IOException
    {
        SceneSwitcher.changeScenes(event, "views/createPhoneView.fxml", "Maku - Add a New Phone");
    }
}
