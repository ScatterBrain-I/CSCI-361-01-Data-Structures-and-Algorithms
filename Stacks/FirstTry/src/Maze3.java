import java.util.Scanner;
import java.util.*;

public class Maze3 {
    public static void main(String args[]){
        IStack<String> stack1 = new StackAL<String>();
        IStack<String> stack2 = new StackAL<String>();
        int[] loc = {1, 1};
        boolean run = true;
        showLocation(loc);
        /*while (run){
            Scanner kb = new Scanner(System.in);
            String act = kb.nextLine().toLowerCase();
            if (act.equals("n") || act.equals("s") || act.equals("e") || act.equals("w") ||
            act.equals("g")){
                int size = stack2.getSize();
                for (int i = 0; i < size; i++){
                    stack2.pop();
                }
            }
            switch(act) {
                case "n":
                    if(y == 1){
                        System.out.println("\nOuch!");
                    }
                    else{
                        stack1.push("S");
                        y--;
                        System.out.println("Undo Stack:" + stack1);
                        System.out.println("Redo Stack:" + stack2);
                        Maze.showLocation(x, y);
                    }
                    break;
                case "s":
                    if(y == 10){
                        System.out.println("\nOuch!");
                    }
                    else{
                        stack1.push("N");
                        y++;
                        System.out.println("Undo Stack:" + stack1);
                        System.out.println("Redo Stack:" + stack2);
                        Maze.showLocation(x, y);
                        }
                    break;
                case "e":
                    if(x == 10){
                        System.out.println("\nOuch!");
                    }
                    else {
                        stack1.push("W");
                        x++;
                        System.out.println("Undo Stack:" + stack1);
                        System.out.println("Redo Stack:" + stack2);
                        showLocation(x, y);
                        }
                    break;
                case "w":
                    if (x == 1){
                        System.out.println("\nOuch!");
                    }
                    else {
                        stack1.push("E");
                        x--;
                        System.out.println("Undo Stack:" + stack1);
                        System.out.println("Redo Stack:" + stack2);
                        showLocation(x, y);
                    }
                    break;
                case "u":
                    if(stack1.isEmpty()){
                        System.out.print("\nThere is nothing to be undone.\n");
                    }
                    else if (stack1.top().equals("G")){
                        stack2.push(stack1.top());
                        stack1.pop();
                        System.out.println("\nBlah!");
                    }
                    else if (stack1.top().equals("N")){
                        stack2.push("S");
                        stack1.pop();
                        y--;
                        System.out.println("Undo Stack:" + stack1);
                        System.out.println("Redo Stack:" + stack2);
                        showLocation(x, y);
                    }
                    else if (stack1.top().equals("S")){
                        stack2.push("N");
                        stack1.pop();
                        y++;
                        System.out.println("Undo Stack:" + stack1);
                        System.out.println("Redo Stack:" + stack2);
                        showLocation(x, y);
                    }
                    else if (stack1.top().equals("E")){
                        stack2.push("W");
                        stack1.pop();
                        x++;
                        System.out.println("Undo Stack:" + stack1);
                        System.out.println("Redo Stack:" + stack2);
                        showLocation(x, y);

                    }
                    else if (stack1.top().equals("W")){
                        stack2.push("E");
                        stack1.pop();
                        x--;
                        System.out.println("Undo Stack:" + stack1);
                        System.out.println("Redo Stack:" + stack2);
                        showLocation(x, y);
                    }
                    break;
                case "r":
                    if(stack2.isEmpty()){
                        System.out.print("\nThere is nothing to be redone.\n");
                    }
                    else if (stack2.top().equals("N")){
                        stack1.push("S");
                        stack2.pop();
                        y--;
                        System.out.println("Undo Stack:" + stack1);
                        System.out.println("Redo Stack:" + stack2);
                        showLocation(x, y);
                    }
                    else if (stack2.top().equals("S")){
                        stack1.push("N");
                        stack2.pop();
                        y++;
                        System.out.println("Undo Stack:" + stack1);
                        System.out.println("Redo Stack:" + stack2);
                        showLocation(x, y);
                    }
                    else if (stack2.top().equals("E")){
                        stack1.push("W");
                        stack2.pop();
                        x++;
                        System.out.println("Undo Stack:" + stack1);
                        System.out.println("Redo Stack:" + stack2);
                        showLocation(x, y);

                    }
                    else if (stack2.top().equals("W")){
                        stack1.push("E");
                        stack2.pop();
                        x--;
                        System.out.println("Undo Stack:" + stack1);
                        System.out.println("Redo Stack:" + stack2);
                        showLocation(x, y);
                    }
                    break;
                case "g":
                    stack1.push(act.toUpperCase());
                    System.out.println("\nGulp!");
                    break;
                case "q":
                    System.out.println("\nSee you later!");
                    run = false;
                    break;
                default:
                    System.out.println("Not a command");
            }
        }*/
    }
    public int moveSouth(int[] locArray);{
        int x = locArray[0];
        int y = locArray[1];
        if(y == 10){
            System.out.println("\nOuch!");
        }
        else{
            stack1.push("N");
            y++;
            locArray[1] = y;
            System.out.println("Undo Stack:" + Maze3.stack1);
            System.out.println("Redo Stack:" + Maze3.stack2);
            showLocation(locArray);
        }
        return locArray;
    }

    public static void showLocation(int[] locArray){
        int x = locArray[0];
        int y = locArray[1];
        System.out.println();
        for (int i = 1; i<11; i++){
            for(int j = 1; j<11; j++){
                if (i==y && j==x){
                    System.out.print("* ");
                }
                else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
        String[] commands = {"N: move North   U: Undo last", "S: move South   R: Redo",
        "E: move East    Q: Quit", "W: move West", "G: drink Grog"};
        System.out.println("\nWhat will you do?");
        for (String command : commands){
            System.out.println(command);
        }
    }
}
