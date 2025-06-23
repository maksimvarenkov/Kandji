package KadjiSmokeTest;

import org.kandji.Assertions.EmptyPageContentAssertions;
import org.kandji.BaseTest.BaseTest;
import org.kandji.Pages.*;
import org.kandji.Sections.Sidebar;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AlertsPageContentTest extends BaseTest {
    LoginPage loginPage;
    Sidebar sidebar;
    AlertsPage alertsPage;
    EmptyPageContentAssertions pageContentAssertions = new EmptyPageContentAssertions();

    @BeforeClass
    void setup() {
        loginPage = new LoginPage(super.driver);
        loginPage.open();
        loginPage.loginToApplicationWithOTP();
        sidebar = new Sidebar(super.driver);
    }


    @Test
    void alertsPageContentTest() {
        sidebar.chooseMenuItem("Alerts");
        alertsPage = new AlertsPage(super.driver);
        alertsPage.waitUntilLoaded();

        pageContentAssertions.verifyAlertsPageActiveAlertsContent(alertsPage);
        alertsPage.clickMutedButton();
        pageContentAssertions.verifyAlertsPageMutedAlertsContent(alertsPage);
        alertsPage.clickClearedButton();
        pageContentAssertions.verifyAlertsPageClearedAlertsContent(alertsPage);
        alertsPage.clickAlertsButton();
        pageContentAssertions.verifyAlertsPageActiveAlertsContent(alertsPage);
    }



}
