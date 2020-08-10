package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;
import pages.FlightSearch;
import pages.LandingPage;
import resources.TestBase;

import java.io.IOException;


public class goIbiboBooking extends TestBase {


    String url = "https://www.goibibo.com/";

    @BeforeTest
    public void setUp() throws IOException {
        driver = initialization(prop.getProperty("browser"));
    }

    @Test
    public void flightBooking() {

        // Steps to open Website
        driver.get(prop.getProperty("url"));

        // Steps to enter the data by reading it from Properties File and click on Search
        LandingPage l=new LandingPage(driver);
        l.clickRoundTrip();
        l.getfromDestination().sendKeys(prop.getProperty("fromDest"));
        //WebElement dropDown = l.findElement(By.cssSelector("*[aria-activedescendant=react-autosuggest-1-suggestion--0]");
        WebDriverWait wait=new WebDriverWait(driver, 10);
        WebElement dropDownS=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("*[aria-activedescendant=react-autosuggest-1-suggestion--0]")));
        dropDownS.click();
        l.getTargetDestination().sendKeys(prop.getProperty("targetDest"));
        WebElement dropDownT=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("*[aria-activedescendant=react-autosuggest-1-suggestion--0]")));
        dropDownT.click();
        l.getDepartureDate().click();
        driver.findElement(By.id("fare_"+prop.getProperty("departDate"))).click();
        l.getReturnDate().click();
        driver.findElement(By.id("fare_"+prop.getProperty("returnDate"))).click();
        l.clickSearch();

        // Doing Sorting and selecting the expensive flight

        FlightSearch f=new FlightSearch(driver);
        f.sortFlight();
        f.selectFlight();
        f.clickBook();

        // Doing the Payment
        // Unfortunately Book was not successful and i was getting below error in the console
//
//        Uncaught TypeError: t.map is not a function
//        at t.render (flt_flights-afede7ca7fa633ef979e.js:2)
//        at p._renderValidatedComponentWithoutOwnerOrContext (flt_vendor-b0de0dae49a907e51c63.js:54)
//        at p._renderValidatedComponent (flt_vendor-b0de0dae49a907e51c63.js:54)
//        at p._updateRenderedComponent (flt_vendor-b0de0dae49a907e51c63.js:54)
//        at p._performComponentUpdate (flt_vendor-b0de0dae49a907e51c63.js:54)
//        at p.updateComponent (flt_vendor-b0de0dae49a907e51c63.js:54)
//        at p.receiveComponent (flt_vendor-b0de0dae49a907e51c63.js:54)
//        at Object.receiveComponent (flt_vendor-b0de0dae49a907e51c63.js:6)
//        at Object.updateChildren (flt_vendor-b0de0dae49a907e51c63.js:54)
//        at v._reconcilerUpdateChildren (flt_vendor-b0de0dae49a907e51c63.js:55)
//        at v._updateChildren (flt_vendor-b0de0dae49a907e51c63.js:55)
//        at v.updateChildren (flt_vendor-b0de0dae49a907e51c63.js:55)
//        at v._updateDOMChildren (flt_vendor-b0de0dae49a907e51c63.js:54)
//        at v.updateComponent (flt_vendor-b0de0dae49a907e51c63.js:54)
//        at v.receiveComponent (flt_vendor-b0de0dae49a907e51c63.js:54)
//        at Object.receiveComponent (flt_vendor-b0de0dae49a907e51c63.js:6)
//        at p._updateRenderedComponent (flt_vendor-b0de0dae49a907e51c63.js:54)
//        at p._performComponentUpdate (flt_vendor-b0de0dae49a907e51c63.js:54)
//        at p.updateComponent (flt_vendor-b0de0dae49a907e51c63.js:54)
//        at p.receiveComponent (flt_vendor-b0de0dae49a907e51c63.js:54)
//        at Object.receiveComponent (flt_vendor-b0de0dae49a907e51c63.js:6)
//        at p._updateRenderedComponent (flt_vendor-b0de0dae49a907e51c63.js:54)
//        at p._performComponentUpdate (flt_vendor-b0de0dae49a907e51c63.js:54)
//        at p.updateComponent (flt_vendor-b0de0dae49a907e51c63.js:54)
//        at performUpdateIfNecessary (flt_vendor-b0de0dae49a907e51c63.js:54)
//        at Object.performUpdateIfNecessary (flt_vendor-b0de0dae49a907e51c63.js:6)
//        at s (flt_vendor-b0de0dae49a907e51c63.js:6)
//        at r.perform (flt_vendor-b0de0dae49a907e51c63.js:8)
//        at o.perform (flt_vendor-b0de0dae49a907e51c63.js:8)
//        at o.perform (flt_vendor-b0de0dae49a907e51c63.js:6)
//        at Object.S [as flushBatchedUpdates] (flt_vendor-b0de0dae49a907e51c63.js:6)
//        at r.closeAll (flt_vendor-b0de0dae49a907e51c63.js:8)
//        at r.perform (flt_vendor-b0de0dae49a907e51c63.js:8)
//        at Object.batchedUpdates (flt_vendor-b0de0dae49a907e51c63.js:55)
//        at Object.i [as batchedUpdates] (flt_vendor-b0de0dae49a907e51c63.js:6)
//        at dispatchEvent (flt_vendor-b0de0dae49a907e51c63.js:55)


    }

    @AfterTest
    public void tearDown()
    {
        driver.close();
        driver=null;
    }

    }





