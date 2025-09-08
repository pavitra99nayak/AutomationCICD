package LambdaTest.AbstractMethods;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	
	public static ExtentReports ExtentReporter()
	{
		String FilePath = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(FilePath);
		reporter.config().setDocumentTitle("Lambda Test Report");
		reporter.config().setReportName("Web UI Testing");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Pavitra Nayak");
		return extent;
	}

}
