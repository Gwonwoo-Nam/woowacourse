package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";

        while (cryptogram.length() != Check_same_char(cryptogram).length()) {
            cryptogram = Check_same_char(cryptogram);
            if (cryptogram.isEmpty())
                break ;
        }
        answer = cryptogram;
        return answer;
    }
}
