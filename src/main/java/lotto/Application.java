package lotto;

import lotto.domain.Lotto;
import java.util.ArrayList;
import java.util.List;
import java.lang.Integer;
import camp.nextstep.edu.missionutils.Console;
import lotto.domain.LottoNumberGenerator;

public class Application {
    public static void main(String[] args) {
        List<Integer> winningNumbers = new ArrayList<>();
        int bonusNumber;
        Input input = new Input();
        input.readPurchaseAmount();
        input.readWinningNumbers();
        input.readBonusNumber();
        winningNumbers = input.getWinningNumbers();

        List<Integer> lottoNumber = new ArrayList<>();
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        lottoNumberGenerator.generate();
        lottoNumberGenerator.sortAscending();
        lottoNumber = lottoNumberGenerator.getNumbers();

        Lotto lotto = new Lotto(lottoNumber);
        for (int i = 0; i<6; i++) {
            System.out.println(lotto.getLottoNumbers().get(i));
        }


        // TODO: 프로그램 구현
    }
}
