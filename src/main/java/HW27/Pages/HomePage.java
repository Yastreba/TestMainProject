package HW27.Pages;

import HW27.Fragments.SearchFragment;

import static com.codeborne.selenide.Selenide.*;

public class HomePage extends BasePage {


    SearchFragment searchFragment = new SearchFragment();


    public HomePage hoverMenuLine(String menuText) {
        $$x("//a[@href='/smartfony/']/span[contains (text(), '" + menuText + "')]").get(1).hover();
        return this;
    }

    public HomePage clickLinkInMenu(String linkText) {
        $x("//a[@href='/smartfony/']//..//span[contains(text(), '" + linkText + "')]").click();
        return this;
    }

    public HomePage hoverMenuLineNoteBooks(String menuText) {
        $$x("//a[@title='" + menuText + "']").get(1).hover();
        return this;
    }

    public HomePage clickLinkInMenuNoteBooks(String linkText) {
        $("a[title='" + linkText + "']").click();
        return this;
    }


    public HomePage waitForPageToLoad() {
        super.waitForPageToLoad();
        return this;
    }

    public HomePage closePopUp() {
        super.closePopUp();
        return this;
    }

    public SearchFragment getSearchFragment() {
        return searchFragment;
    }


}
