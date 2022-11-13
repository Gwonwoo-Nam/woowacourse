package lotto;

import lotto.domain.Lotto;
import java.util.ArrayList;
import java.util.List;
import java.lang.Integer;
import camp.nextstep.edu.missionutils.Console;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.LottoRank;
import lotto.domain.WinningCounter;

public class Application {
    public static void main(String[] args) {
        int lottoCount;
        LottoManager lottoManager = new LottoManager();
        lottoManager.readPurchaseAmount();
        lottoCount = lottoManager.getLottoCount();
        Lotto[] lotto = new Lotto[lottoCount];
        for (int currentCount = 0; currentCount < lottoCount; currentCount++) {
            List<Integer> lottoNumber;
            LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
            lottoNumberGenerator.generate();
            lottoNumberGenerator.sortAscending();
            lottoNumber = lottoNumberGenerator.getNumbers();
            lotto[currentCount] = new Lotto(lottoNumber);
            LottoPrinter lottoPrinter = new LottoPrinter();
            lottoPrinter.printLottoNumbers(lottoNumber);
        }
        //winning number 저장
        List<Integer> winningNumbers = new ArrayList<>();
        lottoManager.readWinningNumbers();
        lottoManager.readBonusNumber();
        winningNumbers = lottoManager.getWinningNumbers();

        // Lotto 정답 비교
        for (int currentCount = 0; currentCount < lottoCount; currentCount++) {
            WinningCounter winningCounter = new WinningCounter();
            winningCounter.countWinning(lotto[currentCount].getLottoNumbers(), winningNumbers);
            System.out.println("Bonus Count : "+winningCounter.getBonus_count());
            System.out.println("normal Count : "+winningCounter.getNormal_count());
        }

        // TODO: 프로그램 구현
    }
}
