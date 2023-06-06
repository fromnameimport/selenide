package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.Random;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ShopPage {
    static String addedItemName = "";
    public String getAddedItemName() {
        return addedItemName;
    }
    public ShopPage addToCartRandomItem() throws InterruptedException {
        ElementsCollection addButtons = $$(By.linkText("Add to cart"));
        ElementsCollection itemNames = $$(By.className("woocommerce-loop-product__title"));
        Random random = new Random();
        int index = random.nextInt(0, addButtons.size() - 1);
        addedItemName = itemNames.get(index).text();
        addButtons.get(index).click();
        Thread.sleep(1000);
        return this;
    }
    public ShopPage filterItems(String filter) {
        switch (filter) {
            case "Clothes" -> $(By.linkText("Clothes")).click();
            case "Shoes" -> $(By.linkText("Shoes")).click();
            case "Uncategorized" -> $(By.linkText("Uncategorized")).click();
            case "Watch" -> $(By.linkText("Watch")).click();
        }
        return this;
    }
    public ShopPage assertFilterIsApplied(String filter) {
        ElementsCollection col = $$("#primary > ul > li");
        for (SelenideElement el : col) {
            String itemClasses = el.getAttribute("class");
            switch (filter) {
                case "Clothes" -> Assert.assertTrue(itemClasses.contains("product_cat-clothes"));
                case "Shoes" -> Assert.assertTrue(itemClasses.contains("product_cat-shoes"));
                case "Uncategorized" -> Assert.assertTrue(itemClasses.contains("product_cat-uncategorized"));
                case "Watch" -> Assert.assertTrue(itemClasses.contains("product_cat-watch"));
                default -> Assert.fail();
            }
        }
        return this;
    }
    public ShopPage assertPageIsOpened() {
        Assert.assertEquals(
                $(By.className("tg-page-header__title")).text(),
                "Shop"
        );
        return this;
    }
}
