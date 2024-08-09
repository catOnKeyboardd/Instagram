import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/*
Open Instagram on desktop and select followers/following and drag down 
copying everything.

Place followers in txt1 and following in txt2
- txt1.txt is followers
- txt2.txt is folloing

Compile the java file and run - java FollowerDifference txt1.txt txt2.txt output.txt
 */

public class FollowerDifference {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java WordDifference <file1> <file2> <outputFile>");
            return;
        }

        String file1 = args[0];
        String file2 = args[1];
        String outputFile = args[2];

        Set<String> wordsInFile1 = new HashSet<>();

        try (BufferedReader reader1 = new BufferedReader(new FileReader(file1))) {
            String line;
            while ((line = reader1.readLine()) != null) {
                wordsInFile1.add(line.trim());
            }
        } catch (IOException e) {
            System.err.println("ajksdajfhkjf " + e.getMessage());
            return;
        }

        try (BufferedReader reader2 = new BufferedReader(new FileReader(file2));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = reader2.readLine()) != null) {
                String word = line.trim();
                if (!wordsInFile1.contains(word)) {
                    writer.write(word);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.err.println("safkhaskjfas " + e.getMessage());
        }
    }
}
