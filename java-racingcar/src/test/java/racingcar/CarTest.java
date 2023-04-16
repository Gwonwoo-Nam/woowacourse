package racingcar;

import java.util.List;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.Model.Car;
import racingcar.Model.CarList;
import racingcar.Model.Cars;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    void moveTest() {
        Car gwonwooCar = new Car("gwonwoo");
        gwonwooCar.move(4);
        assertThat(gwonwooCar.getPosition()).isEqualTo(1);
    }

    @Nested
    public class CarsTest {

        @Test
        void addCarTest() {
            Cars cars = new Cars();
            cars.addCar("gwonwoo,suhee");
            List<Car> carList = cars.getCars().getCarList();
            assertThat(carList.get(0).getName()).isEqualTo("gwonwoo");
            assertThat(carList.get(1).getName()).isEqualTo("suhee");
        }
    }

    @Nested
    public class CarListTest {

        @Test
        void addTest() {
            CarList carList = new CarList();
            carList.add("gwonwoo");
            assertThat(carList.getCarList().get(0).getName()).isEqualTo("gwonwoo");
        }

        @Test
        void IsInSizeTest() {
            CarList carList = new CarList();
            carList.add("gwonwoo");

            assertThatThrownBy(() -> carList.isInSize(carList.getCarList()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
        }

        @Test
        void IsWithoutRepetitionTest() {
            CarList carList = new CarList();
            carList.add("gwonwoo");
            carList.add("gwonwoo");

            assertThatThrownBy(() -> carList.isWithoutRepetition(carList.getCarList()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
        }

        @Test
        void IsInCorrectFormatTest() {
            CarList carList = new CarList();
            carList.add("gwonwoo");

            assertThatThrownBy(() -> carList.isInCorrectFormat(carList.getCarList(),Regex.INPUT_CAR_NAME_LENGTH_REGEX.print(),ErrorMessages.CAR_NAME_LENGTH_ERROR_MESSAGE.print()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
        }

        @Test
        void clearTest() {
            CarList carList = new CarList();
            carList.add("gwonwoo");
            carList.clear();

            assertThat(carList.getCarList()).isEmpty();
        }
    }

}



