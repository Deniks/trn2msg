import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            String transactionFileName = "seed";//InputManager.INPUT_FILE_NAME; // "\\src\\main\\java\\seed";
            ReadFile file = new ReadFile(transactionFileName);
            Transactions transaction = new Transactions(file.GetFileContents());
        } catch (Exception err) {
            System.out.println("-------- Runtime Error --------");
            System.out.println(err);
            ErrorLog errorLog = new ErrorLog(err.toString());
            errorLog.WriteFile();
        }
    }
}