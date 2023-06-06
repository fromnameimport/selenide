package Pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ContactPage {
    public ContactPage enterName(String name) {
        $$("input.input-text").get(0).val(name);
        return this;
    }
    public ContactPage enterEmail(String email) {
        $$("input.input-text").get(1).val(email);
        return this;
    }
    public ContactPage enterPhone(String phone) {
        $$("input.input-text").get(2).val(phone);
        return this;
    }
    public ContactPage enterMessage(String message) {
        $("textarea.input-text").val(message);
        return this;
    }
    public ContactPage clickSubmitButton() {
        $("button.evf-submit").click();
        return this;
    }
    public ContactPage verifyFormIsSent() {
        $("div.everest-forms-notice").shouldHave(Condition.text("Thanks for contacting us! We will be in touch with you shortly"));
        return this;
    }
    public ContactPage assertPageIsOpened() {
        Assert.assertEquals($(By.className("tg-page-header__title")).text(), "Contact");
        return this;
    }
}
