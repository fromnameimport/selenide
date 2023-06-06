package Pages;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class FooterMenu {
    public FooterMenu clickButton(String button) {
        switch (button) {
            case "Home" -> $(By.linkText("Home")).click();
            case "About" -> $(By.linkText("About")).click();
            case "Blog" -> $(By.linkText("Blog")).click();
            case "Contact" -> $(By.linkText("Contact")).click();
            case "Support form" -> $(By.linkText("Support Form")).click();
        }
        return this;
    }
}
