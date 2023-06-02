package Pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;

public class BlogPage {

    public BlogPage assertPageIsOpened() {
        Assert.assertEquals(
                $(By.className("tg-page-header__title")).text(),
                "Blog"
        );
        return this;
    }
}
