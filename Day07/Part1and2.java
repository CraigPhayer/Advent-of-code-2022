package Day07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part1and2 {
    static int p1;
    static int p2;

    public void run() throws FileNotFoundException {
        File file = new File("./Day07/input.txt");
        Scanner scan = new Scanner(file);
        scan.nextLine();

        Directory root = new Directory("/", null);
        Directory currentDir = root;

        boolean ls = false;

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            if (line.charAt(0) == '$') {
                ls = false;
                String command = line.substring(2, 4);
                if (command.equals("ls")) {
                    ls = true;
                } else if (command.equals("cd")) {
                    currentDir = cdRunner(currentDir, root, line.substring(5));
                }
            } else if (ls) {
                if (line.startsWith("dir")) {
                    currentDir.addChild(line.substring(4), currentDir);
                } else {
                    int number = Integer.parseInt(line.substring(0, line.indexOf(" ")));
                    String name = line.substring(line.indexOf(" ") + 1);
                    currentDir.addFile(name, number, currentDir);
                }
            }

        }
        scan.close();
        p1 = Part1(root);

        int totalSpace = 70000000;
        int spaceNeeded = 30000000;
        int minSpaceToDelete = spaceNeeded - (totalSpace - root.size);

        p2 = Part2(root,minSpaceToDelete);
    }
    public int getPart1(){
        return p1;
    }

    public int getPart2(){
        return p2;
    }

    public static Directory cdRunner(Directory currentDir, Directory root, String todo) {
        if (todo.equals("..")) {
            return currentDir.parent;
        } else if (todo.equals("/")) {
            return root;
        } else {
            for (Directory current : currentDir.child) {
                if (current.name.equals(todo)) {
                    return current;
                }
            }
        }
        return root;
    }

    public static int Part1(Directory root) {
        int result = 0;
        int resultPart1 = 0;
        for (Directory dir : root.child) {
            resultPart1 += Part1(dir);
            result += dir.size;
        }
        for (file f : root.files) {
            result += f.size;
        }
        root.size = result;

        if (result <= 100000)
            resultPart1 += result;
        return resultPart1;
    }

    public static int Part2(Directory root, int minSpaceToDelete) {
        int spaceToDelete = root.size;
        for (Directory dir : root.child) {
            int tmp = Part2(dir, minSpaceToDelete);
            if ((tmp >= minSpaceToDelete) && (tmp < spaceToDelete))
                spaceToDelete = tmp;
        }
        return spaceToDelete;
    }
}
