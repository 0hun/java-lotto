package study.step2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step2.controller.LottoController;
import study.step2.domain.Lotto;
import study.step2.domain.LottoNumber;
import study.step2.domain.LottoResult;
import study.step2.domain.Lottos;
import study.step2.domain.Rank;

public class LottoControllerTest {

  @DisplayName("구매 금액을 입력 후 복권의 수 만큼  lottos 객체를 셍성하는지 테스트")
  @Test
  void createLottos() {
    // given
    int money = 3000;
    int lottoCount = 3;
    LottoController lottoController = new LottoController();

    // when
    Lottos lottos = lottoController.createLottos(money);

    // then
    assertThat(lottos.getLottos().size()).isEqualTo(lottoCount);
  }

  @DisplayName("구매 금액을 0으로 입력했을 때, lottos 객체 크기가 0인지 테스트")
  @Test
  void createLottosFail() {
    // given
    int money = 0;
    int lottoCount = 0;
    LottoController lottoController = new LottoController();

    // when
    Lottos lottos = lottoController.createLottos(money);

    // then
    assertThat(lottos.getLottos().size()).isEqualTo(lottoCount);
  }

  @DisplayName("구매 금액, 로또 번호와 당첨 금액을 입력했을때, 당첨 결과가 null이 아닌지 테스트")
  @Test
  void findLottoWinning() {
    // given
    int money = 1000;
    LottoNumber bonusNumber = new LottoNumber(16);

    String pickedLottoNumbers = "1, 2, 3, 12, 15, 16";

    Lotto lotto = new Lotto(pickedLottoNumbers);
    Lottos lottos = new Lottos(new ArrayList<>(Arrays.asList(new Lotto(pickedLottoNumbers))));

    LottoController lottoController = new LottoController();

    // when
    LottoResult lottoResult = lottoController.findLottoWinning(lottos, lotto, money, bonusNumber);

    // then
    assertThat(lottoResult).isNotNull();
  }

  @DisplayName("번호를 다 맞췄을 때, 1등인지 테스트")
  @Test
  void findLottoWinningFirst() {
    // given
    int money = 1000;
    LottoNumber bonusNumber = new LottoNumber(16);

    String pickedLottoNumbers = "1, 2, 3, 12, 15, 16";

    Lotto lotto = new Lotto(pickedLottoNumbers);
    Lottos lottos = new Lottos(new ArrayList<>(Arrays.asList(new Lotto(pickedLottoNumbers))));

    LottoController lottoController = new LottoController();

    // when
    LottoResult lottoResult = lottoController.findLottoWinning(lottos, lotto, money, bonusNumber);

    // then
    assertThat(lottoResult.getValue(Rank.FIRST)).isEqualTo(1);
  }

  @DisplayName("번호를 5개 맞추고 보너스 번호까지 맞췄을 경우 2등인지 테스트")
  @Test
  void findLottoWinningSecondWithBonus() {
    // given
    int money = 1000;

    String pickedLottoNumbers = "1, 2, 3, 12, 15, 16";
    String winingLottoNumbers = "1, 2, 3, 12, 15, 19";

    LottoNumber bonusNumber = new LottoNumber(16);

    Lotto lotto = new Lotto(winingLottoNumbers);
    Lottos lottos = new Lottos(new ArrayList<>(Arrays.asList(new Lotto(pickedLottoNumbers))));

    LottoController lottoController = new LottoController();

    // when
    LottoResult lottoResult = lottoController.findLottoWinning(lottos, lotto, money, bonusNumber);

    // then
    assertThat(lottoResult.getValue(Rank.SECOND)).isEqualTo(1);
  }

}
