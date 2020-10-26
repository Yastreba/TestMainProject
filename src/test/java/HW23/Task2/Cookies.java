package HW23.Task2;

import HW22.Task2.StartBeforeAfter;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.testng.Assert.assertTrue;


public class Cookies extends StartBeforeAfter {

    String LogUrl = "http://demo.guru99.com/Agile_Project/Agi_V1/index.php";

    @BeforeMethod
    public void navigateToUrl() {
        driver.get(LogUrl);
    }

    @Test
    public void cookieTest() {
        driver.manage().window().maximize();
        driver.findElement(By.name("uid")).sendKeys("1303");
        driver.findElement(By.name("password")).sendKeys("Guru99");
        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
        wait.until(presenceOfElementLocated(By.linkText("Log out")));

        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println(cookies);
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
        assertTrue(driver.findElement(By.linkText("Log out")).isDisplayed());
        }
    }






