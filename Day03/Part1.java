package Day03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Part1 {

    String path = "C:\\Users\\sophi\\OneDrive - University of Limerick\\Advent of code\\Day03\\input.txt";
    char common;
    int score = 0;
    int temp = 0;

    public void run() throws IOException {
        List<String> input = Files.readAllLines(Path.of(path));

        for (String strings : input) {
            String str1 = strings.substring(0, strings.length() / 2);
            String str2 = strings.substring(strings.length() / 2);

            char c = commonChars(str1, str2);
            temp = getPriority(c);
            score += temp;
        }
    }

    public int getScore() {
        return score;
    }

    public int getPriority(char c) {
        if (Character.isLowerCase(c)) {
            return ((int) c) - 96;
        } else {
            return ((int) c) - 38;
        }
    }

    public char commonChars(String str1, String str2) {
        common = '0';
        for (char ch : str1.toCharArray()) {
            if (str2.indexOf(ch) != -1) {
                common = ch;
            }
        }
        return common;
    }
}
