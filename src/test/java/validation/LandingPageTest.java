package validation;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pageObjects.LandingPage;
import pageObjects.LifeDesignStringPage;
import pageObjects.QAEngineerPage;
import resources.Base;

public class LandingPageTest extends Base {

	public WebDriver driver;
	LandingPage landingPage;
	LifeDesignStringPage lifeDesignStringObj;
	QAEngineerPage qaEngineerObj;
	WebDriverWait wait;

	public static Logger log = LogManager.getLogger(LandingPageTest.class.getName());

	@BeforeTest
	public void initialize() throws IOException {

		driver = initializeDriver();

	}

	@Test(priority = 1)
	public void GoToMenu() throws InterruptedException {

		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		log.info("Window screen got maximized");
		System.out.println("Window screen got maximized");
		landingPage = new LandingPage(driver);
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(landingPage.Menu()));
		landingPage.Menu().click();
		log.info("Clicked on Menu");
		System.out.println("Clicked on Menu");
		AssertJUnit.assertEquals(driver.getCurrentUrl(), prop.getProperty("url"));
		//Assert.fail();

	}

	@Test(priority = 2)
	public void SubmitProfile() throws InterruptedException {
		lifeDesignStringObj = new LifeDesignStringPage(driver);
		wait.until(ExpectedConditions.visibilityOf(landingPage.LifeDesignStringElement()));
		landingPage.LifeDesignStringElement().click();
		Thread.sleep(3000);
		log.info("Clicked on Life@DesignString");
		System.out.println("Clicked on Life@DesignString");
		AssertJUnit.assertEquals(lifeDesignStringObj.LifeDesignStringOnDesignString().getText(), "Life@DesignString");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", lifeDesignStringObj.QAEngineer());
		wait.until(ExpectedConditions.visibilityOf(lifeDesignStringObj.QAEngineer()));
		lifeDesignStringObj.QAEngineer().click();
		log.info("Clicked on QA Engineer");
		System.out.println("Clicked on QA Engineer");
		AssertJUnit.assertEquals(driver.getCurrentUrl(), prop.getProperty("urlQA"));

		qaEngineerObj = new QAEngineerPage(driver);
		wait.until(ExpectedConditions.visibilityOf(qaEngineerObj.QAEngineerText()));
		Thread.sleep(2000);
		qaEngineerObj.ContactName().click();
		qaEngineerObj.ContactName().sendKeys(prop.getProperty("contactName"));
		log.info("Send Contact Name");
		System.out.println("Send Contact Name");
		qaEngineerObj.ContactNumber().click();
		qaEngineerObj.ContactNumber().sendKeys(prop.getProperty("contactNumber"));
		log.info("Send Contact Number");
		System.out.println("Send Contact Number");
		qaEngineerObj.ContactEmail().click();
		qaEngineerObj.ContactEmail().sendKeys(prop.getProperty("contactEmail"));
		log.info("Send Contact Email");
		System.out.println("Send Contact Email");
		qaEngineerObj.TotalExp().click();
		qaEngineerObj.TotalExp().sendKeys(prop.getProperty("totalExp"));
		log.info("Send Total Exp");
		System.out.println("Send Total Exp");
		qaEngineerObj.CurrentCTC().click();
		qaEngineerObj.CurrentCTC().sendKeys(prop.getProperty("currentCTC"));
		log.info("Send Current CTC");
		System.out.println("Send Current CTC");
		qaEngineerObj.ExpectedCTC().click();
		qaEngineerObj.ExpectedCTC().sendKeys(prop.getProperty("expectedCTC"));
		log.info("Send Expected CTC");
		System.out.println("Send Expected CTC");
		Thread.sleep(1000);
		Select s = new Select(qaEngineerObj.NoticePeriod());
		s.selectByVisibleText(prop.getProperty("noticePeriod"));
		Thread.sleep(1000);
		log.info("Select Notice Period");
		System.out.println("Select Notice Period");

		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
		qaEngineerObj.Message().click();
		qaEngineerObj.Message().sendKeys(prop.getProperty("message"));
		log.info("Send Message");
		System.out.println("Send Message");

		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		qaEngineerObj.ChooseFile().sendKeys(prop.getProperty("filePath"));
		log.info("Choose File from Local");
		System.out.println("Choose File from Local");
		qaEngineerObj.Submit().click();
		log.info("Click on Submit Button");
		System.out.println("Click on Submit Button");

		log.info("Application submitted successfully");
		System.out.println("Application submitted successfully");

	}

	@AfterTest
	public void teardown() {

		driver.close();

	}
}
