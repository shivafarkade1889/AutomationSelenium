package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;


public class ValidateTitleTest extends base {
	
	public WebDriver driver;
	
	public static Logger log = LogManager.getLogger(HomePageTest.class.getName());
	
	@BeforeTest
	public void launchBrowser() throws IOException {
		driver = initializeDriver();
		log.info("Browser driver is initalised");
		driver.get(prop.getProperty("url"));
		log.info("Browser hit the gome URL");
		log.info("Browser hit the gome URL 1");
		log.info("Browser hit the gome URL 2");
		log.info("Browser hit the gome URL 3");
		log.info("Browser hit the gome URL 4");
		log.info("Browser hit the gome URL 5");
	}

	@Test
	public void basePageNavigation() throws IOException {
		LandingPage l = new LandingPage(driver);
		Assert.assertEquals(l.getTitleofCurrentPage().getText(), "An Academy to Learn Earn & Shine  in your QA Career");
		log.info("Required deatisl are displayed on landing page");
		Assert.assertTrue(l.getMenuIcon().isDisplayed());
		log.info("Menu Icon is displayed");
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
		System.out.println("Running Browser is closed");
		log.info("Browser is closed");
	}
}
