package test.testcase;

import org.example.page.CartPage;
import org.example.page.HomePage;
import org.example.page.LoginPage;
import org.example.page.ProductDetailPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.common.BaseTest;

public class ProductAddToBasketWithLogin extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;

    @Test(description = "Login Journey")
    public void loginJourney() throws InterruptedException {
        homePage = new HomePage();
        System.out.println("Çerezler kabul edilir");
        homePage.clickAcceptCookieButton();

        loginPage = new LoginPage();
        System.out.println("Giriş yap veya üye ol butonu tıklanır");
        loginPage.clickLoginOrSignupButton();
        Thread.sleep(2000);
        System.out.println("Giriş yap butonu tıklanır");
        loginPage.clickLoginButton();
        System.out.println("Facebook ile giriş yap butonu tıklanır");
        loginPage.clickLoginWithFacebook();
        System.out.println("Email alanı doldurulur");
        loginPage.fillEmail("");
        System.out.println("Şifre alanı doldurulur");
        loginPage.fillPassword("");
        System.out.println("Giriş yap butonu tıklanır");
        loginPage.clickFacebookLoginButton();
        Assert.assertNotEquals("Giris basarili mi kontrol edilir","Hesabım", homePage.getMyAccountText());

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
        Thread.sleep(2000);
        System.out.println("Sepete eklendi uyarısı kapatılır");
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
        Assert.assertNotEquals(cartPage.firstSellerText(),cartPage.secondSellerText());

        System.out.println("İlk ürünün ismi alınır");
        System.out.println(cartPage.firstProductText());
        System.out.println("İkinci ürünün ismi alınır");
        System.out.println(cartPage.secondProductText());
        System.out.println("İki ürünün isminin aynı olduğu kontrol edilir");
        Assert.assertEquals(cartPage.firstProductText(), cartPage.secondProductText());
    }
}
