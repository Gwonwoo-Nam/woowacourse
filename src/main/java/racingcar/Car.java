package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void drive(int trialNumber) {
        for (int number = 0; number < trialNumber; number++) {
            int randomNumber = pickRandomNumber();
            move(randomNumber);
        }
    }

    private void move(int randomNumber) {
        if (randomNumber >= 4) {
            position++;
        }
    }

    private int pickRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(0,9);

        return randomNumber;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
}
