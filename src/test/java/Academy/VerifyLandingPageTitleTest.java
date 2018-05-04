package Academy;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.Base;

public class VerifyLandingPageTitleTest extends Base {

	public static Logger log = LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void setUp() throws IOException {
		driver = initilizeDriver();

		driver.get("http://qaclickacademy.com/");
		log.info("Launching Browser");
	}

	@Test
	public void Login() throws IOException {

		LandingPage Landing_Page = new LandingPage(driver);

		String Title = driver.getTitle();

		Assert.assertEquals(Title,
				"QA Click Academy | Selenium,Jmeter,SoapUI,Appium,Database testing,QA Training Academy");
		
		log.info(Title);

	}

	@AfterTest
	public void tearDown() {
		driver.close();
		driver = null;
	}

}
