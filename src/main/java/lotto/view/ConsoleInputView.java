package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputView implements InputView {

    @Override
    public int getPrice() {
        String input = Console.readLine();
        //TODO: 구입 금액 검증 로직
        int price = Integer.parseInt(input);

        return price;
    }
}
