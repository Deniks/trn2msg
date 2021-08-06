import java.io.Console;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
public class ReadFile {
    private String path;
    private String fileContents = "";
    public ReadFile(String path) {
        this.path = "\\" + path;
        ParseFile();
    }

    private void ParseFile() {
        try {
            System.out.println(Environment.ROOT_PATH + path);
            File file = new File(Environment.ROOT_PATH+ path);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                fileContents += scanner.nextLine() + "\n";
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error => Couldn't find your file or read its contents.");
            e.printStackTrace();
        }
    }

    public String GetFileContents() {
        return fileContents;
    }
}
