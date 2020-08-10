package resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;

    public static WebDriver initialization(String browserName) throws IOException {

        prop= new Properties();
        FileInputStream fis=new FileInputStream("resources/data.properties");
        prop.load(fis);

        if(browserName.equals("chrome")){
            //System.setProperty("webdriver.chrome.driver", "/Users/jayant/Downloads/chromedriver");
            driver = new ChromeDriver();
        }

        else if(browserName.equals("FF")){
            //System.setProperty("webdriver.gecko.driver", "/Users/jayant/Documents/SeleniumServer/geckodriver");
            driver = new FirefoxDriver();
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;

    }









}
