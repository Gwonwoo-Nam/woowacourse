package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeGame;
import bridge.model.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.Collections;
import java.util.List;

public class BridgeGameController {
    public void run () {
        /**
         * 게임 시작 메시지
         */
        startGame();
        OutputView outputView = new OutputView();
        /**
         * Bridge 입력 메시지 출력과, Bridge Length를 입력받는다.
         */
        final int bridgeSize = getBridgeLength();
        /**
         * Bridge 정답 배열을 생성하여 bridgeGame 객체에 저장한다.
         */
        BridgeGame bridgeGame = new BridgeGame(generateBridge(bridgeSize));

        String userBridgeType;

        while (bridgeGame.getBridgeIndex() < bridgeSize) {
            /**
             * 이동할 칸을 User로부터 입력받는다.
             */
            userBridgeType = getInputMove();
            /**
             * 정답 칸으로 움직인 경우
             */

            if (makeCorrectMove(bridgeGame, userBridgeType)) {
                continue;
            }
            /**
             * 오답 칸으로 움직인 경우
             */
            String gameCommand = makeWrongMove(bridgeGame, userBridgeType);
            /**
             * Game을 Quit하는 경우
             */
            if (gameCommand.equals("Q")) {
                outputView.printResult(bridgeGame.getRetrialNumber(), false, Collections.unmodifiableList(bridgeGame.getUserBridge()));
                return ;
            }
            /**
             * Game을 Retry하는 경우
             */
            bridgeGame.retry(userBridgeType);
        }
        /**
         * 최종 결과 출력
         */
        outputView.printResult(bridgeGame.getRetrialNumber(), true, Collections.unmodifiableList(bridgeGame.getUserBridge()));

    }

    private boolean makeCorrectMove(BridgeGame bridgeGame, String userBridgeType) {
        OutputView outputView = new OutputView();

        if (bridgeGame.move(userBridgeType)) {
            outputView.printMap(bridgeGame.getUserBridge());
            return true;
        }
        return false;
    }

    private static String makeWrongMove(BridgeGame bridgeGame, String userBridgeType) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();

        bridgeGame.moveFail(userBridgeType);
        outputView.printMap(Collections.unmodifiableList(bridgeGame.getUserBridge()));
        outputView.printInputRetrialMessage();
        String gameCommand = inputView.readGameCommand();
        return gameCommand;
    }

    private List<String> generateBridge (int bridgeSize) {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

        final List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        return bridge;
    }

    private int getBridgeLength() {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();

        outputView.printInputBridgeLengthMessage();
        final int bridgeSize = inputView.readBridgeSize();

        return bridgeSize;
    }

    private void startGame() {
        OutputView outputView = new OutputView();
        outputView.printStartMessage();
    }

    private String getInputMove() {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();

        outputView.printInputMoveMessage();
        String userBridgeType = inputView.readMoving();

        return userBridgeType;
    }

}
