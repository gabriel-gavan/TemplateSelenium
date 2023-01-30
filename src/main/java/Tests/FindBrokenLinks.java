package Tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Utils.BaseTest;

public class FindBrokenLinks extends BaseTest{
	static List<String> brokenLinks = new ArrayList<String>();
	@Test
	public void testBrokenLinks() throws IOException {
		List<WebElement> links = driver.findElements(By.cssSelector("a[href*='http']"));
		System.out.println("total links :" + links.size());
		
	//	JavascriptExecutor jse = (JavascriptExecutor) driver;
		//jse.executeScript("arguments[0].setAttribute('href','https://keybooks.ro/account/lost-password')", links);
		
		
		for (int i=0; i<links.size();i++) {
			WebElement element = links.get(i);
			String url = element.getAttribute("href");
			
			if (url == null) {
				continue;
			}
			checkLinks(url);
		}
		assertTrue(brokenLinks.size()==0);
	}
	
	public static void checkLinks(String linkurl) throws IOException {
		try {
			URL url = new URL(linkurl);
			HttpsURLConnection httpUrlConnection = (HttpsURLConnection) url.openConnection();
			httpUrlConnection.setConnectTimeout(3000);
			httpUrlConnection.connect();
			if (httpUrlConnection.getResponseCode()==200) {
				System.out.println(linkurl + " _ " + httpUrlConnection.getResponseCode());
				} if (httpUrlConnection.getResponseCode()==httpUrlConnection.HTTP_NOT_FOUND) {
					System.out.println(linkurl + " _ " + httpUrlConnection.getResponseCode());
					brokenLinks.add(linkurl);
				}
		}catch(MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
