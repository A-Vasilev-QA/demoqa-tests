package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests extends BaseTest{

    @Test
    void fillFormTest() {
        String permanentAddress = "some street 1";

        open("/text-box");
        $("#userName").setValue("Alex");
        $("#userEmail").setValue("alex@qaguru.com");
        $("#currentAddress").setValue("some street 1");
        $("#permanentAddress").setValue(permanentAddress);
        $("#submit").click();

        $("#output #name").shouldHave(text("Alex"));
        $("#output #email").shouldHave(text("alex@qaguru.com"));
        $("#output #currentAddress").shouldHave(text("some street 1"));
        $("#output #permanentAddress").shouldHave(text(permanentAddress));
    }
}
