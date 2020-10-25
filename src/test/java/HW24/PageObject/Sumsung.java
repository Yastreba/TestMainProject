package HW24.PageObject;

import HW24.BaseMethods;
import HW24.PageOdject.ProductListPage;
import HW24.PageOdject.RozetkaMainPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Sumsung extends BaseMethods {

    String LogUrl = "https://rozetka.com.ua/";

    @BeforeMethod
    public void navigateToUrl() {
        driver.get(LogUrl);
    }


    @Test
    public void manufacturerFilterTest() throws Exception {
        RozetkaMainPage rozetkaMainPage = new RozetkaMainPage(driver);
        ProductListPage productListPage = new ProductListPage(driver);
        rozetkaMainPage.maxWindowSize();

        rozetkaMainPage.searchSumsung();
        productListPage.waitProductTableAppear();
        productListPage.selectMobilePhones();

        productListPage.waitProductTableAppear();
        bannerKiller();
        productListPage.selectPhoneFilterByBrand("Apple");
        productListPage.waitProductTableAppear();
        productListPage.selectPhoneFilterByBrand("Honor");

        productListPage.checkMultyplyMobileBrandFilter();
    }

    @Test
    public void priceFilterTest() throws Exception {
        RozetkaMainPage rozetkaMainPage = new RozetkaMainPage(driver);
        ProductListPage productListPage = new ProductListPage(driver);
        rozetkaMainPage.maxWindowSize();

        rozetkaMainPage.searchSumsung();
        productListPage.waitProductTableAppear();
        productListPage.selectMobilePhones();

        productListPage.waitProductTableAppear();
        bannerKiller();
        productListPage.setMaxPriceFilter(15000);
        productListPage.setMinPriceFilter(5000);
        productListPage.filterBtnClick();
        bannerKiller();

        productListPage.checkMobilePriceFilter();
    }

    @Test
    public void galaxyZFilterTest() throws Exception {
        RozetkaMainPage rozetkaMainPage = new RozetkaMainPage(driver);
        ProductListPage productListPage = new ProductListPage(driver);
        rozetkaMainPage.maxWindowSize();

        rozetkaMainPage.searchSumsung();
        productListPage.waitProductTableAppear();
        productListPage.selectMobilePhones();

        productListPage.waitProductTableAppear();
        bannerKiller();
        productListPage.selectPhoneFilterByBrand("Galaxy Z");
        productListPage.waitProductTableAppear();
        productListPage.checkMultyplyMobileBrandFilter();

        productListPage.checkGalaxyMobileBrandFilter();
    }
}






