package Tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.NavMenuPage;
import Utils.BaseTest;
import Utils.TestNgListener;

@Listeners(TestNgListener.class)
public class LoginTest extends BaseTest{
	@Parameters({"user","pass"})
	@Test (priority=0,groups="LoginFunctionality")
	public void loginTest(String username, String parola) {
		NavMenuPage navMenu = new NavMenuPage(driver);
		navMenu.navigateTo(navMenu.loginLink);
	LoginPage loginPage = new LoginPage(driver);
		loginPage.loginInApp(username, parola);
		assertTrue(loginPage.loginSuccessMessageIsDisplayed());
		assertTrue(loginPage.loginMessageIsDisplayed(loginPage.loginSuccessMessage));
		loginPage.logoutFromApp();		
	}
	@Parameters({"user","pass"})
	@Test (priority=1,groups="LoginFunctionality")
	public void invalidloginTest(String username, String parola) {
		NavMenuPage navMenu = new NavMenuPage(driver);
		navMenu.navigateTo(navMenu.loginLink);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginInApp(username, parola);
		assertTrue(loginPage.loginErrorMessageIsDisplayed());
		
				
		
}
}
