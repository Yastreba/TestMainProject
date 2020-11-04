package HW27.Pages;

import HW27.Fragments.AddToCompareWidgetFragment;
import HW27.Fragments.BasketFragment;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class ComparePage {

    AddToCompareWidgetFragment addToCompareWidgetFragment = new AddToCompareWidgetFragment();
    BasketFragment basketFragment = new BasketFragment();
    ElementsCollection compareProducts = $$("[class='title-itm']");
    ElementsCollection compareProductsPrices = $$("//div[@class='compare']//span[@class ='price-number']");
    SelenideElement addBtn = $("[class='add-icon']");



    public ComparePage addToBasketBtnClick(String productName) {
        $x("//h5[contains (text(), '" + productName + "')]/../../..//i[@class = 'icon-new-citrus-cart el-tooltip item']").click();
        return this;
    }

    public BasketFragment getBasketFragment() {
        return basketFragment;
    }

    public ElementsCollection getProductNamesCompare() {
        return compareProducts;
    }

    public ElementsCollection getProductPriceCompare() {
        return compareProductsPrices;

    }

    public AddToCompareWidgetFragment getAddToCompareWidgetFragment() {
        return addToCompareWidgetFragment;
    }

    public ComparePage addProductClick() {
        addBtn.click();
        return this;
    }
}
