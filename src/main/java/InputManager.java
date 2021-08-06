public class InputManager {
    static String INPUT_FILE_NAME;
    static String OUTPUT_FILE_NAME;

    public static void main(String[] args) {
        if (args.length != 1) {
            throw new Error("Only 2 arguments are expected");
        }
        INPUT_FILE_NAME = args[0];
        OUTPUT_FILE_NAME = args[1];
    }
}
