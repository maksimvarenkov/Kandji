package org.kandji.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BlueprintsPage extends BasePage {

    @FindBy(xpath = "//h2[contains(text(), 'Blueprints')]")
    private WebElement pageHeader;

    @FindBy(xpath = "//a[contains(@class, 'blueprint-list__item')]")
    private List<WebElement> blueprintCards;

    @FindBy(css = "[data-testid='page-layout'] input")
    private WebElement searchInput;

    public BlueprintsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public BlueprintsPage waitUntilPageLoaded() {
        waitUntilVisible(pageHeader);
        return this;
    }

    public int getBlueprintCardsCount(){
        return blueprintCards.size();
    }

    public BlueprintsPage fillSearchField(String value){
        type(searchInput, value);
        return this;
    }

}
