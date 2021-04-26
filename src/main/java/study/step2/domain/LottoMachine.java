package study.step2.domain;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

  private static final int LOTTO_MIN_NUMBER = 1;
  private static final int LOTTO_MAX_NUMBER = 45;
  private static final int LOTTO_START_RANGE_NUMBER = 0;
  private static final int LOTTO_END_RANGE_NUMBER = 6;

  private static final List<Integer> lottoNumbers = IntStream
      .rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
      .boxed()
      .collect(Collectors.toList());

  private LottoMachine() {
  }

  public static Set<Integer> pick() {
    Collections.shuffle(lottoNumbers);

    return new TreeSet<>(lottoNumbers.subList(LOTTO_START_RANGE_NUMBER, LOTTO_END_RANGE_NUMBER));
  }

}
