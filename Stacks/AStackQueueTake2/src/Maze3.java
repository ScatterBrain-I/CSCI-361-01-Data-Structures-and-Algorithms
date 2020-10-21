import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Maze3{
    private int xCoord;
    private int yCoord;

    private IStack<String> undoStack;
    private IStack<String> redoStack;

    public static void main(String args[]) {
        Maze3 maze = new Maze3();
        maze.showLocation();
        boolean run = true;
        while (run) {
            Scanner kb = new Scanner(System.in);
            String act = kb.nextLine().toLowerCase();
            if (act.equals("n") || act.equals("s") || act.equals("e") || act.equals("w") ||
            act.equals("g")) {
                int size = maze.redoStack.getSize();
                for(int i = 0; i < size; i++) {
                    maze.redoStack.pop();
                }
            }
            switch (act) {
                case "n":
                    maze.undoStack.push("S");
                    maze.moveNorth();
                    break;
                case "s":
                    maze.undoStack.push("N");
                    maze.moveSouth();
                    break;
                case "e":
                    maze.undoStack.push("W");
                    maze.moveEast();
                    break;
                case "w":
                    maze.undoStack.push("E");
                    maze.moveWest();
                    break;
                case "u":
                    maze.undo();
                    break;
                case "r":
                    maze.redo();
                    break;
                case "g":
                    maze.undoStack.push(act.toUpperCase());
                    System.out.println("\nGulp!\n");
                    break;
                case "q":
                    System.out.println("\nSee you later!\n");
                    run = false;
                    break;
                default:
                    System.out.println("Not a command");
            }
        }
    }

    public Maze3() {
        xCoord = 1;
        yCoord = 1;
        undoStack = new StackAL<String>();
        redoStack = new StackAL<String>();
    }

    public void moveNorth() {
        if (yCoord == 1) {
            System.out.println("\nOuch!\n");
        }
        else {
            yCoord--;
            printStacks();
            showLocation();
        }
    }

    public void moveSouth() {
        if (yCoord == 10) {
            System.out.println("\nOuch!\n");
        }
        else {
            yCoord++;
            printStacks();
            showLocation();
        }
    }

    public void moveEast() {
        if (xCoord == 10) {
            System.out.println("\nOuch!\n");
        }
        else {
            xCoord++;
            printStacks();
            showLocation();
        }
    }

    public void moveWest() {
        if (xCoord == 1) {
            System.out.println("\nOuch!\n");
        }
        else {
            xCoord--;
            printStacks();
            showLocation();
        }
    }

    public void undo() {
        if (undoStack.isEmpty()) {
            System.out.print("\nThere is nothing to be undone.\n");
        }
        else if (undoStack.top().equals("G")) {
            redoStack.push(undoStack.top());
            undoStack.pop();
            System.out.println("\nBlah!\n");
        }
        else if (undoStack.top().equals("N")) {
            redoStack.push("S");
            undoStack.pop();
            moveNorth();
        }
        else if (undoStack.top().equals("S")) {
            redoStack.push("N");
            undoStack.pop();
            moveSouth();
        }
        else if (undoStack.top().equals("E")) {
            redoStack.push("W");
            undoStack.pop();
            moveEast();
        }
        else if (undoStack.top().equals("W")) {
            redoStack.push("E");
            undoStack.pop();
            moveWest();
        }

    }

    public void redo() {
        if (redoStack.isEmpty()) {
            System.out.print("\nThere is nothing to be redone.\n");
        }
        else if (redoStack.top().equals("N")) {
            undoStack.push("S");
            redoStack.pop();
            moveNorth();
        }
        else if (redoStack.top().equals("S")) {
            undoStack.push("N");
            redoStack.pop();
            moveSouth();
        }
        else if (redoStack.top().equals("E")) {
            undoStack.push("W");
            redoStack.pop();
            moveEast();
        }
        else if (redoStack.top().equals("W")) {
            undoStack.push("E");
            redoStack.pop();
            moveWest();
        }
    }

    public void printStacks() {
        System.out.println("Undo Stack:" + undoStack);
        System.out.println("Redo Stack:" + redoStack);
    }

    public void showLocation() {
        System.out.println();
        for(int i = 1; i < 11; i++) {
            for(int j = 1; j < 11; j++) {
                if (i == yCoord && j == xCoord) {
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
        for (String command : commands) {
            System.out.println(command);
        }
    }
}
