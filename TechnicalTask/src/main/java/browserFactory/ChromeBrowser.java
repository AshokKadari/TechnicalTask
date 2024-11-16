package browserFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeBrowser implements Browser{

    WebDriver driver;
    @Override
    public WebDriver setUpBrowser(String Env) throws MalformedURLException {

        switch (Env.toLowerCase()){
            case "local":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("enable-automation");
                options.addArguments("--disable-infobars");
                options.addArguments("--disable-extensions");
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("start-maximized");
                options.addArguments("--incognito");
                // WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(options);
                break;
            case "remote":
                  //TODO
        }
        return driver;
    }
}
