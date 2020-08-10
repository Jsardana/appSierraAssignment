package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage  {


    public WebDriver driver;

    By roundTrip=By.id("roundTrip");
    By fromDestination=By.id("gosuggest_inputSrc");
    By targetDestination=By.id("gosuggest_inputDest");
    By departureDate=By.id("departureCalendar");
    By returnDate=By.id("returnCalendar");
    By search=By.id("gi_search_btn");

    public LandingPage(WebDriver driver) {
        // TODO Auto-generated constructor stub
        this.driver=driver;

    }

    public void clickRoundTrip()
    {
        driver.findElement(roundTrip).click();
    }
    public WebElement getfromDestination()
    {
        return driver.findElement(fromDestination);
    }
    public WebElement getTargetDestination() { return driver.findElement(targetDestination); }
    public WebElement getDepartureDate()
    {
        return driver.findElement(departureDate);
    }
    public WebElement getReturnDate()
    {
        return driver.findElement(returnDate);
    }
    public void clickSearch() {  driver.findElement(search).click(); }

}
