package Pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;

public class CartPage {

    public String getCartItemName() {
        return $("td.product-name > a").text();
    }
    public CartPage assertPageIsOpened() {
        Assert.assertEquals(
                $(By.className("tg-page-header__title")).text(),
                "Cart"
        );
        return this;
    }
}
