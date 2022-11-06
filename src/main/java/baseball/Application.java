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
        public static void readFromUser() { //static type, private 확인
            String userNumberString = Console.readLine(); //String으로 저장
            //List<Integer> userNumberInt = new ArrayList<>();
            for (int i = 0; i < userNumberString.length(); i++) {
                userNumber.add((int)(userNumberString.charAt(i) - '0'));
            }
        }

        public static List<Integer> getUserAnswer() {
            return userNumber;
        }

        private void isDifferentNumber() {
            Set<Integer> userNumberWithoutRedundancy = new HashSet<>(userNumber);
            if (userNumber.size() != userNumberWithoutRedundancy.size()) {
                throw new IllegalArgumentException("Please Enter Different Number.");
            }
        }
        private void isInSize() {
            if (userNumber.size() != 3) {
                throw new IllegalArgumentException("Please Enter 3 digits.");
            }
        }

        private void isNumber() {
            for (int number : userNumber) {
                if (userNumber.get(number) > '9' || userNumber.get(number) < '0') {
                    throw new IllegalArgumentException("Please Enter number.");
                }
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
        System.out.println(MyAnswer.getUserAnswer().get(0)); //동작 확인
        MyAnswer.isDifferentNumber();
        MyAnswer.isInSize();
        MyAnswer.isNumber();

        // TODO: 프로그램 구현
    }
}
