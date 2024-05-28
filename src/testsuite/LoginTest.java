package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

/**
 * 2. Create the package ‘testsuite’ and create the
 * following class inside the ‘testsuite’ package.
 * 1. LoginTest
 * * 3. Write down the following test into ‘LoginTest’ class
 */
public class LoginTest extends BaseTest {

    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    /**
     * 1. userSholdLoginSuccessfullyWithValidCredentials
     * * Enter “tomsmith” username
     * * Enter “SuperSecretPassword!” password
     * * Click on ‘LOGIN’ button
     * * Verify the text “Secure Area”
     */
    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {
        //Enter “tomsmith” username
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
        //Enter “SuperSecretPassword!” password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//i[text()=' Login']")).click();
        // Verify the text “Secure Area”
        String expectedResult = "Secure Area";
        String actualResult = driver.findElement(By.xpath("//h2[text()= ' Secure Area']")).getText();
        Assert.assertEquals("user not login successfully", expectedResult, actualResult);
    }

    /**
     * 2. verifyTheUsernameErrorMessage
     * * Enter “tomsmith1” username
     * * Enter “SuperSecretPassword!” password
     * * Click on ‘LOGIN’ button
     * * Verify the error message “Your username
     * is invalid!”
     */
    @Test
    public void verifyTheUsernameErrorMessage() {
        // Enter “tomsmith1” username
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith1");
        //Enter “SuperSecretPassword!” password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//i[text()=' Login']")).click();
        // Verify the error message “Your username is invalid!”
        String expectedResult = "Your username is invalid!";
        String actualResult = driver.findElement(By.xpath("//div[@id= 'flash' or text()=' Your username is invalid! ']")).getText().substring(0, 25);
        Assert.assertEquals("user not login successfully", expectedResult, actualResult);
    }

    /**
     * 3. verifyThePasswordErrorMessage
     * * Enter “tomsmith” username
     * * Enter “SuperSecretPassword” password
     * * Click on ‘LOGIN’ button
     * * Verify the error message “Your password
     * is invalid!”
     */
    @Test
    public void verifyThePasswordErrorMessage() {
        //Enter “tomsmith” username
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
        //Enter “SuperSecretPassword!” password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecret");
        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//i[text()=' Login']")).click();
        //Verify the error message “Your password is invalid!”
        String expectedResult = "Your password is invalid!";
        String actualResult = driver.findElement(By.xpath("//div[@id = 'flash']")).getText().substring(0, 25);
        Assert.assertEquals("user not login successfully", expectedResult, actualResult);


    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
