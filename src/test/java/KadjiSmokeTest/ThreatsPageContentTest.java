package KadjiSmokeTest;

import org.kandji.Assertions.EmptyPageContentAssertions;
import org.kandji.BaseTest.BaseTest;
import org.kandji.Pages.*;
import org.kandji.Sections.Sidebar;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ThreatsPageContentTest extends BaseTest {
    LoginPage loginPage;
    Sidebar sidebar;
    ThreatsPage threatsPage;


    @BeforeClass(alwaysRun = true)
    void setup(){
        loginPage = new LoginPage(super.driver);
        loginPage.open();
        loginPage.loginToApplicationWithOTP();
        sidebar = new Sidebar(super.driver);
    }

    @Test
    void threatsPageContentTest() {
        sidebar.chooseMenuItem("Threats");
        threatsPage = new ThreatsPage(super.driver);
        threatsPage.waitUntilLoaded();
        Assert.assertTrue(threatsPage.getURL().contains("threat"), "Checking that URL matches and has threats");
        threatsPage.clickLearnMoreLink();
        threatsPage.switchToNewTab();
        Assert.assertTrue(super.driver.getCurrentUrl().contains("overview-of-endpoint-detection-response-edr"), "Checking that URL matches article in KB");
        threatsPage.closeCurrentTab();
        threatsPage.switchToOriginalWindow();
        threatsPage.clickGoToLibraryButton();
        LibraryPage libraryPage = new LibraryPage(super.driver);
        libraryPage.waitUntilPageLoaded();
        Assert.assertTrue(libraryPage.getLibraryNavigationButtonCount() > 0, "Checking that navigation buttons exist");
    }

}
