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


        List<Car> carList = new ArrayList<>();
        for(String carName : carNameList) {
            Car car = new Car(carName);
            carList.add(car);
        }

        for (int i = 0; i < carList.size(); i++) {
            drive(carList.get(i), trialNumber);
            System.out.println(carList.get(i).getName()+"의 위치 : "+carList.get(i).getPosition());
        }
    }

    public void drive(Car car, int trialNumber) {
        for (int number = 0; number < trialNumber; number++) {
            int randomNumber = pickRandomNumber();
            car.move(randomNumber);
        }
    }

    public int pickRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(0,9);

        return randomNumber;
    }

}
