package org.kandji.Pages;

import org.kandji.Helpers.ConfigReader;
import org.kandji.Helpers.OTPGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(name = "action")
    private WebElement loginButton;

    @FindBy(id = "code")
    private WebElement codeInput;

    @FindBy(id = "prompt-logo-center")
    private WebElement kandjiLogo;

    @FindBy(id = "id=error-element-code")
    private WebElement invalidOTPMessage;

    String baseUrl;
    String username;
    String password;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        ConfigReader cr = new ConfigReader();
        baseUrl = cr.getProperty("base_url");
        password = cr.getProperty("password");
        username = cr.getProperty("username");
    }

    public LoginPage open() {
        driver.get(baseUrl);
        waitUntilVisible(usernameInput);
        waitUntilVisible(kandjiLogo);
        return this;
    }

    public boolean isLoginFormDisplayed() {
        return isElementDisplayed(kandjiLogo) && isElementDisplayed(loginButton);
    }

    public LoginPage waitUntilDisplayed() {
        waitUntilVisible(kandjiLogo);
        return this;
    }

    public LoginPage fillCredentials() {
        type(usernameInput, username);
        type(passwordInput, password);
        return this;
    }

    public LoginPage clickSubmit() {
        waitUntilVisible(loginButton);
        click(loginButton);
        return this;
    }

    public LoginPage fillOTPcode() {
        String otp = new OTPGenerator().generateOTPPassword();
        type(codeInput, otp);
        return this;
    }

    public void loginToApplicationWithOTP() {
        fillCredentials().clickSubmit().fillOTPcode().clickSubmit();
    }

    public void fillOTPAndSubmit() {
        fillOTPcode().clickSubmit();
    }

    public boolean isInvalidOTPCodeMessageDisaplyed(){
        return isElementDisplayed(invalidOTPMessage);
    }

}
