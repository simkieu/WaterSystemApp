package model;

import java.util.ArrayList;
import java.util.Date;

/**
 * User: Kyle
 * Date: 10/18/16
 * Time: 7:00 PM
 */
public class ReportManager {

    private static final ReportManager instance = new ReportManager();

    public static ReportManager getInstance() { return instance; }

    private ArrayList<WaterReport> reports;

    /**
     * Constructor
     */
    public ReportManager() {
        reports = new ArrayList<WaterReport>();
    }

    /**
     * Create a report
     * @param reporter the reporter
     * @param location the location of the report
     * @param type      type of the water
     * @param condition the condition of the water
     */
    public void generateReport(User reporter, Location location, WaterType type, WaterCondition condition) {

        int id = reports.size();
        String reporterName = reporter.getName();
        Date date = new Date();

        WaterReport newReport = new WaterReport(id, reporterName, date, location, type, condition);
        reports.add(newReport);

    }

    /**
     *  Get all reports
     * @return List of all reports
     */
    public ArrayList<WaterReport> getReports() {
        return reports;
    }
}
