package Day03;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Part1 part1 = new Part1();
        Part2 part2 = new Part2();
        part1.run();
        part2.run();
        System.out.printf("Part 1: %d\nPart 2: %d", part1.getScore(), part2.getScore());
    }

}
