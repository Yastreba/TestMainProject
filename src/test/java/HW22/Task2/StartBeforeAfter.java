package HW22.Task2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class StartBeforeAfter {

    WebDriver driver;
    WebDriverWait wait;
    String price;
    String model;
    String model2;
    String compareModel1;
    String compareModel2;


    @BeforeClass
    public void DriverSetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    public void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public Boolean isElementPresent(String path) {
        try {
            driver.findElement(By.cssSelector(path));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void banneKiller() {
        sleep(600);
        if (isElementPresent("[class='exponea-close-cross']")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='exponea-close-cross']")));
            driver.findElement(By.cssSelector("[class='exponea-close-cross']")).click();
        }
    }

        @AfterClass
        public void closeDriver() {
            driver.quit();
        }
    }
