package Day03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Part2 {
    String path = "C:\\Users\\sophi\\OneDrive - University of Limerick\\Advent of code\\Day03\\input.txt";
    char common;
    int score = 0;
    int temp = 0;

    public void run() throws IOException {
        List<String> input = Files.readAllLines(Path.of(path));

        for (int i = 0; i < input.size(); ) {
            String str1 = input.get(i);
            String str2 = input.get(i + 1);
            String str3 = input.get(i + 2);
            i += 3;

            char c = commonChars(str1, str2, str3);
            temp = getPriority(c);
            score += temp;
        }
    }

    public int getScore() {
        return score;
    }

    public char commonChars(String str1, String str2, String str3) {
        common = '0';
        for (char ch : str1.toCharArray()) {
            if (str2.indexOf(ch) != -1 && str3.indexOf(ch) != -1) {
                common = ch;
            }
        }
        return common;
    }

    public int getPriority(char c) {
        if (Character.isLowerCase(c)) {
            return ((int) c) - 96;
        } else {
            return ((int) c) - 38;
        }
    }
}
