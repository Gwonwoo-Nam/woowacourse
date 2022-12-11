package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.View.InputView;
import racingcar.View.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        outputView.askCarName();

        InputView inputView = new InputView();
        List<String> carNameList = new ArrayList<>(inputView.readCarName());
        System.out.println(carNameList);

        List<Car> carList = new ArrayList<>();
        for(String carName : carNameList) {
            Car car = new Car(carName);
            carList.add(car);
        }

        for (int i = 0; i < carList.size(); i++) {
            carList.get(i).drive(3);
            System.out.println(carList.get(i).getName()+"의 위치 : "+carList.get(i).getPosition());
        }



    }
}
