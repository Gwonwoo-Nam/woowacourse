package pairmatching;

import java.io.IOException;
import pairmatching.controller.Manager;

public class Application {
    public static void main(String[] args) {
        try {
            Manager.run();
        } catch (IOException e) {
            System.out.println("[ERROR] 파일 입출력 오류");
        }
    }
}
