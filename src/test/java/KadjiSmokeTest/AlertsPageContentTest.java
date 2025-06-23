package KadjiSmokeTest;

import org.kandji.Assertions.EmptyPageContentAssertions;
import org.kandji.BaseTest.BaseTest;
import org.kandji.Pages.*;
import org.kandji.Sections.Sidebar;
import org.testng.annotations.Test;

public class AlertsPageContentTest extends BaseTest {
    Sidebar sidebar;
    AlertsPage alertsPage;
    EmptyPageContentAssertions pageContentAssertions = new EmptyPageContentAssertions();

    @Test
    void alertsPageContentTest() {
        sidebar = new Sidebar(getDriver());
        sidebar.chooseMenuItem("Alerts");
        alertsPage = new AlertsPage(getDriver());
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
