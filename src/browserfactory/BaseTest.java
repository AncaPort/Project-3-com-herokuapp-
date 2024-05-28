package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/**
 * 1. Create the package ‘browserfactory’ and create the
 * class with the name ‘BaseTest’ inside the
 * ‘browserfactory’ package. And write the browser setup
 * code inside the class ‘Base Test’.
 */
public class BaseTest {

    public static WebDriver driver;

    public void openBrowser(String baseUrl) {
        //Launch the Chrome browser
        driver = new ChromeDriver();
        //open the url into browser
        driver.get(baseUrl);
        //maximize browser window
        driver.manage().window().maximize();
        //implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
    }

    public void closeBrowser() {
        driver.quit();//close all the tabs using quit()
    }

}
