package Genric_Utilities;

import java.io.IOException;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportImp  implements ITestListener{
	ExtentReports report;
	ExtentTest test;
	public void onTestStart(ITestResult result) {
		test=report.createTest(result.getMethod().getMethodName());
	}
	public void onTestSuccess(ITestResult result) {
	    test.log(Status.PASS, result.getMethod().getMethodName() + " passed successfully");
	    // Don't log result.getThrowable() here, because it's null on success
	}
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getThrowable());
		
		String screenShot=null;
		try {
			screenShot = WebDriver_Utility.takeScreenShotEx(BaseClass.sdriver,result.getMethod().getMethodName());
			}catch(Throwable e) {
				e.printStackTrace();
			}
		try {
			test.addScreenCaptureFromPath(screenShot);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());
	}
	public void onStart(ITestContext context) {
		String dateAndTime = new Date().toString().replace(" ","_").replace(":","_");
		ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReport/report_" + dateAndTime + ".html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("VtigerReport");
		spark.config().setReportName("vishnu");
		
		//system configure
		report= new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("platform", "windows");
		report.setSystemInfo("executedBy", "VISHNU");
		report.setSystemInfo("reviwedBy", "ARUNA");
	}
	public void onFinish(ITestContext context) {
		report.flush();
	}
	/*public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}*/
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
}
