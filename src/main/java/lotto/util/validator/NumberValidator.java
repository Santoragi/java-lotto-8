package lotto.util.validator;

import static lotto.constant.LottoConstants.LOTTO_NUMBER_COUNT;
import static lotto.constant.LottoConstants.MAX_NUMBER;
import static lotto.constant.LottoConstants.MIN_NUMBER;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberValidator {

    public void validate(List<Integer> numbers) {
        validateNumberRange(numbers);
        validateDuplicate(numbers);
        validateCount(numbers);
    }

    private void validateNumberRange(List<Integer> numbers) {
        numbers.forEach(number -> {
                validateMinNumber(number);
                validateMaxNumber(number);
        });
    }

    private void validateMinNumber(int number) {
        if(number < MIN_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 최소 1입니다.");
        }
    }

    private void validateMaxNumber(int number) {
        if(number > MAX_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 최대 45입니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if(numbers.size() != numberSet.size()) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    private void validateCount(List<Integer> numbers) {
        if(numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("당첨 번호의 개수는 6개입니다.");
        }
    }
}
