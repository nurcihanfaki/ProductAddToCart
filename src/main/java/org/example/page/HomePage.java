package org.example.page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPageObject{

    @FindBy(xpath = "//div[@id=\"myAccount\"]")
    private WebElement myAccountButton;

    @FindBy(xpath = "//input[@type=\"text\" and @autocomplete=\"off\"]")
    private WebElement searchBox;

    @FindBy(className = "SearchBoxOld-cHxjyU99nxdIaAbGyX7F")
    private WebElement searchButton;

    @FindBy(className = "productListContent-zAP0Y5msy8OHn5z7T_K_")
    private WebElement product;

    @FindBy(xpath = "//button[@id=\"onetrust-accept-btn-handler\"]")
    private WebElement acceptCookie;

    @Step
    public String getMyAccountText() {
        return this.myAccountButton.getText();
    }

    @Step
    public void fillSearchBox(String product) {
        this.searchBox.sendKeys(product);
    }

    @Step
    public void clickSearchButton() {
        this.searchButton.click();
    }

    @Step
    public void clickProduct(){
        this.product.click();
    }

    @Step
    public void clickAcceptCookieButton() {
        this.acceptCookie.click();
    }

}
