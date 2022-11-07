package baseball;

import java.util.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;


public class Application {
    public static class UserAnswer {

        public static List<Integer> userNumber = new ArrayList<>();
        public static String userNumberString;

        public static void readFromUser() {
            System.out.print("숫자를 입력해주세요 : ");
            userNumberString = Console.readLine();
        }

        public static List<Integer> getUserAnswer() {
            return userNumber;
        }

        private void isEmpty() {
            if (userNumberString.length() == 0) {
                throw new IllegalArgumentException("Please Enter number.");
            }
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
                if (userNumberString.charAt(i) > '9' || userNumberString.charAt(i) < '1') {
                    throw new IllegalArgumentException("Please Enter number.");
                }
            }
        }

        public void toIntegerList() {
            for (int i = 0; i < userNumberString.length(); i++) {
                userNumber.add((int) (userNumberString.charAt(i) - '0'));
            }
        }

        public void clear() {
            userNumber.clear();
        }
    }

    public static class ComputerAnswer {
        public static List<Integer> computerNumber = new ArrayList<>();

        public void createRandomAnswer() {
            while (computerNumber.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computerNumber.contains(randomNumber)) {
                    computerNumber.add(randomNumber);
                }
            }
        }

        public List<Integer> getComputerAnswer() {
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
            if (Objects.equals(userNumber, computerNumber)) {
                strikeCount++;
            }
        }

        private static void isBall(Integer userNumber, Integer computerNumber) {
            if (!Objects.equals(userNumber, computerNumber)) {
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

    public static class ProcessorPrinter {
        private static void processAndPrint(int ballCount, int strikeCount) {
            if (ballCount != 0 && strikeCount != 0) {
                bothStrikeBall();
            } else if (strikeCount != 0) {
                onlyStrike();
            } else if (ballCount != 0) {
                onlyBall();
            } else {
                nothing();
            }
        }
        private static void nothing() {
            ResultPrinter.printNothing();
        }

        private static void onlyBall() {
            ResultPrinter.printBall();
            ResultPrinter.printEndOfLine();
        }

        private static void onlyStrike() {
            ResultPrinter.printStrike();
            ResultPrinter.printEndOfLine();
        }

        private static void bothStrikeBall() {
            ResultPrinter.printBall();
            ResultPrinter.printSpace();
            ResultPrinter.printStrike();
            ResultPrinter.printEndOfLine();
        }

    }

    public static class ResultPrinter {
        private static void printNothing() {
            System.out.println("낫싱");
        }
        private static void printBall() {
            System.out.print(StrikeBallCounter.getBallCount() + "볼");
        }

        private static void printStrike() {
            System.out.print(StrikeBallCounter.getStrikeCount() + "스트라이크");
        }
        private static void printSpace() {
            System.out.print(" ");
        }
        private static void printEndOfLine() {
            System.out.println();
        }
    }

    public static class GameRestarter {
        public static String restartFlag = "1";
        private static void printEndMessage() {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }
        private static void printStartMessage() {
            System.out.println("숫자 야구 게임을 시작합니다.");
        }
        private static String getRestartFlag() {
            restartFlag = Console.readLine();
            return restartFlag;
        }
        private static boolean endGame(String restartFlag) {
            if (restartFlag.equals("2")) {
                return true;
            }
            return false;
        }
        private static boolean restartGame(String restartFlag) {
            if (restartFlag.equals("1")) {
                return true;
            }
            return false;
        }
    }
    public static void main(String[] args) {
        int ballCount = 0;
        int strikeCount = 0;
        String restartFlag = "1";
        List<Integer> computerAnswer;
        List<Integer> userAnswer;
        ComputerAnswer ComAnswer = new ComputerAnswer();
        UserAnswer MyAnswer = new UserAnswer();
        GameRestarter.printStartMessage();
        while (GameRestarter.restartGame(restartFlag)) {
            computerAnswer = getComputerAnswer(ComAnswer);
            while (StrikeBallCounter.getStrikeCount() != 3) {
                StrikeBallCounter.clear();
                userAnswer = getUserAnswer(MyAnswer);
                StrikeBallCounter.compareAnswers(userAnswer, computerAnswer);
                ballCount = StrikeBallCounter.getBallCount();
                strikeCount = StrikeBallCounter.getStrikeCount();
                ProcessorPrinter.processAndPrint(ballCount, strikeCount);
                MyAnswer.clear();
            }
            StrikeBallCounter.clear();
            computerAnswer.clear();
            GameRestarter.printEndMessage();
            restartFlag = GameRestarter.getRestartFlag();
            if (GameRestarter.endGame(restartFlag)) {
                return ;
            }
        }
    }

    private static List<Integer> getComputerAnswer(ComputerAnswer ComAnswer) {
        ComAnswer.createRandomAnswer();
        return ComAnswer.getComputerAnswer();
    }

    private static List<Integer> getUserAnswer(UserAnswer MyAnswer) {
        MyAnswer.readFromUser();
        MyAnswer.isEmpty();
        MyAnswer.isDifferentNumber();
        MyAnswer.isInSize();
        MyAnswer.isNumber();
        MyAnswer.toIntegerList();
        return MyAnswer.getUserAnswer();
    }


}
