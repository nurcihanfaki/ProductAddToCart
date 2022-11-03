package org.example.page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailPage extends AbstractPageObject{

    @FindBy(xpath = "//span[@class=\"addToCartButton\"]")
    private WebElement firstProductAddToCartButton;

    @FindBy(xpath = "//a[@class=\"checkoutui-Modal-iHhyy79iR28NvF33vKJb\"]")
    private WebElement close;

    @FindBy(xpath = "(//div[@class=\"addToCart\"])[1]")
    private WebElement secondProductAddToCartButton;

    @FindBy(id = "shoppingCart")
    private WebElement goToCart;

    @Step
    public void clickFirstProductAddToCartButton() {
        this.firstProductAddToCartButton.click();
    }
    @Step
    public void clickClose() {
        this.close.click();
    }
    @Step
    public void clickSecondProductAddToCartButton() {
        this.secondProductAddToCartButton.click();
    }
    @Step
    public void clickGoToCart() {
        this.goToCart.click();
    }

}
