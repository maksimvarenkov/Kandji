package KadjiSmokeTest;

import org.kandji.Assertions.EmptyPageContentAssertions;
import org.kandji.BaseTest.BaseTest;
import org.kandji.Pages.*;
import org.kandji.Sections.Sidebar;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EnrollmentPageContentTest extends BaseTest {
    LoginPage loginPage;
    Sidebar sidebar;
    EnrollmentPage enrollmentPage;
    EmptyPageContentAssertions pageContentAssertions = new EmptyPageContentAssertions();

    @BeforeClass
    void setup() {
        loginPage = new LoginPage(super.driver);
        loginPage.open();
        loginPage.loginToApplicationWithOTP();
        sidebar = new Sidebar(super.driver);
    }


    @Test
    void enrollmentPageContentTest() {
        sidebar.chooseMenuItem("Enrollment");
        enrollmentPage = new EnrollmentPage(super.driver);
        enrollmentPage.waitUntilPageLoaded();
        Assert.assertTrue(enrollmentPage.getURL().contains("add-devices"), "Checking that URL matches and has add-devices");
        pageContentAssertions.verifyEnrollmentPageAutomatedViewContent(enrollmentPage);
        enrollmentPage.chooseManualView();
        pageContentAssertions.verifyEnrollmentPageManualViewContent(enrollmentPage);
    }



}
