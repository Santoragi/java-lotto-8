package lotto.util.parser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberParser {

    public List<Integer> parseNumbers(String input) {
        try {
            return Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 정수를 쉼표(,)로 구분하여 입력해야 합니다.");
        }
    }

    public Integer parseNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 정수로 입력해야 합니다.");
        }
    }
}
