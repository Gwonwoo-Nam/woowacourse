package racingcar.Model;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.ErrorMessages;

public class CarList {

       private List<Car> carList = new ArrayList<Car>();

    public List<Car> getCarList() {
        return carList;
    }

    public void add(String carName) {
        carList.add(new Car(carName));
    }



    public void isInSize(List<Car> carList) {
        if (carList.size() < 2 && carList.size() != 0) {
            throw new IllegalArgumentException(ErrorMessages.CAR_NAME_SIZE_ERROR_MESSAGE.print());
        }
    }


    public void isWithoutRepetition(List<Car> carList) {
        Set<String> carSet = new HashSet<>();
        for (Car car : carList) {
            carSet.add(car.getName());
        }
        if (carSet.size() != carList.size()) {
            throw new IllegalArgumentException(ErrorMessages.CAR_NAME_REPETITION_ERROR_MESSAGE.print());
        }
    }



    public void isInCorrectFormat(List<Car> carList, String regex, String errorMessage) {
        for (Car car : carList) {
            if (car.getName().matches(regex) == false) {
                throw new IllegalArgumentException(errorMessage);
            }
        }
    }

    public void clear() {
        carList.clear();
    }
}
