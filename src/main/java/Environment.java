import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Environment {
    static final boolean PRODUCTION = false;
    static final String ROOT_PATH = System.getProperty("user.dir") + (Environment.PRODUCTION ? "" : "\\src\\main\\java");

    static String GetTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
}
