package org.kandji.Utils;

import org.kandji.BaseTest.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Object testClassInstance = result.getInstance();
        if (testClassInstance instanceof BaseTest) {
            WebDriver driver = ((BaseTest) testClassInstance).getDriver();
            ScreenshotUtil.takeScreenshot(driver, result.getName());
        }
    }
}