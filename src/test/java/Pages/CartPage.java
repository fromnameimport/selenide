package Pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CartPage {

    public String getCartItemName() {
        return $("td.product-name > a").text();
    }
}
