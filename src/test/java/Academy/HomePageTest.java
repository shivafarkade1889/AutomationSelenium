package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class HomePageTest extends base {
	
	public WebDriver driver;
	
	public static Logger log = LogManager.getLogger(HomePageTest.class.getName());
	
	@BeforeTest
	public void launchBrowser() throws IOException {
		driver = initializeDriver();
		log.info("Browser Driver is initalised");
		
	}

	@Test(dataProvider="getData")
	public void basePageNavigation(String userName, String password, String message) throws IOException {	
		driver.get(prop.getProperty("url"));
		log.info("Browser Hit the home URL");
		LandingPage l = new LandingPage(driver);
		LoginPage lp =l.loginButton();
		lp.emailTextBox().sendKeys(userName);
		lp.passwordTextBox().sendKeys(password);
		//lp.loginButton().click();
		System.out.println(message);
		log.info("Login succesfull");
		ForgotPage fp = lp.forgotPasswordLink();
		fp.emailTextBox().sendKeys(userName);
		fp.sendMeInstructionLink().click();
		log.info("Forgot Link send succesfull");
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
		System.out.println("Running Browser is closed");
		log.info("Browser is closed");
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][3];
		
		data[0][0] = "test@gmail.com";
		data[0][1] = "Test@#1889";
		data[0][2] = "TestCase Failed";
		
		data[1][0] = "test-1@gmail.com";
		data[1][1] = "Test-1@#1889";
		data[1][2] = "TestCase Failed with 2nd User";
		
		return data;
	}
	
}
