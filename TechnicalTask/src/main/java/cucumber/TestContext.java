package cucumber;




import managers.DriverManager;
import managers.FileReaderManager;
import managers.PageObjectManager;

import java.net.MalformedURLException;

public class TestContext {
    private DriverManager driverManager;
    private final PageObjectManager pageObjectManager;
    private FileReaderManager fileReaderManager;
    public TestContext()
    {
        try{
            driverManager = new DriverManager();
            pageObjectManager = new PageObjectManager(driverManager.getDriver());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public PageObjectManager getPageObjectManager(){
      return  pageObjectManager;
    }

    public FileReaderManager getFileReaderManager(){
        return fileReaderManager.getInstance();
    }
    public DriverManager getDriverManager() throws MalformedURLException
    {
        return driverManager;
    }
}
