package HW24.PageObjectPageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;

import static java.lang.Integer.parseInt;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class ProductListPage {

    WebDriver webDriver;
    WebDriverWait wait;

    public ProductListPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, 10);
        PageFactory.initElements(webDriver, this);
    }

    int liCount;
    String brandOrSeries;
    @FindBy(className = "ng-lazyloaded")
    WebElement waitProductTable;
    @FindBy(xpath = "//span[@class='goods-tile__price-value']")
    List<WebElement> listOfMonitors;
    @FindBy(partialLinkText = "Мобильные телефоны")
    WebElement mobilePhones;
    @FindBy(xpath = "//span[@class='goods-tile__title']")
    List<WebElement> mobileTitle;
    @FindBy(css = "input[formcontrolname='max']")
    WebElement maxPriceFilter;
    @FindBy(css = "input[formcontrolname='min']")
    WebElement minPriceFilter;
    @FindBy(css = "button[class*=slider-filter__button]")
    WebElement filterBtn;

    public void waitProductTableAppear() {
        wait.until(visibilityOf(waitProductTable));
    }

    /**
     * Check Monitors prices for Task1
     **/
    private List<WebElement> getAllProductPrices() {
        return listOfMonitors;
    }

    public void findFirstMonitor(int priceYouNeed) {
        List<WebElement> AllMonitorsPrices = getAllProductPrices();
        for (liCount = 1; liCount < AllMonitorsPrices.size() + 1; liCount++) {
            String price1 = webDriver.findElement(By.xpath("//ul[@class = 'catalog-grid']//li[" + liCount + "]//span[@class = 'goods-tile__price-value']"))
                    .getText()
                    .replaceAll("[^0-9]", "");
            int priceComparison = parseInt(price1);
            if (priceComparison < priceYouNeed) {
                webDriver.findElement(By.xpath("//ul[@class = 'catalog-grid']//li[" + liCount + "]//span[@class = 'goods-tile__title']")).click();
                break;
            }
        }
    }

    public void findSecondMonitor(int priceYouNeed) {
        List<WebElement> AllMonitorsPrices2 = getAllProductPrices();
        for (liCount = 1; liCount < AllMonitorsPrices2.size() + 1; liCount++) {
            String price2 = webDriver.findElement(By.xpath("//ul[@class = 'catalog-grid']//li[" + liCount + "]//span[@class = 'goods-tile__price-value']"))
                    .getText()
                    .replaceAll("[^0-9]", "");
            int priceComparation = parseInt(price2);
            if (priceComparation < priceYouNeed) {
                webDriver.findElement(By.xpath("//ul[@class = 'catalog-grid']//li[" + liCount + "]//span[@class = 'goods-tile__title']")).click();
                break;
            }
        }
    }

    /**
     * Select and check Mobile filters for task2
     */
    public void selectMobilePhones() {
        mobilePhones.click();
    }

    public void selectPhoneFilterByBrand(String brandOrSeries) {
        this.brandOrSeries = brandOrSeries;
        webDriver.findElement(By.cssSelector("label[for='" + brandOrSeries + "']")).click();
    }

    private List<WebElement> mobileTitlesList() {
        return mobileTitle;
    }

    public void checkMultyplyMobileBrandFilter() throws Exception {
        List<WebElement> names = mobileTitlesList();
        for (int i = 1; i < names.size(); i++) {
            if ((names.get(i).getText().contains("Apple")) || (names.get(i).getText().contains("Honor")) || (names.get(i).getText().contains("Samsung"))) {
                continue;
            } else {
                throw new Exception("There is no Samsung, Apple or Honor in the name of item: " + i);
            }
        }
    }

    public void setMaxPriceFilter(int maxPrice) {
        maxPriceFilter.clear();
        String maxPriceStr = Integer.toString(maxPrice);
        maxPriceFilter.sendKeys(maxPriceStr);
    }

    public void setMinPriceFilter(int minPrice) {
        minPriceFilter.clear();
        String minPriceStr = Integer.toString(minPrice);
        minPriceFilter.sendKeys(minPriceStr);
    }

    public void filterBtnClick() {
        filterBtn.click();
    }


    public void checkMobilePriceFilter() throws Exception {
        List<WebElement> prices = getAllProductPrices();
        for (int i = 1; i < prices.size(); i++) {
            String price = webDriver.findElement(By.xpath("//ul[@class = 'catalog-grid']//li[" + i + "]//span[@class = 'goods-tile__price-value']"))
                    .getText()
                    .replaceAll("[^0-9]", "");
            int priceComparison = Integer.parseInt(price);
            if ((priceComparison >= 5000) && (priceComparison <= 15000)) {
                continue;
            }else{
                throw new Exception("the amount of " + i + " element does not match the filter");
            }
        }
    }

    public void checkGalaxyMobileBrandFilter() throws Exception {
        List<WebElement> names = mobileTitlesList();
        for (int i = 1; i < names.size(); i++) {
            if (names.get(i).getText().contains("Galaxy Z")) {
                continue;
            } else {
                throw new Exception("There is no 'Galaxy Z' in the name of item: " + i);
            }
        }
    }
}
