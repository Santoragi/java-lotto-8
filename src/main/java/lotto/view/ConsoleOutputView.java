package lotto.view;

import lotto.domain.Lotto;

public class ConsoleOutputView implements OutputView{

    private static final String LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";

    @Override
    public void printLottoCount(int count) {
        System.out.println(count + LOTTO_COUNT_MESSAGE);
    }

    @Override
    public void printLottoNumber(Lotto lotto) {
        System.out.println(lotto.toString());
    }
}
