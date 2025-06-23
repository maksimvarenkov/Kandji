package KadjiSmokeTest;

import org.kandji.Assertions.EmptyPageContentAssertions;
import org.kandji.BaseTest.BaseTest;
import org.kandji.Pages.*;
import org.kandji.Sections.Sidebar;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyProfilePageContentTest extends BaseTest {
    Sidebar sidebar;
    MyProfilePage myProfilePage;
    EmptyPageContentAssertions pageContentAssertions = new EmptyPageContentAssertions();

    @Test
    void myProfilePageContentTest() {
        sidebar = new Sidebar(getDriver());
        sidebar.clickMyProfile();
        myProfilePage = new MyProfilePage(getDriver());
        myProfilePage.waitUntilPageLoaded();
        Assert.assertTrue(myProfilePage.getURL().contains("user-profile"), "Checking that URL matches and has ser-profile");
        pageContentAssertions.verifyMyProfilePageGeneralViewContent(myProfilePage);

        myProfilePage.chooseMFAView();
        Assert.assertTrue(myProfilePage.getURL().contains("user-profile/mfa"), "Checking that URL matches and has ser-profile");
        pageContentAssertions.verifyMyProfilePageMFAViewContent(myProfilePage);
    }

}
