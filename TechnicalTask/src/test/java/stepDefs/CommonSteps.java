package stepDefs;

import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import lombok.Getter;
import lombok.Setter;
import managers.FileReaderManager;
import pageObjects.CommonPage;
import pageObjects.HomePage;
import readDataFromFile.extractInputData;
import readDataFromFile.extractVerificationData;
import readDataFromFile.readVehicleDetails;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CommonSteps
{
    TestContext context;
    CommonPage commonPage;
    HomePage homepage;


    @Getter @Setter
    public static List<String> vehicleToSearch;
    @Getter @Setter
    public static Map<String, LinkedHashMap<String, String>> outPutVehicleDetails;

    @Getter @Setter
    public static String vehicleRegSearched;




    private final String DIR = System.getProperty("user.dir");
    String inPutfilePath;
    String outPutFilePath;
    public CommonSteps(TestContext context) {

        this.context = context;
        homepage = context.getPageObjectManager().getHomePage();
        commonPage = context.getPageObjectManager().getCommonPage();
    }


    @Given("I navigate to webuyAnyCar website")
    public void i_navigate_to_webuy_any_car_website() {
       String url = FileReaderManager.getConfigFileReader().getUrl("webuyAnyCarUrl");
        commonPage.openSite(url);
        homepage.clickOnAcceptCookiesButton();
    }

    @Given("I read and Extract vehicle reg from the provided input file  and output file")
    public void i_read_and_extract_vehicle_reg_from_the_provided_input_file_and_output_file() throws IOException {
        inPutfilePath= DIR + File.separator+"car_input_V4.txt";
        setVehicleToSearch(extractInputData.extractVehicleNumberPlate(inPutfilePath));
        outPutFilePath=  DIR + File.separator+"car_output_V4.txt";
        setOutPutVehicleDetails(new extractVerificationData().getVehicleDetails(outPutFilePath));
    }

}
