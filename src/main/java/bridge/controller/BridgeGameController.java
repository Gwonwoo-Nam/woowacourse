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


    public BridgeGameController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        outputView.printStartMessage();
        final int bridgeSize = decideBridgeLength();
        bridgeGame = new BridgeGame(generateBridge(bridgeSize));
        BridgeGameProcessor bridgeGameProcessor = new BridgeGameProcessor(bridgeGame);
        bridgeGameProcessor.crossBridge();
        displayResult();
    }

    private int decideBridgeLength() {
        outputView.printInputBridgeLengthMessage();
        final int bridgeSize = inputView.readBridgeSize();

        return bridgeSize;
    }

    private List<String> generateBridge(int bridgeSize) {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

        final List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        return bridge;
    }


    private void displayResult() {
        int retrialNumber = bridgeGame.getRetrialNumber();
        boolean gameSuccess = bridgeGame.getGameSuccess();
        List<String> userBridge = Collections.unmodifiableList(bridgeGame.getUserBridge());

        outputView.printResult(retrialNumber, gameSuccess, userBridge);
    }
}
