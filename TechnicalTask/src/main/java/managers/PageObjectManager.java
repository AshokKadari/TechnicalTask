package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.*;

import java.net.MalformedURLException;

public class PageObjectManager
{
      private WebDriver driver;
      private HomePage homePage;
      private VehicleDetailsPage vehicleDetailsPage;
      private CommonPage commonPage;



      public PageObjectManager(WebDriver driver){
          this.driver=driver;
      }


      public CommonPage getCommonPage(){return (commonPage==null)? commonPage = new CommonPage(driver):commonPage;}
      public HomePage getHomePage(){
          return (homePage == null) ? homePage = new HomePage(driver) : homePage;
      }

      public VehicleDetailsPage getVehicleDetailsPage(){
          return (vehicleDetailsPage == null) ? vehicleDetailsPage = new VehicleDetailsPage(driver) : vehicleDetailsPage;
      }

}
