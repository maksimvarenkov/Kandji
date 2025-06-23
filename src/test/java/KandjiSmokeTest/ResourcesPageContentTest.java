package KandjiSmokeTest;

import org.kandji.BaseTest.BaseTest;
import org.kandji.Pages.*;
import org.kandji.Sections.Sidebar;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ResourcesPageContentTest extends BaseTest {

    Sidebar sidebar;
    ResourcesPage resourcesPage;

    @Test
    void resourcesPageContentTest() {
        sidebar = new Sidebar(getDriver());
        sidebar.chooseMenuItem("Resources");

        resourcesPage = new ResourcesPage(getDriver());
        resourcesPage.waitUntilLoaded();

        Assert.assertTrue(resourcesPage.getURL().contains("resources"), "Checking that URL matches and has resources");
        Assert.assertTrue(resourcesPage.isHeaderVisible(), "Checking that header is visible");
        Assert.assertTrue(resourcesPage.isPageContentDisplayed(), "Checking that page content is displayed");
    }



}
