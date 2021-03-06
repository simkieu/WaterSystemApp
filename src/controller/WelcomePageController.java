package controller;

import fxapp.MainFXApplication;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;

public class WelcomePageController {

    private MainFXApplication mainApplication;

    /**
     * Set main app
     * @param main Set main app to <main>
     */
    public void setMainApp(MainFXApplication main) {
        mainApplication = main;
    }

    @FXML
    /**
     * Open login Page when press Login Button
     */
    public void LoginPressed() {
        mainApplication.showLoginPage();
    }

    @FXML
    /**
     * Register Button when pressed
     */
    public void RegisterPressed() {
        mainApplication.showRegisterPage();
    }
}
