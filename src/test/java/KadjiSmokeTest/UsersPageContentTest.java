package KadjiSmokeTest;

import org.kandji.Assertions.EmptyPageContentAssertions;
import org.kandji.BaseTest.BaseTest;
import org.kandji.Pages.*;
import org.kandji.Sections.Sidebar;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UsersPageContentTest extends BaseTest {
    LoginPage loginPage;
    Sidebar sidebar;
    EmptyPageContentAssertions pageContentAssertions = new EmptyPageContentAssertions();

    @BeforeClass
    void setup(){
        loginPage = new LoginPage(super.driver);
        loginPage.open();
        loginPage.loginToApplicationWithOTP();
        sidebar = new Sidebar(super.driver);
    }

    @Test
    void usersPageContentTest() {
        sidebar.chooseMenuItem("Users");
        UsersPage usersPage = new UsersPage(super.driver);
        usersPage.waitUntilPageLoaded();
        Assert.assertTrue(sidebar.getURL().contains("users"), "Checking that URL matches and has users");
        pageContentAssertions.verifyUsersPageUserViewContent(usersPage);
        usersPage.chooseGroupsView();
        pageContentAssertions.verifyUsersPageGroupsViewContent(usersPage);
    }



}
