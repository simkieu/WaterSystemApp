package controller;

import model.CurrentLoggedInUser;

import fxapp.MainFXApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.RegisteredUsersList;
import model.User;

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
            User loggedUser = RegisteredUsersList.getInstance().getRegisteredUsersList().get
                    (username.getText());
            CurrentLoggedInUser.getInstance().setUser(loggedUser);
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
            errorMessage += "No valid user's name!\n";
        }
        else if (password.getText() == null || password.getText().length() == 0) {
            errorMessage += "No valid password entered!\n";
        }
        else if (!RegisteredUsersList.getInstance().getRegisteredUsersList().containsKey(username.getText())) {
            errorMessage += "This username has not been registered yet!\n";
        }
        else if (!password.getText().equals(RegisteredUsersList.getInstance()
                .getRegisteredUsersList().get(username.getText()).getPassword())) {
            errorMessage += "Your password for this account is incorrect!\n";
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
