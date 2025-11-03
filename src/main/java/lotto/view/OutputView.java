package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public interface OutputView {

    void printLottoCount(int count);
    void printLottoNumbers(List<Lotto> lotto);
}
