package HW26;

import HW26.Pages.ComparePage;
import HW26.Pages.HomePage;
import HW26.Pages.ProductListPage;
import HW26.Pages.ProductPage;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.*;

public class CitrusTest {

    HomePage homePage;
    ProductListPage productListPage;
    ProductPage productPage;
    ComparePage comprePage;
    String productName = "Apple iPhone 11 128Gb Black";
    String productName2 = "Apple iPhone 11";
    String samsungName = "Samsung";
    String xiaomiName = "Xiaomi";
    String nameZTE = "ZTE";



    @BeforeClass
    public void startUp() {
        Configuration.baseUrl = "https://www.citrus.ua/";
        Configuration.startMaximized=true;
        open("");
        homePage = new HomePage();
        productListPage = new ProductListPage();
        productPage = new ProductPage();
        comprePage = new ComparePage();
    }

    @Test
    public void AddToBusketFromMenuTest() {
        homePage.waitForPageToLoad()
                .closePopUp()
                .hoverMenuLine("Смартфоны")
                .clickLinkInMenu("Apple");
        productListPage.waitForPageToLoad()
                .closePopUp()
                .clickOnProductByName(productName);
        String productPrice = productPage.getProductPrice();
        productPage.clickBuyButton();

        productPage.getBasketFragment().getBasket().shouldBe(Condition.visible);
        productPage.getBasketFragment().getProductNamesBasket().shouldHaveSize(1);
        productPage.getBasketFragment().getProductNamesBasket().get(0).shouldHave(Condition.text(productName));
        productPage.getBasketFragment().getBuscetTotlaPrice().shouldHave(Condition.text(productPrice));
    }

    @Test
    public void addProductToBasketViaSearchResult() {
        homePage.waitForPageToLoad()
                .closePopUp()
                .getSearchFragment().searchProduct(productName2);
        String productPrice = productListPage.waitForPageToLoad()
                .closePopUp()
                .getProductPriceByName(productName);
        productListPage.addProductToBascet(productName);

        productPage.getBasketFragment().getBasket().shouldBe(Condition.visible);
        productPage.getBasketFragment().getProductNamesBasket().shouldHaveSize(1);
        productPage.getBasketFragment().getProductNamesBasket().get(0).shouldHave(Condition.text(productName));
        productPage.getBasketFragment().getBuscetTotlaPrice().shouldHave(Condition.text(productPrice));
    }

    @Test
    public void addTwoProductsToBasketViaSearchResult() {
        homePage.waitForPageToLoad()
                .closePopUp()
                .getSearchFragment().searchProduct(productName2);
        String firstProductPrice = productListPage.waitForPageToLoad()
                .closePopUp()
                .getFirsProductPrice();
        String firstProductName = productListPage.getFirsProductName();
        productListPage.addProductToBascet(firstProductName);
        String secondProductPrice = productListPage.getSecondProductPrice();
        String secondProductName = productListPage.getSecondProductName();
        productListPage.addProductToBascet(secondProductName);

        productPage.getBasketFragment().getBasket().shouldBe(Condition.visible);
        productPage.getBasketFragment().getProductNamesBasket().shouldHaveSize(2);
        productPage.getBasketFragment().getProductNamesBasket().get(0).shouldHave(Condition.text(firstProductName));
        productPage.getBasketFragment().getProductNamesBasket().get(1).shouldHave(Condition.text(secondProductName));
        productPage.getBasketFragment().getPricesBasket().get(0).shouldHave(Condition.text(firstProductPrice));
        productPage.getBasketFragment().getPricesBasket().get(1).shouldHave(Condition.text(secondProductPrice));
    }

    @Test
    public void addProductToBasketFromCompression() {
        homePage.waitForPageToLoad()
                .closePopUp()
                .getSearchFragment().searchProduct(productName2);
        String firstProductPrice = productListPage.waitForPageToLoad()
                .closePopUp()
                .getFirsProductPrice();
        String firstProductName = productListPage.getFirsProductName();
        productListPage.addProductToCompression(firstProductName);
        String secondProductPrice = productListPage.getSecondProductPrice();
        String secondProductName = productListPage.getSecondProductName();
        productListPage.addProductToCompression(secondProductName);
        productListPage.compressionBtnClick().waitForPageToLoad().closePopUp();

        comprePage.addToBasketBtnClick(firstProductName);
        comprePage.getBasketFragment().closeBasketBtnClick();
        comprePage.addToBasketBtnClick(secondProductName);
        comprePage.getBasketFragment().closeBasketBtnClick();

        comprePage.getBasketFragment().headerBasketBtnClick();

        productPage.getBasketFragment().getBasket().shouldBe(Condition.visible);
        productPage.getBasketFragment().getProductNamesBasket().shouldHaveSize(2);
        productPage.getBasketFragment().getProductNamesBasket().get(0).shouldHave(Condition.text(firstProductName));
        productPage.getBasketFragment().getProductNamesBasket().get(1).shouldHave(Condition.text(secondProductName));
        productPage.getBasketFragment().getPricesBasket().get(0).shouldHave(Condition.text(firstProductPrice));
        productPage.getBasketFragment().getPricesBasket().get(1).shouldHave(Condition.text(secondProductPrice));

    }

