package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import models.SmartPhone;
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
    private ListView<SmartPhone> smartPhoneListView;

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
    private void addNewPhoneButton(ActionEvent event) throws IOException
    {
        SceneSwitcher.changeScenes(event, "views/createSmartPhoneView.fxml", "Mako - Add a New Smart Phone");
    }

    @FXML
    private void addNewSmartWatchButton(ActionEvent event) throws IOException
    {
        SceneSwitcher.changeScenes(event, "views/createSmartWatchView.fxml", "Mako - Add a New Smart Watch");
    }

    @FXML
    private void detailedPhoneViewButton(ActionEvent event) throws IOException
    {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/detailedSmartPhoneView.fxml"));
        Parent root = loader.load();

        DetailedSmartPhoneViewController controller = loader.getController();

        //Passing the info to the phoneDetailedView controller.
        controller.transferPhoneData(smartPhoneListView.getSelectionModel().getSelectedItem());

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        stage.setScene(new Scene(root));
        stage.setTitle("Mako - Smart Phone Details");
        stage.show();
    }

    @FXML
    private void detailedSmartWatchViewButton(ActionEvent event) throws IOException
    {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/detailedSmartWatchView.fxml"));
        Parent root = loader.load();

        DetailedSmartWatchViewController controller = loader.getController();

        //Passing the info to the phoneDetailedView controller.
        controller.transferSmartWatchData(smartWatchListView.getSelectionModel().getSelectedItem());

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        stage.setScene(new Scene(root));
        stage.setTitle("Mako - Smart Watch Details");
        stage.show();
    }


}
