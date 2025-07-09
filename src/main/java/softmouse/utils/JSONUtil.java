package softmouse.utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.InputStream;
import java.io.InputStreamReader;

public class JSONUtil {

    public static JSONArray readJSONArray(String fileName) {
        try {
            InputStream inputStream = JSONUtil.class.getClassLoader().getResourceAsStream(fileName);
            if (inputStream == null) {
                throw new RuntimeException("JSON file not found: " + fileName);
            }
            JSONParser parser = new JSONParser();
            return (JSONArray) parser.parse(new InputStreamReader(inputStream));
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse JSON file: " + fileName, e);
        }
    }
}

