package bridge;

import bridge.controller.BridgeGameController;
import bridge.view.InputView;

public class Application {

    public static void main(String[] args) {
        try {
            BridgeGameController bridgeGameController = new BridgeGameController();
            bridgeGameController.run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        // TODO: 프로그램 구현
    }
}
