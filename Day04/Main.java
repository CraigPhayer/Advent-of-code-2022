package Day04;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Part1 p1 = new Part1();
        Part2 p2 = new Part2();
        p2.run();
        p1.run();
        System.out.printf("Part 1: %d\nPart 2: %d",p1.getCounter(),p2.getCounter());
    }
}
