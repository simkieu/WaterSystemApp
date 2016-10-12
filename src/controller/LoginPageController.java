package controller;

import model.CurrentLoggedInUser;

import fxapp.MainFXApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Created by simkieu on 9/29/16.
 */
public class LoginPageController {

    @FXML
    private TextField username;

    @FXML
    private TextField password;

    private MainFXApplication mainApplication;

    public void setMainApp(MainFXApplication main) {
        mainApplication = main;
    }

    @FXML
    public void LoginRequest() {

        if (isInputValid()) {
            CurrentLoggedInUser.getInstance().setUsername(username.getText());
            mainApplication.showMainAppPage();
        }
    }

    @FXML
    public void CancelPressed() {
        mainApplication.showWelcomePage();
    }

    private boolean isInputValid() {
        String errorMessage = "";

        //for now just check they actually typed something
        if (username.getText() == null || username.getText().length() == 0) {
            errorMessage += "No valid student name!\n";
        }
        else if (password.getText() == null || password.getText().length() == 0) {
            errorMessage += "No valid major entered!\n";
        }
        else if (!username.getText().equals("user") || !password.getText().equals("pass")) {
            errorMessage += "username and password do not match!\n";
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
