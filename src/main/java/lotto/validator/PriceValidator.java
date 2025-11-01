package lotto.validator;

import static lotto.constant.LottoConstants.LOTTO_PRICE;

public class PriceValidator {

    private static final int MIN_PRICE = 1000;
    private static final int MAX_PRICE = 100000;

    public void validate(int price) {
        validateMinPrice(price);
        validateMaxPrice(price);
        validateDivisibleByLottoPrice(price);
    }

    private void validateMinPrice(int price) {
        if(price < MIN_PRICE) {
            throw new IllegalArgumentException("최소 구입 금액은 1000원입니다.");

        }
    }

    private void validateMaxPrice(int price) {
        if(price > MAX_PRICE) {
            throw new IllegalArgumentException("로또는 최대 10만원까지 구매 가능합니다.");
        }
    }

    private void validateDivisibleByLottoPrice(int price) {
        if(price % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("구매 금액은 로또 한 장의 가격(1000원)으로 나누어 떨어져야합니다.");
        }
    }
}
