package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또의 숫자 개수가 올바르지 않습니다.");
        }
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }



    // TODO: 추가 기능 구현
}
