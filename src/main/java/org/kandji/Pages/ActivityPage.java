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
    private List<WebElement> results;

    private WebElement dropdownOption;

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

    public ActivityPage fillActivityDropdown(String value) {
        KandjiDropdown kandjiDropdown = new KandjiDropdown(activityTypeSelector, driver);
        kandjiDropdown.chooseValue(value);
        activityPageHeader.click();
        return this;
    }

    public ActivityPage fillDataRangeDropdown(String value){
        KandjiDropdown kandjiDropdown = new KandjiDropdown(dataRangeInput, driver);
        kandjiDropdown.chooseValue(value);
        activityPageHeader.click();
        return this;
    }

    public ActivityPage waitUntilDesiredSeacrhCountDisplayed(int desiredCount){
        waitUntilDesiredElementsCountDisplayed(results, desiredCount);
        return this;
    }

    public boolean isNoDataPlaceholderDisplayed(){
        return isElementDisplayed(noDataFoundPlaceholder);
    }

    public ActivityPage waitUntilPlaceholderDisplayed(){
        waitUntilVisible(noDataFoundPlaceholder);

        return this;
    }

    public int getResultsCount(){
        return results.size();
    }



}
