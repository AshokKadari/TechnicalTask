package stepDefs;

import cucumber.TestContext;
import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;
import pageObjects.VehicleDetailsPage;

public class VehicleDetailsSteps
{
    TestContext context;
    VehicleDetailsPage vehicleDetailsPage;

    public VehicleDetailsSteps(TestContext context) {
        this.context = context;
        vehicleDetailsPage = context.getPageObjectManager().getVehicleDetailsPage();
    }

    @Then("I verify that searched vehicle is found and details matched from the output file")
    public void i_verify_that_searched_vehicl_is_found_and_details_are_matched_from_the_output_file(){
        Assertions.assertThat(context.getPageObjectManager().getHomePage().verifyEnterManuallyDisplayed()).isFalse();
        Assertions.assertThat(vehicleDetailsPage.vehicleRegNumberDisplayed())
                .isEqualToIgnoringCase(CommonSteps.outPutVehicleDetails.get(CommonSteps.getVehicleRegSearched()).get("VARIANT_REG"));
        Assertions.assertThat(vehicleDetailsPage.vehicleDetailDisplayedOnSite("Manufacturer"))
                .isEqualToIgnoringCase(CommonSteps.outPutVehicleDetails.get(CommonSteps.getVehicleRegSearched()).get("MAKE"));
        Assertions.assertThat(vehicleDetailsPage.vehicleDetailDisplayedOnSite("Model"))
                .isEqualToIgnoringCase(CommonSteps.outPutVehicleDetails.get(CommonSteps.getVehicleRegSearched()).get("MODEL"));
        Assertions.assertThat(vehicleDetailsPage.getYearText())
                .isEqualToIgnoringCase(CommonSteps.outPutVehicleDetails.get(CommonSteps.getVehicleRegSearched()).get("YEAR"));
    }

}
