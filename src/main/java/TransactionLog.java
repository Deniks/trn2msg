import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class TransactionLog {
    JSONObject rootJsonObject = new JSONObject();
    JSONObject msgListJsonObject = new JSONObject();
    JSONObject totalsJsonObject = new JSONObject();

    JSONArray msgList;

    private byte msgCount;
    private byte sum;


    //Inserting key-value pairs into the json object


    public TransactionLog(JSONArray msgList) {
        this.msgList = msgList;
        PrepareJSON();
        WriteFile();
    }

    private void WriteFile() {
        try {
            FileWriter file = new FileWriter(Environment.ROOT_PATH + "\\output.json");
            file.write(rootJsonObject.toJSONString());

            file.close();
        } catch (Exception err) {
            throw new Error("Couldn't read the file");
        }
    }

    private void PrepareJSON() {
        msgListJsonObject.put("msg-list", msgList);

        totalsJsonObject.put("cnt", msgList.size());
        totalsJsonObject.put("sum", sum);
        totalsJsonObject.put("date", Environment.GetTime());

        rootJsonObject.put("root", msgListJsonObject);
        msgListJsonObject.put("totals", totalsJsonObject);

    }


}
