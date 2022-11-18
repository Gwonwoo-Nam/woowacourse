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
        startGame();

        final int bridgeSize = getBridgeLength();

        BridgeGame bridgeGame = new BridgeGame(generateBridge(bridgeSize));

        String userBridgeType;

        while (bridgeGame.getBridgeIndex() < bridgeSize) {
            userBridgeType = getInputMove();

            if (makeCorrectMove(bridgeGame, userBridgeType)) {
                continue;
            }

            String gameCommand = makeWrongMove(bridgeGame, userBridgeType);

            if (isQuit(gameCommand)) {
                showResult(bridgeGame, false);
                return ;
            }
            bridgeGame.retry(userBridgeType);
        }
        showResult(bridgeGame, true);
    }



    private void startGame() {
        OutputView outputView = new OutputView();
        outputView.printStartMessage();
    }

    private int getBridgeLength() {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();

        outputView.printInputBridgeLengthMessage();
        final int bridgeSize = inputView.readBridgeSize();

        return bridgeSize;
    }
    private List<String> generateBridge (int bridgeSize) {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

        final List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        return bridge;
    }

    private String getInputMove() {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();

        outputView.printInputMoveMessage();
        String userBridgeType = inputView.readMoving();

        return userBridgeType;
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
    private boolean isQuit(String gameCommand) {
        boolean isQuit = gameCommand.equals("Q");

        return isQuit;
    }


    private static void showResult(BridgeGame bridgeGame, boolean isSuccess) {
        OutputView outputView = new OutputView();

        int retrialNumber = bridgeGame.getRetrialNumber();
        List<String> userBridge = Collections.unmodifiableList(bridgeGame.getUserBridge());

        outputView.printResult(retrialNumber, isSuccess, userBridge);
    }

}
