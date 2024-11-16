package pageObjects;

import Utils.SeleniumLib;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonPage
{


    protected WebDriver driver;
    SeleniumLib helpers = new SeleniumLib(driver);

    protected By acceptCookiesButton = By.cssSelector("button#onetrust-accept-btn-handler");
    public CommonPage(WebDriver driver)
    {
        this.driver = driver;
    }


    public void openSite(String url){
        driver.get(url);
    }
}

