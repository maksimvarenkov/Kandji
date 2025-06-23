package org.kandji.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DevicesPage extends BasePage {

    @FindBy(xpath = "//h2[contains(text(), 'Devices')]")
    private WebElement pageHeader;

    @FindBy(xpath = "//h4[contains(text(), 'No devices to display')]")
    private WebElement blankDevicesPlaceholder;

    @FindBy(css = "div[role='tablist'] [data-state='inactive']")
    private WebElement inactiveTab;

    @FindBy(css = "div[role='tablist'] [data-state='active']")
    private WebElement activeTab;

    @FindBy(css = "[data-contentid='devices']")
    private WebElement devicesView;

    @FindBy(css = "[data-contentid='prism']")
    private WebElement prismView;

    @FindBy(css = "[data-tabid='devices']")
    private WebElement devicesTabButton;

    @FindBy(css = "[data-tabid='prism']")
    private WebElement prismTabButton;

    @FindBy(id = "prism-nav-label")
    private List<WebElement> prismViewNavigationLinks;

    public DevicesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public DevicesPage waitUntilPageLoaded() {
        waitUntilVisible(pageHeader);
        return this;
    }

    public boolean isHeaderExist() {
        return isElementDisplayed(pageHeader);
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

    public DevicesPage choosePrismView() {
        clickAndWaitForElement(prismTabButton, prismView);
        return this;
    }

    public DevicesPage chooseDevicesView() {
        clickAndWaitForElement(devicesTabButton, devicesView);
        return this;
    }

    public boolean isDevicesViewActive(){
        return isElementDisplayed(devicesView);
    }

    public boolean isPrismViewActive(){
        return isElementDisplayed(prismView);
    }

    public boolean isPrismNavigationLinksExists(){
        return !prismViewNavigationLinks.isEmpty();
    }
}
