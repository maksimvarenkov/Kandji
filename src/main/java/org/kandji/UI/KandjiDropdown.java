package org.kandji.UI;

import org.kandji.BaseTest.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class KandjiDropdown extends BaseTest {
    private final WebElement element;
    private final WebDriver driver;

    public KandjiDropdown(WebElement element, WebDriver driver) {
        this.element = element;
        this.driver = driver;
    }

    public void chooseValue(String value) {
        //this one is not accurate. If i choose dropdown too fast looks like it's not registering option i chose
        //trying sleep
        element.click();
       WebElement dropdownOption = getDropdownOption(value);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        dropdownOption.click();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private WebElement getDropdownOption(String value) {
        return this.driver.findElement(By.xpath("//div[text()='" + value + "']"));
    }

}
