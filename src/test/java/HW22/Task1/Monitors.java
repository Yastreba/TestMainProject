package HW22.Task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static java.lang.Integer.parseInt;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;


public class Monitors extends StartBeforeAfter {

    String LogUrl = "https://rozetka.com.ua/";

    @BeforeMethod
    public void navigateToUrl() {
        driver.get(LogUrl);
    }

    @Test
    public void positiveTest() {
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.partialLinkText("Ноутбуки и компьютеры"))).build().perform();
        sleep(500);
        driver.findElement(By.linkText("Мониторы")).click();

        wait.until(presenceOfElementLocated(By.className("ng-lazyloaded")));
        banneKiller();
        List<WebElement> prices = driver.findElements(By.xpath("//span[@class='goods-tile__price-value']"));
        int liCount;
        for (liCount = 1; liCount < prices.size() + 1; liCount++) {
            String price = driver.findElement(By.xpath("//ul[@class = 'catalog-grid']//li[" + liCount + "]//span[@class = 'goods-tile__price-value']")).getText().replaceAll("[^0-9]", "");
            int priceComparison = parseInt(price);
            if (priceComparison < 3000) {
                driver.findElement(By.xpath("//ul[@class = 'catalog-grid']//li[" + liCount + "]//span[@class = 'goods-tile__title']")).click();
                break;
            }
        }

        wait.until(presenceOfElementLocated(By.cssSelector("p[class*='product__code detail-code']")));
        if (driver.findElements(By.xpath("//span[text()='1']")).size() == 0){
        sleep(500);
            driver.findElement(By.className("compare-button")).click();
        } else {
            Assert.assertTrue(false);
            return;
        }
        model = driver.findElement(By.className("product__title")).getText();
        modelPrice1 = parseInt(driver.findElement(By.xpath("//*[@class = 'product-prices__inner']//p[1]")).getText().replaceAll("[^0-9]", ""));
        driver.navigate().back();

        sleep(700);
        banneKiller();
        List<WebElement> prices2 = driver.findElements(By.xpath("//span[@class='goods-tile__price-value']"));
        for (liCount = 1; liCount < prices2.size() + 1; liCount++) {
            price = driver.findElement(By.xpath("//ul[@class = 'catalog-grid']//li[" + liCount + "]//span[@class = 'goods-tile__price-value']")).getText().replaceAll("[^0-9]", "");
            int priceComparation = parseInt(price);
            if (priceComparation < modelPrice1) {
                driver.findElement(By.xpath("//ul[@class = 'catalog-grid']//li[" + liCount + "]//span[@class = 'goods-tile__title']")).click();
                break;
            }
        }

        wait.until(presenceOfElementLocated(By.cssSelector("p[class*='product__code detail-code']")));
        if (driver.findElements(By.xpath("//span[text()='1']")).size() == 1){
        driver.findElement(By.className("compare-button")).click();}
        else {
            Assert.assertTrue(false);
            return;
        }
        model2 = driver.findElement(By.className("product__title")).getText();
        modelPrice2 = parseInt(driver.findElement(By.xpath("//*[@class = 'product-prices__inner']//p[1]")).getText().replaceAll("[^0-9]", ""));

        wait.until(presenceOfElementLocated(By.id("icon-compare")));
        driver.findElement(By.cssSelector("i[class*='header']")).click();
        driver.findElement(By.cssSelector("a[class = comparison-modal__link]")).click();
        wait.until(presenceOfElementLocated(By.xpath("//li[2]//div[@class ='product__body']//a")));
        compareModel1 = driver.findElement(By.xpath("//li[1]//div[@class ='product__body']//a")).getText();
        compareModel2 = driver.findElement(By.xpath("//li[2]//div[@class ='product__body']//a")).getText();
        String p1 = driver.findElement(By.xpath("//li[1]//Div[@class = 'product__price product__price--red']")).getText();
        String m1 [] = p1.split("₴");
        comparePrice1 = parseInt(m1[1].replaceAll("[^0-9]", ""));
        String p2 = driver.findElement(By.xpath("//li[2]//Div[@class = 'product__price product__price--red']")).getText();
        String m2 [] = p2.split("₴");
        comparePrice2 = parseInt(m2[1].replaceAll("[^0-9]", ""));
        compare();

    }
}






