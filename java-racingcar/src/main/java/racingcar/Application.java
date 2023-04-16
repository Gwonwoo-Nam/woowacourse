package racingcar;

import racingcar.Controller.CarGameController;

public class Application {
    public static void main(String[] args) {
        CarGameController carGameController = new CarGameController();
        carGameController.play();
    }
}
