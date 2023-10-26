package Utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class JsonUtils {


    public static String getValue(String fileName, String keyName) {

        String filePath = String.format("./src/Resources/%s",fileName);
        JSONParser parser =new JSONParser();
        JSONObject jsonObject;
        String value = "";
        Reader reader;

        try
        {
            reader = new FileReader(filePath);
            jsonObject = (JSONObject) parser.parse(reader);
            value = (String)jsonObject.get(keyName);
            reader.close();
        }
        catch(IOException e)  {
            e.printStackTrace();
        }
        catch(ParseException e)  {
            e.printStackTrace();
        }
        return value;
    }
}
