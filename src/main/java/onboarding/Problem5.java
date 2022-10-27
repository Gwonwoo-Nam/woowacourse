package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> unit = new ArrayList<Integer>(List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1));
        for(int i = 0; i < 9; i++){
            answer.add(money / unit.get(i));
            money = money % unit.get(i);
        }
        return answer;
    }
}
