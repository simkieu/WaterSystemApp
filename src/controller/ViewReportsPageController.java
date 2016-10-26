package controller;

import fxapp.MainFXApplication;
import model.*;

import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.scene.control.ListView;
import javafx.collections.ObservableList;
import java.util.ArrayList;

public class ViewReportsPageController {

    private MainFXApplication mainApplication;

    @FXML
    private ListView<String> list;

    @FXML
    /**
     * Initialize
     */
    private void initialize() {

        ObservableList<String> items = FXCollections.observableArrayList();
        ArrayList<WaterReport> reportList = ReportManager.getInstance().getReports();

        for (WaterReport r : reportList) {
            items.add(r.toString());
        }

        list.setItems(items);
    }

    /**
     * Set the main app
     * @param Set the main application to <main>
     */
    public void setMainApp(MainFXApplication main) {
        mainApplication = main;
    }

    @FXML
    /**
     * Back button
     */
    private void backPressed() {
        mainApplication.showMainAppPage();
    }
}
