package lotto.view;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import lotto.constant.LottoRank;
import lotto.domain.Lotto;

public class ConsoleOutputView implements OutputView{

    private static final String LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String LOTTO_RESULT_MESSAGE = "당첨 통계\n---";
    private static final LottoRank[] LOTTO_RESULT_ORDER = {
            LottoRank.FIFTH,
            LottoRank.FOURTH,
            LottoRank.THIRD,
            LottoRank.SECOND,
            LottoRank.FIRST
    };
    private static final String LOTTO_RATE_MESSAGE = "총 수익률은 %,.1f%%입니다.";

    @Override
    public void printLottoCount(int count) {
        System.out.println();
        System.out.println(count + LOTTO_COUNT_MESSAGE);
    }

    @Override
    public void printLottoNumbers(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.toString()));
    }

    @Override
    public void printLottoResult(Map<LottoRank, Integer> lottoResult) {
        System.out.println(LOTTO_RESULT_MESSAGE);
        for(LottoRank rank : LOTTO_RESULT_ORDER) {
            String rankMessage = getRankMessage(rank);
            int count = lottoResult.getOrDefault(rank, 0);

            System.out.println(rankMessage + " - " + count + "개");
        }
    }

    @Override
    public void printLottoRate(double rate) {
        System.out.printf(LOTTO_RATE_MESSAGE, rate);
    }

    private String getRankMessage(LottoRank rank) {
        String matchMessage;
        int matchCount = rank.getMatchCount();
        boolean matchBonus = rank.getMatchBonus();

        matchMessage = matchCount + "개 일치";
        if (matchCount == 5 && matchBonus) {
            matchMessage = matchCount + "개 일치, 보너스 볼 일치";
        }

        NumberFormat nf = NumberFormat.getInstance(Locale.KOREA);
        String prizeMessage = " (" + nf.format(rank.getPrize()) + "원)";

        return matchMessage + prizeMessage;
    }
}
