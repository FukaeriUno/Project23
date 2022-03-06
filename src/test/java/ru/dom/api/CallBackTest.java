package ru.dom.api;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class CallBackTest {
    @Test
    void shouldSendForm () {
        open("http://localhost:9999/");
        $("[name=name]").setValue("Галина Михайлова");
        $("[name=phone]").setValue("+79258415623");
        $(By.className("checkbox__box")).click();
        $("[role='button']").click();
        $("[data-test-id=order-success]").shouldHave(Condition.exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}
