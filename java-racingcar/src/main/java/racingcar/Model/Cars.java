package racingcar.Model;

import racingcar.ErrorMessages;
import racingcar.Regex;

public class Cars {

    private CarList carList = new CarList();
    private int trialNumber;

    public CarList getCars() {
        return carList;
    }

    public void addCar(String carNames) {
        for (String carName : carNames.split(",")) {
            carList.add(carName);
        }
    }
    public void setTrialNumber(String input) {
        trialNumber = Integer.parseInt(input);
    }

    public int getTrialNumber() {
        return trialNumber;
    }

    public void validate() {
        carList.isInSize(carList.getCarList());
        carList.isWithoutRepetition(carList.getCarList());
        carList.isInCorrectFormat(carList.getCarList(), Regex.INPUT_CAR_NAME_LENGTH_REGEX.print(),
            ErrorMessages.CAR_NAME_LENGTH_ERROR_MESSAGE.print());
    }

    public void findWinner() {
        int maxPosition = findMaxPosition();
        for (Car car : carList.getCarList()) {
            if (car.getPosition() >= maxPosition) {
                car.setWinner();
            }
        }
    }

    private int findMaxPosition() {
        int maxPosition = 0;
        for (Car car : carList.getCarList()) {
            if (car.getPosition() >= maxPosition) {
                 maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }


}
