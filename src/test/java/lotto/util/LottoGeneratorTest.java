package lotto.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {

    private LottoGenerator lottoGenerator;

    @BeforeEach
    void setUp() {
        lottoGenerator = new LottoGenerator();
    }

    @Test
    @DisplayName("입력된 로또 개수 만큼 로또를 생성")
    void 로또_생성() {

        int count = 5;

        List<Lotto> lottos = lottoGenerator.generateByCount(count);

        assertEquals(count, lottos.size());
    }
}
