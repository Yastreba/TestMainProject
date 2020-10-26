package HW24.PageOdject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RozetkaMainPage {
    WebDriver webDriver;
    WebDriverWait wait;

    public RozetkaMainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, 10);
    }

    By actionMoveToElement = By.partialLinkText("Ноутбуки и компьютеры");
    By monitorSelect = By.linkText("Мониторы");
    By searchField = By.name("search");

    public void maxWindowSize() {
        webDriver.manage().window().maximize();
    }

    /**
     * Selecting a section of monitors for Task1
     */
    private void clickSelectedMonitor() {
        webDriver.findElement(monitorSelect).click();
    }

    public void selectMonitorsPage() throws InterruptedException {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(webDriver.findElement(actionMoveToElement)).build().perform();
        Thread.sleep(500);
        clickSelectedMonitor();
    }

    /**
     * Search for Sumsung for Task2
     */
    public void searchSumsung() {
        webDriver.findElement(searchField).sendKeys("samsung" + Keys.ENTER);
    }
}
