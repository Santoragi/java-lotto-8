package lotto.parser;

import static lotto.constant.LottoConstants.LOTTO_NUMBER_COUNT;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.util.parser.NumberParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberParserTest {

    private NumberParser numberParser;

    @BeforeEach
    void setUp() {
        numberParser = new NumberParser();
    }

    @Test
    @DisplayName("사용자가 입력한 당첨 번호를 올바르게 변환")
    void 당첨_번호_변환_성공() {

        String input = "1,2,3,4,5,6";

        List<Integer> numbers = numberParser.parseNumbers(input);

        assertEquals(LOTTO_NUMBER_COUNT, numbers.size());
        assertEquals(List.of(1,2,3,4,5,6), numbers);
    }

    @Test
    @DisplayName("사용자가 당첨 번호를 잘못 입력했을 경우 예외 처리")
    void 당첨_번호_변환_예외() {

        String input = "1,2,삼,4,5,6";

        assertThatThrownBy(() -> numberParser.parseNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨 번호는 정수를 쉼표(,)로 구분하여 입력해야 합니다.");
    }
}
