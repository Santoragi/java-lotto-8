package lotto.util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoCountCalculatorTest {

    LottoCountCalculator lottoCountCalculator;

    @BeforeEach
    void setUp() {
        lottoCountCalculator = new LottoCountCalculator();
    }

    @Test
    @DisplayName("로또 발행 수를 올바르게 계산")
    void 로또_발행수_계산() {

        int price = 10000;

        int count = lottoCountCalculator.calculate(price);

        assertThat(count).isEqualTo(10);
    }
}
