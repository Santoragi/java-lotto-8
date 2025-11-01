package lotto.parser;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PriceParserTest {

    @Test
    @DisplayName("구입 금액을 올바르게 숫자로 변환")
    void 구입_금액_숫자입력() {
        PriceParser priceParser = new PriceParser();
        int price = priceParser.parse("1000");

        assertThat(price).isEqualTo(1000);
    }

    @Test
    @DisplayName("구입 금액이 숫자가 아닌 경우 예외 처리")
    void 구입_금액_문자입력() {
        PriceParser priceParser = new PriceParser();

        assertThatThrownBy(() -> priceParser.parse("10000원"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구입 금액은 정수로 입력해야합니다.");
    }
}
