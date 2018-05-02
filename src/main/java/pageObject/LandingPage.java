package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;

	By signin = By.xpath("//*[@id='homepage']/header/div[1]/div/nav/ul/li[4]/a/span");
	By email = By.xpath("//*[@id='user_email']");

	public LandingPage(WebDriver driver) {

		this.driver = driver;
	}

	public WebElement getLogin() {

		return driver.findElement(signin);
	}

	public WebElement enterEmail() {

		return driver.findElement(email);
	}

}
