package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        int diff = 0;
        if (word.length() < 1 || word.length() > 1000)
            return "";
        for (int i = 0; i < word.length(); i++){
            if (word.charAt(i) >= 65 && word.charAt(i) <= 90) {
                diff = word.charAt(i) - 65;
                answer = answer + (char)(90 - diff);
            }
            else if (word.charAt(i) >= 97 && word.charAt(i) <= 122) {
                diff = word.charAt(i) - 97;
                answer = answer + (char)(122 - diff);
            }
            else
                answer = answer + word.charAt(i);
        }
        return answer;
    }
}
