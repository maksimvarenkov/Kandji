
package org.kandji.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BasePage {

    protected WebDriver driver;
    private final WebDriverWait wait;
    private Set<String> windowHandles;
    private String originalWindowHandle;


    public BasePage(WebDriver driver) {
        super();
        this.driver = driver;

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    protected void waitUntilVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitUntilClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void click(WebElement element) {
        waitUntilClickable(element);
        element.click();
    }

    protected void clickAndWaitForElement(WebElement elementToClick, WebElement elementToAppear) {
        click(elementToClick);
        waitUntilVisible(elementToAppear);
    }

    protected void type(WebElement element, String text) {
        waitUntilVisible(element);
        element.clear();
        element.sendKeys(text);
    }

    protected String getTextFromElement(WebElement element) {
        waitUntilVisible(element);

        return element.getText();
    }

    protected String getValueFromInput(WebElement element) {
        waitUntilVisible(element);

        return element.getAttribute("value");
    }

    public String getURL() {
        return driver.getCurrentUrl();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    protected boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /*
    It's not really elegant solution, but quickest for implementation. In future it have to be replaced
    to lambda with fluent wait
     */
    public void waitUntilDesiredElementsCountDisplayed(List<WebElement> elementList, int desiredCount) {
        for (int i = 0; i < 10; i++) {
            if (elementList.size() == desiredCount) {
                System.out.println("Desired elements count found after try [" + i + "]");
                break;
            } else {
                try {
                    System.out.println("Desired elements count not much after try [" + i + "]");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    //we don't really need it, we could just check href for <a> and it should be enough, but just for demonstration
    public void switchToNewTab() {
        originalWindowHandle = driver.getWindowHandle();
        windowHandles = driver.getWindowHandles();

        ArrayList<String> tabs = new ArrayList<>(windowHandles);
        for (String handle : tabs) {
            if (!handle.equals(originalWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }

    public void switchToOriginalWindow() {
        driver.switchTo().window(originalWindowHandle);
    }

    public void closeCurrentTab() {
        driver.close();
    }

}
