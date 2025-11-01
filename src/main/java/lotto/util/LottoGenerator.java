package lotto.util;

import static lotto.constant.LottoConstants.LOTTO_NUMBER_COUNT;
import static lotto.constant.LottoConstants.MAX_NUMBER;
import static lotto.constant.LottoConstants.MIN_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.Lotto;

public class LottoGenerator {

    public List<Lotto> generateByCount(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> generate())
                .toList();
    }

    private Lotto generate() {
        List<Integer> numbers = generateLottoNumbers();
        return new Lotto(numbers);
    }

    private List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_NUMBER_COUNT);
    }
}
