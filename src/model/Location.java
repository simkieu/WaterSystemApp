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

    /**
     * COnstructor
     * @param name the name of the location
     * @param latitude latitude of the location
     * @param longitude longtitude of the location
     */
    public Location(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        reports = new ArrayList<WaterReport>();
    }

    /**
     *
     * @return The latittude and longtitude
     */
    public LatLong getLatLong() {
        return new LatLong(latitude, longitude);
    }

    /**
     *
     * @return The string represent the information
     */
    public String toString() {
        return (name + " (" + String.format("%.4f", latitude) + ", " + String.format("%.4f", longitude) + ")");
    }
}
