package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.service.LottoServiceImpl;
import lotto.util.LottoCountCalculator;
import lotto.util.LottoGenerator;
import lotto.util.validator.BonusNumberValidator;
import lotto.util.validator.NumberValidator;
import lotto.util.validator.PriceValidator;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {

        LottoCountCalculator lottoCountCalculator = new LottoCountCalculator();
        LottoGenerator lottoGenerator = new LottoGenerator();
        PriceValidator priceValidator = new PriceValidator();
        NumberValidator numberValidator = new NumberValidator();
        BonusNumberValidator bonusNumberValidator = new BonusNumberValidator();
        LottoService lottoService = new LottoServiceImpl(
                lottoCountCalculator,
                lottoGenerator,
                priceValidator,
                numberValidator,
                bonusNumberValidator
        );

        InputView inputView = new ConsoleInputView();
        OutputView outputView = new ConsoleOutputView();
        LottoController lottoController = new LottoController(
                inputView,
                outputView,
                lottoService
        );

        try{
            lottoController.run();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
