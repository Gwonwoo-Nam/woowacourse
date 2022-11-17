package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class BridgeGameController {
    public void run () {
        OutputView outputView = new OutputView();
        outputView.printStartMessage();
        outputView.printInputBridgeLengthMessage();

        InputView inputView = new InputView();
        int bridgeSize = inputView.readBridgeSize();

        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();

        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> bridge = new ArrayList<>();
        bridge = bridgeMaker.makeBridge(bridgeSize);


        BridgeGame bridgeGame = new BridgeGame(bridge);
        for (int bridgeIndex = 0; bridgeIndex < bridgeSize; bridgeIndex++) {
            String userBridgeType;
            if (!bridgeGame.move(bridgeIndex, userBridgeType)) {
                bridgeGame.retry();
            }
        }

    }

}
