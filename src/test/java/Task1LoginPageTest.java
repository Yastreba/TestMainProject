

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.testng.Assert.assertEquals;

public class Task1LoginPageTest extends BaseUITest {

    String LogUrl = "http://demo.guru99.com/Agile_Project/Agi_V1/index.php";

    @BeforeMethod
    public void navigateToUrl() {
        driver.get(LogUrl);
    }

    @Test
    public void positiveTest() {
        driver.findElement(By.name("uid")).sendKeys(login);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();

        WebElement logoutButton = wait.until(presenceOfElementLocated(By.linkText("Log out")));
        logoutButton.click();

        assertEquals(driver.switchTo().alert().getText(), "You Have Succesfully Logged Out!!");
        driver.switchTo().alert().accept();
        assertEquals(driver.getCurrentUrl(), LogUrl);

    }

    @Test
    public void negativePasswordTest() {
        driver.findElement(By.name("uid")).sendKeys(login);
        driver.findElement(By.name("password")).sendKeys("test");
        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();

        assertEquals(driver.switchTo().alert().getText(), "User or Password is not valid");
        driver.switchTo().alert().accept();
        assertEquals(driver.getCurrentUrl(), LogUrl);
    }

    @Test
    public void negativeLoginTest() {
        driver.get(LogUrl);
        driver.findElement(By.name("uid")).sendKeys("test");
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();

        assertEquals(driver.switchTo().alert().getText(), "User or Password is not valid");
        driver.switchTo().alert().accept();
        assertEquals(driver.getCurrentUrl(), LogUrl);
    }

    @Test
    public void negativeEmptyLoginTest() {
        driver.get(LogUrl);
        driver.findElement(By.name("uid")).sendKeys("");
        driver.findElement(By.name("password")).sendKeys(password);

        UserID = wait.until(presenceOfElementLocated(By.id("message23")));
        assertEquals(UserID.getText(), "User-ID must not be blank");
    }

    @Test
    public void negativeEmptyPassTest() {
        driver.get(LogUrl);
        driver.findElement(By.name("uid")).sendKeys(login);
        driver.findElement(By.name("password")).sendKeys("");
        driver.findElement(By.className("barone")).click();

        emptyPass = wait.until(presenceOfElementLocated(By.id("message18")));
        assertEquals(emptyPass.getText(), "Password must not be blank");
    }

    @Test
    public void negativeEmptyPassAndLoginTest() {
        driver.get(LogUrl);
        driver.findElement(By.name("uid")).sendKeys("");
        driver.findElement(By.name("password")).sendKeys("");
        driver.findElement(By.className("barone")).click();

        UserID = wait.until(presenceOfElementLocated(By.id("message23")));
        assertEquals(UserID.getText(), "User-ID must not be blank");
        emptyPass = wait.until(presenceOfElementLocated(By.id("message18")));
        assertEquals(emptyPass.getText(), "Password must not be blank");
    }

    @Test
    public void negativeClickLoginBtnTest() {
        driver.get(LogUrl);
        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();

        assertEquals(driver.switchTo().alert().getText(), "User or Password is not valid");
        driver.switchTo().alert().accept();
        assertEquals(driver.getCurrentUrl(), LogUrl);
    }
}


