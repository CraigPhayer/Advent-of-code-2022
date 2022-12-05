package Day05;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Part1 p1 = new Part1();
        Part2 p2 = new Part2();
        p1.run();
        p2.run();
        System.out.printf("Part 1: %s\nPart 2: %s",p1.getAnswer(),p2.getAnswer());
    }
}
