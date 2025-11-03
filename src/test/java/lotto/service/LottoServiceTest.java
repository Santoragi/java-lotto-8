package lotto.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.constant.LottoRank;
import lotto.domain.Lotto;
import lotto.util.LottoCountCalculator;
import lotto.util.LottoGenerator;
import lotto.util.validator.BonusNumberValidator;
import lotto.util.validator.NumberValidator;
import lotto.util.validator.PriceValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {

    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoServiceImpl(new LottoCountCalculator(),
                new LottoGenerator(),
                new PriceValidator(),
                new NumberValidator(),
                new BonusNumberValidator());
    }

    @Test
    @DisplayName("로또를 가격에 맞는 개수로 발행")
    void 로또_발행() {
        int price = 5000;

        assertEquals(5, lottoService.createLottos(price).size());
    }

    @Test
    @DisplayName("로또 1등 당첨을 올바르게 계산")
    void 로또_1등_당첨() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Lotto> lottos = List.of(lotto);

        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 7;

        Map<LottoRank, Integer> lottoResult = lottoService.matchLottos(lottos, winningNumbers, bonusNumber);
        assertThat(lottoResult.get(LottoRank.FIRST)).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 2등 당첨을 올바르게 계산")
    void 로또_2등_당첨() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Lotto> lottos = List.of(lotto);

        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 45);
        Integer bonusNumber = 6;

        Map<LottoRank, Integer> lottoResult = lottoService.matchLottos(lottos, winningNumbers, bonusNumber);
        assertThat(lottoResult.get(LottoRank.SECOND)).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 3등 당첨을 올바르게 계산")
    void 로또_3등_당첨() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Lotto> lottos = List.of(lotto);

        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 45);
        Integer bonusNumber = 7;

        Map<LottoRank, Integer> lottoResult = lottoService.matchLottos(lottos, winningNumbers, bonusNumber);
        assertThat(lottoResult.get(LottoRank.THIRD)).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 4등 당첨을 올바르게 계산")
    void 로또_4등_당첨() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Lotto> lottos = List.of(lotto);

        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 44, 45);
        Integer bonusNumber = 7;

        Map<LottoRank, Integer> lottoResult = lottoService.matchLottos(lottos, winningNumbers, bonusNumber);
        assertThat(lottoResult.get(LottoRank.FOURTH)).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 5등 당첨을 올바르게 계산")
    void 로또_5등_당첨() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Lotto> lottos = List.of(lotto);

        List<Integer> winningNumbers = List.of(1, 2, 3, 43, 44, 45);
        Integer bonusNumber = 7;

        Map<LottoRank, Integer> lottoResult = lottoService.matchLottos(lottos, winningNumbers, bonusNumber);
        assertThat(lottoResult.get(LottoRank.FIFTH)).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 수익률을 올바르게 계산")
    void 로또_수익률_계산() {
        Map<LottoRank, Integer> lottoResult = new EnumMap<>(LottoRank.class);
        lottoResult.put(LottoRank.FIFTH, 1);
        int price = 8000;

        assertThat(lottoService.calculateRateOfReturn(lottoResult, price)).isEqualTo(62.5f);
    }
}
