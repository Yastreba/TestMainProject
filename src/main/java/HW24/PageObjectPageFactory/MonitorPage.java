package HW24.PageObjectPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;


public class MonitorPage {

    WebDriver webDriver;
    WebDriverWait wait;

    public MonitorPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, 10);
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(css = "p[class*='product__code detail-code']")
    WebElement waitProductCode;
    @FindBy(xpath = "//span[text()='1']")
    List<WebElement> compareNumber;
    @FindBy(className = "compare-button")
    WebElement compareBtn;
    @FindBy(className = "product__title")
    WebElement monitorName;
    @FindBy(xpath = "//*[@class = 'product-prices__inner']//p[1]")
    WebElement monitorPrice;
    @FindBy(css = "i[class*='header']")
    WebElement finalCompareBtn;
    @FindBy(css = "a[class = comparison-modal__link]")
    WebElement comparisonModalLink;

    public void waitProductCode() {
        wait.until(visibilityOf(waitProductCode));
    }

    private List<WebElement> getCompareBtnNumbers() {
        return compareNumber;
    }

    private void clickCompareBtn() {
        compareBtn.click();
    }

    public String getMonitorName() {
        return monitorName.getText();
    }

    public String getMonitorPrice() {
        return monitorPrice.getText().replaceAll("[^0-9]", "");
    }

    public void backBtnClick() {
        webDriver.navigate().back();
    }

    public void finalCompareBtnClick() {
        finalCompareBtn.click();
    }

    public void comparisonModalLinkClick() {
        comparisonModalLink.click();
    }

    public void checkNumberOfComparison(int num) throws Exception {
        if (getCompareBtnNumbers().size() == num) {
            clickCompareBtn();
        } else {
            throw new Exception("Check numbers of compare");
        }

    }
}
