package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<String> answer_rep = new ArrayList<>();
        String temp = "";
        for (int i = 0; i < forms.size(); i++){
            for (int j = 0; j + 1< forms.get(i).get(1).length(); j++){
                temp = forms.get(i).get(1).substring(j,j+2);
                for (int k = i + 1; k < forms.size(); k++){
                    if (forms.get(k).get(1).contains(temp)) {
                        temp = forms.get(k).get(0);
                        answer_rep.add(0,forms.get(k).get(0));
                        answer_rep.add(0,forms.get(i).get(0));
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
