package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.LottoRank;
import lotto.domain.Lotto;
import lotto.util.LottoCountCalculator;
import lotto.util.LottoGenerator;
import lotto.util.validator.BonusNumberValidator;
import lotto.util.validator.NumberValidator;
import lotto.util.validator.PriceValidator;

public class LottoServiceImpl implements LottoService {

    private final LottoCountCalculator lottoCountCalculator;
    private final LottoGenerator lottoGenerator;
    private final PriceValidator priceValidator;
    private final NumberValidator numberValidator;
    private final BonusNumberValidator bonusNumberValidator;

    public LottoServiceImpl(LottoCountCalculator lottoCountCalculator,
                            LottoGenerator lottoGenerator,
                            PriceValidator priceValidator,
                            NumberValidator numberValidator,
                            BonusNumberValidator bonusNumberValidator) {
        this.lottoCountCalculator = lottoCountCalculator;
        this.lottoGenerator = lottoGenerator;
        this.priceValidator = priceValidator;
        this.numberValidator = numberValidator;
        this.bonusNumberValidator = bonusNumberValidator;
    }


    @Override
    public List<Lotto> createLottos(int price) {

        priceValidator.validate(price);

        int count = lottoCountCalculator.calculate(price);
        List<Lotto> lottos = lottoGenerator.generateByCount(count);

        lottos.forEach( lotto -> {
            numberValidator.validate(lotto.getNumbers());
        });

        return lottos;
    }

    @Override
    public List<LottoRank> matchLottos(List<Lotto> lottos, List<Integer> winningNumbers, Integer bonusNumber) {
        lottos.forEach(lotto -> numberValidator.validate(lotto.getNumbers()));
        numberValidator.validate(winningNumbers);
        bonusNumberValidator.validate(winningNumbers, bonusNumber);

        List<LottoRank> lottoResult = new ArrayList<>();
        for(Lotto lotto : lottos) {
            int matchCount = getMatchCount(lotto, winningNumbers);
            boolean matchBonus = isBonusMatched(lotto, bonusNumber);
            addLottoRank(lottoResult, matchCount, matchBonus);
        }

        return lottoResult;
    }

    private int getMatchCount(Lotto lotto, List<Integer> winningNumbers) {
        List<Integer> numbers = lotto.getNumbers();

        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();

    }

    private boolean isBonusMatched(Lotto lotto, Integer bonusNumber) {
        List<Integer> numbers = lotto.getNumbers();

        return numbers.contains(bonusNumber);
    }

    private void addLottoRank(List<LottoRank> lottoResult, int matchCount, boolean matchBonus) {
        if(matchCount == 6) {
            lottoResult.add(LottoRank.FIRST);
        }
        if(matchCount == 5 && matchBonus) {
            lottoResult.add(LottoRank.SECOND);
        }
        if(matchCount == 5 && !matchBonus) {
            lottoResult.add(LottoRank.THIRD);
        }
        if(matchCount == 4) {
            lottoResult.add(LottoRank.FOURTH);
        }
        if(matchCount == 3) {
            lottoResult.add(LottoRank.FIFTH);
        }
    }
}
