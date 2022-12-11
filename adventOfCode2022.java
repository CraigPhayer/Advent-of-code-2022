import Day01.Part1and2;
import Day02.Part1;
import Day02.Part2;

import java.io.IOException;

public class adventOfCode2022 {
    static String separate = "-";
    public static void main(String[] args) throws IOException {
        Part1and2 day1 = new Part1and2();
        Part1 day2Part1 = new Part1();
        Part2 day2Part2 = new Part2();
        Day03.Part1 day3Part1 = new Day03.Part1();
        Day03.Part2 day3Part2 = new Day03.Part2();
        Day04.Part1 day4Part1 = new Day04.Part1();
        Day04.Part2 day4Part2 = new Day04.Part2();
        Day05.Part1 day5Part1 = new Day05.Part1();
        Day05.Part2 day5Part2 = new Day05.Part2();
        Day06.Part1and2 day6Part1 = new Day06.Part1and2();
        Day06.Part1and2 day6Part2 = new Day06.Part1and2();
        Day07.Part1and2 day7 = new Day07.Part1and2();

        day6Part1.setLength(4);
        day6Part2.setLength(14);

        day1.run();
        day2Part1.run();
        day2Part2.run();
        day3Part1.run();
        day3Part2.run();
        day4Part1.run();
        day4Part2.run();
        day5Part1.run();
        day5Part1.run();
        day5Part2.run();
        day6Part1.run();
        day6Part2.run();
        day7.run();

        System.out.printf("DAY 1:\nPart 1: %d\nPart 2: %d\n%s\n", day1.getPart1(),day1.getPart2(),separate.repeat(50));
        System.out.printf("DAY 2:\nPart 1: %d\nPart 2: %d\n%s\n", day2Part1.getScore(), day2Part2.getScore(),separate.repeat(50));
        System.out.printf("DAY 3:\nPart 1: %d\nPart 2: %d\n%s\n", day3Part1.getScore(), day3Part2.getScore(),separate.repeat(50));
        System.out.printf("DAY 4:\nPart 1: %d\nPart 2: %d\n%s\n", day4Part1.getCounter(), day4Part2.getCounter(),separate.repeat(50));
        System.out.printf("DAY 5:\nPart 1: %s\nPart 2: %s\n%s\n",day5Part1.getAnswer(),day5Part2.getAnswer(),separate.repeat(50));
        System.out.printf("DAY 6:\nPart 1: %d\nPart 2: %d\n%s\n",day6Part1.getPosition(),day6Part2.getPosition(),separate.repeat(50));
        System.out.printf("DAY 7:\nPart 1: %d\nPart 2: %d\n%s\n",day7.getPart1(),day7.getPart2(),separate.repeat(50));
    }
}
