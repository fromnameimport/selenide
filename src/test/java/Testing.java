import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Testing {
    public static void main(String args[]) throws InterruptedException {
        Selenide.open("https://practice.automationbro.com/");

        $("i.tg-icon-search").click();
        SelenideElement searchField = $("input.search-field");
        searchField.sendKeys("Watch");
        searchField.pressEnter();
        Thread.sleep(2000);
        //        $$(By.id("primary-menu")).get(1).click();td.product-name > a td[class='product-name']/a
    }
}
