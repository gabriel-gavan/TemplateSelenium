package Tests;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Pages.NavMenuPage;
import Utils.BaseTest;

public class JsExecutorExample extends BaseTest{
	//@Test
	public void example1() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.location='https://www.emag.ro/'");  //obiect...args
		
		driver.navigate().back();
		jse.executeScript("window.history.go(-1)");
		
		
		driver.navigate().forward();
		jse.executeScript("window.history.forward(-1)");
		//1
		driver.navigate().refresh();
		//2
		jse.executeScript("window.history.go(0)");
		//3
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).sendKeys(Keys.F5).perform();
		//4
		driver.navigate().to(driver.getCurrentUrl());
	}
	@Test
	public void example2() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		NavMenuPage menu = new NavMenuPage(driver);
	/*	//alternativa pentru click
		jse.executeScript("arguments[0].click()", menu.getElement(menu.searchIcon));
		//alternativa pentru sendkeys
		jse.executeScript("arguments[0].value='cooking'", menu.getElement(menu.searchField));
		jse.executeScript("arguments[0].click()", menu.getElement(menu.searchIcon));
		
		jse.executeScript("arguments[0].click();"
				+ "arguments[0].value='cooking';"
				+ "arguments[0].click();",
				menu.getElement(menu.searchIcon),
				menu.getElement(menu.searchField));
		*/
		jse.executeScript("document.getElementsByClassName('icon-search')[0].click()");
		jse.executeScript("document.getElementsByClassName('search_field')[0].value='cooking'");
		jse.executeScript("document.getElementsByClassName('icon-search')[0].click()");
		
		//document.getElementsByClassName('post_title')[0].checkVisibility()
		
		//alternativa pentru gettext()
		String bookTitle = jse.executeScript("return document.getElementsByClassName('post_title')[0].childNodes[0].innerHTML").toString();
		//document.getElementsByClassName('post_title')[0].childNodes[0].innerText
		System.out.println(bookTitle);
		
		String pageTitle = jse.executeScript("return document.title").toString();
		System.out.println(pageTitle);
		
		String pageURL = jse.executeScript("return document.URL").toString();
		System.out.println(pageURL);
		
		//jse.executeScript("document.getElementById('rememberme').checked");
		
		//alternativa pentru hoover (moveToElement din clasa Action
		String javaScriptHover = "var obiect = document.createEvent('MouseEvent');"
				+ "obiect.initMouseEvent('mouseover',true);"
				+ "arguments[0].dispatchEvent(obiect);";
		jse.executeScript(javaScriptHover, menu.getElement(menu.bloglink));
		Thread.sleep(3000);
		jse.executeScript(javaScriptHover, menu.getElement(menu.aboutLink));
	}
}
