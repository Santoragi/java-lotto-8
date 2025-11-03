package lotto.validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import lotto.util.validator.BonusNumberValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusNumberValidatorTest {

    private BonusNumberValidator bonusNumberValidator;

    @BeforeEach
    void setUp() {
        bonusNumberValidator = new BonusNumberValidator();
    }

    @Test
    @DisplayName("보너스 숫자가 당첨 번호와 중복되는 경우 예외 처리")
    void 보너스_번호_중복() {

        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 1;

        assertThatThrownBy(() -> bonusNumberValidator.validate(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("보너스 숫자가 1미만인 경우 예외 처리")
    void 보너스_번호_범위_미만() {

        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 0;

        assertThatThrownBy(() -> bonusNumberValidator.validate(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 최소 1입니다.");
    }

    @Test
    @DisplayName("보너스 숫자가 45초과인 경우 예외 처리")
    void 보너스_번호_범위_초과() {

        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 46;

        assertThatThrownBy(() -> bonusNumberValidator.validate(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 최대 45입니다.");
    }

    @Test
    @DisplayName("보너스 숫자를 올바르게 입력한 경우 검증 성공")
    void 보너스_번호_정상() {

        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 7;

        assertDoesNotThrow(() -> bonusNumberValidator.validate(winningNumbers, bonusNumber));

    }


}
