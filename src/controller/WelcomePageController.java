package controller;

import fxapp.MainFXApplication;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;

public class WelcomePageController {

    private MainFXApplication mainApplication;

    public void setMainApp(MainFXApplication main) {
        mainApplication = main;
    }

    @FXML
    public void LoginPressed() {
        mainApplication.showLoginPage();
    }

    @FXML
    public void RegisterPressed() {
        mainApplication.showRegisterPage();
    }
}
