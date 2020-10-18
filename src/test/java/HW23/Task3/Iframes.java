package HW23.Task3;

import HW22.Task2.StartBeforeAfter;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.testng.Assert.assertTrue;


public class Iframes extends StartBeforeAfter {

    String LogUrl = "http://demo.guru99.com/Agile_Project/Agi_V1/index.php";

    @BeforeMethod
    public void navigateToUrl() {
        driver.get(LogUrl);
    }

    @Test
    public void cookieTest() {
        //driver.manage().window().maximize();
        wait.until(presenceOfElementLocated(By.cssSelector("[id*=primis_playerSekindoSPlayer]")));
        WebElement iframe = driver.findElement(By.cssSelector("[id*=primis_playerSekindoSPlayer]"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.id("playBtn")).click();



        }
    }






