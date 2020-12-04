import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FaceLikes {
    private Set<String> uniqueUsers;
    private Map<String, ArrayList<String>> likes;
    private Map<String, ArrayList<String>> likedBys;

    public FaceLikes() {
        uniqueUsers = new HashSet<String>();
        likes = new HashMap<String, ArrayList<String>>();
        likedBys = new HashMap<String, ArrayList<String>>();
    }

    public void buildMaps() {
        try (BufferedReader myReader = new BufferedReader(new FileReader("users.txt"))) {
            String line = myReader.readLine();
            while (line != null) {
                String splitLine[] = line.split(": ");
                uniqueUsers.add(splitLine[0]);
                String likers[] = splitLine[1].split(", ");
                for (String person : likers) {
                    uniqueUsers.add(person);
                    ArrayList<String> addLiker = likes.get(splitLine[0]);
                    if (addLiker == null) {
                        addLiker = new ArrayList<String>();
                        addLiker.add(person);
                        likes.put(splitLine[0], addLiker);
                    }
                    else {
                        if (!addLiker.contains(splitLine[0])) {
                            addLiker.add(person);
                        }
                    }
                    ArrayList<String> addPerson = likedBys.get(person);
                    if (addPerson == null) {
                        addPerson = new ArrayList<String>();
                        addPerson.add(splitLine[0]);
                        likedBys.put(person, addPerson);
                    }
                    else {
                        if (!addPerson.contains(person)) {
                            addPerson.add(splitLine[0]);
                        }
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

    public void getAllUsers() {
        System.out.print("Unique Users (" + uniqueUsers.size() + "): ");
        for (String user : uniqueUsers) {
            System.out.printf("%s ", user);
        }
        System.out.println();
    }

    public void getLikes(String liked) {
        if (likes.containsKey(liked)) {
            List<String> likers = likes.get(liked);
            System.out.printf("%s liked by (%d): ", liked, likers.size());
            for (String user : likers) {
                System.out.printf("%s ", user);
            }
            System.out.println();
        }
        else {
            System.out.printf("%s is not liked by anyone.%n", liked);
        }
    }

    public void getLikedBy(String likedBy) {
        if (likedBys.containsKey(likedBy)) {
            List<String> likedByers = new ArrayList<String>();
            likedByers = likedBys.get(likedBy);
            System.out.printf("%s likes (%d): ", likedBy, likedByers.size());
            for (String user : likedByers) {
                System.out.printf("%s ", user);
            }
            System.out.println();
        }
        else {
            System.out.printf("%s does not like anyone.%n", likedBy);
        }
    }
}
