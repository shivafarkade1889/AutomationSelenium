package Academy;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.SalesForceLandingPage;

public class DataBaseTest extends base {
	
public WebDriver driver;
	
	public static Logger log = LogManager.getLogger(HomePageTest.class.getName());
	
	@BeforeTest
	public void launchBrowser() throws IOException {
		driver = initializeDriver();
		log.info("Browser Driver is initalised");
		
	}
	
	@Test
	public void mySQLTest() throws SQLException {
		String userName = null;
		String password = null;
		ResultSet rs = dbConnection("select * from EmployeeInfo where location = \"Akot\";");
		while(rs.next()) {
			 userName = rs.getString("name");
			 password = rs.getString("location");
		}
		log.info("Test data grab succefully");
		
		driver.get("https://login.salesforce.com/?locale=eu");
		
		SalesForceLandingPage sf = new SalesForceLandingPage(driver);
		sf.userNameEditBox().sendKeys(userName);
		log.info("Test data entered in userName filed");
		sf.passwordEditBox().sendKeys(password);
		log.info("Test data entered in password filed");
		sf.loginButtonIcon().click();
		log.info("User able to click on Login button");
		Assert.assertEquals(sf.errorMessage().getText(),"Please check your username and password. If you still can't log in, contact your Salesforce administrator.");
		log.info("Text has been compared succefully");
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
		System.out.println("Running Browser is closed");
		log.info("Browser is closed");
	}
	

}
