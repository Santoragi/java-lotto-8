package lotto.service;

import java.util.List;
import lotto.domain.Lotto;

public interface LottoService {

    List<Lotto> createLottos(int price);
}
