package groupid1.artifact1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseSetup {
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Running Before Suite....");
	}
	
	@BeforeClass
	public void beforeClass () {
		System.out.println("Running Before Class....");
		
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Running Before Method....");
	}
	
	@BeforeTest 
	public void beforeTest(){
		System.out.println("Running Before Test....");
	}
	
	@BeforeGroups
	public void beforeGroups() {
		System.out.println("Running Before Groups");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("Running After Suite....");
	}
	
	@AfterClass
	public void afterClass () {
		System.out.println("Running After Class....");
		
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("Running After Method....");
	}
	
	@AfterTest 
	public void afterTest(){
		System.out.println("Running After Test....");
	}
	
	@AfterGroups
	public void afterGroups() {
		System.out.println("Running After Groups");
	}
	

}
