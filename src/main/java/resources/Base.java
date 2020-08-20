package resources;

/*
 *  Download ChromeDriver.exe and set the path at Java Line:38 and Download geckodriver.exe and set the path at Java Line:42
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Base {

	public WebDriver driver;
	public Properties prop;
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir")+"//src//main//java//resources//data.properties");

		prop.load(fis);
		String browserName = prop.getProperty("browser");
		System.out.println("Testing started in : " + browserName);

		if (browserName.equals("chrome")) {
			//WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver", "/Users/kumarshashi/Documents/Software/chromedriver");
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/kumarshashi/Documents/Software/geckodriver");
			driver = new FirefoxDriver();
		} else if (browserName.equals("IE")) {
			driver = new InternetExplorerDriver();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		System.out.println(System.getProperty("user.dir"));
		String destinationPath = System.getProperty("user.dir")+ "/reports/"+testCaseName+ ".png";
		System.out.println(destinationPath);
		FileUtils.copyFile(src,new File(destinationPath));
		return destinationPath;

	}

}
