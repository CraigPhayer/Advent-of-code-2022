package Day02;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Day02AoCPart1 part1 = new Day02AoCPart1();
        Day02AoCPart2 part2 = new Day02AoCPart2();
        part1.run();
        part2.run();
        System.out.printf("Part 1: %d\nPart 2: %d",part1.getScore(),part2.getScore());
    }
}
