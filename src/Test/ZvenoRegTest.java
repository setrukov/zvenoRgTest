package Test;
import Pages.*;
import Utils.FileUtils;
import Utils.JsonUtils;
import Utils.RandUtils;
import Utils.TestDataUtils;
import org.junit.Assert;
import org.junit.Test;



public class ZvenoRegTest extends BaseTest {


    @Test
    public void testRusIp() {
        //методы PO не возвращают экземпляр PO.
        //Т.к. я не знаю, какого стиля вы придерживаетесь,
        //я выбрал стиль, который нам показали на стажировке,
        //но понимаю, как переделать в fluent
        MainPage mainPage = new MainPage();
        mainPage.clickSignUpButton();
        RegPageOne regPageOne = new RegPageOne();
        String testCaseCountry = "ru";
        String testCaseOwnershipType = "ИП";
        //заготовка для передачи параметров о стране и форме собственности через ddt аннотации
        String countryData = String.format("countryName_%s", testCaseCountry);
        String countryName = JsonUtils.getValue("testData.json", countryData);
        String countryFlag = testCaseCountry;
        String surName = JsonUtils.getValue("testData.json","surName");
        String name =  JsonUtils.getValue("testData.json","name");
        String secondName = JsonUtils.getValue("testData.json","secondName");
        String email = String.format("%s@gmail.com",RandUtils.generateContent(10));
        String phoneNumber = RandUtils.generatePhoneNumber();
        //так как для успешной регистрации нужны уникальные email и телефон,
        //остальные данные получаем из testData.json
        String password = JsonUtils.getValue("testData.json","password");
        String companyFullName = JsonUtils.getValue("testData.json","companyFullName");
        String companyAbbreviatedName = JsonUtils.getValue("testData.json","companyAbbreviatedName");
        String tgnl = JsonUtils.getValue("testData.json","tgnl");
        String inn = TestDataUtils.getINN(testCaseCountry);
        String okpo = TestDataUtils.getOKPO(testCaseCountry,testCaseOwnershipType);

        regPageOne.InputSurname(surName);
        regPageOne.InputName(name);
        regPageOne.InputSecondName(secondName);
        regPageOne.InputEmail(email);
        regPageOne.InputPhoneNumber(phoneNumber);
        regPageOne.InputPassword(password);
        regPageOne.ClickCountryFlag(countryFlag);
        regPageOne.ClickNextRegPage();

        RegPageTwo regPageTwo = new RegPageTwo();
        regPageTwo.selectACountryFromListbox(countryName);
        regPageTwo.selectAllCompanyTypes();
        regPageTwo.inputAFullCompanyName(companyFullName);
        regPageTwo.SelectOwnershipTypeFromListbox(testCaseOwnershipType);
        regPageTwo.inputAbbreviatedCompanyName(companyAbbreviatedName);
        regPageTwo.inputTGNL(tgnl);
        regPageTwo.inputINN(inn);
        regPageTwo.inputOKPO(okpo);

        regPageTwo.uploadStateRegFile(FileUtils.getResourceFile("stateReg.png"));
        regPageTwo.uploadTaxControlFile(FileUtils.getResourceFile("taxControl.png"));
        regPageTwo.checkAgreement();
        regPageTwo.sendApplication();
        String successMessage = JsonUtils.getValue("testData.json","successMessage");

        Assert.assertEquals(successMessage,regPageTwo.regMessageText());

        //ассерты вынесены в тестовый метод, потому что .should(..)
        //селенида вызываются непосредственно на элементах PO,
        //на стажировке от нас требовали оставлять работать с элементами только
        //на PO, а ассерты выполнять в тестовом методе.
    }

