package racingcar.Model;

public class Car {
    private final String name;
    private int position = 0;
    private boolean winner = false;

    public Car(String name) {
        this.name = name;
    }

    public void move(int randomNumber) {
        if (randomNumber >= 4) {
            position++;
        }
    }

    public void setWinner() {
        winner = true;
    }

    public boolean getWinner() {
        return winner;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
}
