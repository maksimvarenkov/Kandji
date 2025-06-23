package org.kandji.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ThreatsPage extends BasePage {

    @FindBy(xpath = "//h4[contains(text(), 'Get started with Kandji EDR')]")
    private WebElement getStartedNotificationheader;

    @FindBy(xpath = "//main[@class='full-width-sidebar-opened']/div[1] //a")
    private WebElement learnMoreLink;

    @FindBy(xpath = "//button[contains(text(), 'Go to Library')]")
    private WebElement goToLibraryButton;

    public ThreatsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public ThreatsPage waitUntilLoaded(){
        waitUntilVisible(getStartedNotificationheader);
        return this;
    }

    public void clickGoToLibraryButton(){
        click(goToLibraryButton);
    }

    public void clickLearnMoreLink(){
        click(learnMoreLink);
    }




}
