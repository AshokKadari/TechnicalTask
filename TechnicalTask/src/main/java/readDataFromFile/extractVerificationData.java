package readDataFromFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class extractVerificationData implements readVehicleDetails
{
    BufferedReader reader = null;
    @Override
    public Map<String, LinkedHashMap<String, String>> getVehicleDetails(String filePath) {

        Map<String, LinkedHashMap<String, String>> outerMap = new HashMap<String, LinkedHashMap<String, String>>();
        LinkedHashMap<String, String> innerMap = new LinkedHashMap<>();
        int counter = 0;
        String delimitor = ",";
        String line = "";

        try {
            reader = new BufferedReader(new FileReader(filePath));
            String keyValues = reader.readLine();
            String [] keys = keyValues.split(delimitor);
            while ((line = reader.readLine()) != null) {
                String[] info = line.split(delimitor);
                innerMap.put(keys[0],info[0]);
                innerMap.put(keys[1],info[1]);
                innerMap.put(keys[2],info[2]);
                innerMap.put(keys[3],info[3]);
                String key = info[0];
                if(!outerMap.containsKey(key)){
                    outerMap.put(key, new LinkedHashMap<>(innerMap));
                }
            }
        } catch(IOException e){
        }
        return outerMap;
    }
}
