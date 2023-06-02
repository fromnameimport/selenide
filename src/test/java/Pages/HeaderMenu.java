package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class HeaderMenu {
    public void goToPage(String page)  {
        switch (page) {
            case "Home page": $(By.linkText("Home")).click(); break;
            case "About page":  $(By.linkText("About")).click(); break;
            case "Shop page": $(By.linkText("Shop")).click(); break;
            case "Contact us page": $(By.linkText("Contact")).click(); break;
            case "My account page": $(By.linkText("My account")).click(); break;
            case "Blog page": $(By.linkText("Blog")).click(); break;
            case "Cart page": $(By.className("cart-page-link")).click(); break;
        }
    }
    public HeaderMenu search(String searchString) {
        $("i.tg-icon-search").click();
        SelenideElement searchField = $("input.search-field");
        searchField.sendKeys(searchString);
        searchField.pressEnter();
        return this;
    }
    public HeaderMenu verifySearchResults(String searchString) {

        ElementsCollection results = $$("h2.entry-title > a");
        boolean result = results.texts().contains(searchString);
        if (result) {
            Assert.assertTrue(true);
        } else {
            Assert.assertEquals($("div.page-content > p").text(), "Sorry, but nothing matched your search terms. Please try again with some different keywords.");
        }
        return this;
    }
}
