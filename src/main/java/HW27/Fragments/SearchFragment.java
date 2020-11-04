package HW27.Fragments;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class SearchFragment {

    SelenideElement searchInput = $("[class='global-search__field']");
    SelenideElement searchButtonSubmit = $("[class='global-search__submit']");

    public SearchFragment searchProduct(String productName) {
        searchInput.val(productName);
        searchButtonSubmit.click();
        return this;
    }


}


