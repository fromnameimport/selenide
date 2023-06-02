package StepDefinitions;

import Pages.*;
import com.beust.ah.A;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.*;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;

public class Steps {
    HomePage homePage = new HomePage();
    HeaderMenu headerMenu = new HeaderMenu();
    ShopPage shopPage = new ShopPage();
    AboutPage aboutPage = new AboutPage();
    BlogPage blogPage = new BlogPage();
    ContactPage contactPage = new ContactPage();
    CartPage cartPage = new CartPage();
    AccountPage accountPage = new AccountPage();

    String addedItemName = "";

    // actions
    @When("I open test site homepage")
    public void i_open_test_site_homepage() {
        homePage.open();
    }
    @Then("Close browser")
    public void close_browser() {
        Selenide.closeWebDriver();
    }
    @Then("I fill out, submit 'Send Us Message' and verify form sending")
    public void i_fill_out_and_submit_form() {
        contactPage.enterName("Dmytro")
                .enterPhone("380808008080")
                .enterEmail("test@test.com")
                .enterMessage("Some problem description")
                .clickSubmitButton()
                .verifyFormIsSent();
    }
    @Then("I enter invalid users credentials")
    public void i_enter_invalid_users_credentials() {
        accountPage.enterLogin("invalidLogin")
                .enterPassword("wrongPassword")
                .clickLoginButton();
    }
    @Then("I add to cart random item")
    public void i_add_to_cart_random_item() throws InterruptedException {
        shopPage.addToCartRandomItem();
        addedItemName = shopPage.getAddedItemName();
    }

    // navigation & search
    @Then("I go to {string}")
    public void i_go_to(String string)  {
        headerMenu.goToPage(string);
    }
    @Then("I search for {string}")
    public void i_search_for(String string) {
        headerMenu.search(string);
    }

    // verify
    @Then("I verify that the logo is present on the page")
    public void i_verify_that_the_logo_is_present_on_the_page() {
        homePage.checkForLogoVisibility();
    }
    @Then("I verify that {string} is present")
    public void i_verify_that_is_present(String string) {

    }
    @Then("I verify that the {string} page is present")
    public void i_verify_that_the_page_is_present(String page) {
        switch (page) {
            case "Home":  break;
            case "About":  aboutPage.assertPageIsOpened(); break;
            case "Shop": shopPage.assertPageIsOpened(); break;
            case "Contact us": contactPage.assertPageIsOpened(); break;
            case "My account":  break;
            case "Blog": blogPage.assertPageIsOpened(); break;
            case "Cart":  break;
        }
    }
    @Then("I verify that added item is added to cart")
    public void i_verify_that_added_item_is_added_to_cart() {
        Assert.assertEquals(addedItemName, cartPage.getCartItemName());
    }
    @Then("I verify that there are mistake message")
    public void i_verify_that_there_are_mistake_message() {
        accountPage.isLoginErrorPresent();
    }
    @Then("I verify search results for {string}")
    public void i_verify_search_results_for(String string) {
        headerMenu.verifySearchResults(string);
    }
}
