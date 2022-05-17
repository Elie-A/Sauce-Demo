package utilities.applicationUtilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import managers.DriverManager;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.*;

public class Parsers {



    public List<String> getCredentials(String filePath, String mainKey, String usernameKey, String passwordKey) throws Exception{
        List<String> credentials = new ArrayList<>();

        JSONParser parser = new JSONParser();
        File file = getFileFromResource(DriverManager.absolutePath , filePath);
        FileReader reader = new FileReader(file);

        Object jsonObject = parser.parse(reader);
        JSONObject jsonObj = (JSONObject) jsonObject;

        JSONObject subSubJsonObj = (JSONObject) jsonObj.get(mainKey);
        String email = (String) subSubJsonObj.get(usernameKey);
        String password = (String) subSubJsonObj.get(passwordKey);

        credentials.add(email);
        credentials.add(password);

        return credentials;
    }

    public Map<String, String> jsonToHashMap(String filePath) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JSONParser parser = new JSONParser();

        File file = getFileFromResource(DriverManager.absolutePath , filePath);
        FileReader reader = new FileReader(file);

        Object jsonObject = parser.parse(reader);
        JSONObject jsonObj = (JSONObject) jsonObject;

        String jsonObjStr = jsonObj.toJSONString();
        Map<String, String> jsonData = mapper.readValue(jsonObjStr,
                Map.class);
        return jsonData;
    }

    private File getFileFromResource(String absolutePath, String fileName) throws Exception {

        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(absolutePath + fileName);
        if (resource == null) {
            DriverManager.killDriverProcess();
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return new File(resource.toURI());
        }
    }
}
