package lotto.service;

import java.util.List;
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
}
