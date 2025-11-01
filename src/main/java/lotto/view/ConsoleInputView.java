package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputView implements InputView {

    private static final String PRICE_MESSAGE = "구입금액을 입력해 주세요.";

    @Override
    public String getPrice() {
        System.out.println(PRICE_MESSAGE);
        return Console.readLine();
    }
}
