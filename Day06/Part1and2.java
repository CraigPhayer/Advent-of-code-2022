package Day06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Part1and2 {
    String path = "C:\\Users\\sophi\\OneDrive - University of Limerick\\Advent of code\\Day06\\input.txt";
    private String input;
    int length;
    int position;

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

    public int getPosition() {
        return position;
    }

    public void setLength(int length) {//Allows me do do literally nothing part 2
        this.length = length;
    }

    public void run() {
        inputsFromFile();
        LinkedList<Character> chars = new LinkedList<>();
        char[] characterArray = input.toCharArray();
        for (int i = 0; i < length; i++) {
            chars.add(characterArray[i]);
        }

        for (int i = 4; i < characterArray.length - 1; i++) {
            if (checkDuplicates(chars,length)) {
                position += i;
                return;
            }
            chars.remove();
            chars.add(characterArray[i]);
        }

    }

    public boolean checkDuplicates(LinkedList<Character> c, int length) {
        for (int i = 0; i < c.size(); i++)
            for (int j = 0; j < length; j++) {
                if (c.get(i).equals(c.get(j)) && i != j)
                    return false;
            }
        return true;
    }
}