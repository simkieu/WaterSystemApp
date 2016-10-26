package model;
import java.util.Date;
import com.lynden.gmapsfx.javascript.object.LatLong;


/**
 * User: Kyle
 * Date: 10/18/16
 * Time: 6:02 PM
 */
public class WaterReport {

    private int id;
    private String reporter;
    private Date date;

    private Location location;
    private WaterType type;
    private WaterCondition condition;

    /**
     * Construcotr
     * @param the ID of the report
     * @param the person who reported
     * @param Date of the report
     * @param location of the report
     * @param type of the water
     * @param condition of the water
     */
    public WaterReport(int id, String reporter, Date date, Location location, WaterType type, WaterCondition condition) {

        this.id = id;
        this.reporter = reporter;
        this.date = date;
        this.location = location;
        this.type = type;
        this.condition = condition;

    }

    /**
     *
     * @return The latittude and longtitude of the report
     */
    public LatLong getLatLong() {
        return location.getLatLong();
    }

    /**
     *
     * @return the string represent the information of the report
     */
    public String toString() {
        return (location + ": " + type + " / " + condition + "  [#" + id + ", " + reporter + ", " + date + "]");
    }

}

