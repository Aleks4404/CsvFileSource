package ru.netology.bonus.bonus;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BonusServiceTest {
    @ParameterizedTest
    @CsvSource(
            value={
                    "'registered user, bonus under limit',100060,true,30",
                    "'registered user, bonus over limit',100000060,true,500",
                    "'notRegistered user, bonus under limit',100060,false,10",
                    "'notRegistered user, bonus over limit',1000000060,false,500"
            }
    )
     void shouldCalculate(String test, long amount, boolean registered, long expected) {

        ru.netology.bonus.BonusService service = new ru.netology.bonus.BonusService();

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }
}