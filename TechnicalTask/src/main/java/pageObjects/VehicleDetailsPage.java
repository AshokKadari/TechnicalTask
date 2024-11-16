package pageObjects;

import Utils.SeleniumLib;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VehicleDetailsPage extends CommonPage
{

    SeleniumLib helpers = new SeleniumLib(driver);

    private By vehicleDetail(String detail)
    {
        return By.xpath("(//div[contains(text(),'"+detail+"')]/following-sibling::div)[2]");
    }
    private By year = By.xpath("(//div[text()='Year:']/following-sibling::div)[2]");

    private By regNumber = By.xpath("(//div[@id='vehicleImage']//div[@class='details-vrm ng-star-inserted'])[2]");

    public VehicleDetailsPage(WebDriver driver)
    {
        super(driver);
    }


    public String vehicleDetailDisplayedOnSite(String detail)
    {
        return helpers.GetText(vehicleDetail(detail),"Vehicle detail text of "+detail+"");
    }

    public String getYearText(){
        return helpers.GetText(year,"Vehicle detail text of Year");
    }


    public String vehicleRegNumberDisplayed(){
        return helpers.GetText(regNumber, "Vehicle details - Vehicle Reg");
    }
}
