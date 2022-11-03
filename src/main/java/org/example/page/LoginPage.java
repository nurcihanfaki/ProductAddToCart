package org.example.page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPageObject {

    @FindBy(id = "myAccount")
    private WebElement loginOrSignupButton;

    @FindBy(id = "login")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"btnFacebook\"]")
    private WebElement loginWithFacebook;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "pass")
    private WebElement password;

    @FindBy(id = "loginbutton")
    private WebElement facebookLoginButton;

    @Step
    public void clickLoginOrSignupButton() {
        this.loginOrSignupButton.click();
    }

    @Step
    public void clickLoginButton() {
        this.loginButton.click();
    }

    @Step
    public void clickLoginWithFacebook() {
        this.loginWithFacebook.click();
    }

    @Step
    public void fillEmail(String email) {
        this.email.sendKeys(email);
    }

    @Step
    public void fillPassword(String password) {
        this.password.sendKeys(password);
    }

    @Step
    public void clickFacebookLoginButton() {
        this.facebookLoginButton.click();
    }
}