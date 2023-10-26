package Pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;
public class RegPageOne {
    //локаторы на кириллице видятся не лучшим вариантом,
    //хотя бы из возможности локализации страниц в будущем,
    // но обращаться по индексам это риск поломки теста при изменении страницы.
    // мне кажется, лучшим вариантом было бы избавиться от автогенерации в поле id,
    // чтобы можно было обращаться по определенному заранее имени на латинице,
    // как //input[contains(@id,'inputName')]

    private SelenideElement surnameInputForm = $x("//input[contains(@input-label,'Фамилия')]");
    private SelenideElement nameInputForm = $x("//input[contains(@input-label,'Имя')]");
    private SelenideElement secondNameInputForm = $x("//input[contains(@input-label,'Отчество')]");
    private SelenideElement emailInputForm = $x("//input[contains(@input-label,'E-mail')]");
    private SelenideElement countryCodeDropdown = $x("//div[@data-type='select' and @class='wrapper']");
    private SelenideElement phoneNumberInputForm = $x("//input[contains(@input-label,'Телефон')]");
    private SelenideElement passwordInputForm = $x("//input[contains(@input-label,'Пароль')]");
    private SelenideElement passwordConfirmationInputForm = $x("//input[contains(@input-label,'Повторите')]");
    private SelenideElement countryFlag;
    //в c# aquality selenium есть возможность передавать
    //в локатор переменную с помощью интерполяции строк
    //private IButton _CountryFlag(string country) => ElementFactory.GetButton(By.XPath($"//img[contains(@alt,'{country}')]"),"Country code selection by the flag");

    private SelenideElement nextRegPage = $x("//button[contains(@name,'Далее')]");
    public void InputSurname(String surname)
    {
        surnameInputForm.setValue(surname);
    }
    public void InputName(String name)
    {
        nameInputForm.setValue(name);
    }
    public void InputSecondName(String secondName)
    {
        secondNameInputForm.setValue(secondName);
    }
    public void InputEmail(String email)
    {
        emailInputForm.setValue(email);
    }
    public void InputPhoneNumber(String phone)
    {
        phoneNumberInputForm.setValue(phone);
    }
    public void InputPassword(String password)
    {
        passwordInputForm.setValue(password);
        passwordConfirmationInputForm.setValue(password);
    }
    public void ClickCountryCodeSelector()
    {
        countryCodeDropdown.click();
    }
    public void ClickCountryFlag(String country) {
        String countryLocator = String.format("//div[contains(@role,'listbox')]//img[contains(@alt,'%s')]",country);
        countryFlag = $x(countryLocator);
        countryCodeDropdown.click();
        countryFlag.click();
    }
    public void ClickNextRegPage()
    {
        nextRegPage.click();
    }
}
