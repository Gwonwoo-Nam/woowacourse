package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int check_List(List<Integer> pobi, List<Integer> crong) {
        if (pobi.size() != 2 || crong.size() != 2)// 예외처리 0 : 각 List의 사이즈는 2이다
            return (-1);
        if ((pobi.get(0) < 1 || pobi.get(1) > 400) || (crong.get(0) < 1 || crong.get(1) > 400)) // 예외처리 1 : Page의 범위를 넘어가는 경우
            return (-1);
        if (pobi.get(0) % 2 == 0 || crong.get(0) % 2 == 0) // 예외처리 2 : 첫 페이지가 홀수가 아닌 경우
            return (-1);
        if (pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1) // 예외처리 3 : 페이지가 연속이 아닌 경우
            return (-1);
        return (0);
    }
    public static int page_digits(int digit) {
        List<Integer> digits = new ArrayList<>();
        int sum_digits = 0;
        int multiply_digits = 1;
        int i = 0;

        while (digit > 0) {
            digits.add(digit % 10); // 각 자리를 digits 배열에 저장
            digit = digit / 10;
            i++;
        }
        for (int k = 0; k < i; k++) {
            sum_digits += digits.get(k);
            multiply_digits *= digits.get(k);
        }
        return (sum_digits >= multiply_digits ? sum_digits : multiply_digits);
    }
    public static int check_max(List<Integer> p) {
        if (page_digits(p.get(0)) > page_digits(p.get(1)))
            return page_digits(p.get(0));
        else
            return page_digits(p.get(1));
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobi_result;
        int crong_result;

        if (check_List(pobi, crong) == -1)
            return -1; //예외처리
        pobi_result = check_max(pobi);
        crong_result = check_max(crong);
        if (pobi_result > crong_result)
            answer = 1;
        else if (pobi_result == crong_result)
            answer = 0;
        else
            answer = 2;
        return answer;
    }
}