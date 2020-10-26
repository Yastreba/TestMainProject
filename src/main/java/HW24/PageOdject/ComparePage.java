package HW24.PageOdject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Integer.parseInt;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class ComparePage {

    WebDriver webDriver;
    WebDriverWait wait;

    public ComparePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, 10);
    }

    By compareModelOfMonitor = By.xpath("//li[1]//div[@class ='product__body']//a");
    By comparePriceOfMonitor = By.xpath("//li[1]//Div[@class = 'product__price product__price--red']");
    By compareModelOfSecondMonitor = By.xpath("//li[2]//div[@class ='product__body']//a");
    By comparePriceOfSecondMonitor = By.xpath("//li[2]//Div[@class = 'product__price product__price--red']");

    public void waitCompareTable() {
        wait.until(presenceOfElementLocated(compareModelOfSecondMonitor));
    }

    public String getStringCompareModelOfMonitor() {
        return webDriver.findElement(compareModelOfMonitor).getText();
    }

    public String getStringCompareModelOfSecondMonitor() {
        return webDriver.findElement(compareModelOfSecondMonitor).getText();
    }

    public String getStringComparePriceOfMonitor() {
        return webDriver.findElement(comparePriceOfMonitor).getText();
    }

    public String getStringComparePriceOfSecondMonitor() {
        return webDriver.findElement(comparePriceOfSecondMonitor).getText();
    }

    public int getIntPrice() {
        String str1 = getStringComparePriceOfMonitor();
        String result1[] = str1.split("₴");
        return parseInt(result1[1].replaceAll("[^0-9]", ""));
    }

    public int getIntSecondPrice() {
        String str2 = getStringComparePriceOfSecondMonitor();
        String result2[] = str2.split("₴");
        return parseInt(result2[1].replaceAll("[^0-9]", ""));
    }


}

