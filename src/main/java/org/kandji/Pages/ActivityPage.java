package org.kandji.Pages;

import org.kandji.UI.KandjiDropdown;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ActivityPage extends BasePage {

    @FindBy(xpath = "//h2[contains(text(), 'Activity')]")
    private WebElement activityPageHeader;

    @FindBy(xpath = "//div[label[text()='Activity Type']]")
    private WebElement activityTypeSelector;

    @FindBy(xpath = "//div[label[text()='Date Range']]")
    private WebElement dataRangeInput;

    @FindBy(xpath = "//section[text()='NO DATA TO DISPLAY']")
    private WebElement noDataFoundPlaceholder;

    @FindBy(css = ".activity-tab-new-description")
    private List<WebElement> listDescriptionItems;

    public ActivityPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public ActivityPage waitUntilLoaded() {
        waitUntilVisible(activityPageHeader);
        return this;
    }

    public boolean isHeaderVisible() {
        return isElementDisplayed(activityPageHeader);
    }

    private void fillDropdown(String name, String value) {
        KandjiDropdown kandjiDropdown;
        if (name.equals("activity")) {
            kandjiDropdown = new KandjiDropdown(activityTypeSelector, driver);
        } else if (name.equals("date")) {
            kandjiDropdown = new KandjiDropdown(dataRangeInput, driver);
        } else {
            kandjiDropdown = new KandjiDropdown(activityTypeSelector, driver);
        }

        kandjiDropdown.chooseValue(value);
        activityPageHeader.click();
    }

    public ActivityPage fillActivityDropdown(String value) {
        fillDropdown("activity", value);
        return this;
    }

    public ActivityPage waitUntilDesiredSearchCountDisplayed(int desiredCount) {
        waitUntilDesiredElementsCountDisplayed(listDescriptionItems, desiredCount);
        return this;
    }

    public ActivityPage fillDateRangeDropdown(String value) {
        fillDropdown("date", value);
        return this;
    }

    public boolean isNoDataPlaceholderDisplayed() {
        return isElementDisplayed(noDataFoundPlaceholder);
    }

    public ActivityPage waitUntilPlaceholderDisplayed() {
        waitUntilVisible(noDataFoundPlaceholder);
        return this;
    }

    public int getResultsCount() {
        return listDescriptionItems.size();
    }

}
