import org.json.simple.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class Transactions {
    private String[] rawTransactions;
    private  List<Transaction> transactions = new ArrayList<>();
    private JSONArray msgList = new JSONArray();
    private double sumOfAmounts;

    public Transactions(String transactionFileInput) {
        this.rawTransactions = transactionFileInput.split("\n");

        for (String rawTransaction : rawTransactions) {
            Transaction transaction = new Transaction(rawTransaction);
            transaction.Debug();
            msgList.add(transaction.GetResult());
            transactions.add(transaction);
        }

        TransactionLog transactionLog = new TransactionLog(msgList);
    }


}
