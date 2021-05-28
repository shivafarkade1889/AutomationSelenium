package Academy;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;



public class base {
	
public WebDriver driver;
public Properties prop;
	
public WebDriver initializeDriver() throws IOException {
	
	prop = new Properties();
	FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
	prop.load(fis);
	String browserName = prop.getProperty("browser");
	//String browserName = System.getProperty("browser");
	System.out.println(browserName);
	if(browserName.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}
	else if(browserName.equals("firefox"))
	{
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\src\\main\\java\\resources\\geckodriver.exe");
		 driver = new FirefoxDriver();
		 driver.manage().window().maximize();
	}
	else if(browserName.equals("IE")) {
		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\IEDriverServer.exe");
		 driver = new InternetExplorerDriver();
		 driver.manage().window().maximize();
	}
	else if(browserName.equals("headless")) {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
	}
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;
}

public  String getScreenShotPath(String testMethodName, WebDriver driver) throws IOException {
	TakesScreenshot ts=(TakesScreenshot)driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testMethodName+".png";
	FileUtils.copyFile(source, new File(destinationFile));
	return destinationFile;
}


public  ResultSet dbConnection(String query) throws SQLException {
	
	String host = "localhost";
	String port = "3306";
	
	Connection con =DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/seleniumQA","root","Premlata@1889");
	
	Statement s = con.createStatement();
	ResultSet rs = s.executeQuery(query);
	return rs;
}

}
