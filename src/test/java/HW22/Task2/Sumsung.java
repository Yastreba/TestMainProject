package HW22.Task2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;


public class Sumsung extends StartBeforeAfter {


    String LogUrl = "https://rozetka.com.ua/";

    @BeforeMethod
    public void navigateToUrl() {
        driver.get(LogUrl);
    }

    @Test
    public void manufacturerFilterTest() {
        driver.manage().window().maximize();

        driver.findElement(By.name("search")).sendKeys("samsung" + Keys.ENTER);
        wait.until(presenceOfElementLocated(By.className("ng-lazyloaded")));
        driver.findElement(By.partialLinkText("Мобильные телефоны")).click();

        wait.until(presenceOfElementLocated(By.className("ng-lazyloaded")));
        banneKiller();
        driver.findElement(By.cssSelector("label[for=Apple]")).click();
        wait.until(presenceOfElementLocated(By.className("ng-lazyloaded")));
        driver.findElement(By.cssSelector("label[for=Honor]")).click();
        List<WebElement> names = driver.findElements(By.xpath("//span[@class='goods-tile__title']"));
        for (int i = 1; i < names.size(); i++) {
            if ((!names.contains("apple")) || (!names.contains("honor")) || (!names.contains("samsung"))) {
            } else {
                Assert.assertTrue(false, "There is no Samsung, Apple or Honor in the name of item: " + i);
                break;
            }
        }
    }

    @Test
    public void priceFilterTest() {
        driver.manage().window().maximize();

        driver.findElement(By.name("search")).sendKeys("samsung" + Keys.ENTER);
        wait.until(presenceOfElementLocated(By.className("ng-lazyloaded")));
        driver.findElement(By.partialLinkText("Мобильные телефоны")).click();

        wait.until(presenceOfElementLocated(By.className("ng-lazyloaded")));
        banneKiller();
        driver.findElement(By.cssSelector("input[formcontrolname='max']")).clear();
        driver.findElement(By.cssSelector("input[formcontrolname='max']")).sendKeys("15000");
        driver.findElement(By.cssSelector("input[formcontrolname='min']")).clear();
        driver.findElement(By.cssSelector("input[formcontrolname='min']")).sendKeys("5000");
        driver.findElement(By.cssSelector("button[class*=slider-filter__button]")).click();
        banneKiller();
        List<WebElement> prices = driver.findElements(By.xpath("//span[@class='goods-tile__price-value']"));
        for (int i = 1; i < prices.size(); i++) {
            String price = driver.findElement(By.xpath("//ul[@class = 'catalog-grid']//li[" + i + "]//span[@class = 'goods-tile__price-value']")).getText().replaceAll("[^0-9]", "");
            int priceComparison = Integer.parseInt(price);
            if (!(priceComparison < 5000) || !(priceComparison > 15000)) {
            } else {
                Assert.assertTrue(false, "the amount of " + i + " element does not match the filter");
                break;
            }
        }
    }

    @Test
    public void galaxyZFilterTest() {
        driver.manage().window().maximize();

        driver.findElement(By.name("search")).sendKeys("samsung" + Keys.ENTER);
        wait.until(presenceOfElementLocated(By.className("ng-lazyloaded")));
        driver.findElement(By.partialLinkText("Мобильные телефоны")).click();

        wait.until(presenceOfElementLocated(By.className("ng-lazyloaded")));
        banneKiller();
        driver.findElement(By.cssSelector("label[for='Galaxy Z']")).click();
        List<WebElement> names = driver.findElements(By.xpath("//span[@class='goods-tile__title']"));
        for (int i = 1; i < names.size(); i++) {
            if (!names.contains("Glaxy Z")) {
            } else {
                Assert.assertTrue(false, "There is no Samsung, Apple or Honor in the name of item: " + i);
                break;
            }
        }
    }
}






