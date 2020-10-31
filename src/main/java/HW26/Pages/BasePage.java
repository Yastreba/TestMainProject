package HW26.Pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Selenide.*;

public class BasePage {

    SelenideElement popUpCloseButton = $(".el-dialog__close");

    public BasePage waitForPageToLoad() {
        new WebDriverWait(WebDriverRunner.getWebDriver(), 10).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        return this;
    }

    public BasePage closePopUp() {
        if (popUpCloseButton.isDisplayed()) {
            popUpCloseButton.click();
        }
        return this;
    }

}
