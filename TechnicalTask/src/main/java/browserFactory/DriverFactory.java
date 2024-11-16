package browserFactory;

import java.util.HashMap;
import java.util.function.Supplier;

public class DriverFactory
{
    public static final Supplier<Browser> ChromeDriver = ChromeBrowser:: new;
    public static final Supplier<Browser> FirefoxDriver = ChromeBrowser:: new;

    public static HashMap<String, Supplier<Browser>> map = new HashMap<>();

    static{
        map.put("chrome", ChromeDriver);
        map.put("firefox", FirefoxDriver);
    }
    public static Supplier<Browser> get(String browser){
        return map.get(browser);
    }


}
