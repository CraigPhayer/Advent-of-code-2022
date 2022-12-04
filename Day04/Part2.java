package Day04;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Part2 {
    int counter;
    String path = "C:\\Users\\sophi\\OneDrive - University of Limerick\\Advent of code\\Day04\\input.txt";


    public void run() throws IOException {
        counter = 0;
        File file = new File(path);
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            String inputs = sc.nextLine();
            if (overlaps(inputs)) counter++;
        }
    }

    public int getCounter() {
        return counter;
    }

    public boolean overlaps(String input) {
        String[] lines = input.split(",");
        String[] pair1 = lines[0].split("-");
        int no1 = Integer.parseInt(pair1[0]);
        int no2 = Integer.parseInt(pair1[1]);

        String[] pair2 = lines[1].split("-");
        int no3 = Integer.parseInt(pair2[0]);
        int no4 = Integer.parseInt(pair2[1]);
        return no1 >= no3 && no1 <= no4 ||
                no2 >= no3 && no2 <= no4 ||
                no3 >= no1 && no3 <= no1 ||
                no4 >= no1 && no4 <= no2;
    }
}

