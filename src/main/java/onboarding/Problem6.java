package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {

    private static int check_email(List<List<String>> forms){
        int count = 0;
        for(List<String> items : forms) {
            count++;
            if (check_domain(items.get(0)) == -1)
                return (-1);
        }
        if (count < 1 || count > 10000)
            return (-1); // 예외처리 1 : 멤버의 number가 1~10000
        return (0);
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<String> answer_rep = new ArrayList<>();
        String temp = "";
        if (check_email(forms) == -1)
            return ();
        for (int i = 0; i < forms.size(); i++){
            for (int j = 0; j + 1< forms.get(i).get(1).length(); j++){
                temp = forms.get(i).get(1).substring(j,j+2);
                for (int k = i + 1; k < forms.size(); k++){
                    if (forms.get(k).get(1).contains(temp)) {
                        temp = forms.get(k).get(0);
                        answer_rep.add(forms.get(k).get(0));
                        answer_rep.add(forms.get(i).get(0));
                    }
                }
            }
        }
        for (String email : answer_rep){
            if(!answer.contains(email))
                answer.add(email);
        }
        Collections.sort(answer);
        return answer;
    }
}
