package HW27.CitrusSteps;

import HW26.Pages.ComparePage;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

public class ComparePageStep {

    ComparePage comparePage = new ComparePage();
    @Step("Add product To basket")
    public void addToBasket(String productname) {
        comparePage.addToBasketBtnClick(productname);
        comparePage.getBasketFragment().closeBasketBtnClick();
    }
    @Step("Click basket button")
    public void clickBasketBtn() {
        comparePage.getBasketFragment().headerBasketBtnClick();
    }
    @Step("Verify Product in compare page")
    public void verifyProductInComparePage(String firstProductName, String secondProductName, String firstProductPrice, String secondProductPrice ) {
        comparePage.getProductNamesCompare().shouldHaveSize(4);
        comparePage.getProductNamesCompare().get(1).shouldHave(Condition.text(firstProductName));
        comparePage.getProductNamesCompare().get(2).shouldHave(Condition.text(secondProductName));
        comparePage.getProductPriceCompare().get(3).shouldHave(Condition.text(firstProductPrice));
        comparePage.getProductPriceCompare().get(4).shouldHave(Condition.text(secondProductPrice));
    }
    @Step("Cleck add btn")
    public void addProductClick() {
        comparePage.addProductClick();
    }

@Step("Choose first product in compare widget")
    public void chooseFirstProductInCompare() {
        comparePage.getAddToCompareWidgetFragment().productList().get(1).click();
    }
@Step("Get name of first notebook in compare widget")
    public String getThirdNoteBookName() {
      return comparePage.getAddToCompareWidgetFragment().getFirsProductName();
    }

@Step("Get price of first notebook in compare widget")
    public String getThirdNoteBookPrice() {
    return comparePage.getAddToCompareWidgetFragment().getFirsProductPrice();
    }
@Step("Click add button on compare Widget")
    public void clickAddbtn() {
        comparePage.getAddToCompareWidgetFragment().clickAdd();
    }
@Step("Final Verify products on compare page")
    public void verifyFinalyProductInComparePage(String firstProductName, String secondProductName, String thirdProductName, String firstProductPrice , String secondProductPrice, String thirdProductPrice) {
    comparePage.getProductNamesCompare().shouldHaveSize(6);
    comparePage.getProductNamesCompare().get(1).shouldHave(Condition.text(firstProductName));
    comparePage.getProductNamesCompare().get(2).shouldHave(Condition.text(secondProductName));
    comparePage.getProductNamesCompare().get(3).shouldHave(Condition.text(thirdProductName));
    comparePage.getProductPriceCompare().get(2).shouldHave(Condition.text(firstProductPrice));
    comparePage.getProductPriceCompare().get(5).shouldHave(Condition.text(secondProductPrice));
    comparePage.getProductPriceCompare().get(8).shouldHave(Condition.text(thirdProductPrice));
    }
}
