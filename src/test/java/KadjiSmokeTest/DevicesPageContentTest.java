package KadjiSmokeTest;

import org.kandji.Assertions.EmptyPageContentAssertions;
import org.kandji.BaseTest.BaseTest;
import org.kandji.Pages.*;
import org.kandji.Sections.Sidebar;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DevicesPageContentTest extends BaseTest {
    DevicesPage devicesPage;
    Sidebar sidebar;
    EmptyPageContentAssertions pageContentAssertions = new EmptyPageContentAssertions();

    @Test
    void devicesPageContentTest() {
        sidebar = new Sidebar(getDriver());
        sidebar.chooseMenuItem("Devices");
        devicesPage = new DevicesPage(getDriver());
        devicesPage.waitUntilPageLoaded();

        Assert.assertTrue(sidebar.getURL().contains("devices"), "Checking that URL matches and has devices");
        pageContentAssertions.verifyDevicesPageDevicesModeContent(devicesPage);

        devicesPage.choosePrismView();
        pageContentAssertions.verifyDevicePagePrismModeContent(devicesPage);
    }

}
