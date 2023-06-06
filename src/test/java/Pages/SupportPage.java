package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;

public class SupportPage {

    public SupportPage assertPageIsOpened() {
        Assert.assertEquals($("h1.tg-page-header__title").text(), "Support Form");
        return this;
    }

    public SupportPage enterName(String name) {
        $(".support-name input").val(name);
        return this;
    }
    public SupportPage enterEmail(String email) {
        $(".support-email input").val("testname@gmail.com");
        return this;
    }
    public SupportPage enterSubject(String subject) {
        $(".support-subject input").val(subject);
        return this;
    }
    public SupportPage selectOption(String option) {
        SelenideElement dropdown = $(By.id("evf-680-field_82kaAPhrnW-6"));
        switch (option) {
            case "Quick support team" -> dropdown.selectOption("Quick support team");
            case "Technical Team" -> dropdown.selectOption("Technical Team");
            case "Sales team" -> dropdown.selectOption("Sales team");
        }
        return this;
    }
    public SupportPage selectCheckbox(String checkbox) {
        switch (checkbox) {
            case "Integration Issue" -> $(".support-checkboxes li:nth-child(1) input").click();
            case "Hardware Issue" -> $(".support-checkboxes li:nth-child(2) input").click();
            case "Software Issue" -> $(".support-checkboxes li:nth-child(3) input").click();
            case "Other" -> $(".support-checkboxes li:nth-child(4) input").click();
        }
        return this;
    }
    public SupportPage selectTodayDate() {
        $(".support-date").click();
        $(".flatpickr-day.today").click();
        return this;
    }
    public SupportPage clickSubmitButton() {
        $(By.className("everest-forms-submit-button")).click();
        return this;
    }
    public SupportPage verifyIsFormSent() {
        $(By.className("everest-forms-notice")).shouldHave(Condition.text("Thanks for contacting us! We will be in touch with you shortly"));
        return this;
    }
}
