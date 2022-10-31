package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utils.SeleniumWrappers;

public class EventsPage extends SeleniumWrappers{

	public EventsPage(WebDriver driver) {
		super(driver);
		}
	
	public By festivalOfOldFilmsLinks = By.linkText("Festival of Old Films");
	
	
}
