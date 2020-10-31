package HW26.Pages;

import HW26.Fragments.FilterFragment;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import net.bytebuddy.implementation.bytecode.Throw;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Integer.parseInt;

public class ProductListPage extends BasePage {

    FilterFragment filterFragment = new FilterFragment();
    SelenideElement moreItemsBtn = $("[class = 'more-items__icon']");
    ElementsCollection getPrices = $$x("//div[@class = 'base-price']/span[@class = 'price-number']");
    ElementsCollection getNames = $$x("//div[@class = 'product-card__name']");
    SelenideElement compareBtn = $("[class = 'user-actions__compare tips-parent']");
    ElementsCollection productCards = $$("[class='product-card product-card--mini']");
    ElementsCollection noteBooksPrices = $$x("//div[@class = 'prices__price']/span[@class = 'price']");


    public ProductListPage clickOnProductByName(String productName) {
        $x("//span[contains (text(), '" + productName + "')]").click();
        return this;
    }

    public ProductListPage waitForPageToLoad() {
        super.waitForPageToLoad();
        return this;
    }

    public ProductListPage closePopUp() {
        super.closePopUp();
        return this;
    }

    public String getProductPriceByName(String productName) {
        if ($x("//h5[contains (text(), '" + productName + "')]").isDisplayed()) {
            $x("//h5[contains (text(), '" + productName + "')]/../../..//div[@class = 'base-price']/span[@class = 'price-number']").scrollTo().getText();
        } else {
            moreItemsBtn.click();
        }
        return $x("//h5[contains (text(), '" + productName + "')]/../../..//div[@class = 'base-price']/span[@class = 'price-number']").getText();
    }

    public ProductListPage addProductToBascet(String productName) {
        $x("//h5[contains (text(), '" + productName + "')]/../../..//i[@class = 'icon-new-citrus-cart el-tooltip item']").click();
        return this;
    }

    public String getFirsProductPrice() {
        return getPrices.get(0).getText();
    }

    public String getSecondProductPrice() {
        return getPrices.get(1).getText();
    }

    public String getFirsProductName() {
        return getNames.get(0).getText();
    }

    public String getSecondProductName() {
        return getNames.get(1).getText();
    }

    public ProductListPage addProductToCompression(String productName) {
        $x("//h5[contains (text(), '" + productName + "')]/../../..//i[@class = 'icon-comparison2 el-tooltip item']").click();
        return this;
    }

    public ProductListPage compressionBtnClick() {
        compareBtn.click();
        return this;
    }

    public FilterFragment getFilterFragment() {
        return filterFragment;
    }

    public ElementsCollection getAllNames() {
        return getNames;
    }

    public ElementsCollection getAllPrices() {
        return getPrices;
    }


    public void checkMaterialFilter() throws Exception {
        for (int count = 0; count < productCards.size(); count++) {
            productCards.get(count).hover();
            bb:
            if (productCards.get(count).getText().contains("Пластик")) {
                break bb;
            } else {
                throw new Exception("Test Failed");
            }
        }
    }

    public void checkAllPrices() throws Exception {
        for (int count = 0; count < getPrices.size(); count++) {
            int price = parseInt(getPrices.get(count).getText().replace(" ", ""));
            bb:
            if ((price >= 1000) && (price <= 9000)) {
                break bb;
            } else {
                throw new Exception("Test Failed");
            }
        }
    }

    public void checkAllNames(String name) throws Exception {
        for (int count = 0; count < getNames.size(); count++) {
            bb:
            if (getNames.get(count).getText().contains(name)) {
                break bb;
            } else {
                throw new Exception("Test Failed");
            }
        }
    }


    public String getFirsNoteBookPrice() {
        return noteBooksPrices.get(0).getText();
    }

    public String getSecondNoteBookPrice() {
        return noteBooksPrices.get(1).getText();
    }

    public ProductListPage addProductToCompressionNotebooks(String productName) {
        $x("//span[contains (text(), '" + productName + "')]/../../../../..//button[@class='product-card__to-compare']").hover().click();
        return this;
    }


    public void chectMemFilter() throws Exception {
        for (int i = 0; i <= getAllNames().size(); i++) {
            bb:
            if (getAllNames().get(0).getText().contains("/32Gb") || (getAllNames().contains(text(("/64Gb"))))) {
                break bb;
            } else {
                throw new Exception("Test Failed");
            }
        }
    }
}
