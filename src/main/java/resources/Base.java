package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Base {

	public static WebDriver driver;

	public Properties prop;

	public WebDriver initilizeDriver() throws IOException {

		prop = new Properties();

		FileInputStream fis = new FileInputStream(
				"C:\\Users\\kevser\\E2EProject\\src\\main\\java\\resources\\data.properties");

		prop.load(fis);

		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\kevser\\E2EProject\\src\\drivers\\chromedriver.exe");

			driver = new ChromeDriver();

		} else if (browserName.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\kevser\\E2EProject\\src\\drivers\\geckodriver.exe");

			driver = new FirefoxDriver();

		} else if (browserName.equals("IE")) {

			System.setProperty("webdriver.ie.driver",
					"C:\\Users\\kevser\\E2EProject\\src\\drivers\\MicrosoftWebDriver.exe");

			driver = new InternetExplorerDriver();
		}

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		return driver;
	}
	
	public void getScreenShot(String result) throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:/Users/kevser/E2EProject/src/FaiedScreen/ "+result+"_ScreenShot.png"));
	}
}
