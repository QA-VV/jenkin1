package groupid1.artifact1;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportSetup implements ITestListener {
	
	
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extentReport;
	public ExtentTest test;
	

	 /**
	   * Invoked each time before a test will be invoked. The <code>ITestResult</code> is only partially
	   * filled with the references to class, method, start millis and status.
	   *
	   * @param result the partially filled <code>ITestResult</code>
	   * @see ITestResult#STARTED
	   */
	  public void onTestStart(ITestResult result) {
	   System.out.println("--------------------Listener -> onTestStart");
	   test = extentReport.createTest(result.getName());
	   
	  }

	  /**
	   * Invoked each time a test succeeds.
	   *
	   * @param result <code>ITestResult</code> containing information about the run test
	   * @see ITestResult#SUCCESS
	   */
	  public void onTestSuccess(ITestResult result) {
		  System.out.println("--------------------Listener -> onTestSuccess");
	  }

	  /**
	   * Invoked each time a test fails.
	   *
	   * @param result <code>ITestResult</code> containing information about the run test
	   * @see ITestResult#FAILURE
	   */
	  public void onTestFailure(ITestResult result) {
		  System.out.println("--------------------Listener -> onTestFailure");
	  }

	  /**
	   * Invoked each time a test is skipped.
	   *
	   * @param result <code>ITestResult</code> containing information about the run test
	   * @see ITestResult#SKIP
	   */
	  public void onTestSkipped(ITestResult result) {
		  System.out.println("--------------------Listener -> onTestSkipped");
	  }

	  /**
	   * Invoked each time a method fails but has been annotated with successPercentage and this failure
	   * still keeps it within the success percentage requested.
	   *
	   * @param result <code>ITestResult</code> containing information about the run test
	   * @see ITestResult#SUCCESS_PERCENTAGE_FAILURE
	   */
	  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	    // not implemented
	  }

	  /**
	   * Invoked each time a test fails due to a timeout.
	   *
	   * @param result <code>ITestResult</code> containing information about the run test
	   */
	  public void onTestFailedWithTimeout(ITestResult result) {
	    onTestFailure(result);
	  }

	  /**
	   * Invoked before running all the test methods belonging to the classes inside the &lt;test&gt;
	   * tag and calling all their Configuration methods.
	   *
	   * @param context The test context
	   */
	  public void onStart(ITestContext context) {
		  System.out.println("--------------------Listener -> onStart");
		  
		  File file = new File("MyHtmlReport.html");
			
		    
		    sparkReporter = new ExtentSparkReporter(file);
		    sparkReporter.config().setDocumentTitle("Automation Reports");
		    sparkReporter.config().setTheme(Theme.DARK);
		    sparkReporter.config().setReportName("Functional REport");
		    
		    extentReport = new ExtentReports();
		    extentReport.attachReporter(sparkReporter);
		    
		    extentReport.setSystemInfo("Operating system name", System.getProperty("os.name"));
		    extentReport.setSystemInfo("Operating system version", System.getProperty("os.version"));
		    extentReport.setSystemInfo("User's account name", System.getProperty("user.name"));
		    extentReport.setSystemInfo("User's home directory", System.getProperty("user.home"));
		    extentReport.setSystemInfo("User's current working directory", System.getProperty("user.dir"));
	  }

	  /**
	   * Invoked after all the test methods belonging to the classes inside the &lt;test&gt; tag have
	   * run and all their Configuration methods have been called.
	   *
	   * @param context The test context
	   */
	  public void onFinish(ITestContext context) {
		  System.out.println("--------------------Listener -> onFinish");
		  extentReport.flush();
	  }

}
