package Pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;

public class CartPage {

    public String getCartItemName() {
        return $("td.product-name > a").text();
    }
    public CartPage assertPageIsOpened() {
        Assert.assertEquals($(By.className("tg-page-header__title")).text(), "Cart");
        return this;
    }
    public CartPage uploadFile() {
        $("input.file_input_hidden").uploadFile(new File("src/test/java/Util/test.txt"));
        $("input.file_input_submit").click();
        return this;
    }
    public CartPage assertFileIsUploaded() {
        $("#wfu_messageblock_header_1_label_1").shouldHave(Condition.text("File test.txt uploaded successfully"));
        return this;
    }
}
