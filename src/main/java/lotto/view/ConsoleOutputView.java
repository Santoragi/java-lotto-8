package lotto.view;

public class ConsoleOutputView implements OutputView{

    private static final String LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";

    @Override
    public void printLottoCount(int count) {
        System.out.println(count + LOTTO_COUNT_MESSAGE);
    }
}
