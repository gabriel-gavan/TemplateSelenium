package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utils.SeleniumWrappers;

public class PostFormatsPage extends SeleniumWrappers{

	public PostFormatsPage(WebDriver driver) {
		super(driver);
		}
	public By galleryFormat = By.cssSelector("a[href='https://keybooks.ro/2016/02/01/gallery-format/'");
}
