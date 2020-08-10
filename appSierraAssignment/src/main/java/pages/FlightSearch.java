package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FlightSearch  {


    public WebDriver driver;

    List<WebElement> sortingFlight= (List<WebElement>) By.id("PRICE");
    List<WebElement> selectFlight=(List<WebElement>) By.className("custRad");
    By bookButton = By.className("button fr fltbook fb widthF105 quicks fb");



    public FlightSearch(WebDriver driver) {
        // TODO Auto-generated constructor stub
        this.driver=driver;

    }

    public void sortFlight()
    {
        for (WebElement option : sortingFlight) {
                option.click();
            }
    }

    public void selectFlight()
    {
        for (WebElement option : selectFlight) {
            option.click();
        }
    }

    public void clickBook() {  driver.findElement(bookButton).click();}


}
