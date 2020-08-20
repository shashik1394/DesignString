package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LifeDesignStringPage {

	public WebDriver driver;

	By lifedesignStringOnDesignString = By.xpath("//h5[text()='Life@DesignString']");
	By qaEngineer = By.xpath("//span[text()='QA Engineer']");
	
	public LifeDesignStringPage(WebDriver driver) {
		this.driver = driver;

	}
	
	public WebElement LifeDesignStringOnDesignString() {
		return driver.findElement(lifedesignStringOnDesignString);
	}
	
	public WebElement QAEngineer() {
		return driver.findElement(qaEngineer);
	}
}
