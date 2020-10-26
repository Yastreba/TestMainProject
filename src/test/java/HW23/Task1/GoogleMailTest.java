package HW23.Task1;

import HW22.Task2.StartBeforeAfter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.testng.Assert.assertTrue;


public class GoogleMailTest extends StartBeforeAfter {

    String LogUrl = "https://mail.google.com";

    @BeforeMethod
    public void navigateToUrl() {
        driver.get(LogUrl);
    }

    @Test
    public void cookieTest() throws AWTException {
        String num = String.valueOf((int) ( Math.random() * 1000 ));
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("input[type=email]")).sendKeys("Hillel1989test"+ Keys.ENTER);
        wait.until(elementToBeClickable(By.cssSelector("input[type=password]")));
        driver.findElement(By.cssSelector("input[type=password]")).sendKeys("test654321"+ Keys.ENTER);
        wait.until(presenceOfElementLocated(By.cssSelector("a[aria-label^='Входящие']")));
        driver.findElement(By.className("z0")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.name("to")));
        driver.findElement(By.name("to")).click();
        driver.findElement(By.name("to")).sendKeys("Hillel1989test@gmail.com");
        driver.findElement(By.name("subjectbox")).sendKeys(num);
        driver.findElement(By.className("Am")).sendKeys("test");

        driver.findElement(By.cssSelector("[command='Files']")).click();
        StringSelection ss = new StringSelection("/home/yastreba/testFile.jpg");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        sleep(5000);
        driver.findElement(By.cssSelector("tbody div[aria-label*='Отправить']")).click();

        wait.until(presenceOfElementLocated(By.xpath("//span[text()='"+ num +"']")));
        driver.findElement(By.xpath("//*[@class = 'bog']//span[text()='"+ num + "']")).click();
        wait.until(presenceOfElementLocated(By.cssSelector("img[title='testFile.jpg']")));
        assertTrue(driver.findElement(By.cssSelector("img[title='testFile.jpg']")).isDisplayed());
        }
    }






