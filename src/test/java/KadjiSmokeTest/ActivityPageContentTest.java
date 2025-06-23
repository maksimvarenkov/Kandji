package KadjiSmokeTest;

import org.kandji.Assertions.EmptyPageContentAssertions;
import org.kandji.BaseTest.BaseTest;
import org.kandji.Pages.*;
import org.kandji.Sections.Sidebar;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ActivityPageContentTest extends BaseTest {
    LoginPage loginPage;
    Sidebar sidebar;
    ActivityPage activityPage;


    @BeforeClass
    void setup() {
        loginPage = new LoginPage(super.driver);
        loginPage.open();
        loginPage.loginToApplicationWithOTP();
        sidebar = new Sidebar(super.driver);
    }


    @Test
    void activityPageContentTest() {
        sidebar.chooseMenuItem("Activity");
        activityPage = new ActivityPage(super.driver);
        activityPage.waitUntilLoaded();
        Assert.assertTrue(sidebar.getURL().contains("activity"), "Checking that URL matches and has activity");
        activityPage.fillActivityDropdown("Blueprint Name Changed");
        activityPage.waitUntilDesiredSeacrhCountDisplayed(2);
        Assert.assertEquals(activityPage.getResultsCount(), 2, "Checking that we have only two Blueprint Changes");

        //checking Date range
        activityPage.fillDataRangeDropdown("Past 1 Day");
        activityPage.waitUntilPlaceholderDisplayed();
        Assert.assertTrue(activityPage.isNoDataPlaceholderDisplayed(), "Checking that no data placeholder displayed");
    }



}
