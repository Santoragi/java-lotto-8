package lotto.util.validator;

import static lotto.constant.LottoConstants.MAX_NUMBER;
import static lotto.constant.LottoConstants.MIN_NUMBER;

import java.util.List;

public class BonusNumberValidator {

    public void validate(List<Integer> winningNumbers, Integer bonusNumber) {
        validateNumberRange(bonusNumber);
        validateDuplicate(winningNumbers, bonusNumber);
    }

    private void validateDuplicate(List<Integer> winningNumbers, Integer bonusNumber) {
        boolean isDuplicate = winningNumbers.stream()
                .anyMatch( number -> number.equals(bonusNumber));

        if(isDuplicate) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    private void validateNumberRange(Integer bonusNumber) {
        validateMinNumber(bonusNumber);
        validateMaxNumber(bonusNumber);
    }

    private void validateMinNumber(Integer bonusNumber) {
        if(bonusNumber < MIN_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 최소 1입니다.");
        }
    }

    private void validateMaxNumber(Integer bonusNumber) {
        if(bonusNumber > MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 최대 45입니다.");
        }
    }
}
