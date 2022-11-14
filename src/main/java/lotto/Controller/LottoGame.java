package lotto.Controller;

import lotto.domain.*;
import lotto.UI.LottoManager;
import lotto.UI.LottoPrinter;

import java.util.List;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;
    private static int lottoCount;
    private static List<Integer> winningNumbers;

    public void play() {
        LottoManager lottoManager = new LottoManager();
        lottoManager.readPurchaseAmount();
        lottoCount = lottoManager.getLottoCount();
        Lotto[] lotto = new Lotto[lottoCount];
        generateLotto(lottoCount, lotto);
        lottoManager.readWinningNumbers();
        lottoManager.readBonusNumber();
        winningNumbers = lottoManager.getWinningNumbers();
        LottoRank[] rankBoard = getRankBoard(lotto);
        showLottoRankBoard(rankBoard);
        showLottoProfitResult(lottoCount, rankBoard);
    }

    private static LottoRank[] getRankBoard(Lotto[] lotto) {
        LottoRank[] rankBoard = LottoRank.values();
        for (int currentCount = 0; currentCount < lottoCount; currentCount++) {
            WinningCounter winningCounter = new WinningCounter();
            int normalCount = winningCounter.countWinningNormal(lotto[currentCount].getLottoNumbers(), winningNumbers);
            int bonusCount = winningCounter.countWinningBonus(lotto[currentCount].getLottoNumbers(), winningNumbers);
            updateRankBoard(rankBoard, winningCounter, normalCount, bonusCount);
        }
        return rankBoard;
    }

    private static void updateRankBoard(LottoRank[] rankBoard, WinningCounter winningCounter, int normalCount, int bonusCount) {
        for (LottoRank rank : rankBoard) {
            if (rank.checkThirdPlace(normalCount, bonusCount)) {
                break;
            }
            rank.findMatchingRank(normalCount);
        }
    }

    private static LottoPrinter showLottoRankBoard(LottoRank[] values) {
        LottoPrinter lottoPrinter = new LottoPrinter();
        lottoPrinter.printStatisticMessage();
        for (LottoRank rank : values) {
            lottoPrinter.printWinningResult(rank);
        }
        return lottoPrinter;
    }

    private static void showLottoProfitResult(int lottoCount, LottoRank[] values) {
        LottoPrinter lottoPrinter = new LottoPrinter();
        ProfitManager profitManager = new ProfitManager();
        for (LottoRank rank : values) {
            profitManager.sumEarning(rank);
        }
        int purchaseAmount = lottoCount * LOTTO_PRICE;
        double totalProfit = profitManager.calculate(purchaseAmount);
        lottoPrinter.printProfit(totalProfit);
    }

    private static void generateLotto(int lottoCount, Lotto[] lotto) {
        LottoPrinter lottoPrinter = new LottoPrinter();
        for (int currentCount = 0; currentCount < lottoCount; currentCount++) {
            List<Integer> lottoNumber;
            LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
            lottoNumber = lottoNumberGenerator.generate();
            lottoNumber = lottoNumberGenerator.sortAscending(lottoNumber);
            lotto[currentCount] = new Lotto(lottoNumber);
            lottoPrinter.printLottoNumbers(lottoNumber);
        }
    }
}

