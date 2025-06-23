package org.kandji.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LibraryPage extends BasePage {

    @FindBy(xpath = "//h2[contains(text(), 'Library')]")
    private WebElement pageHeader;

    @FindBy(xpath = "//div[contains(@class, 'virtuoso-grid-item')]")
    private List<WebElement> libraryCards;

    @FindBy(css = "[data-testid='page-layout'] input")
    private WebElement searchInput;

    @FindBy(xpath = "//h1[contains(text(), 'No results found')]")
    private WebElement noSearchResultsFound;

    @FindBy(css = "div[role='listbox'] button")
    private List<WebElement> navigationButtons;

    public LibraryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public LibraryPage waitUntilPageLoaded() {
        waitUntilVisible(pageHeader);
        return this;
    }

    public int getLibraryCardsCount() {
        return libraryCards.size();
    }

    public LibraryPage fillSearchField(String value) {
        type(searchInput, value);
        return this;
    }

    public LibraryPage waitForLibraryCards(int desiredCount){
        this.waitUntilDesiredElementsCountDisplayed(libraryCards, desiredCount);
        return this;
    }

    public LibraryPage waitForEmptySearchPlaceholder() {
        waitUntilVisible(noSearchResultsFound);
        return this;
    }

    public boolean isNoSearchResultsPlaceholderDisplayed() {
        return isElementDisplayed(noSearchResultsFound);
    }

    public int getLibraryNavigationButtonCount() {
        return navigationButtons.size();
    }



}
