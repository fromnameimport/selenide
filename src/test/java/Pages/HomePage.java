package Pages;

import com.codeborne.selenide.*;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class HomePage {
    // getters
    private static SelenideElement getLogo() {
        return $(By.className("custom-logo"));
    }
    private static SelenideElement getStartedButton() {
        return $(By.className("elementor-button-text"));
    }
    private static ElementsCollection getHeaderMenuElement() {
        return $$(By.id("primary-menu"));
    }

    // checks
    public HomePage checkForLogoVisibility() {
        getLogo().shouldBe(Condition.visible);
        return this;
    }

    // actions
    public void open() {
        String homePageUrl = "https://practice.automationbro.com/";
        Selenide.open(homePageUrl);
    }

    // asserts
    public HomePage assertPageIsOpened() {
        Assert.assertEquals($("h1.elementor-heading-title").text(), "Think different. Make different.");
        return this;
    }

}
