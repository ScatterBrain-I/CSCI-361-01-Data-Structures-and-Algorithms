import java.util.Scanner;
import java.util.*;

public class Maze {
    public static void main(String args[]){
        IStack<String> stack1 = new StackArray<String>();
        IStack<String> stack2 = new StackArray<String>();
        int x = 1;
        int y = 1;
        boolean run = true;
        showLocation(x, y);
        while (run){
            Scanner kb = new Scanner(System.in);
            String act = kb.nextLine();
            boolean quit = true;
            if (act.equalsIgnoreCase("n") || act.equalsIgnoreCase("s") ||
            act.equalsIgnoreCase("e") || act.equalsIgnoreCase("w")){
                movement(act, x, y, stack1, stack2);
            }
            if (act.equalsIgnoreCase("g")){
                stack1.push(act);
                System.out.println("\nGulp!");
            }
            if (act.equalsIgnoreCase("u")){
                if(stack1.top().equalsIgnoreCase("g")){
                    stack2.push(stack1.top());
                    stack1.pop();
                    System.out.println("\nBlah");
                }
                else if (stack2.top().equalsIgnoreCase("n")){
                    movement("s", x, y, stack1, stack2);
                    stack2.pop();
                }
                else if (stack2.top().equalsIgnoreCase("s")){
                    movement("n", x, y, stack1, stack2);
                    stack2.pop();
                }
                else if(stack2.top().equalsIgnoreCase("e")){
                    movement("w", x, y, stack1, stack2);
                    stack2.pop();
                }
                else if(stack2.top().equalsIgnoreCase("w")){
                    movement("e", x, y, stack1, stack2);
                    stack2.pop();
                }
                else {
                    System.out.println("There is nothing to redo.");
                }
            }
            if (act.equalsIgnoreCase("r")){

            }
            if (act.equalsIgnoreCase("q")){
                System.out.println("\nSee you later!");
                run = false;
            }
            System.out.println(x + ", " + y);
        }
    }

    public static void showLocation(int x, int y){
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

    public static void movement(String act, int x, int y, IStack<String> stack1, IStack<String> stack2){
        if (act.equalsIgnoreCase("n") || act.equalsIgnoreCase("s")){
            if ((y == 1 && act.equalsIgnoreCase("n")) || (y == 10 && act.equalsIgnoreCase("s"))){
                System.out.println("\nOuch!");
            }
            else if (act.equalsIgnoreCase("s")){
                stack1.push(act);
                y++;
                System.out.println("Undo Stack:" + stack1);
                System.out.println("Redo Stack:" + stack2);
                showLocation(x, y);
            }
            else {
                stack1.push(act);
                y--;
                System.out.println("Undo Stack:" + stack1);
                System.out.println("Redo Stack:" + stack2);
                showLocation(x, y);
            }
        }
        if (act.equalsIgnoreCase("e") || act.equalsIgnoreCase("w")){
            if ((x == 1 && act.equalsIgnoreCase("w")) || (x == 10 && act.equalsIgnoreCase("e"))){
                System.out.println("\nOuch!");
            }
            else if (act.equalsIgnoreCase("e")){
                stack1.push(act);
                x++;
                System.out.println("Undo Stack:" + stack1);
                System.out.println("Redo Stack:" + stack2);
                showLocation(x, y);
            }
            else {
                stack1.push(act);
                x--;
                System.out.println("Undo Stack:" + stack1);
                System.out.println("Redo Stack:" + stack2);
                showLocation(x, y);
            }
        }
    }
}
