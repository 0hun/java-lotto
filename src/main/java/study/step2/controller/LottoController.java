package study.step2.controller;

import study.step2.domain.LottoPrice;
import study.step2.domain.LottoResult;
import study.step2.domain.Lottos;
import study.step2.domain.WinningLotto;
import study.step2.view.ResultView;

public class LottoController {

  public LottoController() {
  }

  public Lottos createLottos(int money, int manualLottosSize) {
    LottoPrice lottoPrice  = new LottoPrice(money);
    int lottoCount = lottoPrice.lottoCount() - manualLottosSize;

    Lottos lottos = Lottos.makeLottos(lottoCount);

    ResultView.printLottoCount(manualLottosSize, lottos.getLottos().size());

    ResultView.printLottos(lottos);

    return lottos;
  }

  public LottoResult findLottoWinning(Lottos lottos, WinningLotto winningLotto, int money) {
    LottoResult lottoResult = lottos.match(winningLotto);

    ResultView.printLottoResultMessage();

    ResultView.printLottoResult(lottoResult);

    ResultView.printYield(lottoResult, money);

    return lottoResult;
  }

}
