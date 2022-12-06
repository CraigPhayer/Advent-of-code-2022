package Day01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Part1and2 {
    private String input;
    private String path = "C:\\Users\\sophi\\OneDrive - University of Limerick\\Advent of code\\Day01\\inputDay01Part1.txt";
    private ArrayList<Integer> elves;
    int part2;
    int part1;

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

    public int getPart2() {
        return part2;
    }

    public int getPart1() {
        return part1;
    }

    public Part1and2() {
        inputsFromFile();
    }

    public void run() {
        inputsFromFile();
        Part1and2 p1 = new Part1and2();
        String inputs = p1.getInput();
        String[] line = inputs.split("\n");
        elves = new ArrayList<>();

        int calories = 0;
        for (String str : line) {
            if (str.equals("")) {
                elves.add(calories);
                calories = 0;
                continue;
            }
            calories += Integer.parseInt(str);
        }
        elves.sort(Collections.reverseOrder());

        part2 = elves.get(0) + elves.get(1) + elves.get(2);
        part1 = elves.get(0);
    }
}
 