    @Test
    public void testRusOOO(){
        MainPage mainPage = new MainPage();
        mainPage.clickSignUpButton();
        RegPageOne regPageOne = new RegPageOne();
        String testCaseCountry = "ru";
        String testCaseOwnershipType = "ООО";
        String countryData = String.format("countryName_%s", testCaseCountry);
        String countryName = JsonUtils.getValue("testData.json", countryData);
        String countryFlag = testCaseCountry;
        String surName = JsonUtils.getValue("testData.json","surName");
        String name =  JsonUtils.getValue("testData.json","name");
        String secondName = JsonUtils.getValue("testData.json","secondName");
        String email = String.format("%s@gmail.com",RandUtils.generateContent(10));
        String phoneNumber = RandUtils.generatePhoneNumber();
        String password = JsonUtils.getValue("testData.json","password");
        String companyFullName = JsonUtils.getValue("testData.json","companyFullName");
        String companyAbbreviatedName = JsonUtils.getValue("testData.json","companyAbbreviatedName");
        String tgnl = JsonUtils.getValue("testData.json","tgnl");
        String inn = TestDataUtils.getINN(testCaseCountry);
        String okpo = TestDataUtils.getOKPO(testCaseCountry,testCaseOwnershipType);
        String ogrn = JsonUtils.getValue("testData.json","ogrn");
        String kpp = JsonUtils.getValue("testData.json","kpp");

        regPageOne.InputSurname(surName);
        regPageOne.InputName(name);
        regPageOne.InputSecondName(secondName);
        regPageOne.InputEmail(email);
        regPageOne.InputPhoneNumber(phoneNumber);
        regPageOne.InputPassword(password);
        regPageOne.ClickCountryFlag(countryFlag);
        regPageOne.ClickNextRegPage();

        RegPageTwo regPageTwo = new RegPageTwo();
        regPageTwo.selectACountryFromListbox(countryName);
        regPageTwo.selectAllCompanyTypes();
        regPageTwo.inputAFullCompanyName(companyFullName);
        regPageTwo.SelectOwnershipTypeFromListbox(testCaseOwnershipType);
        regPageTwo.inputAbbreviatedCompanyName(companyAbbreviatedName);
        regPageTwo.inputTGNL(tgnl);
        regPageTwo.inputINN(inn);
        regPageTwo.inputOKPO(okpo);
        regPageTwo.inputOGRN(ogrn);
        regPageTwo.inputKPP(kpp);
        regPageTwo.uploadStateRegFile(FileUtils.getResourceFile("stateReg.png"));
        regPageTwo.uploadTaxControlFile(FileUtils.getResourceFile("taxControl.png"));
        regPageTwo.uploadAccessLetterUploadInputFile(FileUtils.getResourceFile("accessLetter.png"));
        regPageTwo.checkAgreement();
        regPageTwo.sendApplication();
        String successMessage = JsonUtils.getValue("testData.json","successMessage");
        Assert.assertEquals(successMessage,regPageTwo.regMessageText());
    }

    @Test
    public void testKazIP() {
        MainPage mainPage = new MainPage();
        mainPage.clickSignUpButton();
        RegPageOne regPageOne = new RegPageOne();
        String testCaseCountry = "kz";
        String testCaseOwnershipType = "ИП";
        String countryData = String.format("countryName_%s", testCaseCountry);
        String countryName = JsonUtils.getValue("testData.json", countryData);
        String countryFlag = testCaseCountry;
        String surName = JsonUtils.getValue("testData.json","surName");
        String name =  JsonUtils.getValue("testData.json","name");
        String secondName = JsonUtils.getValue("testData.json","secondName");
        String email = String.format("%s@gmail.com",RandUtils.generateContent(10));
        String phoneNumber = RandUtils.generatePhoneNumber();
        String password = JsonUtils.getValue("testData.json","password");
        String companyFullName = JsonUtils.getValue("testData.json","companyFullName");
        String companyAbbreviatedName = JsonUtils.getValue("testData.json","companyAbbreviatedName");
        String tgnl = JsonUtils.getValue("testData.json","tgnl");
        String iin = JsonUtils.getValue("testData.json","iin");
        String okpo = TestDataUtils.getOKPO(testCaseCountry,testCaseOwnershipType);

        regPageOne.InputSurname(surName);
        regPageOne.InputName(name);
        regPageOne.InputSecondName(secondName);
        regPageOne.InputEmail(email);
        regPageOne.InputPhoneNumber(phoneNumber);
        regPageOne.InputPassword(password);
        regPageOne.ClickCountryFlag(countryFlag);
        regPageOne.ClickNextRegPage();

        RegPageTwo regPageTwo = new RegPageTwo();
        regPageTwo.selectACountryFromListbox(countryName);
        regPageTwo.selectAllCompanyTypes();
        regPageTwo.inputAFullCompanyName(companyFullName);
        regPageTwo.SelectOwnershipTypeFromListbox(testCaseOwnershipType);
        regPageTwo.inputAbbreviatedCompanyName(companyAbbreviatedName);
        regPageTwo.inputTGNL(tgnl);
        regPageTwo.inputIIN(iin);
        regPageTwo.inputOKPO(okpo);
        regPageTwo.uploadPersonalIdInputInputFile(FileUtils.getResourceFile("persId.png"));
        regPageTwo.checkAgreement();
        regPageTwo.sendApplication();
        String successMessage = JsonUtils.getValue("testData.json","successMessage");
        Assert.assertEquals(successMessage,regPageTwo.regMessageText());
    }

