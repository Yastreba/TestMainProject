package HW27.CitrusSteps;

import HW27.Pages.ProductPage;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

public class ProductPageStep {

    ProductPage productPage = new ProductPage();

    @Step("Add product to basket")
    public String addProductToBasket() {
        productPage.clickBuyButton();
        return productPage.getProductPrice();
    }

    @Step("Verify basket content")
    public void verifyBasketContent(String productName, String productPrice) {
        productPage.getBasketFragment().getBasket().shouldBe(Condition.visible);
        productPage.getBasketFragment().getProductNamesBasket().shouldHaveSize(1);
        productPage.getBasketFragment().getProductNamesBasket().get(0).shouldHave(Condition.text(productName));
        productPage.getBasketFragment().getBuscetTotlaPrice().shouldHave(Condition.text(productPrice));
    }

    @Step("Verify basket content with multyply Products")
    public void verifyMultyplyProductBasketContent(String firstProductName, String firstProductPrice, String secondProductName, String secondProductPrice) {
        productPage.getBasketFragment().getBasket().shouldBe(Condition.visible);
        productPage.getBasketFragment().getProductNamesBasket().shouldHaveSize(2);
        productPage.getBasketFragment().getProductNamesBasket().get(0).shouldHave(Condition.text(firstProductName));
        productPage.getBasketFragment().getProductNamesBasket().get(1).shouldHave(Condition.text(secondProductName));
        productPage.getBasketFragment().getPricesBasket().get(0).shouldHave(Condition.text(firstProductPrice));
        productPage.getBasketFragment().getPricesBasket().get(1).shouldHave(Condition.text(secondProductPrice));

    }
}
