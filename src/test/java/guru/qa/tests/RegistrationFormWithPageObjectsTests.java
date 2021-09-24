package guru.qa.tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static guru.qa.pages.AutomationPracticeFormPage.*;
import static guru.qa.pages.AutomationPracticeFormPage.selectGender;

public class RegistrationFormWithPageObjectsTests extends BaseTest {

    Faker faker = new Faker();
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            genderValue,
            userNumber = faker.phoneNumber().subscriberNumber(10),
            fullDate,
            subjectLetter = faker.regexify("[a-eg-jl-v]"),
            subjectName,
            hobbies,
            fileName = "1.jpg",
            currentAddress = faker.address().fullAddress();
    int genderNumber = faker.number().numberBetween(1, 3);
    boolean isFirstHobby = faker.bool().bool(),
            isSecondHobby = faker.bool().bool(),
            isThirdHobby = faker.bool().bool();
    Date birthDate = faker.date().birthday();


    @Test
    public void fillFormTest() {
        openPage();
        typeFirstName(firstName);
        typeLastName(lastName);
        typeUserEmail(userEmail);
        genderValue = selectGender(genderNumber);
        typeUserNumber(userNumber);
        fullDate = selectDate(birthDate);
        subjectName = inputSubject(subjectLetter);
        //$("label[for=\"hobbies-checkbox-1\"]").click();
        hobbies = selectHobbies(isFirstHobby, isSecondHobby, isThirdHobby);
        uploadPicture(fileName);
        typeCurrentAddress(currentAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        clickSubmit();

        checkResultsValue("Student Name", firstName + " " + lastName);
        checkResultsValue("Student Email", userEmail);
        checkResultsValue("Gender", genderValue);
        checkResultsValue("Mobile", userNumber);
        checkResultsValue("Date of Birth", fullDate);
        checkResultsValue("Subjects", subjectName);
        //$(".table-responsive").$(byText("Hobbies")).sibling(0).shouldHave(text("Sports"));
        checkResultsValue("Hobbies", hobbies);
        checkResultsValue("Picture", fileName);
        checkResultsValue("Address", currentAddress);
        $(".table-responsive").$(byText("State and City")).sibling(0).shouldHave(text("NCR Delhi"));

        sleep(3000);
    }
}
