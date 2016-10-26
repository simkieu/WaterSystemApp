package model;

import java.util.ArrayList;

/**
 * User: Kyle
 * Date: 10/18/16
 * Time: 7:18 PM
 */
public class LocationManager
{
    private ArrayList<Location> locations;

    /**
     * Add a locaction
     * @param location the location to be added
     */
    public void addLocation(Location location) {
        locations.add(location);
    }
}
