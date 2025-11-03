package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.constant.LottoRank;
import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.util.LottoCountCalculator;
import lotto.util.parser.NumberParser;
import lotto.util.parser.PriceParser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;
    private NumberParser numberParser = new NumberParser();
    private PriceParser priceParser = new PriceParser();
    private LottoCountCalculator lottoCountCalculator = new LottoCountCalculator();

    public LottoController(InputView inputView,
                           OutputView outputView,
                           LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        int price = priceParser.parse(inputView.getPrice());
        int count = lottoCountCalculator.calculate(price);
        outputView.printLottoCount(count);

        List<Lotto> lottos = lottoService.createLottos(price);
        outputView.printLottoNumbers(lottos);

        List<Integer> winningNumbers = numberParser.parseNumbers(inputView.getWinningNumbers());
        Integer bonusNumber = numberParser.parseNumber(inputView.getBonusNumber());
        Map<LottoRank, Integer> lottoResult = lottoService.matchLottos(lottos, winningNumbers, bonusNumber);
        outputView.printLottoResult(lottoResult);

        double rate = lottoService.calculateRateOfReturn(lottoResult, price);
        outputView.printLottoRate(rate);
    }

}
