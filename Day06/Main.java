package Day06;

public class Main {
    public static void main(String[] args) {
        Part1and2 p1 = new Part1and2();
        Part1and2 p2 = new Part1and2();
        p1.setLength(4);
        p1.run();
        p2.setLength(14);
        p2.run();
        System.out.printf("Part 1: %d\nPart 2: %d",p1.getPosition(),p2.getPosition());
    }
}
