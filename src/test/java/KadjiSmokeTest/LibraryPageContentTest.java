package KadjiSmokeTest;

import org.kandji.Assertions.EmptyPageContentAssertions;
import org.kandji.BaseTest.BaseTest;
import org.kandji.Pages.*;
import org.kandji.Sections.Sidebar;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LibraryPageContentTest extends BaseTest {
    LoginPage loginPage;
    Sidebar sidebar;
    LibraryPage libraryPage;


    @BeforeClass(alwaysRun = true)
    void setup(){
        loginPage = new LoginPage(super.driver);
        loginPage.open();
        loginPage.loginToApplicationWithOTP();
        sidebar = new Sidebar(super.driver);
    }

    @Test
    void libraryPageContentTest() {
        sidebar.chooseMenuItem("Library");
        libraryPage = new LibraryPage(super.driver);
        libraryPage.waitUntilPageLoaded();
        Assert.assertTrue(libraryPage.getURL().contains("library"), "Checking that URL matches and has library");
        Assert.assertTrue(libraryPage.getLibraryNavigationButtonCount() > 0, "Checking that navigation buttons exist");
        Assert.assertTrue(libraryPage.getLibraryCardsCount() > 0, "Checking that some library cards displayed");
    }

    @Test
    void libraryPageSearchTest() {
        sidebar.chooseMenuItem("Library");
        Assert.assertTrue(libraryPage.getLibraryNavigationButtonCount() > 0, "Checking that navigation buttons exist");
        //This part is flaky. Will need to add check for waiting until it will be desired card items on page, because i cannot see if there
        libraryPage.fillSearchField("firewall");
        libraryPage.waitForLibraryCards(5);
        Assert.assertEquals(libraryPage.getLibraryCardsCount(), 5, "Checking that we have 5 matching library cards");

        libraryPage.fillSearchField("not matching query").waitForEmptySearchPlaceholder();
        Assert.assertTrue(libraryPage.isNoSearchResultsPlaceholderDisplayed(), "Checking that No results found placeholder displayed for non matching query");
    }


}
