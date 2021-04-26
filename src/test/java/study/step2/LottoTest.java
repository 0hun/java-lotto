package study.step2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.TreeSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step2.domain.Lotto;
import study.step2.domain.LottoMachine;
import study.step2.domain.LottoNumber;

public class LottoTest {

  @DisplayName("번호를 입력 했을때, lotto 객체를 생성하는지 테스트")
  @Test
  void createLotto() {
    // given
    LottoNumber pickedLottoNumbers = new LottoNumber(LottoMachine.pick());

    // when
    Lotto lotto = new Lotto(pickedLottoNumbers);

    // then
    assertThat(lotto).isEqualTo(new Lotto(pickedLottoNumbers));
  }

  @DisplayName("번호를 입력하지 않았을 때, 로또 번호가 없는 빈 lotto 객체 생성")
  @Test
  void createLottoFail() {
    // given
    LottoNumber pickedLottoNumbers = new LottoNumber(new TreeSet<>());

    // when
    Lotto lotto = new Lotto(pickedLottoNumbers);

    // then
    assertThat(lotto).isEqualTo(new Lotto(pickedLottoNumbers));
  }

  @DisplayName("당첨 번호와 로또 번호가 몇개 맞는지 테스트")
  @Test
  void lottoNumberMatch() {
    // given
    LottoNumber winningLottoNumbers = new LottoNumber(new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
    LottoNumber pickedLottoNumbers = new LottoNumber(new TreeSet<>(Arrays.asList(1, 2, 3, 12, 15, 16)));

    // when
    Lotto lotto = new Lotto(pickedLottoNumbers);

    // then
    assertThat(lotto.matchCount(winningLottoNumbers)).isEqualTo(3);
  }

  @DisplayName("당첨 번호와 로또 번호가 맞지 않는지 테스트")
  @Test
  void lottoNumberMatchFail() {
    // given
    LottoNumber winningLottoNumbers = new LottoNumber(new TreeSet<>(Arrays.asList(10, 11, 17, 18, 19, 20)));
    LottoNumber pickedLottoNumbers = new LottoNumber(new TreeSet<>(Arrays.asList(1, 2, 3, 12, 15, 16)));

    // when
    Lotto lotto = new Lotto(pickedLottoNumbers);

    // then
    assertThat(lotto.matchCount(winningLottoNumbers)).isEqualTo(0);
  }

}
