package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import java.io.File;
import java.time.Duration;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class RegPageTwo {

    private SelenideElement countryDropdown = $x("//input[contains(@input-label,'Страна')]/../..");
    private SelenideElement countryToSelect;
    private SelenideElement fullCompanyNameInputForm = $x("//input[contains(@input-label,'Полное') and contains(@input-label,'организации')]");
    private SelenideElement abbrevCompanyNameInputForm = $x("//input[contains(@input-label,'Сокращенное') and contains(@input-label,'организации')]");
    private SelenideElement ownershipTypeDropdown = $x("//input[contains(@input-label,'Форма собственности')]/../..");
    private SelenideElement ownershipTypeToSelect;
    private SelenideElement companyTypeDropdown = $x("//input[contains(@input-label,'Тип компании')]/../..");
    private ElementsCollection companyTypeElements = $$x("//div[contains(@class,'content__active')]//div[contains(@class,'checkbox')]");
    private SelenideElement tgnlInputForm = $x("//input[contains(@input-label,'ТГНЛ')]");
    private SelenideElement innInputForm = $x("//input[contains(@input-label,'ИНН')]");
    private SelenideElement kppInputForm = $x("//input[contains(@input-label,'КПП')]");
    private SelenideElement okpoInputForm = $x("//input[contains(@input-label,'ОКПО')]");
    private SelenideElement ogrnInputForm = $x("//input[contains(@input-label,'ОГРН')]");
    private SelenideElement ogrnipInputForm = $x("//input[contains(@input-label,'ОГРНИП')]");
    private SelenideElement iinInputForm = $x("//input[contains(@input-label,'ИИН')]");
    private SelenideElement regNumberInputForm = $x("//input[contains(@input-label,'номер')]");
    private SelenideElement binInputForm = $x("//input[contains(@input-label,'БИН') and not(contains(@input-label,'ОКПО'))]");
    private SelenideElement stateRegUploadInput = $x("//span[contains(text(),'гос.регистрации')]/../../..//div[contains(@class,'slot') and contains(@class, 'input')]//input");
    private SelenideElement taxControlUploadInput = $x("//span[contains(text(),'нал.учет')]/../../..//div[contains(@class,'slot') and contains(@class, 'input')]//input");
    private SelenideElement accessLetterUploadInput = $x("//span[contains(text(),'доступа')]/../../..//div[contains(@class,'slot') and contains(@class, 'input')]//input");
    private SelenideElement personalIdInput = $x("//span[contains(text(),'Удостоверение')]/../../..//div[contains(@class,'slot') and contains(@class, 'input')]//input");
    private SelenideElement agreementCheckbox = $x("//input[contains(@type,'checkbox')]");
    private SelenideElement sendApplication = $x("//button[contains(@name,'заявку')]");

    private SelenideElement successfulRegMessage = $x("//div[contains(text(),'Вы успешно подали заявку!')]");
    //я не сделал разные PO для разных тестов, потому что думаю, что лучше передавать условия через аннотации, но еще не успел разобраться, как работать с ними в селениде

    public void selectACountryFromListbox(String country)
    {
        String countryLocator = String.format("//div[contains(@class,'content__active')]//div[contains(text(),'%s')]",country);
        countryToSelect = $x(countryLocator);
        countryDropdown.click();
        countryToSelect.click();
    }

    public void inputAFullCompanyName(String companyFullName)
    {
        fullCompanyNameInputForm.click();
        fullCompanyNameInputForm.setValue(companyFullName);
    }

    public void clickAFullCompanyName()
    {
        fullCompanyNameInputForm.click();
    }
    public void inputAbbreviatedCompanyName(String companyAbbrevName)
    {
        abbrevCompanyNameInputForm.setValue(companyAbbrevName);
    }

    public void SelectOwnershipTypeFromListbox(String ownershipType)
    {
        String ownershipTypeLocator = String.format("//div[contains(@class,'content') and contains(@class,'active')]//div[contains(text(),'%s')]",ownershipType);
        ownershipTypeToSelect = $x(ownershipTypeLocator);
        ownershipTypeDropdown.click();
        ownershipTypeToSelect.click();
    }

    public void selectAllCompanyTypes()
    {
        companyTypeDropdown.click();
        companyTypeElements.asFixedIterable().forEach(companyType -> companyType.click());
    }

    public void inputTGNL(String tgnl)
    {
        tgnlInputForm.setValue(tgnl);
    }
    public void inputINN(String inn)
    {
        innInputForm.setValue(inn);
    }
    public void inputKPP(String kpp)
    {
        kppInputForm.setValue(kpp);
    }
    public void inputOKPO(String okpo)
    {
        okpoInputForm.setValue(okpo);
    }
    public void inputOGRN(String ogrn)
    {
        ogrnInputForm.setValue(ogrn);
    }
    public void inputOGRNIP(String ogrnip)
    {
        ogrnipInputForm.setValue(ogrnip);
    }
    public void inputRegNumber(String regNumber)
    {
        regNumberInputForm.setValue(regNumber);
    }
    public void inputIIN(String iin)
    {
        iinInputForm.setValue(iin);
    }
    public void inputBIN(String bin)
    {
        binInputForm.setValue(bin);
    }
    public void uploadStateRegFile(File file)
    {
        stateRegUploadInput.uploadFile(file);
    }

    public void uploadTaxControlFile(File file)
    {
        taxControlUploadInput.uploadFile(file);
    }
    public void uploadAccessLetterUploadInputFile(File file)
    {
        accessLetterUploadInput.uploadFile(file);
    }
    public void uploadPersonalIdInputInputFile(File file)
    {
        personalIdInput.uploadFile(file);
    }
    //передавать так файлы очень удобно!
    public void checkAgreement() {
        if (agreementCheckbox.getAttribute("aria-checked").equals("false")) {
            agreementCheckbox.click();
        }
    }

    public void sendApplication() {
        sendApplication.click();
    }
    public String regMessageText() {
        final int intWaitDuration =10;
        Duration duration = Duration.ofSeconds(intWaitDuration);
        return successfulRegMessage.shouldBe(visible,duration).getText();
    }

}
