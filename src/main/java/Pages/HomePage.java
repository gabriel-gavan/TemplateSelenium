package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utils.SeleniumWrappers;

public class HomePage extends SeleniumWrappers{

	public HomePage(WebDriver driver) {
		super(driver);
		}
	public By facebooklink = By.cssSelector("a[href='https://www.facebook.com/keytraining.ro']");
	public By twiterlink = By.cssSelector("a[href='https://twitter.com/']");
	public By instagramlink = By.cssSelector("a[href='https://www.instagram.com']");
	
	public void clicklink(By locator) {
		hoverElement(locator);
		click(locator);
}

}