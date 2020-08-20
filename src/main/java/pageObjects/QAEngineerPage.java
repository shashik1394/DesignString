package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class QAEngineerPage {

	public WebDriver driver;
	
	By qaEngineerText = By.xpath("//h1[text()='QA Engineer']");
	By contactName = By.xpath("//input[@placeholder='eg. John Doe']");
	By contactNumber = By.xpath("//input[@type='tel']");
	By contactEmail = By.xpath("//input[@placeholder='eg. johndoe@example.com']");
	By totalExp = By.xpath("//input[@placeholder='eg. 2 years']");
	By currentCTC = By.xpath("//input[@placeholder='eg. 4 LPA']");
	By expectedCTC = By.xpath("//input[@placeholder='eg. 5 LPA']");
	By noticePeriod = By.xpath("//select[@id='notice-period']");
	By message = By.xpath("//textarea[@placeholder='Enter message']");
	By filePath = By.xpath("//input[@type='file']");
	By submit = By.xpath("//button[@type='submit']");
	
	public QAEngineerPage(WebDriver driver) {
		this.driver = driver;

	}
	
	public WebElement QAEngineerText() {
		return driver.findElement(qaEngineerText);
	}
	
	public WebElement ContactName() {
		return driver.findElement(contactName);
	}
	
	public WebElement ContactNumber() {
		return driver.findElement(contactNumber);
	}
	
	public WebElement ContactEmail() {
		return driver.findElement(contactEmail);
	}
	
	public WebElement TotalExp() {
		return driver.findElement(totalExp);
	}
	
	public WebElement CurrentCTC() {
		return driver.findElement(currentCTC);
	}
	
	public WebElement ExpectedCTC() {
		return driver.findElement(expectedCTC);
	}
	
	public WebElement NoticePeriod() {
		return driver.findElement(noticePeriod);
	}
	
	public WebElement Message() {
		return driver.findElement(message);
	}
	
	public WebElement ChooseFile() {
		return driver.findElement(filePath);
	}
	
	public WebElement Submit() {
		return driver.findElement(submit);
	}
}
