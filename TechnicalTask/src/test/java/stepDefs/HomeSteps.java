package stepDefs;

import Utils.commonUtils;
import cucumber.TestContext;
import io.cucumber.java.en.Given;
import pageObjects.HomePage;


public class HomeSteps
{
    TestContext context;
    HomePage homePage;

    public HomeSteps(TestContext context) {
        this.context = context;
        homePage = context.getPageObjectManager().getHomePage();
    }
    @Given("I search for vehicle {int} vehicle registration number extracted with random miles")
    public void i_search_for_vehicle_vehicle_registration_number_extracted_with_random_miles(Integer num) {
        String vehicleReg = CommonSteps.getVehicleToSearch().get(num-1);
        CommonSteps.setVehicleRegSearched(vehicleReg.replaceAll("\\s+",""));
        int milage = commonUtils.RandomNumber();
        homePage.enterVehicleRegToSearch(vehicleReg).enterMilage(String.valueOf(milage)).clickSearch();
    }
}
