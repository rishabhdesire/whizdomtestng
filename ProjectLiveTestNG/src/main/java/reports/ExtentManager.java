package reports;

import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	static ExtentReports reports;
	
	public static ExtentReports getReports() {
		
		if(reports==null)
		{
			reports = new ExtentReports();
			Date d = new Date();
			String reportsFolderPath = System.getProperty("user.dir")+"//Reports//"+d.toString().replace(":", "-");
			String screenshotsFolderPath = reportsFolderPath+"//Screenshots//";
			
			File f = new File(screenshotsFolderPath);
			f.mkdirs();
			
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportsFolderPath);
			sparkReporter.config().setDocumentTitle("Automation Reports");
			sparkReporter.config().setReportName("Production Testing Reports");
			sparkReporter.config().setTheme(Theme.DARK);
			sparkReporter.config().setEncoding("utf-8");
			
			reports.attachReporter(sparkReporter);
		}
	
		return reports;
	}

}
