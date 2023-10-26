package Pages;

import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    public void clickSignUpButton() {
       $x("//a[contains(@href,'reg')]").click();
    }

}
