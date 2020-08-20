package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;

	By menu = By.linkText("Menu");
	By lifedesignString = By.xpath("//span[text()='We are Hiring']");
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;

	}

	public WebElement Menu() {
		return driver.findElement(menu);
	}
	
	public WebElement LifeDesignStringElement() {
		return driver.findElement(lifedesignString);
	}
}
