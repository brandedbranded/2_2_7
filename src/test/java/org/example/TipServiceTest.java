package org.example;

import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TipServiceTest {

    @ParameterizedTest(name = "Тест для суммы {0}")
    @DisplayName("Расчет чаевых при различной сумме заказа")
    @Description("При сумме до 1000 прибавляется 10%, при сумме более 1000 прибавляется 5%")
    @CsvSource({
            "990, 1.1",
            "1100, 1.05",
            "1000, 1.05",
            "-10, 1.1",
            "0, 1.1",
    })
    void roundTipsTest(BigDecimal amount, BigDecimal exp) {
        TipService tipService = new TipService();
        assertEquals(amount.multiply(exp), tipService.roundTips(amount));
    }
}