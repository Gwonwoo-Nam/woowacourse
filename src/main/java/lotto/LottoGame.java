package lotto;

import lotto.domain.*;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;
    private static int lottoCount;
    private static List<Integer> winningNumbers;

    public void play() {
        LottoManager lottoManager = new LottoManager();
        lottoManager.readPurchaseAmount();
        lottoCount = lottoManager.getLottoCount();
        //개수만큼 로또 생성
        Lotto[] lotto = new Lotto[lottoCount];
        generateLotto(lottoCount, lotto);
        //winning number 저장
        lottoManager.readWinningNumbers();
        lottoManager.readBonusNumber();
        winningNumbers = lottoManager.getWinningNumbers();
        // Lotto 정답 비교
        LottoRank[] rankBoard = getRankBoard(lotto);
        // Lotto Rank 출력
        showLottoRankBoard(rankBoard);
        showLottoProfitResult(lottoCount, rankBoard);
    }

    private static LottoRank[] getRankBoard(Lotto[] lotto) {
        LottoRank[] rankBoard = LottoRank.values();
        for (int currentCount = 0; currentCount < lottoCount; currentCount++) {
            WinningCounter winningCounter = new WinningCounter();
            winningCounter.countWinning(lotto[currentCount].getLottoNumbers(), winningNumbers);
            updateRankBoard(rankBoard, winningCounter);
        }
        return rankBoard;
    }

    private static void updateRankBoard(LottoRank[] rankBoard, WinningCounter winningCounter) {
        int normalCount = winningCounter.getNormal_count();
        int bonusCount = winningCounter.getBonus_count();
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
            lottoNumberGenerator.generate();
            lottoNumberGenerator.sortAscending();
            lottoNumber = lottoNumberGenerator.getNumbers();
            lotto[currentCount] = new Lotto(lottoNumber);
            lottoPrinter.printLottoNumbers(lottoNumber);
        }
    }
}

