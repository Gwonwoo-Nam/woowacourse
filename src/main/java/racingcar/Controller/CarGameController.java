package racingcar.Controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.Car;
import racingcar.View.InputView;
import racingcar.View.OutputView;

public class CarGameController {

    public void play() {
        OutputView outputView = new OutputView();
        outputView.askCarName();

        InputView inputView = new InputView();
        List<String> carNameList = new ArrayList<>(inputView.readCarName());

        outputView.askTrialNumber();

        int trialNumber = inputView.readTrialNumber();

        outputView.printResultMessage();
        List<Car> carList = new ArrayList<>();
        for(String carName : carNameList) {
            Car car = new Car(carName);
            carList.add(car);
        }

        for (int number = 0; number < trialNumber; number++) {
            driveCars(carList);
        }
    }

    public void driveCars(List<Car> carList) {
        OutputView outputView = new OutputView();

        for (Car car : carList) {
            int randomNumber = pickRandomNumber();
            car.move(randomNumber);
            outputView.printResult(car.getName(), car.getPosition());
        }
        System.out.println();
    }

    public int pickRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(0,9);

        return randomNumber;
    }

}
