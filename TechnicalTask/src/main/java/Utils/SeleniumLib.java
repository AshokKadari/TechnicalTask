package Utils;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.logging.Logger;


public class SeleniumLib {

    private Logger LOGGER = Logger.getLogger(String.valueOf(SeleniumLib.class));
    private final WebDriver driver;
    @Getter @Setter private int wait = 20000;
    public SeleniumLib(WebDriver driver){
        this.driver=driver;
    }

    public SeleniumLib Wait(int mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }
    public WebDriver GetDriver() {
        return driver;
    }

    public WebElement WaitForVisible(By locator, String comment) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofMillis(getWait()))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(StaleElementReferenceException.class)
                .withMessage(comment + " in :: " + locator);
        LOGGER.info("Waiting for :: " + comment + " find By :: " + locator);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public SeleniumLib SendKeys(By locator, String text, String Comment) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofMillis(getWait()))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(StaleElementReferenceException.class)
                .withMessage("Waiting for element to be visible " + locator);
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        if(e != null){
            e.clear();
            e.sendKeys(text);
            LOGGER.info(text + " :: is entered in :: " + Comment + " :: find By locator :: " + locator );
        }
        return this;
    }

    public List<WebElement> ReturnElementsVisible(By locator) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofMillis(getWait()))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(StaleElementReferenceException.class)
                .withMessage("Waiting for elements to be visible " + locator);
        LOGGER.info("Waiting for elements to be visible :: " + locator);
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public List<WebElement> GetWebElements(By locator){
        return GetDriver().findElements(locator);
    }
    public WebElement GetWebElement(By locator, String comment){
        LOGGER.info("Finding element " +comment+ "  :: By " + locator);
        return GetDriver().findElement(locator);
    }


    public WebElement WaitForClickable(By locator, String Comment) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofMillis(getWait()))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(StaleElementReferenceException.class)
                .withMessage("Waiting for element to be clickable " + locator);
        LOGGER.info("Waiting for :: "+Comment+ " :: to be clickable - find by " + locator);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public String GetText(By locator, String text)
    {
        return WaitForVisible(locator,text).getText();
    }


    public Boolean WaitForText(By locator, String text) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofMillis(getWait()))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(StaleElementReferenceException.class)
                .withMessage("Waiting for text " + text + " in locator " + locator);
        LOGGER.info("Waiting for text " + text + " in locator " + locator);
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }


    public String ReturnPageTitle() {
        return driver.getTitle();
    }

    public SeleniumLib ScrollIntoView(WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView();", element);
        return this;
    }
    public boolean VerifyPresent(By locator) {
        WebElement element = null;
        Loop:
        for (int sec = 1; ; sec++) {
            if (sec == 3) break Loop;
            try {
                if (driver.findElements(locator).size() != 0) {
                    element = driver.findElement(locator);
                    break Loop;
                } else {
                    Wait(2000);
                    LOGGER.info("Waiting for element " + locator + " " + sec);
                }
            } catch (Exception e) {
            }
        }
        boolean present;
        if (element == null) {
            present = false;
        } else {
            present = true;
        }
        return present;
    }

    public boolean VerifyDisplayed(By locator) {
        boolean displayed = false;
        Loop:
        for (int sec = 1; ; sec++) {
            if (sec == 2) break Loop;
            try {
                if (driver.findElements(locator).size() != 0) {
                    if (driver.findElement(locator).isDisplayed()) {
                        displayed = true;
                        break Loop;
                    }
                } else {
                    Wait(2000);
                    LOGGER.info("Waiting for element " + locator + " " + sec);
                }
            } catch (Exception e) {
            }
        }
        return displayed;
    }

    public void WaitToDisappear(WebElement element)
    {
        Assert.assertTrue(WaitUntilDisappear(element));
    }

    private Boolean WaitUntilDisappear(WebElement element)
    {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofMillis(getWait()))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(StaleElementReferenceException.class)
                .withMessage("Waiting for element to disappear " + element);
        return wait.until(ExpectedConditions.invisibilityOf(element));
    }
}