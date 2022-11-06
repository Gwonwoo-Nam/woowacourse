package baseball;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;


public class Application {
    public static class UserAnswer { // public type이어야하는지 확인

        public static List<Integer> userNumber = new ArrayList<>();
        public static String userNumberString;
        public static void readFromUser() { //static type, private 확인
            userNumberString = Console.readLine(); //String으로 저장
            //List<Integer> userNumberInt = new ArrayList<>();

        }

        public static List<Integer> getUserAnswer() {
            return userNumber;
        }

        private void isDifferentNumber() {
            Set<Character> userNumberWithoutRedundancy = new HashSet<>();
            for (int i = 0; i < userNumberString.length(); i++) {
                userNumberWithoutRedundancy.add(userNumberString.charAt(i));
            }
            if (userNumberString.length() != userNumberWithoutRedundancy.size()) {
                throw new IllegalArgumentException("Please Enter Different Number.");
            }
        }
        private void isInSize() {
            if (userNumberString.length() != 3) {
                throw new IllegalArgumentException("Please Enter 3 digits.");
            }
        }

        private void isNumber() {
            for (int i = 0; i < userNumberString.length(); i++) {
                if (userNumberString.charAt(i) > '9' || userNumberString.charAt(i) < '0') {
                    throw new IllegalArgumentException("Please Enter number.");
                }
            }
        }

        public static void toIntegerList() {
            for (int i = 0; i < userNumberString.length(); i++) {
                userNumber.add((int) (userNumberString.charAt(i) - '0'));
            }
        }
    }
/*
    public class ComputerAnswer {
        private static void createRandomAnswer() {

        }

        private static void saveComputerAnswer() {

        }

    }

    public class StrikeBallCounter {

        private static void compareAnswers() {

        }

        private static void isStrike() {

        }

        private static void isBall() {

        }
    }

    public class StrikeBallCountProcessor {
        private static void getCount() {

        }

        private static void sendcount() {

        }
    }

    public class ResultPrinter {


        private static void printNothing() {

        }

        private static void printBall() {

        }

        private static void printStrike() {

        }

        private static void printEndOfLine() {

        }

    }
*/
    public static void main(String[] args) {
        UserAnswer MyAnswer = new UserAnswer();
        MyAnswer.readFromUser();
        MyAnswer.isDifferentNumber();
        MyAnswer.isInSize();
        MyAnswer.isNumber();
        MyAnswer.toIntegerList();
        System.out.println(MyAnswer.getUserAnswer().get(0)); //동작 확인

        // TODO: 프로그램 구현
    }
}
