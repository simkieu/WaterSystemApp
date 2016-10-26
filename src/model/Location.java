package model;

import java.util.ArrayList;
import com.lynden.gmapsfx.javascript.object.LatLong;


/**
 * User: Kyle
 * Date: 10/18/16
 * Time: 6:24 PM
 */
public class Location
{

    private String name;
    private double latitude;
    private double longitude;
    private ArrayList<WaterReport> reports;

    public Location(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        reports = new ArrayList<WaterReport>();
    }
    public LatLong getLatLong() {
        return new LatLong(latitude, longitude);
    }
    public String toString() {
        return (name + " (" + String.format("%.4f", latitude) + ", " + String.format("%.4f", longitude) + ")");
    }
}
