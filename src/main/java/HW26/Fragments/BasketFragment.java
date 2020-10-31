package HW26.Fragments;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class BasketFragment {

    SelenideElement baskedWidget = $x("//div[@class='el-dialog__body']");
    ElementsCollection getProductNames = $$("[class*='ctrs-basket-product__name']");
    SelenideElement basketTotalPrice = $("[class='ctrs-main-price ctrs-basket-footer__new-price']");
    ElementsCollection basketPrices = $$x("//div[@class = 'ctrs-basket-item__total-price']/span[@class = 'ctrs-main-price']");
    SelenideElement closeBasketBtn = $x("//button[@class='el-dialog__headerbtn']");
    SelenideElement BasketBtn = $("[class='icon-new-citrus-cart']");

    public ElementsCollection getProductNamesBasket() {
        return getProductNames;
    }

    public SelenideElement getBuscetTotlaPrice() {
        return basketTotalPrice;
    }

    public SelenideElement getBasket() {
        return baskedWidget;
    }

    public ElementsCollection getPricesBasket() {
        return basketPrices;
    }

    public void closeBasketBtnClick() {
        closeBasketBtn.shouldBe(Condition.visible).click();
    }

    public void headerBasketBtnClick() {
        BasketBtn.click();
    }
}
