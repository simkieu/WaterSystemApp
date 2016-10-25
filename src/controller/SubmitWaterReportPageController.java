package controller;

import fxapp.MainFXApplication;
import model.*;

import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert;

/**
 * User: Kyle
 * Date: 10/18/16
 * Time: 7:23 PM
 */
public class SubmitWaterReportPageController {

    private MainFXApplication mainApplication;

    @FXML
    private TextField locationName;

    @FXML
    private TextField latitudeField;

    @FXML
    private TextField longitudeField;

    @FXML
    private ComboBox waterType;

    @FXML
    private ComboBox waterCondition;

    @FXML
    private void initialize() {

        waterType.setItems(FXCollections.observableArrayList(WaterType.values()));
        waterType.setValue(WaterType.Bottled);

        waterCondition.setItems(FXCollections.observableArrayList(WaterCondition.values()));
        waterCondition.setValue(WaterCondition.Waste);

    }

    public void setMainApp(MainFXApplication main) {
        mainApplication = main;
    }

    @FXML
    public void CancelPressed() {
        mainApplication.showMainAppPage();
    }

    @FXML
    public void SubmitPressed() {

        if (isInputValid()) {

            double latitude = Double.parseDouble(latitudeField.getText());
            double longitude = Double.parseDouble(longitudeField.getText());
            Location location = new Location(locationName.getText(), latitude, longitude);
            User reporter = (CurrentLoggedInUser.getInstance()).getCurrentUser();

            ReportManager.getInstance().generateReport(reporter, location, (WaterType) waterType.getValue(), (WaterCondition) waterCondition.getValue());

            mainApplication.showMainAppPage();

        }

    }

    private boolean isInputValid() {
        String errorMessage = "";

        //for now just check they actually typed something
        if (locationName.getText() == null || locationName.getText().length() == 0) {
            errorMessage += "Invalid location name.\n";
        }

        String lat = latitudeField.getText();
        String lon = longitudeField.getText();

        //checks if latitude and longitude contain only appropriate characters
        if ((! lat.matches("[0-9-.]+")) || lat == null || lat.length() == 0) {
            errorMessage += "Invalid latitude.\n";
        }
        if ((! lon.matches("[0-9-.]+")) || lon == null || lon.length() == 0) {
            errorMessage += "Invalid longitude.\n";
        }

        //no error message means success / good input
        if (errorMessage.length() == 0) {

            return true;

        } else {

            // Show the error message if bad data
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(mainApplication.getMainScreen());
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;

        }
    }
}
