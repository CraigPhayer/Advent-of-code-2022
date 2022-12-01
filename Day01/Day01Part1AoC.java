package Day01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Day01Part1AoC {
    private String input;
    private String path = "C:\\Users\\sophi\\OneDrive - University of Limerick\\Advent of code\\Day01\\inputDay01Part1.txt";
    private ArrayList elves;

    void inputsFromFile() {//Thank you Brendan :)

        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String sCurrentLine;
            while ((sCurrentLine = reader.readLine()) != null) {
                contentBuilder.append(sCurrentLine).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.input = contentBuilder.toString();
    }

    public String getInput() {
        return input;
    }

    public Day01Part1AoC() {
        inputsFromFile();
    }

    public int run() {
        inputsFromFile();
        Day01Part1AoC p1 =new Day01Part1AoC();
        String inputs = p1.getInput();
        String[] line = inputs.split("\n");
        ArrayList<Integer> elves = new ArrayList<>();

        int calories = 0;
        for (String str: line){
            if (str.equals("")){
                elves.add(calories);
                calories = 0;
                continue;
            }
            calories += Integer.parseInt(str);
        }
        elves.sort(Collections.reverseOrder());
        return elves.get(0);
    }
}
 