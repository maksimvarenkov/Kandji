package KadjiSmokeTest;

import org.kandji.Assertions.EmptyPageContentAssertions;
import org.kandji.BaseTest.BaseTest;
import org.kandji.Pages.*;
import org.kandji.Sections.Sidebar;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MyProfilePageContentTest extends BaseTest {
    LoginPage loginPage;
    Sidebar sidebar;
    MyProflePage myProflePage;
    EmptyPageContentAssertions pageContentAssertions = new EmptyPageContentAssertions();

    @BeforeClass
    void setup() {
        loginPage = new LoginPage(super.driver);
        loginPage.open();
        loginPage.loginToApplicationWithOTP();
        sidebar = new Sidebar(super.driver);
    }


    @Test
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
