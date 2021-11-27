package demoqa.test;

import demoqa.pages.RegistationPage;
import demoqa.testData.TestData;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("Student Registration Form")
@Tag("registrationPage")
public class StudentRegistrationFormTest extends TestBase {

    RegistationPage registationPage = new RegistationPage();
    TestData testData = new TestData();

    @Test
    @Owner("Кочуров Д.Е")
    @Feature("Github")
    @Story("Student Registration Form")
    @DisplayName("Заполняем Student Registration Form и отправляем данные")

    void fullFormTest() {
        registationPage
                .openPage()
                .typeFirstName(testData.firstName)
                .typeLastName(testData.lastName)
                .typeEmail(testData.email)
                .typeGender("Male")
                .typePhoneNumber(testData.phoneNumber)
                .setDate("18", "July", "1990")
                .typeSubject("Arts")
                .typeUploadPicture(testData.picture)
                .typeHobbies("Reading")
                .typeHobbies("Music")
                .typeCurrentAddress(testData.address)
                .typeState("NCR")
                .typeCity("Noida")
                .submitClick();
        registationPage
                .checkResultsValue("Student Name", testData.firstName + " " + testData.lastName)
                .checkResultsValue("Student Email", testData.email)
                .checkResultsValue("Gender", "Male")
                .checkResultsValue("Mobile", testData.phoneNumber)
                .checkResultsValue("Date of Birth", "18 July,1990")
                .checkResultsValue("Subjects", "Arts")
                .checkResultsValue("Hobbies", "Reading, Music")
                .checkResultsValue("Picture", testData.picture)
                .checkResultsValue("Address", testData.address)
                .checkResultsValue("State and City", "NCR Noida");
    }
}
