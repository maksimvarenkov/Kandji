package org.kandji.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnrollmentPage extends BasePage {

    @FindBy(xpath = "//h1[contains(text(), 'Enrollment')]")
    private WebElement enrollmentPageHeader;

    @FindBy(xpath = "//span[contains(text(), 'Automated Device Enrollment is not configured')]")
    private WebElement blankDevicesPlaceholder;

    @FindBy(css = "div[role='tablist'] [data-state='inactive']")
    private WebElement inactiveTab;

    @FindBy(css = "div[role='tablist'] [data-state='active']")
    private WebElement activeTab;

    @FindBy(css = "[data-contentid='automated']")
    private WebElement automatedView;

    @FindBy(css = "[data-contentid='manual']")
    private WebElement manualView;

    @FindBy(css = "[data-tabid='automated']")
    private WebElement automatedTabButton;

    @FindBy(css = "[data-tabid='manual']")
    private WebElement manualTabButton;

    @FindBy(xpath = "//h1[contains(text(), 'Download a one-time use enrollment profile')]")
    private WebElement downloadBlueprintManualView;

    public EnrollmentPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public EnrollmentPage waitUntilPageLoaded() {
        waitUntilVisible(enrollmentPageHeader);
        return this;
    }

    public boolean isHeaderExist() {
        return isElementDisplayed(enrollmentPageHeader);
    }

    public boolean isEmptyDevicesPlaceholderExists() {
        return isElementDisplayed(blankDevicesPlaceholder);
    }

    public String getInactiveTabName() {
        return getTextFromElement(inactiveTab);
    }

    public String getActiveTabName() {
        return getTextFromElement(activeTab);
    }

    public EnrollmentPage chooseManualView() {
        clickAndWaitForElement(manualTabButton, manualView);
        return this;
    }

    public EnrollmentPage chooseAutomatedView() {
        clickAndWaitForElement(automatedTabButton, automatedView);
        return this;
    }

    public boolean isAutomatedViewActive() {
        return isElementDisplayed(automatedView);
    }

    public boolean isManualViewActive() {
        return isElementDisplayed(manualView);
    }

    public boolean isManualViewOpened() {
        return isElementDisplayed(downloadBlueprintManualView);
    }

}
