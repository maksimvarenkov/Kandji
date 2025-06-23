package KadjiSmokeTest;

import org.kandji.Assertions.EmptyPageContentAssertions;
import org.kandji.BaseTest.BaseTest;
import org.kandji.Pages.*;
import org.kandji.Sections.Sidebar;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginLogoutTest extends BaseTest {
    LoginPage loginPage;
    DevicesPage devicesPage;
    Sidebar sidebar;

    @Test
    void loginPageDisplayedTest() {
        loginPage = new LoginPage(super.driver);
        loginPage.open();
        Assert.assertTrue(loginPage.getURL().contains("auth.kandji.io"), "Checking login page URL match");
        Assert.assertTrue(loginPage.isLoginFormDisplayed(), "Checking that login form displayed");
    }

    @Test(dependsOnMethods = {"loginPageDisplayedTest"})
    void loginTest() {
        loginPage.loginToApplicationWithOTP();
        sidebar = new Sidebar(super.driver);
        Assert.assertTrue(sidebar.getURL().contains("kandji.io"), "Checking that URL matches");
        Assert.assertTrue(sidebar.isUserLogged(), "Checking that user logged in");
    }


    @Test(dependsOnMethods = {"loginPageDisplayedTest", "loginTest"})
    void logoutTest() {
        sidebar.chooseMenuItem("Devices");
        devicesPage = new DevicesPage(super.driver);
        devicesPage.waitUntilPageLoaded();
        Assert.assertTrue(devicesPage.getURL().contains("devices"), "Checking that URL matches and has devices");
        sidebar.logout();
        Assert.assertTrue(loginPage.isLoginFormDisplayed(), "Checking that user redirected to login form");
        Assert.assertTrue(loginPage.getURL().contains("https://auth.kandji.io"), "Checking that URL matches and has auth");
    }

}
