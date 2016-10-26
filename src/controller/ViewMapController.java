package controller;

import com.lynden.gmapsfx.javascript.object.*;
import fxapp.MainFXApplication;

import com.lynden.gmapsfx.service.elevation.ElevationResult;
import com.lynden.gmapsfx.service.elevation.ElevationServiceCallback;
import com.lynden.gmapsfx.service.elevation.ElevationStatus;
import com.lynden.gmapsfx.javascript.event.UIEventType;

import com.lynden.gmapsfx.service.directions.DirectionStatus;
import com.lynden.gmapsfx.service.directions.DirectionsRenderer;
import com.lynden.gmapsfx.service.directions.DirectionsResult;
import com.lynden.gmapsfx.service.directions.DirectionsServiceCallback;
import com.lynden.gmapsfx.service.geocoding.GeocoderStatus;
import com.lynden.gmapsfx.service.geocoding.GeocodingResult;
import com.lynden.gmapsfx.service.geocoding.GeocodingService;
import com.lynden.gmapsfx.service.geocoding.GeocodingServiceCallback;
import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import netscape.javascript.JSObject;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.net.URL;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.*;

/**
 * Created by DangKhoa on 10/25/16.
 */
public class ViewMapController implements Initializable, MapComponentInitializedListener{

        private MainFXApplication mainApplication;

        @FXML
        private GoogleMapView mapsView;

        @FXML
        private TextField addressTextField;

        private GoogleMap map;

        private GeocodingService geocodingService;

        private StringProperty address = new SimpleStringProperty();

        @Override
        public void initialize(URL url, ResourceBundle rb) {
            mapsView.addMapInializedListener(this);
        }

        /**
         *  Set the main Application to <main>
         * @param The main application
         */
        public void setMainApp(MainFXApplication main) {
            mainApplication = main;
        }

        @Override
        public void mapInitialized() {
            geocodingService = new GeocodingService();
            MapOptions mapOptions = new MapOptions();
            LatLong GT = new LatLong(33.778463, -84.398881);
            mapOptions.center(GT)
                    .mapType(MapTypeIdEnum.ROADMAP)
                    .overviewMapControl(false)
                    .panControl(false)
                    .rotateControl(false)
                    .scaleControl(false)
                    .streetViewControl(false)
                    .zoomControl(false)
                    .zoom(12);
            map = mapsView.createMap(mapOptions);

            ArrayList<WaterReport> reportList = ReportManager.getInstance().getReports();
            for (WaterReport r : reportList) {

                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.position(r.getLatLong())
                        .title("My new Marker")
                        .animation(Animation.DROP)
                        .visible(true);
                Marker marker = new Marker(markerOptions);
                map.addUIEventHandler(marker,
                        UIEventType.click,
                        (JSObject obj) -> {
                            InfoWindowOptions infoWindowOptions = new InfoWindowOptions();
                            infoWindowOptions.content(r.toString());

                            InfoWindow window = new InfoWindow(infoWindowOptions);
                            window.open(map, marker);
                        });
                map.addMarker(marker);
            }



        }

        @FXML
        /**
         * Set function for back Button
         */
        private void backPressed() {
            mainApplication.showMainAppPage();
        }



}
