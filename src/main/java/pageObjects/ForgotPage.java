package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPage {
	public WebDriver driver;
	
	public ForgotPage(WebDriver driver) {
		this.driver=driver;
	}

	private By email = By.xpath("//input[@id='user_email']");
	
	private By sendMeInstruction = By.xpath("//input[@name='commit']");


	public WebElement emailTextBox() {
		return driver.findElement(email);
	}
	
	public WebElement sendMeInstructionLink() {
		return driver.findElement(sendMeInstruction);
	}
	
}
