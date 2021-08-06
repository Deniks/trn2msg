import java.util.Objects;

public class Transaction {
    private String type; // size - 2
    private String accountNumber; // size - 16
    private String amountInSubmit; // size - 12
    private String time; // size - 14
    private String numericCode; // size - 3
    private String alphaCode;

    private CurrencyCode currencyCode;

    public Transaction(String rawTransaction) {
        type = rawTransaction.substring(0, 2);
        accountNumber = FormatAccountNumber(rawTransaction.substring(2, 18));
        amountInSubmit = FormatAmountInSubmit(rawTransaction.substring(18, 30));
        time = FormatTime(rawTransaction.substring(30, 42));
        currencyCode = new CurrencyCode(rawTransaction.substring(44, 47));
        numericCode = currencyCode.GetNumericCode();
        alphaCode = currencyCode.GetAlphaCode();
    }

    private String FormatAmountInSubmit(String amountInSubmit) {
        String result = "";

        for (int i = 0; i < amountInSubmit.length(); i++) {
            if (amountInSubmit.charAt(i) != '0' || result.length() > 0) {
                if (i == amountInSubmit.length() - 2) result += ".";
                result += amountInSubmit.charAt(i);
            }
        }
        return result;
    }

    private String FormatAccountNumber(String accountNumber) {
        String result = "";

        for (int i = 0; i < accountNumber.length(); i++) {
            if (i > 5 && i < accountNumber.length() - 4) {
                result += "*";
            } else {
                result += accountNumber.charAt(i);
            }
        }

        return result;
    }

    private String FormatTime(String time) {
        String year = time.substring(0, 4);
        String hour = time.substring(8, 10);
        String min = time.substring(10, 12);
        String day = time.substring(4, 6);
        String month = time.substring(6, 8);
        return day + "." + month + "." + year + " " + hour + ":" + min;
    }

    public String GetResult() {
        String message;
        final String PURCHASE = "00";
        final String WITHDRAWAL = "01";
        if (Objects.equals(type, PURCHASE)) {
            message = "Purchase with card " + accountNumber + " on " + time + ", " + amountInSubmit + alphaCode;
        } else if (Objects.equals(type, WITHDRAWAL)) {
            message = "Withdrawal with card " + accountNumber + " on " + time + ", " + amountInSubmit + alphaCode;
        } else {
            throw new Error("Unknown transaction type: " + type);
        }
        return message;
    }

    public void Debug() {
        System.out.println("-------- Transaction Details --------");
        System.out.println(type);
        System.out.println(accountNumber);
        System.out.println(amountInSubmit);
        System.out.println(time);
        System.out.println(numericCode);
        System.out.println(alphaCode);
        System.out.println("----------------------------");

    }
}
