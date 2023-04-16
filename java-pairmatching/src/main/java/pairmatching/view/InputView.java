package pairmatching.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static final String USER_YES = "네";
    public static final String USER_NO = "아니오";

    public static List<String> readFile(String pathname) throws IOException {
        File file = new File(pathname);
        List<String> contents = new ArrayList<>();
        if(file.exists()) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String str;

            while((str = bufferedReader.readLine()) != null) {
                contents.add(str);
            }
            bufferedReader.close();
        }
        return contents;
    }

    public static String readLine() {
        String feature = Console.readLine();

        return feature;
    }

    public static List<String> readOptions() {
        String read = Console.readLine().replaceAll(" ","");
        List<String> options = Arrays.asList(read.split(",")); //공백 제거

        return options;
    }

}
