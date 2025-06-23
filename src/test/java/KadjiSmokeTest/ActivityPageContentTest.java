package KadjiSmokeTest;

import org.kandji.BaseTest.BaseTest;
import org.kandji.Pages.*;
import org.kandji.Sections.Sidebar;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActivityPageContentTest extends BaseTest {
    Sidebar sidebar;
    ActivityPage activityPage;


    @Test
    void activityPageContentTest() {
        sidebar = new Sidebar(getDriver());
        sidebar.chooseMenuItem("Activity");
        activityPage = new ActivityPage(getDriver());
        activityPage.waitUntilLoaded();
        Assert.assertTrue(sidebar.getURL().contains("activity"), "Checking that URL matches and has activity");
        activityPage.fillActivityDropdown("Blueprint Name Changed");
        activityPage.waitUntilDesiredSearchCountDisplayed(2);
        Assert.assertEquals(activityPage.getResultsCount(), 2, "Checking that we have only two Blueprint Changes");

        //checking Date range
        activityPage.fillDateRangeDropdown("Past 1 Day");
        activityPage.waitUntilPlaceholderDisplayed();
        Assert.assertTrue(activityPage.isNoDataPlaceholderDisplayed(), "Checking that no data placeholder displayed");
    }

}
