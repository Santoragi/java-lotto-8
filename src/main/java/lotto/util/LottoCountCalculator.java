package lotto.util;

import static lotto.constant.LottoConstants.LOTTO_PRICE;

public class LottoCountCalculator {

    public int calculate(int price) {
        return price / LOTTO_PRICE;
    }
}
