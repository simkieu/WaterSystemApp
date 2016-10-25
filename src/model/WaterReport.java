package model;
import java.util.Date;

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

    public WaterReport(int id, String reporter, Date date, Location location, WaterType type, WaterCondition condition) {

        this.id = id;
        this.reporter = reporter;
        this.date = date;
        this.location = location;
        this.type = type;
        this.condition = condition;

    }

    public String toString() {
        return (location + ": " + type + " / " + condition + "  [#" + id + ", " + reporter + ", " + date + "]");
    }

}

