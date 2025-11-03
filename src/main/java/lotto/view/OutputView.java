package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.constant.LottoRank;
import lotto.domain.Lotto;

public interface OutputView {

    void printLottoCount(int count);
    void printLottoNumbers(List<Lotto> lotto);
    void printLottoResult(Map<LottoRank, Integer> lottoResult);
}
