
package org.kandji.BaseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.kandji.Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {
    protected boolean isLoginRequired = true;
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeClass(alwaysRun = true)
    public void setupTest() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");

        WebDriver localDriver = new ChromeDriver(chromeOptions);
        localDriver.manage().window().maximize();
        localDriver.manage().deleteAllCookies();
        localDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        localDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.set(localDriver);
        if (isLoginRequired) {
            KandjiLogin();
        }
    }

    private void KandjiLogin() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        loginPage.loginToApplicationWithOTP();
    }

    @AfterClass(alwaysRun = true)
    public void teardown() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }

    protected WebDriver getDriver() {
        return driver.get();
    }
}
