package HW24.PageObjectPageFactory;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RozetkaMainPage {
    WebDriver webDriver;
    WebDriverWait wait;

    public RozetkaMainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, 10);
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(partialLinkText = "Ноутбуки и компьютеры")
    WebElement actionMoveToElement;
    @FindBy(linkText = "Мониторы")
    WebElement monitorSelect;
    @FindBy(name = "search")
    WebElement searchField;

    public void maxWindowSize() {
        webDriver.manage().window().maximize();
    }

    /**
     * Selecting a section of monitors for Task1
     */
    private void clickSelectedMonitor() {
        monitorSelect.click();
    }

    public void selectMonitorsPage() throws InterruptedException {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(actionMoveToElement).build().perform();
        Thread.sleep(500);
        clickSelectedMonitor();
    }

    /**
     * Search for Sumsung for Task2
     */
    public void searchSumsung() {
        searchField.sendKeys("samsung" + Keys.ENTER);
    }
}
