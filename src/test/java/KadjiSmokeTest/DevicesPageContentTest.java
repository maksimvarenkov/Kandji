package KadjiSmokeTest;

import org.kandji.Assertions.EmptyPageContentAssertions;
import org.kandji.BaseTest.BaseTest;
import org.kandji.Pages.*;
import org.kandji.Sections.Sidebar;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DevicesPageContentTest extends BaseTest {
    LoginPage loginPage;
    DevicesPage devicesPage;
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
    void devicesPageContentTest() {
        sidebar.chooseMenuItem("Devices");
        devicesPage = new DevicesPage(super.driver);
        devicesPage.waitUntilPageLoaded();
        Assert.assertTrue(sidebar.getURL().contains("devices"), "Checking that URL matches and has devices");
        pageContentAssertions.verifyDevicesPageDevicesModeContent(devicesPage);
        devicesPage.choosePrismView();
        pageContentAssertions.verifyDevicePagePrismModeContent(devicesPage);
    }



}
