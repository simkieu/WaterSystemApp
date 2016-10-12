package controller;

import fxapp.MainFXApplication;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

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

    private MainFXApplication mainApplication;

    public void setMainApp(MainFXApplication main) {
        mainApplication = main;
    }
}
