@vehicleSearch
Feature: Verify vehicle details feature

  Background:
    Given I read and Extract vehicle reg from the provided input file  and output file
  Scenario Outline: Verify given vehicle details match with the details in the webuyany car site
    And I navigate to <site> website
    And I search for vehicle <INDEX> vehicle registration number extracted with random miles
    Then I verify that searched vehicle is found and details matched from the output file

    Examples:
    |site           |INDEX|
    |webuyAnyCar    |1    |
    |webuyAnyCar    |2    |
    |webuyAnyCar    |3    |
    |webuyAnyCar    |4    |