    @Test
    public void priceFilterTest() throws Exception {
        homePage.waitForPageToLoad()
                .closePopUp()
                .hoverMenuLine("Смартфоны")
                .clickLinkInMenu(samsungName);
        productListPage.waitForPageToLoad()
                .closePopUp();
        productListPage.getFilterFragment().setMinPriceFilter("1000");
        productListPage.getFilterFragment().setMaxPriceFilter("9000");
        productListPage.getAllNames();
        productListPage.getAllPrices();

        productListPage.checkAllNames(xiaomiName);//?????????????????????????????????????????????????????????
        productListPage.checkAllPrices();


    }

    @Test
    public void memmoryFilterTest() {
        homePage.waitForPageToLoad()
                .closePopUp()
                .hoverMenuLine("Смартфоны")
                .clickLinkInMenu(xiaomiName);
        productListPage.waitForPageToLoad()
                .closePopUp();
        productListPage.getFilterFragment().setMemorySize("32");
        productListPage.getFilterFragment().setMemorySize("64");
        productListPage.getAllNames();

        productListPage.getAllNames().contains(texts(xiaomiName));//??????????????????????????????


        productListPage.getAllNames().filter(Condition.text("/32Gb"));
        productListPage.getAllNames().shouldHave(texts("/64Gb"));//????????????????????????????????????

    }
    @Test
    public void materialFilterTest() throws Exception {
        homePage.waitForPageToLoad()
                .closePopUp()
                .hoverMenuLine("Смартфоны")
                .clickLinkInMenu(nameZTE);
        productListPage.waitForPageToLoad()
                .closePopUp();
        productListPage.getFilterFragment().setMaterial("Пластик");
        productListPage.checkMaterialFilter();

    }

@Test
public void comparisonTest() {
    homePage.waitForPageToLoad()
            .closePopUp()
            .hoverMenuLineNoteBooks("Ноутбуки, планшеты, МФУ")
            .clickLinkInMenuNoteBooks("Acer");
    String firstProductPrice = productListPage.waitForPageToLoad()
            .closePopUp()
            .getFirsNoteBookPrice();
    String firstProductName = productListPage.getFirsProductName();
    String secondProductPrice = productListPage.getSecondNoteBookPrice();
    String secondProductName = productListPage.getSecondProductName();
    productListPage.addProductToCompressionNotebooks(firstProductName);
    productListPage.addProductToCompressionNotebooks(secondProductName);
    productListPage.compressionBtnClick()
            .waitForPageToLoad()
            .closePopUp();

    comprePage.getProductNamesCompare().shouldHaveSize(4);
    comprePage.getProductNamesCompare().get(1).shouldHave(Condition.text(firstProductName));
    comprePage.getProductNamesCompare().get(2).shouldHave(Condition.text(secondProductName));
    comprePage.getProductPriceCompare().get(3).shouldHave(Condition.text(firstProductPrice));
    comprePage.getProductPriceCompare().get(4).shouldHave(Condition.text(secondProductPrice));
    comprePage.addProductClick();

    comprePage.getAddToCompareWidgetFragment().productList().get(1).click();
    String thirdProductName = comprePage.getAddToCompareWidgetFragment().getFirsProductName();
    String thirdProductPrice = comprePage.getAddToCompareWidgetFragment().getFirsProductPrice();
    comprePage.getAddToCompareWidgetFragment().clickAdd();

    comprePage.getProductNamesCompare().shouldHaveSize(6);
    comprePage.getProductNamesCompare().get(1).shouldHave(Condition.text(firstProductName));
    comprePage.getProductNamesCompare().get(2).shouldHave(Condition.text(secondProductName));
    comprePage.getProductNamesCompare().get(3).shouldHave(Condition.text(thirdProductName));
    comprePage.getProductPriceCompare().get(2).shouldHave(Condition.text(firstProductPrice));
    comprePage.getProductPriceCompare().get(5).shouldHave(Condition.text(secondProductPrice));
    comprePage.getProductPriceCompare().get(8).shouldHave(Condition.text(thirdProductPrice));




    }

}
