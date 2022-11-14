package lotto;

import lotto.domain.*;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    public void play() {
        //구매 금액 입력
        LottoManager lottoManager = new LottoManager();
        lottoManager.readPurchaseAmount();
        //개수만큼 로또 생성
        int lottoCount;
        lottoCount = lottoManager.getLottoCount();
        Lotto[] lotto = new Lotto[lottoCount];
        generateLotto(lottoCount, lotto);
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
        LottoPrinter lottoPrinter = new LottoPrinter();
        lottoPrinter.printStatisticMessage();
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

    private static void generateLotto(int lottoCount, Lotto[] lotto) {
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
    }
}

