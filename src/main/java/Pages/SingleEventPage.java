package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utils.SeleniumWrappers;

public class SingleEventPage extends SeleniumWrappers{

	public SingleEventPage(WebDriver driver) {
		super(driver);
		}

	public By map = By.partialLinkText("map");
	
	public By iframe = By.tagName("iframe");
	
	public void clickMap() {
		hoverElement(iframe);
		driver.switchTo().frame(getElement(iframe));
		click(map);
	}
}
