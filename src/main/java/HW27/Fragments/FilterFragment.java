package HW27.Fragments;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

public class FilterFragment {

    ElementsCollection priceFilters = $$("[class = 'el-input__inner']");

    public FilterFragment setMinPriceFilter(String minPrice) {
        priceFilters.get(0).val(minPrice);
        return this;
    }

    public FilterFragment setMaxPriceFilter(String maxPrices) {
        priceFilters.get(1).val(maxPrices);
        return this;
    }

    public FilterFragment setMemorySize(String size) {
        $x("//a[contains(text(), '" + size + " Гб')]").click();
        return this;
    }

    public FilterFragment setMaterial(String material) {
        $x("//a[contains(text(),'" + material + "')]").click();
        return this;
    }
}
