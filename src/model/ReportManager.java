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

    public ReportManager() {
        reports = new ArrayList<WaterReport>();
    }

    public void generateReport(User reporter, Location location, WaterType type, WaterCondition condition) {

        int id = reports.size();
        String reporterName = reporter.getName();
        Date date = new Date();

        WaterReport newReport = new WaterReport(id, reporterName, date, location, type, condition);
        reports.add(newReport);

    }

    public ArrayList<WaterReport> getReports() {
        return reports;
    }
}
