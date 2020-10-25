package HW24.PageObjectPageFactory;


import HW24.BaseMethods;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Integer.parseInt;

public class Monitors extends BaseMethods {

    String LogUrl = "https://rozetka.com.ua/";

    @BeforeMethod
    public void navigateToUrl() {
        driver.get(LogUrl);
    }

    @Test
    public void positiveTest() throws Exception {

        RozetkaMainPage rozetkaMainPage = new RozetkaMainPage(driver);
        ProductListPage productListPage = new ProductListPage(driver);
        MonitorPage monitorPage = new MonitorPage(driver);
        ComparePage comparePage = new ComparePage(driver);

        rozetkaMainPage.maxWindowSize();

        rozetkaMainPage.selectMonitorsPage();
        productListPage.waitProductTableAppear();
        bannerKiller();

        productListPage.findFirstMonitor(3000);
        monitorPage.waitProductCode();
        monitorPage.checkNumberOfComparison(0);

        modelOfMonitor = monitorPage.getMonitorName();
        priceOfMonitor = parseInt(monitorPage.getMonitorPrice());
        monitorPage.backBtnClick();

        sleep(700);
        bannerKiller();
        productListPage.findSecondMonitor(priceOfMonitor);

        monitorPage.waitProductCode();
        monitorPage.checkNumberOfComparison(1);

        modelOfSecondMonitor = monitorPage.getMonitorName();
        priceOfSecondMonitor = parseInt(monitorPage.getMonitorPrice());

        monitorPage.finalCompareBtnClick();
        monitorPage.comparisonModalLinkClick();
        comparePage.waitCompareTable();

        compareModelOfMonitor = comparePage.getStringCompareModelOfMonitor();
        compareModelOfSecondMonitor = comparePage.getStringCompareModelOfSecondMonitor();
        comparePriceOfMonitor = comparePage.getIntPrice();
        comparePriceOfSecondMonitor = comparePage.getIntSecondPrice();

        Assert.assertTrue(comparePriceOfMonitor == priceOfMonitor);
        Assert.assertEquals(compareModelOfMonitor, modelOfMonitor);
        Assert.assertTrue(comparePriceOfSecondMonitor == priceOfSecondMonitor);
        Assert.assertEquals(compareModelOfSecondMonitor, modelOfSecondMonitor);

    }

}






