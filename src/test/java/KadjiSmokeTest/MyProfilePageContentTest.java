package KadjiSmokeTest;

import org.kandji.Assertions.EmptyPageContentAssertions;
import org.kandji.BaseTest.BaseTest;
import org.kandji.Pages.*;
import org.kandji.Sections.Sidebar;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyProfilePageContentTest extends BaseTest {
    Sidebar sidebar;
    MyProflePage myProflePage;
    EmptyPageContentAssertions pageContentAssertions = new EmptyPageContentAssertions();

    @Test
    void myProfilePageContentTest() {
        sidebar = new Sidebar(getDriver());
        sidebar.clickMyProfile();
        myProflePage = new MyProflePage(getDriver());
        myProflePage.waitUntilPageLoaded();
        Assert.assertTrue(myProflePage.getURL().contains("user-profile"), "Checking that URL matches and has ser-profile");
        pageContentAssertions.verifyMyProfilePageGeneralViewContent(myProflePage);

        myProflePage.chooseMFAView();
        Assert.assertTrue(myProflePage.getURL().contains("user-profile/mfa"), "Checking that URL matches and has ser-profile");
        pageContentAssertions.verifyMyProfilePageMFAViewContent(myProflePage);
    }

}
