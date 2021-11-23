package demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import demoqa.pages.components.CalendarComponent;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistationPage {

    private final String FORM_TITLE = "Student Registration Form";
    private SelenideElement
            formTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderRadioButton = $("#genterWrapper"),
            phoneNumberInput = $("#userNumber"),
            subjectMultiInpunt = $("#subjectsInput"),
            uploadPictureButton = $("input[id=uploadPicture]"),
            hobbiesCheckbox = $("#hobbiesWrapper"),
            currentAddressInput = $("#currentAddress"),
            stateCitySelected = $("#stateCity-wrapper"),
            stateSelected = $("#state"),
            citySelected = $("#city"),
            submitClick = $("#submit"),
            resultsTable = $(".table-responsive");

    @Step("Открываем Student Registration Form")
    public RegistationPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));
        return this;
    }

    @Step("Заполняем First Name")
    public RegistationPage typeFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    @Step("Заполняем Last Name")
    public RegistationPage typeLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    @Step("Заполняем email")
    public RegistationPage typeEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    @Step("Выбираем пол")
    public RegistationPage typeGender(String value) {
        genderRadioButton.find(byText(value)).click();
        return this;
    }

    @Step("Заполняем номер мобильного телефона")
    public RegistationPage typePhoneNumber(String value) {
        phoneNumberInput.setValue(value);
        return this;
    }

    @Step("Заполняем дату рождения")
    public RegistationPage setDate(String day, String month, String year) {
        new CalendarComponent().setDate(day, month, year);
        return this;
    }

    @Step("Выбираем дисциплину")
    public RegistationPage typeSubject(String value) {
        subjectMultiInpunt.setValue(value).pressEnter();
        return this;
    }

    @Step("Загружаем фотографию")
    public RegistationPage typeUploadPicture(String value) {
        uploadPictureButton.uploadFromClasspath(value);
        return this;
    }

    @Step("Выбираем хобби")
    public RegistationPage typeHobbies(String value) {
        hobbiesCheckbox.findElement(byText(value)).click();
        return this;
    }

    @Step("Заполняем текущий адрес")
    public RegistationPage typeCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    @Step("Выбираем штат")
    public RegistationPage typeState(String value) {
        stateSelected.click();
        stateCitySelected.$(byText(value)).scrollTo().click();
        return this;
    }

    @Step("Выбираем город")
    public RegistationPage typeCity(String value) {
        citySelected.click();
        stateCitySelected.$(byText(value)).scrollTo().click();
        return this;
    }

    @Step("Нажать отправить")
    public void submitClick() {
        submitClick.click();
    }

    @Step("Проверяем отправленные данные")
    public RegistationPage checkResultsValue(String key, String value) {
        resultsTable.$(byText(key)).
                parent().shouldHave(text(value));
        return this;
    }
}
