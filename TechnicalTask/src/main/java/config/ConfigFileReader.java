package config;

import java.io.*;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigFileReader {

    private final Properties properties;

    private final String propertyFilePath = System.getProperty("user.dir") + File.separator + Paths.get("src", "main", "java", "config", "config.properties");

    public ConfigFileReader() {
        BufferedReader bufferedReader;
        try{
            bufferedReader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try{
                properties.load(bufferedReader);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public String getBrowser(){
        return properties.getProperty("browser");
    }

    public String getUrl(String site){
        return properties.getProperty(site);
    }

    public String getEnv(){
        return properties.getProperty("env");
    }
}
