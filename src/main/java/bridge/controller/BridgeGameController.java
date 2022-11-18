package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeGame;
import bridge.model.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.Collections;
import java.util.List;

public class BridgeGameController {
    private InputView inputView;
    private OutputView outputView;
    private BridgeGame bridgeGame;
    public BridgeGameController () {
        inputView = new InputView();
        outputView = new OutputView();
    }
    public void run () {
        startGame();
        final int bridgeSize = getBridgeLength(); // decideBridgeSize
        bridgeGame = new BridgeGame(generateBridge(bridgeSize)); //generateBridge
        boolean isSuccess = playGame(); //playGame
        displayResult(isSuccess);
    }

    private boolean playGame () {
        String userBridgeType;
        while (bridgeGame.getBridgeIndex() < bridgeGame.getBridgeSize()) {
            userBridgeType = getInputMove();
            if (makeCorrectMove(userBridgeType)) {
                continue;
            }

            String gameCommand = makeWrongMove(userBridgeType);
            if (isQuit(gameCommand)) {
                return false;
            }
            bridgeGame.retry(userBridgeType);
        }
        return true;
    }

    private void startGame() {
        outputView.printStartMessage();
    }

    private int getBridgeLength() {
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
        outputView.printInputMoveMessage();
        String userBridgeType = inputView.readMoving();

        return userBridgeType;
    }
    private boolean makeCorrectMove(String userBridgeType) {
        if (bridgeGame.move(userBridgeType)) {
            outputView.printMap(bridgeGame.getUserBridge());
            return true;
        }
        return false;
    }

    private String makeWrongMove(String userBridgeType) {
        //bridgeGame.moveFail(userBridgeType);
        outputView.printMap(Collections.unmodifiableList(bridgeGame.getUserBridge()));
        outputView.printInputRetrialMessage();
        String gameCommand = inputView.readGameCommand();
        return gameCommand;
    }
    private boolean isQuit(String gameCommand) {
        boolean isQuit = gameCommand.equals("Q");

        return isQuit;
    }


    private void displayResult(boolean isSuccess) {
        int retrialNumber = bridgeGame.getRetrialNumber();
        List<String> userBridge = Collections.unmodifiableList(bridgeGame.getUserBridge());

        outputView.printResult(retrialNumber, isSuccess, userBridge);
    }

}
