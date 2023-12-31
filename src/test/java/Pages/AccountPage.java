package Pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AccountPage {

    public AccountPage enterLogin(String login) {
        $$("input.input-text").get(0).val(login);
        return this;
    }
    public AccountPage enterPassword(String password) {
        $$("input.input-text").get(1).val(password);
        return this;
    }
    public AccountPage clickLoginButton() {
        $$("button.woocommerce-button").get(0).click();
        return this;
    }
    public AccountPage isLoginErrorPresent() {
        $("ul.woocommerce-error").shouldBe(Condition.visible);
        return this;
    }
    public AccountPage assertPageIsOpened() {
        Assert.assertEquals($(By.className("tg-page-header__title")).text(), "My account");
        return this;
    }
}