    @Test
    public void testKazOOO() {
        MainPage mainPage = new MainPage();
        mainPage.clickSignUpButton();
        RegPageOne regPageOne = new RegPageOne();
        String testCaseCountry = "kz";
        String testCaseOwnershipType = "ООО";
        //в сценарии прописано ООО, поэтому тест падает, я бы уточнил, имелось ли в виду именно ООО, или нужна замена на ТОО. При замене тест проходит, как и для сценария Киргизя, ООО
        String countryData = String.format("countryName_%s", testCaseCountry);
        String countryName = JsonUtils.getValue("testData.json", countryData);
        String countryFlag = testCaseCountry;
        String surName = JsonUtils.getValue("testData.json","surName");
        String name =  JsonUtils.getValue("testData.json","name");
        String secondName = JsonUtils.getValue("testData.json","secondName");
        String email = String.format("%s@gmail.com",RandUtils.generateContent(10));
        String phoneNumber = RandUtils.generatePhoneNumber();
        String password = JsonUtils.getValue("testData.json","password");
        String companyFullName = JsonUtils.getValue("testData.json","companyFullName");
        String companyAbbreviatedName = JsonUtils.getValue("testData.json","companyAbbreviatedName");
        String tgnl = JsonUtils.getValue("testData.json","tgnl");
        String regNumber = JsonUtils.getValue("testData.json","regNumber");
        String bin = JsonUtils.getValue("testData.json","bin");
        String okpo = TestDataUtils.getOKPO(testCaseCountry,testCaseOwnershipType);


        regPageOne.InputSurname(surName);
        regPageOne.InputName(name);
        regPageOne.InputSecondName(secondName);
        regPageOne.InputEmail(email);
        regPageOne.InputPhoneNumber(phoneNumber);
        regPageOne.InputPassword(password);
        regPageOne.ClickCountryFlag(countryFlag);
        regPageOne.ClickNextRegPage();

        RegPageTwo regPageTwo = new RegPageTwo();
        regPageTwo.selectACountryFromListbox(countryName);
        regPageTwo.selectAllCompanyTypes();
        regPageTwo.inputAFullCompanyName(companyFullName);
        regPageTwo.SelectOwnershipTypeFromListbox(testCaseOwnershipType);
        regPageTwo.inputAbbreviatedCompanyName(companyAbbreviatedName);
        regPageTwo.inputTGNL(tgnl);
        regPageTwo.inputRegNumber(regNumber);
        regPageTwo.inputBIN(bin);
        regPageTwo.inputOKPO(okpo);
        regPageTwo.uploadStateRegFile(FileUtils.getResourceFile("stateReg.png"));
        regPageTwo.uploadTaxControlFile(FileUtils.getResourceFile("taxControl.png"));
        regPageTwo.checkAgreement();
        regPageTwo.sendApplication();
        String successMessage = JsonUtils.getValue("testData.json","successMessage");
        Assert.assertEquals(successMessage,regPageTwo.regMessageText());
    }
    @Test
    public void testKyrIP() {
        MainPage mainPage = new MainPage();
        mainPage.clickSignUpButton();
        RegPageOne regPageOne = new RegPageOne();
        String testCaseCountry = "kg";
        String testCaseOwnershipType = "ИП";

        String countryData = String.format("countryName_%s", testCaseCountry);
        String countryName = JsonUtils.getValue("testData.json", countryData);
        String countryFlag = testCaseCountry;
        String surName = JsonUtils.getValue("testData.json","surName");
        String name =  JsonUtils.getValue("testData.json","name");
        String secondName = JsonUtils.getValue("testData.json","secondName");
        String email = String.format("%s@gmail.com",RandUtils.generateContent(10));
        String phoneNumber = RandUtils.generatePhoneNumber();
        String password = JsonUtils.getValue("testData.json","password");
        String companyFullName = JsonUtils.getValue("testData.json","companyFullName");
        String companyAbbreviatedName = JsonUtils.getValue("testData.json","companyAbbreviatedName");
        String tgnl = JsonUtils.getValue("testData.json","tgnl");
        String inn = TestDataUtils.getINN(testCaseCountry);
        String okpo = TestDataUtils.getOKPO(testCaseCountry,testCaseOwnershipType);


        regPageOne.InputSurname(surName);
        regPageOne.InputName(name);
        regPageOne.InputSecondName(secondName);
        regPageOne.InputEmail(email);
        regPageOne.InputPhoneNumber(phoneNumber);
        regPageOne.InputPassword(password);
        regPageOne.ClickCountryFlag(countryFlag);
        regPageOne.ClickNextRegPage();

        RegPageTwo regPageTwo = new RegPageTwo();
        regPageTwo.selectACountryFromListbox(countryName);
        regPageTwo.selectAllCompanyTypes();
        regPageTwo.inputAFullCompanyName(companyFullName);
        regPageTwo.SelectOwnershipTypeFromListbox(testCaseOwnershipType);
        regPageTwo.inputAbbreviatedCompanyName(companyAbbreviatedName);
        regPageTwo.inputTGNL(tgnl);
        regPageTwo.inputINN(inn);
        regPageTwo.inputOKPO(okpo);
        regPageTwo.uploadStateRegFile(FileUtils.getResourceFile("stateReg.png"));
        regPageTwo.uploadTaxControlFile(FileUtils.getResourceFile("taxControl.png"));
        regPageTwo.checkAgreement();
        regPageTwo.sendApplication();
        String successMessage = JsonUtils.getValue("testData.json","successMessage");
        Assert.assertEquals(successMessage,regPageTwo.regMessageText());
    }
    @Test
    public void testKyrOOO() {
        MainPage mainPage = new MainPage();
        mainPage.clickSignUpButton();
        RegPageOne regPageOne = new RegPageOne();
        String testCaseCountry = "kg";
        String testCaseOwnershipType = "ОсОО";

        String countryData = String.format("countryName_%s", testCaseCountry);
        String countryName = JsonUtils.getValue("testData.json", countryData);
        String countryFlag = testCaseCountry;
        String surName = JsonUtils.getValue("testData.json","surName");
        String name =  JsonUtils.getValue("testData.json","name");
        String secondName = JsonUtils.getValue("testData.json","secondName");
        String email = String.format("%s@gmail.com",RandUtils.generateContent(10));
        String phoneNumber = RandUtils.generatePhoneNumber();
        String password = JsonUtils.getValue("testData.json","password");
        String companyFullName = JsonUtils.getValue("testData.json","companyFullName");
        String companyAbbreviatedName = JsonUtils.getValue("testData.json","companyAbbreviatedName");
        String tgnl = JsonUtils.getValue("testData.json","tgnl");
        String inn = TestDataUtils.getINN(testCaseCountry);
        String okpo = TestDataUtils.getOKPO(testCaseCountry,testCaseOwnershipType);
        String regNumber = JsonUtils.getValue("testData.json","regNumber");


        regPageOne.InputSurname(surName);
        regPageOne.InputName(name);
        regPageOne.InputSecondName(secondName);
        regPageOne.InputEmail(email);
        regPageOne.InputPhoneNumber(phoneNumber);
        regPageOne.InputPassword(password);
        regPageOne.ClickCountryFlag(countryFlag);
        regPageOne.ClickNextRegPage();

        RegPageTwo regPageTwo = new RegPageTwo();
        regPageTwo.selectACountryFromListbox(countryName);
        regPageTwo.selectAllCompanyTypes();
        regPageTwo.inputAFullCompanyName(companyFullName);
        regPageTwo.SelectOwnershipTypeFromListbox(testCaseOwnershipType);
        regPageTwo.inputAbbreviatedCompanyName(companyAbbreviatedName);
        regPageTwo.inputTGNL(tgnl);
        regPageTwo.inputINN(inn);
        regPageTwo.inputRegNumber(regNumber);
        regPageTwo.inputOKPO(okpo);
        regPageTwo.uploadStateRegFile(FileUtils.getResourceFile("stateReg.png"));
        regPageTwo.uploadTaxControlFile(FileUtils.getResourceFile("taxControl.png"));
        regPageTwo.uploadAccessLetterUploadInputFile(FileUtils.getResourceFile("accessLetter.png"));
        regPageTwo.checkAgreement();
        regPageTwo.sendApplication();
        String successMessage = JsonUtils.getValue("testData.json","successMessage");
        Assert.assertEquals(successMessage,regPageTwo.regMessageText());
    }
}

