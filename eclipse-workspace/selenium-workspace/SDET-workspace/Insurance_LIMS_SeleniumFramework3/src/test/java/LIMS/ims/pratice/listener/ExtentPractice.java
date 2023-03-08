package LIMS.ims.pratice.listener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentPractice {
	public static void main(String[] args) {

		ExtentSparkReporter spark = new ExtentSparkReporter("./helloworld");
		spark.config().setDocumentTitle("ullalal");
		spark.config().setReportName("rep name");
		ExtentReports report = new ExtentReports();
		report.attachReporter(spark);
		ExtentTest hello = report.createTest("hai hello namaste");
		hello.warning("warn");
		report.flush();

	}

}
