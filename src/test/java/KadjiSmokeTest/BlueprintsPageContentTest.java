package KadjiSmokeTest;

import org.kandji.Assertions.EmptyPageContentAssertions;
import org.kandji.BaseTest.BaseTest;
import org.kandji.Pages.*;
import org.kandji.Sections.Sidebar;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BlueprintsPageContentTest extends BaseTest {
    LoginPage loginPage;
    Sidebar sidebar;
    BlueprintsPage blueprintsPage;

    @BeforeClass
    void setup() {
        loginPage = new LoginPage(super.driver);
        loginPage.open();
        loginPage.loginToApplicationWithOTP();
        sidebar = new Sidebar(super.driver);
    }


    @Test
    void blueprintsPageContentTest() {
        sidebar.chooseMenuItem("Blueprints");
        blueprintsPage = new BlueprintsPage(super.driver);
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
