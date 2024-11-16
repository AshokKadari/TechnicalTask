package readDataFromFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class extractInputData
{
    public static List<String> extractVehicleNumberPlate(String filePath) throws IOException {

        System.out.println("filePath = " + filePath);
     //   String content1 = new String(Files.readAllBytes(Paths.get("src/main/java/TestData/car_input V4.txt")));
        String content = new String(Files.readAllBytes(Paths.get(filePath)));


        List<String> details = new ArrayList<>();
        Pattern r = Pattern.compile("[A-Z]{2}[0-9]{2} ?[A-Z]{3}");
        Matcher m = r.matcher(content);
        String str = null;
        while(m.find()) {
            details.add(m.group());
        }
        return details;
    }
}
