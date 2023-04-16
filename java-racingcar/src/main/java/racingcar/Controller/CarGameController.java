package racingcar.Controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.ErrorMessages;
import racingcar.Model.Car;
import racingcar.Model.Cars;
import racingcar.Regex;
import racingcar.View.InputView;
import racingcar.View.OutputView;

public class CarGameController {

    public void play() {
        Cars cars = new Cars();

        setCarsName(cars);

        setTrialNumber(cars);

        OutputView.printResultMessage();

        driveCars(cars);

        cars.findWinner();

        OutputView.printWinner(getWinners(cars));
    }

    private void setCarsName(Cars cars) {
        try {
            cars.getCars().clear();
            cars.addCar(InputView.readCarsName());
            cars.validate();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setCarsName(cars);
        }
    }

    private void setTrialNumber(Cars cars) {

        try {
            String input = InputView.readTrialNumber();
            validateTrialNumber(input);
            cars.setTrialNumber(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setTrialNumber(cars);
        }
    }

    public void validateTrialNumber(String input) {
        if (!input.matches(Regex.INPUT_TRIAL_NUMBER_REGEX.print())) {
            throw new IllegalArgumentException(ErrorMessages.TRIAL_NUMBER_ERROR_MESSAGE.print());
        }
    }

    public void driveCars(Cars cars) {
        for (int number = 0; number < cars.getTrialNumber(); number++) {
            for (Car car : cars.getCars().getCarList()) {
                int randomNumber = pickRandomNumber();
                car.move(randomNumber);
                OutputView.printResult(car.getName(), car.getPosition());
            }
            System.out.println();
        }
        System.out.println();
    }

    public int pickRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);

        return randomNumber;
    }

    public String getWinners(Cars cars) {
        List<String> winnerList = new ArrayList<>();
        for (Car car : cars.getCars().getCarList()) {
            if (car.getWinner() == true) {
                winnerList.add(car.getName());
            }
        }
        return String.join(",",winnerList);
    }

}
