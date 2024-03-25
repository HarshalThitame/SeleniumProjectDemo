package listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import utilities.ExtentReporter;

public class Listeners extends Base implements ITestListener {

	public WebDriver driver = null;
	ExtentReports extentReport = ExtentReporter.getExtentReport();
	ExtentTest extentTest;
	ThreadLocal<ExtentTest> extentTestThread = new ThreadLocal<>(); // Thread safe Extent reports

	@Override
	public void onTestStart(ITestResult result) {

		String testName = result.getName();
		extentTest = extentReport.createTest(testName + " execution started");
		extentTestThread.set(extentTest);

	}

	@Override
	public void onTestSuccess(ITestResult result) {

		String testName = result.getName();
//		extentTest.log(Status.PASS,testName+ "get passed");

		extentTestThread.get().log(Status.PASS, testName + "get passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {

//		extentTest.fail(result.getThrowable());
		extentTestThread.get().fail(result.getThrowable());

		String testName = result.getName();

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());

			String sreenshotFilePath = takeSreenshot(testName, driver);
			extentTestThread.get().addScreenCaptureFromPath(sreenshotFilePath, testName);

		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException
				| IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {
		extentReport.flush();

	}

}
