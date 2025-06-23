package org.kandji.Sections;

import org.kandji.Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Sidebar extends BasePage {

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(css = "[data-testid='sidebar'] [data-testid='universal-search-item']")
    private WebElement searchItem;

    @FindBy(css = "[data-testid='sidebar'] [data-testid='sidebar-devices']")
    private WebElement devicesPageLink;

    @FindBy(css = "[data-testid='sidebar'] [data-testid='sidebar-blueprints']")
    private WebElement blueprintsPageLink;

    @FindBy(css = "[data-testid='sidebar'] [data-testid='sidebar-library']")
    private WebElement libararyPageLink;

    @FindBy(css = "[data-testid='sidebar'] [data-testid='sidebar-users']")
    private WebElement usersPageLink;

    @FindBy(css = "[data-testid='sidebar'] [data-testid='sidebar-threats']")
    private WebElement threatsPageLink;

    @FindBy(css = "[data-testid='sidebar'] [data-testid='sidebar-vulnerabilities']")
    private WebElement vulnerabilitiesPageLink;

    @FindBy(css = "[data-testid='sidebar'] [data-testid='sidebar-alerts']")
    private WebElement alertsPageLink;

    @FindBy(css = "[data-testid='sidebar'] [data-testid='sidebar-activity']")
    private WebElement activityPageLink;

    @FindBy(css = "[data-testid='sidebar'] [data-testid='sidebar-enrollment']")
    private WebElement enrollmentPageLink;

    @FindBy(css = "[data-testid='sidebar'] [data-testid='sidebar-resources']")
    private WebElement resourcesPageLink;

    @FindBy(css = "[data-testid='sidebar-user-name']")
    private WebElement sidebarUsername;

    @FindBy(css = "[data-testid='log-out-button']")
    private WebElement sidebarLogoutItem;

    @FindBy(css = "[data-testid='my-profile-button']")
    private WebElement sidebarMyProfileItem;


    public Sidebar(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isUserLogged() {
        return isElementDisplayed(sidebarUsername);
    }

    public void waitUntilSidebarDisplayed() {
        waitUntilVisible(sidebarUsername);
    }

    public void chooseMenuItem(String menuItem) {
        switch (menuItem) {
            case "Devices":
                click(devicesPageLink);
                break;
            case "Blueprints":
                click(blueprintsPageLink);
                break;
            case "Library":
                click(libararyPageLink);
                break;
            case "Users":
                click(usersPageLink);
                break;
            case "Threats":
                click(threatsPageLink);
                break;
            case "Vulnerabilities":
                click(vulnerabilitiesPageLink);
                break;
            case "Alerts":
                click(alertsPageLink);
                break;
            case "Activity":
                click(activityPageLink);
                break;
            case "Enrollment":
                click(enrollmentPageLink);
                break;
            case "Resources":
                click(resourcesPageLink);
                break;
        }
    }

    public void logout() {
        clickAndWaitForElement(sidebarUsername, sidebarLogoutItem);
        sidebarLogoutItem.click();
    }

    public void clickMyProfile() {
        clickAndWaitForElement(sidebarUsername, sidebarMyProfileItem);
        sidebarMyProfileItem.click();
    }

}
