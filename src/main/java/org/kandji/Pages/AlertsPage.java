package org.kandji.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsPage extends BasePage {

    @FindBy(xpath = "//h2[contains(text(), 'Alerts')]")
    private WebElement alertsPageHeader;

    @FindBy(xpath = "//h4[contains(text(), 'No data available')]")
    private WebElement alertsPagePlaceHolder;

    @FindBy(xpath = "//main[@class='full-width-sidebar-opened']/div[1] //input")
    private WebElement searchInput;

    @FindBy(xpath = "//button[contains(text(), 'Alerts')]")
    private WebElement alertsButton;

    @FindBy(xpath = "//button[contains(text(), 'Muted')]")
    private WebElement mutedButton;

    @FindBy(xpath = "//button[contains(text(), 'Cleared')]")
    private WebElement clearedButton;

    public AlertsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public AlertsPage waitUntilLoaded() {
        waitUntilVisible(alertsPageHeader);
        return this;
    }

    public boolean isHeaderVisible() {
        return isElementDisplayed(alertsPageHeader);
    }

    public boolean isPlaceholderDisplayed() {
        return isElementDisplayed(alertsPagePlaceHolder);
    }

    public AlertsPage clickAlertsButton() {
        click(alertsButton);
        return this;
    }

    public AlertsPage clickMutedButton() {
        click(mutedButton);
        return this;
    }

    public AlertsPage clickClearedButton() {
        click(clearedButton);
        return this;
    }

}
