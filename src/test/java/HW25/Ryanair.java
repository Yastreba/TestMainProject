package HW25;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class Ryanair {

        @Test
        public void positiveTest(){
            Configuration.timeout = 10000;

            open("https://www.ryanair.com/us/en");

            $x("//button[contains(text(), 'Yes, I agree')]").click();
            $(By.id("input-button__departure")).clear();
            $(By.id("input-button__departure")).val("Vienna");
            $x("//span[contains(text(), ' Vienna ')]").click();
            $(By.id("input-button__destination")).val("Kyiv");
            $$x("//span[contains(text(), ' Kyiv ')]").first().click();

            $("div[data-id='2020-11-21']").click();
            $("div[data-id='2020-11-24']").click();
            $$("[class='counter__button-wrapper--enabled']").first().click();

            $("[class*='flight-search-widget__start-search ry-b']").click();

            $$x("//div[@class='header']").shouldHaveSize(2);


            $$("[class*='date-item__date b2']").get(0).shouldHave(Condition.text(" 21Nov "));
            $$("[class*='date-item__date b2']").get(1).shouldHave(Condition.text(" 24Nov "));

        }

}
