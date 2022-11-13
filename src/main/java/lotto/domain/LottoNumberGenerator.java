package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoNumberGenerator {
    private List<Integer> numbers;

    public void setNumbers(List<Integer> setNumbers) {
        numbers = setNumbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void generate() {
        setNumbers(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    public void sortAscending() {
        int[] numberList = new int[numbers.size()];
        for (int index = 0; index < numbers.size(); index++) {
            numberList[index] = numbers.get(index);
        }
        Arrays.sort(numberList);

        List<Integer> sortedNumbers = new ArrayList<>();
        for (int number : numberList) {
            sortedNumbers.add(number);
        }
        numbers = sortedNumbers;
    }

}
