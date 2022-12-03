package Day02;

import java.io.*;
import java.util.Map;
import java.util.Scanner;

public class Part1 {
    String input;
    String path = "C:\\Users\\sophi\\OneDrive - University of Limerick\\Advent of code\\Day02\\input.txt";
    private static final int draw = 3;
    private static final int loss = 0;
    private static final int win = 6;
    private static final int rock = 1;
    private static final int paper = 2;
    private static final int scissors = 3;
    //A - ROCK
    //B - PAPER
    //C - SCISSORS
    //X - ROCK
    //Y - PAPER
    //Z - SCISSORS
    private static final Map<String,Integer> Game = Map.of(
            "A Y",win+paper,
            "A X",draw+rock,
            "A Z",loss+scissors,
            "B X",loss+rock,
            "B Y",draw+paper,
            "B Z",win+scissors,
            "C X",win+rock,
            "C Y",loss+paper,
            "C Z",draw+scissors
    );
    private int score = 0;

    public int getScore() {
        return score;
    }
    public void run() throws FileNotFoundException {
        File file = new File(path);
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            String lines = sc.nextLine();
            score += Game.get(lines);
            }
        sc.close();
    }
}

