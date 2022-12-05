package Day05;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Part2 {

    ArrayList<Stack<Character>> stacks;
    String line;
    String answer;
    String path = "C:\\Users\\sophi\\OneDrive - University of Limerick\\Advent of code\\Day05\\input.txt";
    Stack<Character> stack1 = new Stack<>();
    Stack<Character> stack2 = new Stack<>();
    Stack<Character> stack3 = new Stack<>();
    Stack<Character> stack4 = new Stack<>();
    Stack<Character> stack5 = new Stack<>();
    Stack<Character> stack6 = new Stack<>();
    Stack<Character> stack7 = new Stack<>();
    Stack<Character> stack8 = new Stack<>();
    Stack<Character> stack9 = new Stack<>();

    public void run() throws FileNotFoundException {
        initializeStack();
        stackList();
        Scanner sc = new Scanner(new File(path));
        line = sc.nextLine();
        while (!line.isEmpty()){
            line = sc.nextLine();
        }
        while (sc.hasNext()){
            line = sc.nextLine();
            String[] split = line.split(" ");
            int boxes = Integer.parseInt(split[1]);
            int from = Integer.parseInt(split[3]) - 1;
            int to = Integer.parseInt(split[5]) - 1;
            ArrayList<Character> temp = new ArrayList<>();
            while (boxes-- >0){
                temp.add(stacks.get(from).pop());
            }
            Collections.reverse(temp);
            for (char ch : temp)
                stacks.get(to).push(ch);
        }
        answer = "";
        for (int i = 1;i<=9;i++)
            answer += getStack(i).peek();
    }

    public void stackList(){
        stacks = new ArrayList<>();
        stacks.add(stack1);
        stacks.add(stack2);
        stacks.add(stack3);
        stacks.add(stack4);
        stacks.add(stack5);
        stacks.add(stack6);
        stacks.add(stack7);
        stacks.add(stack8);
        stacks.add(stack9);
    }
    public String getAnswer() {
        return answer;
    }

    private void initializeStack(){
        initializeStack(1,"RGHQSBTN");
        initializeStack(2,"HSFDPZJ");
        initializeStack(3,"ZHV");
        initializeStack(4,"MZJFGH");
        initializeStack(5,"TZCDLMSR");
        initializeStack(6,"MTWVHZJ");
        initializeStack(7,"TEPLZ");
        initializeStack(8,"QVWS");
        initializeStack(9,"WHLMTDNC");
    }

    private void initializeStack(int number, String str) {
        for (char c : str.toCharArray())
            getStack(number).add(c);
    }

    private Stack<Character> getStack(int number) {
        return switch (number) {
            case 1 -> stack1;
            case 2 -> stack2;
            case 3 -> stack3;
            case 4 -> stack4;
            case 5 -> stack5;
            case 6 -> stack6;
            case 7 -> stack7;
            case 8 -> stack8;
            case 9 -> stack9;
            default -> throw new IllegalArgumentException("Stack number error: " + number);
        };

    }
}
