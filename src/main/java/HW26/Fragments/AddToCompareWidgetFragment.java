package HW26.Fragments;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class AddToCompareWidgetFragment {

    ElementsCollection compareWidgetProductList = $$("[class='el-checkbox']");
    ElementsCollection compareWidgetNames = $$("class='product-name'");
    ElementsCollection compareWidgetPrices = $$x("//span[@class='price-new']//span[@class='price-number']");
SelenideElement addBtn = $x("//button[@class='el-button el-button--primary']");

    public ElementsCollection productList() {
    return compareWidgetProductList;
    }

    public String getFirsProductName() {
       return compareWidgetNames.get(1).getText();
    }

    public String getFirsProductPrice() {
      return compareWidgetPrices.get(1).getText();
    }

    public void clickAdd() {
        addBtn.click();
    }
}
