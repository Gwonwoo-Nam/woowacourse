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
            System.out.print("숫자를 입력해주세요 : ");
            userNumberString = Console.readLine();
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

        public static void clear() {
            userNumber.clear();
        }
    }

    public static class ComputerAnswer {
        public static List<Integer> computerNumber = new ArrayList<>();

        public static void createRandomAnswer() {
            while (computerNumber.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computerNumber.contains(randomNumber)) {
                    computerNumber.add(randomNumber);
                }
            }
        }

        public static List<Integer> getComputerAnswer() {
            return computerNumber;
        }
    }

    public static class StrikeBallCounter {
        public static int strikeCount = 0;
        public static int ballCount = 0;

        private static void compareAnswers(List<Integer> userAnswer, List<Integer> computerAnswer) {
            for (int index = 0; index < computerAnswer.size(); index++) {
                if (computerAnswer.contains(userAnswer.get(index))) {
                    isStrike(userAnswer.get(index), computerAnswer.get(index));
                    isBall(userAnswer.get(index), computerAnswer.get(index));
                }
            }
        }

        private static void isStrike(Integer userNumber, Integer computerNumber) {
            if (userNumber == computerNumber) {
                strikeCount++;
            }
        }

        private static void isBall(Integer userNumber, Integer computerNumber) {
            if (userNumber != computerNumber) {
                ballCount++;
            }
        }

        private static int getStrikeCount() {
            return strikeCount;
        }

        private static int getBallCount() {
            return ballCount;
        }

        private static void clear() {
            strikeCount = 0;
            ballCount = 0;
        }
    }

    /*
        public class StrikeBallCountProcessor {
            private static void getCount() {

            }

            private static void sendcount() {

            }
        }*/

        public class ResultPrinter {


            private static void printNothing() {
                System.out.println("낫싱");
            }



        }
    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");
        /*for (Integer number : UserAnswer.getUserAnswer()) {
            System.out.println(number);
        }*/

        ComputerAnswer ComAnswer = new ComputerAnswer();
        ComAnswer.createRandomAnswer();

        System.out.println("Computer Answer");
        for (Integer number : ComAnswer.getComputerAnswer()) {
            System.out.println(number);
        }


        UserAnswer MyAnswer = new UserAnswer();
        while (StrikeBallCounter.getStrikeCount() != 3){
            StrikeBallCounter.clear();
            MyAnswer.readFromUser();
            MyAnswer.isDifferentNumber();
            MyAnswer.isInSize();
            MyAnswer.isNumber();
            MyAnswer.toIntegerList();
            StrikeBallCounter.compareAnswers(MyAnswer.getUserAnswer(), ComAnswer.getComputerAnswer());
            System.out.println(StrikeBallCounter.getBallCount() + "볼 ");
            System.out.println(StrikeBallCounter.getStrikeCount() + "스트라이크");
            MyAnswer.clear();

        }

    }
}
