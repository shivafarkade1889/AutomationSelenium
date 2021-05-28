package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	static ExtentReports report;
	
	public static ExtentReports getReportObject() {
		String path = System.getProperty("user.dir")+"\\Reports\\index.html";
		ExtentSparkReporter ex = new ExtentSparkReporter(path);
		ex.config().setReportName("Web Automation Result");
		ex.config().setDocumentTitle("Test Results");
		
		report = new ExtentReports();
		report.attachReporter(ex);
		report.setSystemInfo("Tester", "Shiva Farkade");
		return report;
	}

}
