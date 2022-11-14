package lotto;

import lotto.domain.*;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    public void play() {

        int lottoCount;
        LottoManager lottoManager = new LottoManager();
        lottoManager.readPurchaseAmount();
        lottoCount = lottoManager.getLottoCount();
        Lotto[] lotto = new Lotto[lottoCount];
        LottoPrinter lottoPrinter = new LottoPrinter();
        for (int currentCount = 0; currentCount < lottoCount; currentCount++) {
            List<Integer> lottoNumber;
            LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
            lottoNumberGenerator.generate();
            lottoNumberGenerator.sortAscending();
            lottoNumber = lottoNumberGenerator.getNumbers();
            lotto[currentCount] = new Lotto(lottoNumber);

            lottoPrinter.printLottoNumbers(lottoNumber);
        }
        //winning number 저장
        List<Integer> winningNumbers = new ArrayList<>();
        lottoManager.readWinningNumbers();
        lottoManager.readBonusNumber();
        winningNumbers = lottoManager.getWinningNumbers();

        // Lotto 정답 비교
        LottoRank[] values = LottoRank.values();
        for (int currentCount = 0; currentCount < lottoCount; currentCount++) {
            WinningCounter winningCounter = new WinningCounter();
            winningCounter.countWinning(lotto[currentCount].getLottoNumbers(), winningNumbers);
            int normalCount = winningCounter.getNormal_count();
            int bonusCount = winningCounter.getBonus_count();

            for (LottoRank rank : values) {
                if (rank.checkThirdPlace(normalCount, bonusCount)) {
                    break;
                }
                rank.findMatchingRank(normalCount);
            }

        }
        // Lotto Rank 출력
        for (LottoRank rank : values) {
            lottoPrinter.printWinningResult(rank);
        }
        ProfitManager profitManager = new ProfitManager();
        for (LottoRank rank : values) {
            profitManager.sumEarning(rank);
        }
        double totalProfit = profitManager.calculate(lottoManager.getPurchaseAmount());
        lottoPrinter.printProfit(totalProfit);
    }
}

