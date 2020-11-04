package HW27.CitrusSteps;

import HW27.Pages.BasePage;
import HW27.Pages.ComparePage;
import HW27.Pages.ProductListPage;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

public class ProductListPageStep {


    ProductListPage productListPage = new ProductListPage();
    ComparePage comparePage = new ComparePage();

    @Step("Click On Product")
    public void productListPage(String productName) {
        productListPage.waitForPageToLoad()
                .closePopUp()
                .clickOnProductByName(productName);
    }

    @Step("Store price and add product to basket")
    public String addProductToBascet(String productName) {
        productListPage.waitForPageToLoad()
                .closePopUp()
                .addProductToBascet(productName);
        return productListPage.getProductPriceByName(productName);
    }

    @Step("Store price of first product")
    public String addFirstProductPrice() {
        productListPage.waitForPageToLoad()
                .closePopUp();
        return productListPage.getFirsProductPrice();
    }

    @Step("Store name of first product")
    public String getFirsProductName() {
        return productListPage.getFirsProductName();
    }

    @Step("Add product to basket")
    public void addProductToBasket(String firstProductName) {
        productListPage.addProductToBascet(firstProductName);
    }

    @Step("Store price of second product")
    public String addSecondProductPrice() {
        return productListPage.getSecondProductPrice();
    }

    @Step("Store name of second product")
    public String getSecondProductName() {
        return productListPage.getSecondProductName();
    }

    @Step("Add to Compare")
    public void addToCompare(String productname) {
        productListPage.addProductToCompression(productname);
    }

    @Step("Click on compare btn")
    public void compareBtnClick() {
        productListPage.compressionBtnClick().waitForPageToLoad().closePopUp();
    }

    @Step("Set min Price filter")
    public void setMinPriceFilter(String price) {
        productListPage.getFilterFragment().setMinPriceFilter(price);
    }

    @Step("Set max Price filter")
    public void setMaxriceFilter(String price) {
        productListPage.getFilterFragment().setMaxPriceFilter(price);
    }

    @Step("get all names")
    public void getAllNames() {
        productListPage.getAllNames();
    }

    @Step("get all Prices")
    public void getAllPrices() {
        productListPage.getAllPrices();
    }

    @Step("Verify Names")
    public void verifyNames(String productName) throws Exception {
        productListPage.checkAllNames(productName);
    }

    @Step("Verify Price Filter")
    public void verifyPrices() throws Exception {
        productListPage.checkAllPrices();
    }

    @Step("Set mammary size")
    public void setMemorySize(String memSize) {
        productListPage.getFilterFragment().setMemorySize(memSize);
    }

@Step("Verify MemFilter")
    public void verifyMemFilter() throws Exception {
    productListPage.chectMemFilter();
    }
@Step("set Material Filter")
    public void setMaterialFilter(String material) {
    productListPage.getFilterFragment().setMaterial(material);
    }
@Step("Verify material Filter")
    public void checkMaterialFilter() throws Exception {
        productListPage.checkMaterialFilter();
    }
@Step("Get 1st NoteBook Price")
    public String getFirsNoteBookPrice() {
        productListPage.waitForPageToLoad().closePopUp();
        return  productListPage.getFirsNoteBookPrice();
    }
@Step("Get First NoteBookName")
    public String getFirstNoteBookName() {
    return productListPage.getFirsProductName();
    }
    @Step("Get second NoteBookName")
    public String getSecondNoteBookPrice() {
   return productListPage.getSecondProductName();
    }
@Step("Get second noteBook price")
    public String getsecondNoteBookName() {
    return productListPage.getSecondNoteBookPrice();
    }
@Step("Add notebooks to compare")
    public void addProductToCompareNotebooks(String ProductName) {
    productListPage.addProductToCompressionNotebooks(ProductName);
    }

}
