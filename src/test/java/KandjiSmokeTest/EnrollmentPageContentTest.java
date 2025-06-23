package KandjiSmokeTest;

import org.kandji.Assertions.EmptyPageContentAssertions;
import org.kandji.BaseTest.BaseTest;
import org.kandji.Pages.*;
import org.kandji.Sections.Sidebar;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EnrollmentPageContentTest extends BaseTest {

    Sidebar sidebar;
    EnrollmentPage enrollmentPage;
    EmptyPageContentAssertions pageContentAssertions = new EmptyPageContentAssertions();

    @Test
    void enrollmentPageContentTest() {
        sidebar = new Sidebar(getDriver());
        sidebar.chooseMenuItem("Enrollment");

        enrollmentPage = new EnrollmentPage(getDriver());
        enrollmentPage.waitUntilPageLoaded();
        Assert.assertTrue(enrollmentPage.getURL().contains("add-devices"), "Checking that URL matches and has add-devices");
        pageContentAssertions.verifyEnrollmentPageAutomatedViewContent(enrollmentPage);
        enrollmentPage.chooseManualView();
        pageContentAssertions.verifyEnrollmentPageManualViewContent(enrollmentPage);
    }

}
