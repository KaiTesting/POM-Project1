package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.Base;

public class HomePage_LoginTest extends Base {

	public static Logger log = LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void setUp() throws IOException {
		driver = initilizeDriver();

	}

	@Test(dataProvider = "getData")
	public void Login(String userName, String passWord) throws IOException {

		driver.get("http://qaclickacademy.com/");
		log.info("Launching Browser");

		LandingPage Landing_Page = new LandingPage(driver);

		Landing_Page.getLogin().click();
		log.info("Clicked on Login button");

		LoginPage Login_Page = new LoginPage(driver);

		Login_Page.enterEmail().sendKeys(userName);
		log.info(userName);

		Login_Page.enterPassword().sendKeys(passWord);
		log.info(passWord);

		Login_Page.ClickLogInButton().click();
		log.info("Click submit button");

	}

	@DataProvider
	public Object[][] getData() {

		Object[][] data = new Object[2][2];

		data[0][0] = "username1@gmail.com";
		data[0][1] = "123456";

		data[1][0] = "username2@gmail.com";
		data[1][1] = "456789";

		return data;

	}

	@AfterTest
	public void tearDown() {
		driver.close();
		driver = null;
	}
}
