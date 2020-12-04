import java.util.Map;
import java.util.HashMap;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class Plates {
    private Map<String, Integer> plateMap;

    public Plates() {
        plateMap = new HashMap<String, Integer>();
    }

    public void buildMap() {
        try (BufferedReader myReader = new BufferedReader(new FileReader("plates.txt"))) {
            String line = myReader.readLine();
            while (line != null) {
                String stateAbbrev[] = line.split(" +");
                for (String state : stateAbbrev) {
                    state = cleanUp(state);
                    if(!plateMap.containsKey(state)) {
                        plateMap.put(state, 1);
                    }
                    else {
                        int frequency = plateMap.get(state);
                        plateMap.put(state, frequency + 1);
                    }
                }
                line = myReader.readLine();
            }
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private String cleanUp(String state) {
        String cleanedState = "";
        state = state.toUpperCase();
        for (Character c : state.toCharArray()) {
            if (Character.isLetter(c)) {
                cleanedState = cleanedState + c;
            }
        }
        return cleanedState.trim();
    }

    public void printCounts() {
        /* do not edit the implementation of this method*/
        System.out.println("Number of Plates: " + plateMap.keySet().size());
        for (String key : plateMap.keySet())
        System.out.printf("%s -> %s%n", key, plateMap.get(key));
    }
}
