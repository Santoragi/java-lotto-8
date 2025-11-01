package lotto.util.parser;

public class PriceParser {

    public int parse(String input) {
        try {
            int price = Integer.parseInt(input);
            return price;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구입 금액은 정수로 입력해야합니다.");
        }
    }
}
