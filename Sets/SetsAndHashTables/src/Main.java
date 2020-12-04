public class Main {
    public static void main(String[] args) {
        Plates main = new Plates();
        main.buildMap();
        main.printCounts();
        /*
        * The output should be:
        *
        * Number of Plates: 6
        * MA -> 2
        * ME -> 3
        * WA -> 1
        * NY -> 5
        * NJ -> 2
        * VT -> 1
        */
    }
}
