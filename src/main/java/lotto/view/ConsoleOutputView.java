package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class ConsoleOutputView implements OutputView{

    private static final String LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";

    @Override
    public void printLottoCount(int count) {
        System.out.println();
        System.out.println(count + LOTTO_COUNT_MESSAGE);
    }

    @Override
    public void printLottoNumbers(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.toString()));
    }
}
