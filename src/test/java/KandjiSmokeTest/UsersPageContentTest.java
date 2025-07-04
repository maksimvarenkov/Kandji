package KandjiSmokeTest;

import io.qameta.allure.Description;
import org.kandji.Assertions.EmptyPageContentAssertions;
import org.kandji.BaseTest.BaseTest;
import org.kandji.Pages.*;
import org.kandji.Sections.Sidebar;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UsersPageContentTest extends BaseTest {

    Sidebar sidebar;
    EmptyPageContentAssertions pageContentAssertions = new EmptyPageContentAssertions();

    @Test(description = "Users page content verification")
    @Description("Checking that empty Users page has proper URL, header and different views working ")
    void usersPageContentTest() {
        sidebar = new Sidebar(getDriver());
        sidebar.chooseMenuItem("Users");

        UsersPage usersPage = new UsersPage(getDriver());
        usersPage.waitUntilPageLoaded();
        Assert.assertTrue(sidebar.getURL().contains("users"), "Checking that URL matches and has users");
        pageContentAssertions.verifyUsersPageUserViewContent(usersPage);
        usersPage.chooseGroupsView();
        pageContentAssertions.verifyUsersPageGroupsViewContent(usersPage);
    }



}
