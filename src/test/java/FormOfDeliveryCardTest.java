import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class FormOfDeliveryCardTest {

    @Test
    void shouldTestSuccessOrderIfCorrectFilling() {
       LocalDate localDate = LocalDate.now().plusDays(5);
       String  date = DateTimeFormatter.ofPattern("dd.MM.yyyy").format(localDate);
        open("http://localhost:9999");
        $("[data-test-id='city'] .input__control").setValue("Ульяновск");
        $("[data-test-id='date'] .input__control").click();
        $("[data-test-id='date'] .input__control").click();
        $("[data-test-id='date'] .input__control").clear();
       // $("[data-test-id='date'] .input__control").sendKeys(date);
        $("[data-test-id='name'] .input__control").setValue("Мария Гребенькова");
        $("[data-test-id='phone'] .input__control").setValue("+79876543210");
        $$(".checkbox__box").find(Condition.visible).click();
        $$("button").find(Condition.exactText("Забронировать")).click();
        $(withText("Встреча успешно забронирована"))
                .shouldBe(Condition.visible, Duration.ofSeconds(15));

    }


}
















