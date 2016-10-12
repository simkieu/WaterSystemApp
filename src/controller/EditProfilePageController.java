package controller;

import fxapp.MainFXApplication;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.AccountType;
import model.CurrentLoggedInUser;
import model.RegisteredUsersList;
import model.User;

/**
 * Created by simkieu on 10/12/16.
 */
public class EditProfilePageController {

    @FXML
    private Label username;

    @FXML
    private TextField name;

    @FXML
    private TextField password;

    @FXML
    private ComboBox accountType;

    @FXML
    private void initialize() {
        username.setText(CurrentLoggedInUser.getInstance().getCurrentUser().getUserName());
        name.setText(CurrentLoggedInUser.getInstance().getCurrentUser().getName());
        accountType.setItems(FXCollections.observableArrayList(AccountType.values()));
        accountType.setValue(CurrentLoggedInUser.getInstance().getCurrentUser().getAccountType());

    }

    private MainFXApplication mainApplication;

    public void setMainApp(MainFXApplication main) {
        mainApplication = main;
    }

    @FXML
    public void UpdateProfilePressed() {
        if (isInputValid()) {
            User modifiedUser = new User(name.getText(), username.getText(), password.getText(),
                    (AccountType) accountType.getValue());
            CurrentLoggedInUser.getInstance().setUser(modifiedUser);
            RegisteredUsersList.getInstance().getRegisteredUsersList().put(username.getText(),
                    modifiedUser);
            mainApplication.showMainAppPage();
        }
    }

    private boolean isInputValid() {
        String errorMessage = "";

        //for now just check they actually typed something
        if (name.getText() == null || username.getText().length() == 0) {
            errorMessage += "No valid user's name!\n";
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

    @FXML
    public void CancelPressed() {
        mainApplication.showMainAppPage();
    }
}
