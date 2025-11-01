package lotto.util.parser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberParser {

    public List<Integer> parse(String input) {
        try {
            return Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("당첨 번호는 정수를 쉼표(,)로 구분하여 입력해야 합니다.");
        }
    }
}
