package org.kandji.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResourcesPage extends BasePage {

    @FindBy(xpath = "//h2[contains(text(), 'Resources')]")
    private WebElement resourcesPageHeader;

    @FindBy(css = "[data-testid='page-layout-content']")
    private WebElement pageContent;

    public ResourcesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public ResourcesPage waitUntilLoaded() {
        waitUntilVisible(resourcesPageHeader);
        return this;
    }

    public boolean isHeaderVisible() {
        return isElementDisplayed(resourcesPageHeader);
    }

    public boolean isPageContentDisplayed() {
        return isElementDisplayed(pageContent);
    }

}
