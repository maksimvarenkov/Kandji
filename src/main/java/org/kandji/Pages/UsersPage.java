package org.kandji.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UsersPage extends BasePage {

    @FindBy(xpath = "//h2[contains(text(), 'Users')]")
    private WebElement pageHeader;

    @FindBy(xpath = "//h1[contains(text(), 'There are no users in Kandji')]")
    private WebElement blankUsersPlaceholder;

    @FindBy(xpath = "//h1[contains(text(), 'There are no groups in Kandji')]")
    private WebElement blankGroupsPlaceholder;

    @FindBy(css = "div[role='tablist'] [data-state='inactive']")
    private WebElement inactiveTab;

    @FindBy(css = "div[role='tablist'] [data-state='active']")
    private WebElement activeTab;

    @FindBy(css = "[data-testid='user-empty-state']")
    private WebElement blankPlaceholder;

    @FindBy(css = "[data-contentid='groups']")
    private WebElement groupView;

    @FindBy(css = "[data-contentid='users']")
    private WebElement usersView;

    @FindBy(css = "[data-tabid='groups']")
    private WebElement groupViewTabButton;

    @FindBy(css = "[data-tabid='users']")
    private WebElement usersViewTabButton;

    public UsersPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public UsersPage waitUntilPageLoaded() {
        waitUntilVisible(pageHeader);
        return this;
    }

    public boolean isHeaderExist() {
        return isElementDisplayed(pageHeader);
    }

    public boolean isEmptyUsersPlaceholderExists() {
        return isElementDisplayed(blankUsersPlaceholder);
    }

    public boolean isEmptyGroupsPlaceholderExists() {
        return isElementDisplayed(blankGroupsPlaceholder);
    }

    public String getInactiveTabName() {
        return getTextFromElement(inactiveTab);
    }

    public String getActiveTabName() {
        return getTextFromElement(activeTab);
    }

    public UsersPage chooseUsersView() {
        clickAndWaitForElement(usersViewTabButton, usersView);
        return this;
    }

    public UsersPage chooseGroupsView() {
        clickAndWaitForElement(groupViewTabButton, groupView);
        return this;
    }

    public boolean isUsersViewActive() {
        return isElementDisplayed(usersView);
    }

    public boolean isGroupsViewActive() {
        return isElementDisplayed(groupView);
    }
}
