package bridge.controller;

import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.Collections;

public class BridgeGameProcessor {

    private BridgeGame bridgeGame;
    private OutputView outputView = new OutputView();
    private InputView inputView = new InputView();

    public BridgeGameProcessor(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
    }

    public void crossBridge() {
        while (bridgeGame.isNotOver()) {
            String direction = chooseDirection();
            makeMove(direction);
        }
    }

    private String chooseDirection() {
        outputView.printInputMoveMessage();
        String direction = inputView.readMoving();

        return direction;
    }

    private void makeMove(String direction) {
        boolean moveSuccess = bridgeGame.move(direction);

        moveSuccess();
        if (moveSuccess == false) {
            moveFail();
        }
    }

    private void moveSuccess() {
        outputView.printMap(Collections.unmodifiableList(bridgeGame.getUserBridge()));
    }

    private void moveFail() {
        outputView.printInputRetrialMessage();
        String gameCommand = inputView.readGameCommand();
        bridgeGame.retry(gameCommand);
        bridgeGame.giveUp(gameCommand);
    }
}
