package test.testcase;

import org.example.page.CartPage;
import org.example.page.HomePage;
import org.example.page.ProductDetailPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.common.BaseTest;

public class ProductAddToBasketWithoutLogin extends BaseTest {

    HomePage homePage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;

    @Test(description = "Without Login Journey")
    public void withoutLoginJourney() throws InterruptedException {
        homePage = new HomePage();
        System.out.println("Çerezler kabul edilir");
        homePage.clickAcceptCookieButton();
        System.out.println("Arama kutusuna ürün yazılır");
        homePage.fillSearchBox("nutella");
        System.out.println("Arama butonuna tıklanır");
        homePage.clickSearchButton();
        System.out.println("Ürüne tıklanır");
        homePage.clickProduct();

        System.out.println("Diğer sekmeye geçilir");
        anotherWindow();

        productDetailPage = new ProductDetailPage();
        System.out.println("Ilk ürün sepete eklenir");
        productDetailPage.clickFirstProductAddToCartButton();
        System.out.println("Sepete eklendi uyarısı kapatılır");
        Thread.sleep(5000);
        productDetailPage.clickClose();
        System.out.println("Aynı ürün farklı satıcıdan sepete eklenir");
        productDetailPage.clickSecondProductAddToCartButton();
        System.out.println("Sepete gidilir");
        productDetailPage.clickGoToCart();

        cartPage = new CartPage();
        System.out.println("İlk satıcının ismi alınır");
        System.out.println(cartPage.firstSellerText());
        System.out.println("İkinci satıcının ismi alınır");
        System.out.println(cartPage.secondSellerText());
        System.out.println("İki satıcının isminin farklı olduğu kontrol edilir");
        Assert.assertNotEquals(cartPage.firstSellerText(), cartPage.secondSellerText());

        System.out.println("İlk ürünün ismi alınır");
        System.out.println(cartPage.firstProductText());
        System.out.println("İkinci ürünün ismi alınır");
        System.out.println(cartPage.secondProductText());
        System.out.println("İki ürünün isminin aynı olduğu kontrol edilir");
        Assert.assertEquals(cartPage.firstProductText(), cartPage.secondProductText());

    }
}
