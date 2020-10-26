package HW24.PageOdject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;


public class MonitorPage {

    WebDriver webDriver;
    WebDriverWait wait;

    public MonitorPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, 10);
    }

    By waitProductCode = By.cssSelector("p[class*='product__code detail-code']");
    By compareNumber = By.xpath("//span[text()='1']");
    By compareBtn = By.className("compare-button");
    By monitorName = By.className("product__title");
    By monitorPrice = By.xpath("//*[@class = 'product-prices__inner']//p[1]");
    By finalCompareBtn = By.cssSelector("i[class*='header']");
    By comparisonModalLink = By.cssSelector("a[class = comparison-modal__link]");

    public void waitProductCode() {
        wait.until(presenceOfElementLocated(waitProductCode));
    }

    public List<WebElement> getCompareBtnNumbers() {
        return webDriver.findElements(compareNumber);
    }

    public void clickCompareBtn() {
        webDriver.findElement(compareBtn).click();
    }

    public String getMonitorName() {
        return webDriver.findElement(monitorName).getText();
    }

    public String getMonitorPrice() {
        return webDriver.findElement(monitorPrice).getText().replaceAll("[^0-9]", "");
    }

    public void backBtnClick() {
        webDriver.navigate().back();
    }

    public void finalCompareBtnClick() {
        webDriver.findElement(finalCompareBtn).click();
    }

    public void comparisonModalLinkClick() {
        webDriver.findElement(comparisonModalLink).click();
    }

    public void checkNumberOfComparison(int num) throws Exception {
        if (getCompareBtnNumbers().size() == num) {
            clickCompareBtn();
        } else {
            throw new Exception("Check numbers of compare");
        }
    }
}
