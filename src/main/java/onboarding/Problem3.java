package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    public static int number_digits(int number){
        List<Integer> digits = new ArrayList<Integer>();
        int i = 0;
        int clap = 0;

        while (number > 0) {
            digits.add(number % 10); // 각 자리를 digits 배열에 저장
            number = number / 10;
            i++;
        }
        for (int j=0; j<digits.size(); j++){
            if (digits.get(j) % 3 == 0 && digits.get(j) != 0)
                clap++;
        }
        return clap;
    }
    public static int solution(int number) {
        int answer = 0;
        if (number > 10000 || number < 1)
            return (0);
        for (int i = 1; i <= number; i++)
        {
            answer += number_digits(i);
        }
        return answer;
    }
}
