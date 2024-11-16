package browserFactory;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public interface Browser {

    WebDriver setUpBrowser(String Env) throws MalformedURLException;

}
