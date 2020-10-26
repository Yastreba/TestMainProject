package HW24.PageObjectPageFactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Integer.parseInt;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class ComparePage {

    WebDriver webDriver;
    WebDriverWait wait;

    public ComparePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, 10);
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//li[1]//div[@class ='product__body']//a")
    WebElement compareModelOfMonitor;
    @FindBy(xpath = "//li[1]//Div[@class = 'product__price product__price--red']")
    WebElement comparePriceOfMonitor;
    @FindBy(xpath = "//li[2]//div[@class ='product__body']//a")
    WebElement compareModelOfSecondMonitor;
    @FindBy(xpath = "//li[2]//Div[@class = 'product__price product__price--red']")
    WebElement comparePriceOfSecondMonitor;

    public void waitCompareTable() {
        wait.until(visibilityOf(compareModelOfSecondMonitor));
    }

    public String getStringCompareModelOfMonitor() {
        return compareModelOfMonitor.getText();
    }

    public String getStringCompareModelOfSecondMonitor() {
        return compareModelOfSecondMonitor.getText();
    }

    public String getStringComparePriceOfMonitor() {
        return comparePriceOfMonitor.getText();
    }

    public String getStringComparePriceOfSecondMonitor() {
        return comparePriceOfSecondMonitor.getText();
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

