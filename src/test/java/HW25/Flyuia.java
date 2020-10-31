package HW25;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$;

public class Flyuia {

    @Test
    public void ticketeTestFlyuia(){
        Configuration.timeout = 10000;

        open("https://www.flyuia.com/ua/en/home");

        if ($("[class='modal-header']").isDisplayed()) {
            $$x("//div[@class='modal-header']/span[@class='close']").get(1).click();
        }
        $("[placeholder='Departure']").val("Vienna").pressEnter();
        $("[placeholder='Arrival']").val("Kyiv").pressEnter();

        $x("//div[@id='start-screen']//span[@class='obe-sw-icon-calendar-departure']").click();
        $("i[class='obe-sw-icon-navigate_next']").click();
        $x("//button[contains (text(), '19')]").click();
        $x("//div[@id='start-screen']//span[@class='obe-sw-icon-calendar-arrivals']").click();
        $x("//button[contains (text(), '21')]").click();
        $("span[class='obe-sw-icon-passenger']").click();
        $$("button[class='set-val-btn fx-row__center__center fx-flex-15']").get(1).click();
        $("[id='SEARCH_WIDGET_FORM_BUTTONS_SEARCH_FLIGHTS']").click();

        switchTo().window(1);

        $("[class='btn-primary']").click();
        $("i[class='icon-close']").click();
        if ($("[name='pwAskLater']").isDisplayed()){
            $("[name='pwAskLater']").click();
        }

        $$x("//div[@class='product__title']").shouldHaveSize(2);
        $$("[class*='date-title']").get(0).shouldHave(Condition.text(" Thu, 19 Nov "));
        $$("[class*='date-title']").get(1).shouldHave(Condition.text(" Thu, 26 Nov "));

    }

}
