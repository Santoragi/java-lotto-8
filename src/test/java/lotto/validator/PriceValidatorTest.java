package lotto.validator;


import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import lotto.util.validator.PriceValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PriceValidatorTest {

    private PriceValidator priceValidator;
    @BeforeEach
    void setUp() {
        priceValidator = new PriceValidator();
    }

    @Test
    @DisplayName("최소 구입 금액보다 적은 값에 대해 예외 처리")
    void 최소_구입_금액_미만() {

        int price = 10;

        assertThatThrownBy(() -> priceValidator.validate(price))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("최소 구입 금액은 1000원입니다.");
    }

    @Test
    @DisplayName("최소 구입 금액보다 큰 값에 대해 검증을 성공")
    void 최소_구입_금액_이상() {

        int price = 3000;

        assertDoesNotThrow(() -> priceValidator.validate(price));
    }

    @Test
    @DisplayName("최대 구입 금액보다 작은 값에 대해 검증을 성공")
    void 최대_구입_금액_미만() {

        int price = 10000;

        assertDoesNotThrow(() -> priceValidator.validate(price));
    }

    @Test
    @DisplayName("최대 구입 금액보다 큰 값에 대해 예외 처리")
    void 최대_구입_금액_이상() {

        int price = 200000;

        assertThatThrownBy(() -> priceValidator.validate(price))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또는 최대 10만원까지 구매 가능합니다.");
    }

    @Test
    @DisplayName("로또 한장의 가격으로 나누어 떨어지는 경우 검증을 성공")
    void 구입_금액_1000원단위_만족() {

        int price = 100000;

        assertDoesNotThrow(() -> priceValidator.validate(price));
    }

    @Test
    @DisplayName("로또 한장의 가격으로 나누어 떨어지지 않는 경우 예외 처리")
    void 구입_금액_1000원단위_불만족() {

        int price = 10001;

        assertThatThrownBy(() -> priceValidator.validate(price))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구매 금액은 로또 한 장의 가격(1000원)으로 나누어 떨어져야합니다.");
    }
}
