package Tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import Pages.EventsPage;
import Pages.HomePage;
import Pages.NavMenuPage;

import Utils.BaseTest;

public class temacurs20CheckRedirects extends BaseTest{
	@Test
	public void checkRedirects() throws InterruptedException {
	
	HomePage hPage = new HomePage(driver);
	hPage.clicklink(hPage.facebooklink);
	hPage.clicklink(hPage.twiterlink);
	hPage.clicklink(hPage.instagramlink);
	Thread.sleep(2000);
	//get id of opened tabs
	System.out.println("All : "+ driver.getWindowHandles());
	System.out.println("Current : "+ driver.getWindowHandle());
		
	List<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
	System.out.println(browserTabs.size());
	driver.switchTo().window(browserTabs.get(1));
	driver.close();
	driver.switchTo().window(browserTabs.get(2));
	driver.close();
	driver.switchTo().window(browserTabs.get(3));
	driver.close();
	driver.switchTo().window(browserTabs.get(0));
	
	System.out.println("Size : "+ browserTabs.size());
	
	
	Thread.sleep(3000);
}
}
