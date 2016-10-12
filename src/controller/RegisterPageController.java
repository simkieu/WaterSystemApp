package controller;

import fxapp.MainFXApplication;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.AccountType;
import model.CurrentLoggedInUser;
import model.RegisteredUsersList;
import model.User;

/**
 * Created by simkieu on 10/11/16.
 */
public class RegisterPageController {
    @FXML
    private TextField name;

    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    private ComboBox accountType;

    @FXML
    private void initialize() {
        accountType.setItems(FXCollections.observableArrayList(AccountType.values()));
        accountType.setValue(AccountType.User);
    }

    private MainFXApplication mainApplication;

    public void setMainApp(MainFXApplication main) {
        mainApplication = main;
    }

    @FXML
    public void CancelPressed() {
        mainApplication.showWelcomePage();
    }

    @FXML
    public void RegisterPressed() {
        if (isInputValid()) {
            User userToBeAdded = new User(name.getText(), username.getText(), password.getText(),
                    (AccountType) accountType.getValue());
            boolean result = RegisteredUsersList.getInstance().addUser(userToBeAdded);
            if (result) {
                mainApplication.showWelcomePage();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.initOwner(mainApplication.getMainScreen());
                alert.setTitle("Registered username");
                alert.setHeaderText("Registered username");
                alert.setContentText("Sorry, Someone already registered with this username!");
                alert.showAndWait();
            }
        }
    }

    private boolean isInputValid() {
        String errorMessage = "";

        //for now just check they actually typed something
        if (name.getText() == null || username.getText().length() == 0) {
            errorMessage += "No valid user's name!\n";
        }
        else if (username.getText() == null || username.getText().length() == 0) {
            errorMessage += "No valid user's id!\n";
        }
        else if (password.getText() == null || password.getText().length() == 0) {
            errorMessage += "No valid password entered!\n";
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
