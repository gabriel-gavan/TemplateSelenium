package Utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v102.page.model.InstallabilityError;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWrappers {
	public WebDriver driver;
	public SeleniumWrappers(WebDriver driver) {
		this.driver = driver;
	}
public void sendKeys(By locator, String value) {
	WebElement element =  driver.findElement(locator);
	waitForElmentToBeVisible(element);
	Log.info("Called <sendKeys> on element " + element.getAttribute("outerHTML"));
	try {
		Log.info("Called <clear> on element " + element.getAttribute("outer.HTML"));
		element.clear();
		Log.info("Called <sendKeys> on element " + element.getAttribute("outer.HTML"));
		element.sendKeys(value);
	}catch(Exception e) {
		Log.error("Element not found in method<SendKeys()>");
		Log.error(e.getMessage());
		
	}
}
	public void click(By locator) {
		WebElement element = driver.findElement(locator);
		Log.info("Called method <click()> on element " + element.getAttribute("outerHTML"));
		try{
			
			waitForElementToBeClickable(element);
			element.click();
		}catch(NoSuchElementException e) {
			Log.error("Element not found in method <click()> after 10 seconds");
			Log.error(e.getMessage());
		}catch (StaleElementReferenceException e ) {
		element = driver.findElement(locator);
		Log.info("Called for <StaleElementReferenceException> on element" + element.getAttribute("outerHTML"));
		element.click();
		 }
		}
	
	public void waitForElementToBeClickable(WebElement element) {
		try {
			Log.info("Called for <waitForElementToBeClickable>" + element.getAttribute("outerHTML"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch(NoSuchElementException e) {
			Log.error("Element not found in method <waitForElementToBeClickable> after 10 seconds");
			Log.error(e.getMessage());
		}
	}
	public void waitForElmentToBeVisible(WebElement element) {
		try {
			Log.info("Called <waitForElmentToBeVisible> on element " + element.getAttribute("outerHTML"));
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(element));
		}catch(NoSuchElementException e) {
			Log.error("Element not found in method <waitForElmentToBeVisible> after 10 seconds");
			Log.error(e.getMessage());
		}
	}
		
	public void dragAndDrop(By locator,int x, int y) {
		WebElement element = driver.findElement(locator);
		Actions action = new Actions(driver);
		action.dragAndDropBy(element, x,y).perform();
		
	//	action.clickAndHold(element).moveByOffset(300, 0).release().build().perform();
		//action.sendKeys(Keys.TAB).click().sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
		//action.moveByOffset(600, 300);
		//action.click();
	}
	
	public void hoverElement(By locator) {
		WebElement element = driver.findElement(locator);
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		
	}
	public String readURL() {
		return driver.getCurrentUrl();
	}
	public void findElement(By locator) {
		WebElement element  = driver.findElement(locator);
	}
}
