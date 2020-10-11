import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task2Googletest extends BaseUITest {

    String LogUrl = "http://google.com";

    @BeforeMethod
    public void navigateToUrl() {
        driver.get(LogUrl);
    }

    @Test
    public void googleTest() {
        driver.findElement(By.name("q")).sendKeys("iphone kyiv buy" + Keys.ENTER);
        for (int i = 1; i < 6; i++) {
            if (driver.findElements(By.xpath("//cite[text()='stylus.ua']")).size() != 0) {
                System.out.println("STYLUS.UA found on " + i + " page");
                break;
            } else if (i != 5) {
                driver.findElement(By.id("pnnext")).click();
            } else {
                System.out.println("STYLUS.UA not found on first 5 pages");
            }
        }
    }
}