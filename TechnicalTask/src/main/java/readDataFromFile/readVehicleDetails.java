package readDataFromFile;

import java.util.LinkedHashMap;
import java.util.Map;

public interface readVehicleDetails
{

    public Map<String, LinkedHashMap<String, String>> getVehicleDetails(String filePath);
}
