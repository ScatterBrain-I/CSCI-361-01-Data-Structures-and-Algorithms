/*
Takes an input txt file from user and creates a frequencyFile.txt from import.
frequencyFile.txt creates an unsorted list "[char], [frequency]" on each line.
*/
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Frequency {
    public void frequency() {
        String str = "";

        Scanner kb = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String fileName = kb.nextLine();

        try {
            File myFile = new File(fileName);
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                str = (str + data);
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            File myObj = new File("frequencyFile.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            }
            else {
                System.out.println("frequencyFile.txt has been overwritten with new data.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        int[] freq = new int[str.length()];
        int i, j;
        char string[] = str.toCharArray();

        try {
            FileWriter myWriter = new FileWriter("frequencyFile.txt");

            for(i = 0; i <str.length(); i++) {
                freq[i] = 1;
                for(j = i + 1; j <str.length(); j++) {
                    if(string[i] == string[j]) {
                        freq[i]++;
                        string[j] = '0';
                    }
                }
            }
            for(i = 0; i <freq.length; i++) {
                if(string[i] != '0')
                    myWriter.write(string[i] + "," + freq[i] + "\n");
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
