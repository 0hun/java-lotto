package study.step2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step2.validator.Validator;

public class ValidatorTest {

  @DisplayName("1000원을 입력했을 때, validator 통과하는지 테스트")
  @Test
  void validatorMoneySuccess() {
    // given
    int money = 1000;

    // when
    Throwable thrown = catchThrowable(() -> {
      Validator.validatorMoney(money);
    });

    // then
    assertThat(thrown).isEqualTo(null);
  }

  @DisplayName("900원을 입력했을 때, 에러가 발생하는지 테스트")
  @Test
  void validatorMoneyFail() {
    // given
    int money = 900;

    // when
    Throwable thrown = catchThrowable(() -> {
      Validator.validatorMoney(money);
    });

    // then
    assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
  }

}
