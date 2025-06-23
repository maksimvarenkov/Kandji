import org.kandji.Assertions.EmptyPageContentAssertions;
import org.kandji.BaseTest.BaseTest;
import org.kandji.Pages.*;
import org.kandji.Sections.Sidebar;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KandjiBackup extends BaseTest {
    LoginPage loginPage;
    DevicesPage devicesPage;
    Sidebar sidebar;
    BlueprintsPage blueprintsPage;
    LibraryPage libraryPage;
    ThreatsPage threatsPage;
    AlertsPage alertsPage;
    ActivityPage activityPage;
    EnrollmentPage enrollmentPage;
    ResourcesPage resourcesPage;
    MyProflePage myProflePage;
    EmptyPageContentAssertions pageContentAssertions = new EmptyPageContentAssertions();

    @Test
    void loginPageDisplayedTest() {
        loginPage = new LoginPage(super.driver);
        loginPage.open();
        Assert.assertTrue(loginPage.getURL().contains("auth.kandji.io"), "Checking login page URL match");
        Assert.assertTrue(loginPage.isLoginFormDisplayed(), "Checking that login form displayed");
    }

    @Test(dependsOnMethods = {"loginPageDisplayedTest"})
    void loginTest() {
        loginPage.loginToApplicationWithOTP();
        sidebar = new Sidebar(super.driver);
        Assert.assertTrue(sidebar.getURL().contains("kandji.io"), "Checking that URL matches");
        Assert.assertTrue(sidebar.isUserLogged(), "Checking that user logged in");
    }
//
//    @Test(dependsOnMethods = {"loginPageDisplayedTest", "loginTest"})
//    void devicesPageContentTest() {
//        sidebar.chooseMenuItem("Devices");
//        devicesPage = new DevicesPage(super.driver);
//        devicesPage.waitUntilPageLoaded();
//        Assert.assertTrue(sidebar.getURL().contains("devices"), "Checking that URL matches and has devices");
//        pageContentAssertions.verifyDevicesPageDevicesModeContent(devicesPage);
//        devicesPage.choosePrismView();
//        pageContentAssertions.verifyDevicePagePrismModeContent(devicesPage);
//    }
//
//    @Test(dependsOnMethods = {"loginPageDisplayedTest", "loginTest"})
//    void blueprintsPageContentTest() {
//        sidebar.chooseMenuItem("Blueprints");
//        blueprintsPage = new BlueprintsPage(super.driver);
//        blueprintsPage.waitUntilPageLoaded();
//
//        Assert.assertTrue(blueprintsPage.getURL().contains("blueprints"), "Checking that URL matches and has blueprints");
//        Assert.assertEquals(blueprintsPage.getBlueprintCardsCount(), 2, "Verify that we have 2 blueprint cards by default");
//    }
//
//    @Test(dependsOnMethods = {"loginPageDisplayedTest", "loginTest", "blueprintsPageContentTest"})
//    void blueprintsPageSearchTest() {
//        sidebar.chooseMenuItem("Blueprints");
//        blueprintsPage.fillSearchField("kandji");
//        Assert.assertEquals(blueprintsPage.getBlueprintCardsCount(), 1, "Verify that we have 1 blueprint card matching search criteria");
//
//        //to think about it, maybe it will be better to delete this one. Will take a bit longer due to implicit wait, as there's no
//        //blank placeholder. Check should be limited
//
//        //     blueprintsPage.fillSearchField("not matching query");
//        //     Assert.assertEquals(blueprintsPage.getBlueprintCardsCount(), 0, "Verify that we don't have blueprint cards matching search criteria");
//    }
//
//    @Test(dependsOnMethods = {"loginPageDisplayedTest", "loginTest"})
//    void libraryPageContentTest() {
//        sidebar.chooseMenuItem("Library");
//        libraryPage = new LibraryPage(super.driver);
//        libraryPage.waitUntilPageLoaded();
//        Assert.assertTrue(libraryPage.getURL().contains("library"), "Checking that URL matches and has library");
//        Assert.assertTrue(libraryPage.getLibraryNavigationButtonCount() > 0, "Checking that navigation buttons exist");
//        Assert.assertTrue(libraryPage.getLibraryCardsCount() > 0, "Checking that some library cards displayed");
//    }
//
//    @Test(dependsOnMethods = {"loginPageDisplayedTest", "loginTest", "libraryPageContentTest"})
//    void libraryPageSearchTest() {
//        sidebar.chooseMenuItem("Library");
//        Assert.assertTrue(libraryPage.getLibraryNavigationButtonCount() > 0, "Checking that navigation buttons exist");
//
//        //This part is flaky. Will need to add check for waiting until it will be desired card items on page, because i cannot see if there
//        libraryPage.fillSearchField("firewall");
//        libraryPage.waitForLibraryCards(5);
//        Assert.assertEquals(libraryPage.getLibraryCardsCount(), 5, "Checking that we have 5 matching library cards");
//
//        libraryPage.fillSearchField("not matching query").waitForEmptySearchPlaceholder();
//        Assert.assertTrue(libraryPage.isNoSearchResultsPlaceholderDisplayed(), "Checking that No results found placeholder displayed for non matching query");
//    }
//
//    @Test(dependsOnMethods = {"loginPageDisplayedTest", "loginTest"})
//    void usersPageContentTest() {
//        sidebar.chooseMenuItem("Users");
//        UsersPage usersPage = new UsersPage(super.driver);
//        usersPage.waitUntilPageLoaded();
//        Assert.assertTrue(sidebar.getURL().contains("users"), "Checking that URL matches and has users");
//        pageContentAssertions.verifyUsersPageUserViewContent(usersPage);
//        usersPage.chooseGroupsView();
//        pageContentAssertions.verifyUsersPageGroupsViewContent(usersPage);
//    }
//
//    @Test(dependsOnMethods = {"loginPageDisplayedTest", "loginTest"})
//    void threatsPageContentTest() {
//        sidebar.chooseMenuItem("Threats");
//        threatsPage = new ThreatsPage(super.driver);
//        threatsPage.waitUntilLoaded();
//        Assert.assertTrue(threatsPage.getURL().contains("threat"), "Checking that URL matches and has threats");
//        threatsPage.clickLearnMoreLink();
//        threatsPage.switchToNewTab();
//        Assert.assertTrue(super.driver.getCurrentUrl().contains("overview-of-endpoint-detection-response-edr"), "Checking that URL matches article in KB");
//        threatsPage.closeCurrentTab();
//        threatsPage.switchToOriginalWindow();
//        threatsPage.clickGoToLibraryButton();
//        libraryPage.waitUntilPageLoaded();
//        Assert.assertTrue(libraryPage.getLibraryNavigationButtonCount() > 0, "Checking that navigation buttons exist");
//    }
//
//    @Test(dependsOnMethods = {"loginPageDisplayedTest", "loginTest"})
//    void alertsPageContentTest() {
//        sidebar.chooseMenuItem("Alerts");
//        alertsPage = new AlertsPage(super.driver);
//        alertsPage.waitUntilLoaded();
//
//        pageContentAssertions.verifyAlertsPageActiveAlertsContent(alertsPage);
//        alertsPage.clickMutedButton();
//        pageContentAssertions.verifyAlertsPageMutedAlertsContent(alertsPage);
//        alertsPage.clickClearedButton();
//        pageContentAssertions.verifyAlertsPageClearedAlertsContent(alertsPage);
//        alertsPage.clickAlertsButton();
//        pageContentAssertions.verifyAlertsPageActiveAlertsContent(alertsPage);
//    }

//    @Test(dependsOnMethods = {"loginPageDisplayedTest", "loginTest"})
//    void activityPageContentTest() {
//        sidebar.chooseMenuItem("Activity");
//        activityPage = new ActivityPage(super.driver);
//        activityPage.waitUntilLoaded();
//        Assert.assertTrue(sidebar.getURL().contains("activity"), "Checking that URL matches and has activity");
//        activityPage.fillActivityDropdown("Blueprint Name Changed");
//        activityPage.waitUntilDesiredSeacrhCountDisplayed(2);
//        Assert.assertEquals(activityPage.getResultsCount(), 2, "Checking that we have only two Blueprint Changes");
//
//
//        //checking Date range
//      //  activityPage.fillActivityDropdown("Blueprint Name Changed");
//        activityPage.fillDataRangeDropdown("Past 1 Day");
//        activityPage.waitUntilPlaceholderDisplayed();
//        Assert.assertTrue(activityPage.isNoDataPlaceholderDisplayed(), "Checking that no data placeholder displayed");
//    }
//
//    @Test(dependsOnMethods = {"loginPageDisplayedTest", "loginTest"})
//    void enrollmentPageContentTest() {
//        sidebar.chooseMenuItem("Enrollment");
//        enrollmentPage = new EnrollmentPage(super.driver);
//        enrollmentPage.waitUntilPageLoaded();
//        Assert.assertTrue(enrollmentPage.getURL().contains("add-devices"), "Checking that URL matches and has add-devices");
//        pageContentAssertions.verifyEnrollmentPageAutomatedViewContent(enrollmentPage);
//        enrollmentPage.chooseManualView();
//        pageContentAssertions.verifyEnrollmentPageManualViewContent(enrollmentPage);
//    }

//    @Test(dependsOnMethods = {"loginPageDisplayedTest", "loginTest"})
//    void resourcesPageContentTest() {
//        sidebar.chooseMenuItem("Resources");
//        resourcesPage = new ResourcesPage(super.driver);
//        resourcesPage.waitUntilLoaded();
//        Assert.assertTrue(resourcesPage.getURL().contains("resources"), "Checking that URL matches and has resources");
//        Assert.assertTrue(resourcesPage.isHeaderVisible(), "Checking that header is visible");
//        Assert.assertTrue(resourcesPage.isPageContentDisplayed(), "Checking that page content is displayed");
//    }

    @Test(dependsOnMethods = {"loginPageDisplayedTest", "loginTest"})
    void myProfilePageContentTest() {
        sidebar.clickMyProfile();
        myProflePage = new MyProflePage(super.driver);
        myProflePage.waitUntilPageLoaded();
        Assert.assertTrue(myProflePage.getURL().contains("user-profile"), "Checking that URL matches and has ser-profile");
        pageContentAssertions.verifyMyProfilePageGeneralViewContent(myProflePage);
        myProflePage.chooseMFAView();
        Assert.assertTrue(myProflePage.getURL().contains("user-profile/mfa"), "Checking that URL matches and has ser-profile");
        pageContentAssertions.verifyMyProfilePageMFAViewContent(myProflePage);

    }

}
