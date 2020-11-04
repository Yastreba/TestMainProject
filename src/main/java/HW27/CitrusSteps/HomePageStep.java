package HW27.CitrusSteps;

import HW27.Pages.HomePage;
import io.qameta.allure.Step;

public class HomePageStep {

    HomePage homePage = new HomePage();

    @Step("click on 'Apple' Link In Menu")
    public void clickLinkInMenu(String text) {
        homePage.waitForPageToLoad()
                .closePopUp()
                .hoverMenuLine("Смартфоны")
                .clickLinkInMenu(text);
    }

    @Step("Search Product")
    public void findProductBySearchField(String text) {
        homePage.waitForPageToLoad()
                .closePopUp()
                .getSearchFragment().searchProduct(text);
    }
}
