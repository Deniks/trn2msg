import java.io.FileWriter;

public class ErrorLog {

    private String errorMessage;
private String path = Environment.ROOT_PATH + "\\error.log";
    public ErrorLog(String errorMessage) {
        this.errorMessage = errorMessage;
        WriteFile();
    }
    public void WriteFile() {
        try {
            FileWriter file = new FileWriter(path);
            file.write(Environment.GetTime() + " | " + errorMessage);
            file.close();
        } catch (Exception err) {
            throw new Error("Couldn't read the file");
        }
    }
}
