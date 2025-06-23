package KandjiSmokeTest;

import org.kandji.BaseTest.BaseTest;
import org.kandji.Pages.*;
import org.kandji.Sections.Sidebar;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ThreatsPageContentTest extends BaseTest {
    Sidebar sidebar;
    ThreatsPage threatsPage;

    @Test
    void threatsPageContentTest() {
        sidebar = new Sidebar(getDriver());
        sidebar.chooseMenuItem("Threats");
        threatsPage = new ThreatsPage(getDriver()).waitUntilLoaded();
        threatsPage.waitUntilLoaded();
        Assert.assertTrue(threatsPage.getURL().contains("threat"), "Checking that URL matches and has threats");

        //checking link in another tab
        threatsPage.clickLearnMoreLink();
        threatsPage.switchToNewTab();
        Assert.assertTrue(getDriver().getCurrentUrl().contains("overview-of-endpoint-detection-response-edr"), "Checking that URL matches article in KB");
        threatsPage.closeCurrentTab();
        threatsPage.switchToOriginalWindow();

        threatsPage.clickGoToLibraryButton();
        LibraryPage libraryPage = new LibraryPage(getDriver());
        libraryPage.waitUntilPageLoaded();
        Assert.assertTrue(libraryPage.getLibraryNavigationButtonCount() > 0, "Checking that navigation buttons exist");
    }

}
