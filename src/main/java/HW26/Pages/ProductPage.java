package HW26.Pages;

import HW26.Fragments.BasketFragment;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.util.Dictionary;

import static com.codeborne.selenide.Selenide.$x;

public class ProductPage extends BasePage {

    BasketFragment basketFragment = new BasketFragment();
    SelenideElement productPrice = $x("//div[@class = 'price']/span/span");
    SelenideElement buyButton = $x("//button[@class = 'btn orange full'][contains(text(), 'Купить')]");

    public String getProductPrice() {
        return productPrice.getText();
    }

    public ProductPage clickBuyButton() {
        buyButton.shouldBe(Condition.enabled).click();
        return this;
    }

    public BasketFragment getBasketFragment() {
        return basketFragment;
    }

    public ProductPage waitForPageToLoad() {
        super.waitForPageToLoad();
        return this;
    }

}
