package onboarding;

import java.util.List;

class Problem1 {
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