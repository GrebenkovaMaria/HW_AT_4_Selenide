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
       LocalDate localDate = LocalDate.now().plusDays(3);
       String  date = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(localDate);
        open("http://localhost:9999");
        $$("[data-test-id='city']").find(Condition.visible).setValue("Ульяновск");
        $$("[placeholder='Дата встречи']").find(Condition.visible).setValue(date);
        $$("[data-test-id='name']").find(Condition.visible).setValue("Мария Гребенькова");
        $$("[data-test-id='phone']").find(Condition.visible).setValue("+79876543210");
        $$(".checkbox__box").find(Condition.visible).click();
        $$("button").find(Condition.exactText("Забронировать")).click();
        $(withText("Встреча успешно забронирована"))
                .shouldBe(Condition.visible, Duration.ofSeconds(15));

    }


}

