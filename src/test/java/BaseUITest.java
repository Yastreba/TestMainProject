import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class BaseUITest {

    String login = "1303";
    String password = "Guru99";
    WebElement emptyPass;
    WebElement UserID;
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void DriverSetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @AfterClass
    public void closeDriver() {
        driver.quit();
    }
}
