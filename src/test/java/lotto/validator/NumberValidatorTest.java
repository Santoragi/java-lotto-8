package lotto.validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import lotto.util.validator.NumberValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberValidatorTest {

    private NumberValidator numberValidator;

    @BeforeEach
    void setUp() {
        numberValidator = new NumberValidator();
    }

    @Test
    @DisplayName("최솟값보다 작은 수 입력 시 예외 처리")
    void 최솟값_미만_입력() {

        List<Integer> numbers = List.of(0, 1, 2, 3, 4, 5);

        assertThatThrownBy(() -> numberValidator.validate(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 최소 1입니다.");
    }

    @Test
    @DisplayName("최댓값보다 큰 수 입력 시 예외 처리")
    void 최댓값_초과_입력() {

        List<Integer> numbers = List.of(41, 42, 43, 44, 45, 46);

        assertThatThrownBy(() -> numberValidator.validate(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 최대 45입니다.");
    }

    @Test
    @DisplayName("중복되는 숫자 입력 시 예외 처리")
    void 중복_숫자_입력() {

        List<Integer> numbers = List.of(1, 1, 2, 3, 45, 45);

        assertThatThrownBy(() -> numberValidator.validate(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("6개 미만의 숫자 입력 시 예외 처리")
    void 개수_5개_입력() {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        assertThatThrownBy(() -> numberValidator.validate(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호의 개수는 6개입니다.");
    }

    @Test
    @DisplayName("6개 초과의 숫자 입력 시 예외 처리")
    void 개수_7개_입력() {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);

        assertThatThrownBy(() -> numberValidator.validate(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호의 개수는 6개입니다.");
    }

    @Test
    @DisplayName("당첨번호를 올바르게 입력 시 검증 성공")
    void 검증_성공() {

        List<Integer> numbers = List.of(8, 21, 23, 41, 42, 43);

        assertDoesNotThrow(() -> numberValidator.validate(numbers));
    }

}
