package lotto;

import lotto.domain.Lotto;
import java.util.ArrayList;
import java.util.List;
import java.lang.Integer;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        List<Integer> winningNumbers = new ArrayList<>();
        int bonusNumber;
        Input input = new Input();
        input.readPurchaseAmount();
        input.readWinningNumbers();
        input.readBonusNumber();
        winningNumbers = input.getWinningNumbers();
/*
        List<Integer> lottoNumber = new ArrayList<>();
        Lotto lotto = new Lotto(lottoNumber);
        lotto.generate();
        for (int i = 0; i<6; i++) {
            System.out.println(lotto.getLotto().get(i));
        }*/


        // TODO: 프로그램 구현
    }
}
