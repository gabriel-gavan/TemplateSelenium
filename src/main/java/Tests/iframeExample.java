package Tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Pages.ContactPage;
import Pages.EventsPage;
import Pages.NavMenuPage;
import Pages.SingleEventPage;
import Utils.BaseTest;

public class iframeExample extends BaseTest{
	//@Test
	public void IframeExample() throws InterruptedException {
		NavMenuPage menu = new NavMenuPage(driver);
		menu.navigateTo(menu.contactLink);
		
		ContactPage contactPage = new ContactPage(driver);
		contactPage.zoomMap(contactPage.zoomIn);
		Thread.sleep(3000);
	}
	
	@Test
	public void iframeExample2() throws InterruptedException {
		NavMenuPage menu = new NavMenuPage(driver);
		menu.navigateTo(menu.eventsLink);
		EventsPage eventsPage = new EventsPage(driver);
		eventsPage.click(eventsPage.festivalOfOldFilmsLinks);
		Actions action  = new Actions(driver);
		action.scrollByAmount(0, 2000).perform();
		Thread.sleep(3000);
		
		SingleEventPage sePage = new SingleEventPage(driver);
		sePage.clickMap();
		Thread.sleep(3000);
		//get id of opened tabs
		System.out.println("All : "+ driver.getWindowHandles());
		
		System.out.println("Current : "+ driver.getWindowHandle());
		
		List<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
		System.out.println(browserTabs.size());
		driver.switchTo().window(browserTabs.get(1));
		driver.close();
		driver.switchTo().window(browserTabs.get(0));
		
		System.out.println("Size : "+ browserTabs.size());
		sePage.clickMap();
		Thread.sleep(3000);
	}

}
