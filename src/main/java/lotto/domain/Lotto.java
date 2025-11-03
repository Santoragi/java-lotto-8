package lotto.domain;

import static lotto.constant.LottoConstants.NUMBER_DELIMETER;
import static lotto.constant.LottoConstants.NUMBER_PREFIX;
import static lotto.constant.LottoConstants.NUMBER_SUFFIX;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        Set<Integer> numberSet = new HashSet<>(numbers);
        if(numberSet.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    public String toString() {
        return numbers.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(NUMBER_DELIMETER, NUMBER_PREFIX, NUMBER_SUFFIX));
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
