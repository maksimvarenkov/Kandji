package KandjiSmokeTest;

import org.kandji.BaseTest.BaseTest;
import org.kandji.Pages.*;
import org.kandji.Sections.Sidebar;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LibraryPageContentTest extends BaseTest {
    Sidebar sidebar;
    LibraryPage libraryPage;

    @Test
    void libraryPageContentTest() {
        sidebar = new Sidebar(getDriver());
        sidebar.chooseMenuItem("Library");
        libraryPage = new LibraryPage(getDriver());
        libraryPage.waitUntilPageLoaded();

        Assert.assertTrue(libraryPage.getURL().contains("library"), "Checking that URL matches and has library");
        Assert.assertTrue(libraryPage.getLibraryNavigationButtonCount() > 0, "Checking that navigation buttons exist");
        Assert.assertTrue(libraryPage.getLibraryCardsCount() > 0, "Checking that some library cards displayed");
    }

    @Test
    void libraryPageSearchTest() {
        sidebar.chooseMenuItem("Library");
        Assert.assertTrue(libraryPage.getLibraryNavigationButtonCount() > 0, "Checking that navigation buttons exist");

        libraryPage.fillSearchField("firewall");
        libraryPage.waitForLibraryCards(5);
        Assert.assertEquals(libraryPage.getLibraryCardsCount(), 5, "Checking that we have 5 matching library cards");

        libraryPage.fillSearchField("not matching query").waitForEmptySearchPlaceholder();
        Assert.assertTrue(libraryPage.isNoSearchResultsPlaceholderDisplayed(), "Checking that No results found placeholder displayed for non matching query");
    }

}
