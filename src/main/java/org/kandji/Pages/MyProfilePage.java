package org.kandji.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProfilePage extends BasePage {

    @FindBy(xpath = "//h2[contains(text(), 'Profile')]")
    private WebElement pageHeader;

    @FindBy(css = "div[role='tablist'] [data-state='inactive']")
    private WebElement inactiveTab;

    @FindBy(css = "div[role='tablist'] [data-state='active']")
    private WebElement activeTab;

    @FindBy(css = "[data-contentid='general']")
    private WebElement generalView;

    @FindBy(css = "[data-contentid='multi-factor-authentication']")
    private WebElement mfaView;

    @FindBy(css = "[data-tabid='general']")
    private WebElement generalTabButton;

    @FindBy(css = "[data-tabid='multi-factor-authentication']")
    private WebElement mfaTabButton;

    @FindBy(xpath = "//h1[contains(text(), 'User information')]")
    private WebElement generalViewContent;

    @FindBy(xpath = "//h1[contains(text(), 'One-Time Password (OTP)')]")
    private WebElement mfaViewContent;


    public MyProfilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public MyProfilePage waitUntilPageLoaded() {
        waitUntilVisible(pageHeader);
        return this;
    }

    public boolean isHeaderExist() {
        return isElementDisplayed(pageHeader);
    }

    public String getInactiveTabName() {
        return getTextFromElement(inactiveTab);
    }

    public String getActiveTabName() {
        return getTextFromElement(activeTab);
    }

    public MyProfilePage chooseGeneralView() {
        clickAndWaitForElement(generalTabButton, generalView);
        return this;
    }

    public MyProfilePage chooseMFAView() {
        clickAndWaitForElement(mfaTabButton, mfaView);
        return this;
    }

    public boolean isGeneralViewActive() {
        return isElementDisplayed(generalView);
    }

    public boolean isMFAViewActive() {
        return isElementDisplayed(mfaView);
    }

    public boolean isMFAContentDsipalyed() {
        return isElementDisplayed(mfaViewContent);
    }

    public boolean isGeneralContentDsipalyed() {
        return isElementDisplayed(generalViewContent);
    }

}
