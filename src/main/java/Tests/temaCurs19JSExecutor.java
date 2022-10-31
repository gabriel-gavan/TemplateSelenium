package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Pages.NavMenuPage;
import Pages.PostFormatsPage;
import Utils.BaseTest;

public class temaCurs19JSExecutor  extends BaseTest{

	@Test
	public void jsSelectorAddComment() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
			NavMenuPage menu = new NavMenuPage(driver);
			String javaScriptHover = "var obiect = document.createEvent('MouseEvent');"
					+ "obiect.initMouseEvent('mouseover',true);"
					+ "arguments[0].dispatchEvent(obiect);";
			jse.executeScript(javaScriptHover, menu.getElement(menu.bloglink));
			
			jse.executeScript("arguments[0].click()", menu.getElement(menu.openPostFOrmats));
		
			PostFormatsPage pfPage = new PostFormatsPage(driver);
				
			
			WebElement galleryFormat = driver.findElement(By.cssSelector("a[href='https://keybooks.ro/2016/02/01/gallery-format/'"));
			jse.executeScript("arguments[0].scrollIntoView();", galleryFormat);
			jse.executeScript("arguments[0].click()", galleryFormat);
			
			
			WebElement findComment = driver.findElement(By.cssSelector("h2[class='section_title comments_form_title'"));
			jse.executeScript("arguments[0].scrollIntoView();", findComment);
			
			WebElement addComment = driver.findElement(By.cssSelector("textarea[id='comment']"));
			jse.executeScript("arguments[0].click();", addComment);
			jse.executeScript("const random = (length = 8) => "
					+ "{return Math.random().toString(16).substr(2, length);};"
					+ "arguments[0].value=random(6);", addComment);
			
			WebElement addCommentName = driver.findElement(By.cssSelector("input[id='author']"));
			jse.executeScript("arguments[0].click();", addCommentName);
			jse.executeScript("arguments[0].value='some name'", addCommentName);
			
			
			WebElement addCommentEmail = driver.findElement(By.cssSelector("input[id='email']"));
			jse.executeScript("arguments[0].click();", addCommentEmail);
			jse.executeScript("arguments[0].value='test@test.com'", addCommentEmail);
			
			WebElement addCommentURL = driver.findElement(By.cssSelector("input[id='url']"));
			jse.executeScript("arguments[0].click();", addCommentURL);
			jse.executeScript("arguments[0].value='www.test.com'", addCommentURL);
			
			WebElement postCommentButton = driver.findElement(By.cssSelector("input[name='submit']"));
			jse.executeScript("arguments[0].click();", postCommentButton);
			Thread.sleep(3000);
			
			
	}
}
