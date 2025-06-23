package org.kandji.Assertions;

import org.kandji.Pages.*;
import org.testng.Assert;

public class EmptyPageContentAssertions {

    public void verifyDevicesPageDevicesModeContent(DevicesPage devicesPage) {
        Assert.assertTrue(devicesPage.isHeaderExist(), "Checking that Header on Devices page exists");
        Assert.assertTrue(devicesPage.isDevicesViewActive(), "Checking that devices view Active by default");
        Assert.assertEquals(devicesPage.getInactiveTabName(), "Prism", "Checking that Prism tab not selected by default");
        Assert.assertEquals(devicesPage.getActiveTabName(), "Views", "Checking that Views tab selected by default");
        Assert.assertTrue(devicesPage.isEmptyDevicesPlaceholderExists(), "Checking that 'No devices to display' " +
                "placeholder exists in Devices views mode");
    }

    public void verifyDevicePagePrismModeContent(DevicesPage devicesPage) {
        Assert.assertTrue(devicesPage.isPrismViewActive(), "Checking that Prism View Active");
        Assert.assertEquals(devicesPage.getInactiveTabName(), "Views", "Checking that Views tab in tablist not selected");
        Assert.assertEquals(devicesPage.getActiveTabName(), "Prism", "Checking that Prism tab selected and highlighted");
        Assert.assertTrue(devicesPage.isPrismNavigationLinksExists(), "Checking that prism navigation links exists");
    }

    public void verifyEnrollmentPageAutomatedViewContent(EnrollmentPage enrollmentPage) {
        Assert.assertTrue(enrollmentPage.isHeaderExist(), "Checking that header on Enrollment page exists");
        Assert.assertTrue(enrollmentPage.isAutomatedViewActive(), "Checking that Automated view is active");
        Assert.assertEquals(enrollmentPage.getActiveTabName(), "Automated Device Enrollment", "Checking that Automated view tab active");
        Assert.assertEquals(enrollmentPage.getInactiveTabName(), "Manual Enrollment", "Checking that Manual tab is not active");
        Assert.assertTrue(enrollmentPage.isEmptyDevicesPlaceholderExists(), "Checking that empty devices placeholder exists");
    }

    public void verifyEnrollmentPageManualViewContent(EnrollmentPage enrollmentPage) {
        Assert.assertTrue(enrollmentPage.isHeaderExist(), "Checking that header on Enrollment page exists");
        Assert.assertTrue(enrollmentPage.isManualViewActive(), "Checking that Manual view is active");
        Assert.assertEquals(enrollmentPage.getInactiveTabName(), "Automated Device Enrollment", "Checking that Automated view tab is not active");
        Assert.assertEquals(enrollmentPage.getActiveTabName(), "Manual Enrollment", "Checking that Manual tab is active");
        Assert.assertTrue(enrollmentPage.isManualViewOpened(), "Checking that Manual view has some tab specific content");
    }

    public void verifyUsersPageUserViewContent(UsersPage usersPage) {
        Assert.assertTrue(usersPage.isHeaderExist(), "Checking that Header on Users page exists");
        Assert.assertTrue(usersPage.isUsersViewActive(), "Checking that Users view Active by default");
        Assert.assertEquals(usersPage.getInactiveTabName(), "Groups", "Checking that Groups tab not selected by default");
        Assert.assertEquals(usersPage.getActiveTabName(), "Users", "Checking that Users tab selected by default");
        Assert.assertTrue(usersPage.isEmptyUsersPlaceholderExists(), "Checking that 'There are no users in Kandji' " +
                "placeholder exists in Devices views mode");
    }

    public void verifyUsersPageGroupsViewContent(UsersPage usersPage) {
        Assert.assertTrue(usersPage.isGroupsViewActive(), "Checking that Groups View Active");
        Assert.assertEquals(usersPage.getInactiveTabName(), "Users", "Checking that Users tab in tablist not selected");
        Assert.assertEquals(usersPage.getActiveTabName(), "Groups", "Checking that Groups tab selected and highlighted");
        Assert.assertTrue(usersPage.isEmptyGroupsPlaceholderExists(), "Checking that 'There are no groups in Kandji' " +
                "placeholder exists in Devices views mode");
    }

    public void verifyAlertsPageActiveAlertsContent(AlertsPage alertsPage) {
        Assert.assertTrue(alertsPage.getURL().contains("alerts/active"), "Checking that URL matches and has alerts/active");
        Assert.assertTrue(alertsPage.isHeaderVisible(), "Checking that header is visible");
        Assert.assertTrue(alertsPage.isPlaceholderDisplayed(), "Checking that placeholder displayed");
    }

    public void verifyAlertsPageMutedAlertsContent(AlertsPage alertsPage) {
        Assert.assertTrue(alertsPage.getURL().contains("alerts/muted"), "Checking that URL matches and has alerts/muted");
        Assert.assertTrue(alertsPage.isHeaderVisible(), "Checking that header is visible");
        Assert.assertTrue(alertsPage.isPlaceholderDisplayed(), "Checking that placeholder displayed");
    }

    public void verifyAlertsPageClearedAlertsContent(AlertsPage alertsPage) {
        Assert.assertTrue(alertsPage.getURL().contains("alerts/old"), "Checking that URL matches and has alerts/old");
        Assert.assertTrue(alertsPage.isHeaderVisible(), "Checking that header is visible");
        Assert.assertTrue(alertsPage.isPlaceholderDisplayed(), "Checking that placeholder displayed");
    }

    public void verifyMyProfilePageGeneralViewContent(MyProfilePage myProfilePage) {
        Assert.assertTrue(myProfilePage.isHeaderExist(), "Checking that header on My Profile page exists");
        Assert.assertTrue(myProfilePage.isGeneralViewActive(), "Checking that General view is active");
        Assert.assertEquals(myProfilePage.getActiveTabName(), "General", "Checking that Automated view tab active");
        Assert.assertEquals(myProfilePage.getInactiveTabName(), "Multi-Factor Authentication", "Checking that Multi-Factor Authentication tab is not active");
        Assert.assertTrue(myProfilePage.isGeneralContentDsipalyed(), "Checking that general view content exists");
    }

    public void verifyMyProfilePageMFAViewContent(MyProfilePage myProfilePage) {
        Assert.assertTrue(myProfilePage.isHeaderExist(), "Checking that header on My Profile page exists");
        Assert.assertTrue(myProfilePage.isMFAViewActive(), "Checking that MFA view is active");
        Assert.assertEquals(myProfilePage.getInactiveTabName(), "General", "Checking that General view tab inactive");
        Assert.assertEquals(myProfilePage.getActiveTabName(), "Multi-Factor Authentication", "Checking that Multi-Factor Authentication tab is active");
        Assert.assertTrue(myProfilePage.isMFAContentDsipalyed(), "Checking that MFA view content exists");
    }

}
