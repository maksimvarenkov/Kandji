package KandjiSmokeTest;

import org.kandji.BaseTest.BaseTest;
import org.kandji.Pages.*;
import org.kandji.Sections.Sidebar;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BlueprintsPageContentTest extends BaseTest {
    Sidebar sidebar;
    BlueprintsPage blueprintsPage;

    @Test
    void blueprintsPageContentTest() {
        sidebar = new Sidebar(getDriver());
        sidebar.chooseMenuItem("Blueprints");
        blueprintsPage = new BlueprintsPage(getDriver());
        blueprintsPage.waitUntilPageLoaded();

        Assert.assertTrue(blueprintsPage.getURL().contains("blueprints"), "Checking that URL matches and has blueprints");
        Assert.assertEquals(blueprintsPage.getBlueprintCardsCount(), 2, "Verify that we have 2 blueprint cards by default");
    }

    @Test
    void blueprintsPageSearchTest() {
        sidebar.chooseMenuItem("Blueprints");
        blueprintsPage.fillSearchField("kandji");

        Assert.assertEquals(blueprintsPage.getBlueprintCardsCount(), 1, "Verify that we have 1 blueprint card matching search criteria");
        //takes a bit longer than necessary because there's no placeholder for search results
        blueprintsPage.fillSearchField("not matching query");
        Assert.assertEquals(blueprintsPage.getBlueprintCardsCount(), 0, "Verify that we don't have blueprint cards matching search criteria");
    }

}
