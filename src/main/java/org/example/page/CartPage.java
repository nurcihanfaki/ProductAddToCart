package org.example.page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends AbstractPageObject{

    @FindBy(xpath = "(//span[@class=\"merchantLink_2Ii8s\"])[1]")
    private WebElement firstSeller;

    @FindBy(xpath = "(//span[@class=\"merchantLink_2Ii8s\"])[2]")
    private WebElement secondSeller;
    @FindBy(xpath = "(//div[@class=\"product_name_3Lh3t\"])[1]")
    private WebElement firstProduct;
    @FindBy(xpath = "(//div[@class=\"product_name_3Lh3t\"])[2]")
    private WebElement secondProduct;

    @Step
    public String firstSellerText() {
        return this.firstSeller.getText();
    }
    @Step
    public String secondSellerText() {
        return this.secondSeller.getText();
    }
    @Step
    public String firstProductText() {
        return this.firstProduct.getText();
    }
    @Step
    public String secondProductText() {
        return this.secondProduct.getText();
    }
}
