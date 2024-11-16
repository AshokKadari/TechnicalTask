package managers;

import browserFactory.DriverFactory;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class DriverManager
{

    public static WebDriver driver;

    private static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();
    private static List<WebDriver> storedDrivers = new ArrayList<>();
    {
        Runtime.getRuntime().addShutdownHook(new Thread()
        {
            public void run() {
                storedDrivers.forEach(WebDriver::quit);
            }
        });
    }
    public DriverManager() throws MalformedURLException {
        if (getDriver() == null)
        {
            String env = FileReaderManager.getConfigFileReader().getEnv();
            String browser = FileReaderManager.configFileReader.getBrowser();
            driver = DriverFactory.get(browser).get().setUpBrowser(env);
            addDriver(driver);
        }
    }


    public static void addDriver(WebDriver driver)
    {
        storedDrivers.add(driver);
        drivers.set(driver);
    }

    public static void removeDriver()
    {
        storedDrivers.remove(drivers.get());
        drivers.remove();
    }


    public static WebDriver getDriver() throws MalformedURLException {
        return drivers.get();
    }


}
