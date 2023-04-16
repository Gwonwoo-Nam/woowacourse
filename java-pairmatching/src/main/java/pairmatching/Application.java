package pairmatching;

import java.io.IOException;

import pairmatching.controller.Manager;
import pairmatching.view.InfoMessages;

public class Application {
    public static void main(String[] args) {
        try {
            Manager.run();
        } catch (IOException e) {
            InfoMessages.ERROR_IO.println();
        }
    }
}
