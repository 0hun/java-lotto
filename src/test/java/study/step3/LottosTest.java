package study.step3;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import study.step3.domain.Amount;
import study.step3.domain.LottoFactory;
import study.step3.domain.Lottos;

public class LottosTest {
    @Test
    @DisplayName("금액에 따른 로또 생성 테스트")
    void purchase() {
        // given
        Lottos lottos = LottoFactory.purchase(new Amount(12000));
        // when & then
        assertThat(lottos.getLottos().size()).isEqualTo(12);
    }
}
