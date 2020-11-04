package HW28;

import HW27.CitrusSteps.ComparePageStep;
import HW27.CitrusSteps.HomePageStep;
import HW27.CitrusSteps.ProductListPageStep;
import HW27.CitrusSteps.ProductPageStep;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.testng.ScreenShooter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

@Listeners({ ScreenShooter.class})
public class CitrusTest {

    HomePageStep homePageStep;
    ProductListPageStep productListPageStep;
    ProductPageStep productPageStep;
    ComparePageStep comprePageStep;

    String productName = "Apple iPhone 11 128Gb Black";
    String productName2 = "Apple iPhone 11";
    String samsungName = "Samsung";
    String nameZTE = "ZTE";


    @BeforeClass
    public void startUp() {
        ScreenShooter.captureSuccessfulTests = true;
        Configuration.baseUrl = "https://www.citrus.ua/";
        Configuration.startMaximized = true;
        open("");
        homePageStep = new HomePageStep();
        productListPageStep = new ProductListPageStep();
        productPageStep = new ProductPageStep();
        comprePageStep = new ComparePageStep();
    }

    @Test
    public void AddToBusketFromMenuTest() {
        homePageStep.clickLinkInMenu("Apple");
        productListPageStep.productListPage(productName);
        String productPrice = productPageStep.addProductToBasket();
        productPageStep.verifyBasketContent(productName, productPrice);
    }

    @Test
    public void addProductToBasketViaSearchResult() {
        homePageStep.findProductBySearchField(productName2);
        String productPrice = productListPageStep.addProductToBascet(productName);
        productPageStep.verifyBasketContent(productName, productPrice);
    }

    @Test
    public void addTwoProductsToBasketViaSearchResult() {
        homePageStep.findProductBySearchField(productName2);
        String firstProductPrice = productListPageStep.addFirstProductPrice();
        String firstProductName = productListPageStep.getFirsProductName();
        productListPageStep.addProductToBasket(firstProductName);
        String secondProductPrice = productListPageStep.addSecondProductPrice();
        String secondProductName = productListPageStep.getSecondProductName();
        productListPageStep.addProductToBasket(secondProductName);
        productPageStep.verifyMultyplyProductBasketContent(firstProductName, firstProductPrice, secondProductName, secondProductPrice);
    }

    @Test
    public void addProductToBasketFromCompression() {
        homePageStep.findProductBySearchField(productName2);
        String firstProductPrice = productListPageStep.addFirstProductPrice();
        String firstProductName = productListPageStep.getFirsProductName();
        productListPageStep.addToCompare(firstProductName);
        String secondProductPrice = productListPageStep.addSecondProductPrice();
        String secondProductName = productListPageStep.getSecondProductName();
        productListPageStep.addToCompare(secondProductName);
        productListPageStep.compareBtnClick();
        comprePageStep.addToBasket(firstProductName);
        comprePageStep.addToBasket(secondProductName);
        comprePageStep.clickBasketBtn();
        productPageStep.verifyMultyplyProductBasketContent(firstProductName, firstProductPrice, secondProductName, secondProductPrice);
    }

    @Test
    public void priceFilterTest() throws Exception {
        homePageStep.clickLinkInMenu("Samsung");
        productListPageStep.setMinPriceFilter("1000");
        productListPageStep.setMaxriceFilter("9000");
        productListPageStep.getAllNames();
        productListPageStep.getAllPrices();
        productListPageStep.verifyNames(samsungName);
        productListPageStep.verifyPrices();
    }

    @Test
    public void memoryFilterTest() throws Exception {
        homePageStep.clickLinkInMenu("Xiaomi");
        productListPageStep.setMemorySize("32");
        productListPageStep.setMemorySize("64");
        productListPageStep.verifyNames("Xiaomi");
        productListPageStep.verifyMemFilter();
    }

    @Test
    public void materialFilterTest() throws Exception {
        homePageStep.clickLinkInMenu(nameZTE);
        productListPageStep.setMaterialFilter("Пластик");
        productListPageStep.checkMaterialFilter();
    }

    @Test
    public void compareTest() {
        homePageStep.clickLinkInMenu("Acer");
        String firstProductPrice =  productListPageStep.getFirsNoteBookPrice();
        String firstProductName = productListPageStep.getFirstNoteBookName();
        String secondProductPrice = productListPageStep.getSecondNoteBookPrice();
        String secondProductName = productListPageStep.getsecondNoteBookName();
        productListPageStep.addProductToCompareNotebooks(firstProductName);
        productListPageStep.addProductToCompareNotebooks(secondProductName);
        productListPageStep.compareBtnClick();
        comprePageStep.verifyProductInComparePage(firstProductName, secondProductName, firstProductPrice, secondProductPrice);
        comprePageStep.addProductClick();
        comprePageStep.chooseFirstProductInCompare();
        String thirdProductName = comprePageStep.getThirdNoteBookName();
        String thirdProductPrice = comprePageStep.getThirdNoteBookPrice();
        comprePageStep.clickAddbtn();
        comprePageStep.verifyFinalyProductInComparePage(firstProductName, secondProductName, thirdProductName, firstProductPrice , secondProductPrice, thirdProductPrice);

    }

}
