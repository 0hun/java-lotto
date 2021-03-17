package study.lotto.view;

import study.lotto.exception.LottoException;
import study.lotto.view.dto.RequestMoney;
import study.lotto.view.dto.RequestWinningNumber;

import java.util.Objects;
import java.util.Scanner;

public class InputView {

    public static final String GUIDE_LAST_WEEK_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String GUIDE_PURCHASE_MONEY = "구입금액을 입력해 주세요.";
    public static final String GUIDE_NOT_FOUND_MONEY = "금액을 지불하셔야 합니다.";
    public static final String GUIDE_PURCHASE_LOTTO = "로또를 구매할 수 없습니다.";
    public static final int LOTTO_PRICE = 1000;

    private static final Scanner in = new Scanner(System.in);

    public static RequestMoney requestMoney() {
        System.out.println(GUIDE_PURCHASE_MONEY);
        final String inputMoney = in.nextLine();

        if(isNotNullAndIsBlank(inputMoney)) {
            throw new LottoException(GUIDE_NOT_FOUND_MONEY);
        }
        if(isCanNotBuyLotto(inputMoney)) {
            throw new LottoException(GUIDE_PURCHASE_LOTTO);
        }
        final int money = Integer.parseInt(inputMoney);
        return new RequestMoney(money);
    }

    private static boolean isNotNullAndIsBlank(final String inputMoney) {
        return Objects.isNull(inputMoney) || inputMoney.isEmpty();
    }

    private static boolean isCanNotBuyLotto(final String input) {
        return !isNumeric(input) || isLackOfMoney(input);
    }

    private static boolean isLackOfMoney(final String inputMoney) {
        return Integer.parseInt(inputMoney) < LOTTO_PRICE;
    }

    public static boolean isNumeric(final String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public RequestWinningNumber requestWinningNumber() {
        System.out.println(GUIDE_LAST_WEEK_WINNING_NUMBER);
        final String inputWinningNumber = in.nextLine();

        return new RequestWinningNumber(inputWinningNumber);
    }
}