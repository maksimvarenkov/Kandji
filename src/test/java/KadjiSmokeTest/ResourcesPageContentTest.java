package KadjiSmokeTest;

import org.kandji.Assertions.EmptyPageContentAssertions;
import org.kandji.BaseTest.BaseTest;
import org.kandji.Pages.*;
import org.kandji.Sections.Sidebar;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ResourcesPageContentTest extends BaseTest {
    LoginPage loginPage;
    Sidebar sidebar;
    ResourcesPage resourcesPage;

    @BeforeClass
    void setup() {
        loginPage = new LoginPage(super.driver);
        loginPage.open();
        loginPage.loginToApplicationWithOTP();
        sidebar = new Sidebar(super.driver);
    }


    @Test
    void resourcesPageContentTest() {
        sidebar.chooseMenuItem("Resources");
        resourcesPage = new ResourcesPage(super.driver);
        resourcesPage.waitUntilLoaded();
        Assert.assertTrue(resourcesPage.getURL().contains("resources"), "Checking that URL matches and has resources");
        Assert.assertTrue(resourcesPage.isHeaderVisible(), "Checking that header is visible");
        Assert.assertTrue(resourcesPage.isPageContentDisplayed(), "Checking that page content is displayed");
    }



}
