package onboarding;

public class Problem2 {
    public static String Check_same_char(String cryptogram)
    {
        char prev = '\0';
        String answer = "";
        int i = 0;
        for (i = 0; i + 1 < cryptogram.length(); i++) {
            if (cryptogram.charAt(i) != cryptogram.charAt(i + 1) && cryptogram.charAt(i) != prev)// 앞뒤 글자와 달라야함
                answer = answer + cryptogram.charAt(i);
            prev = cryptogram.charAt(i);
        }
        if (cryptogram.charAt(i) != prev)
            answer = answer + cryptogram.charAt(i);
        return answer;
    }
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
