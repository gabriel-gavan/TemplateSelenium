package Tests;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

import Utils.BaseTest;

public class CookieHandling extends BaseTest{
	@Test(priority=1)
	public void addCokie() {
		driver.manage().addCookie(new Cookie("MyCookie","My cookie value"));
	}
	@Test(priority=2)
	public void getCookieNamed() {
		Cookie cookie = driver.manage().getCookieNamed("PHPSESSID");
		
		System.out.println(cookie);
	}
	
	@Test(priority=3)
	public void getAllCookies() {
		Set<Cookie> allcookies = driver.manage().getCookies();
		System.out.println(allcookies);
	}
	@Test(priority=4)
	public void deleteCookieName() {
		driver.manage().deleteCookieNamed("MyCookie");
		Set<Cookie> allcookies = driver.manage().getCookies();
		System.out.println("After delete: " + allcookies);
	}
	@Test(priority=5)
	public void deleteAllCokies() {
		driver.manage().deleteAllCookies();
		Set<Cookie> allcookies = driver.manage().getCookies();
		System.out.println("After delete all: " + allcookies);
	}
}
