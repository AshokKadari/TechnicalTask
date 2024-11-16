package pageObjects;

import Utils.SeleniumLib;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends CommonPage
{

    SeleniumLib helpers = new SeleniumLib(driver);

   private By searchVehicleInput = By.cssSelector("#vehicleReg");
   private By milageInput = By.cssSelector("#Mileage");
   private By vehicleValidationButton = By.cssSelector("button#btn-go");

   private By enterdetailsManuallyButton = By.cssSelector("button#e2e-enterdetailsmanually");



    public HomePage(WebDriver driver)
    {
        super(driver);
    }

    public void clickOnAcceptCookiesButton(){

        if(helpers.VerifyPresent(acceptCookiesButton)){
            helpers.WaitForClickable(acceptCookiesButton, "accept cookies").click();
        }
    }



    public HomePage enterVehicleRegToSearch(String vehicleReg)
    {
        helpers.SendKeys(searchVehicleInput,vehicleReg, "Vehicle search Input");
        return this;
    }

    public HomePage enterMilage(String milage)
    {
        helpers.SendKeys(milageInput,milage, "Milage Input");
        return this;
    }

    public HomePage clickSearch()
    {
        helpers.WaitForClickable(vehicleValidationButton, "search vehicle button").click();
        return this;
    }

    public Boolean verifyEnterManuallyDisplayed()
    {
        return helpers.VerifyDisplayed(enterdetailsManuallyButton);
    }



}
