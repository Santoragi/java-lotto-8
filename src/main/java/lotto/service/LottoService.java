package lotto.service;

import java.util.List;
import lotto.constant.LottoRank;
import lotto.domain.Lotto;

public interface LottoService {

    List<Lotto> createLottos(int price);
    List<LottoRank> matchLottos(List<Lotto> lottos, List<Integer> winningNumbers, Integer bonusNumber);
    float calculateRateOfReturn(List<LottoRank> lottoResult, int price);
}
