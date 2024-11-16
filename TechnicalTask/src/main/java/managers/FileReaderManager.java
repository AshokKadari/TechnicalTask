package managers;
import config.ConfigFileReader;

public class FileReaderManager
{
    public static ConfigFileReader configFileReader;
    private static FileReaderManager fileReaderManager = new FileReaderManager();
    private FileReaderManager(){
    }

    public static FileReaderManager getInstance(){
        return fileReaderManager;
    }
    public static ConfigFileReader getConfigFileReader(){
        return (configFileReader == null) ? configFileReader = new ConfigFileReader() :configFileReader;
    }
}
