package ru.netology.bonus;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BonusServiceTest {
    @ParameterizedTest
    @CsvSource(
            value = {
                    "'registered user, bonus under limit',100060,true,30",
                    "'registered user, bonus over limit',100000060,true,500",
                    "'not registered user, bonus under limit',100060,false,10",
                    "'not registered user, bonus over limit',1000000060,false,500"

            }
    )
    @CsvFileSource(resources = "/data.csv", delimiter = '/')
    void shouldCalculate(String testName, long amount, boolean registered, long expected) {
        BonusService service = new BonusService();

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }
}
