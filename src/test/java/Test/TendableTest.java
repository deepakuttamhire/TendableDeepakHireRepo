package Test;

//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.junit.Assert.*;

public class TendableTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set up the WebDriver for Chrome
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tendable.com");
    }

    @Test(priority = 1)
    public void testTopLevelMenus() {
        // Test if top-level menus are visible
        WebElement homeMenu = driver.findElement(By.xpath("//img[@alt='Tendable Logo']"));
        WebElement ourStoryMenu = driver.findElement(By.linkText("Our Story"));
        WebElement ourSolutionMenu = driver.findElement(By.linkText("Our Solution"));
        WebElement whyTendableMenu = driver.findElement(By.xpath("//body/header/div/nav/ul/li[3]/a"));

        assertTrue("Home menu should be visible", homeMenu.isDisplayed());
        System.out.println("Home(tendable) menu is visible.");
        assertTrue("Our Story menu should be visible", ourStoryMenu.isDisplayed());
        System.out.println("Our Story menu is visible.");
        assertTrue("Our Solution menu should be visible", ourSolutionMenu.isDisplayed());
        System.out.println("Our Solution menu is visible.");
        assertTrue("Why Tendable menu should be visible", whyTendableMenu.isDisplayed());
        System.out.println("Why Tendable menu is visible.");
        System.out.println("========================================");
    }

    @Test(priority = 2)
    public void testRequestDemoButton() {
        // Test if "Request a Demo" button is on each page
        // Check Home page
        WebElement homeMenu = driver.findElement(By.xpath("//img[@alt='Tendable Logo']"));
        homeMenu.click();
        WebElement demoButtonHome = driver.findElement(By.xpath("//a[text()='Request A Demo']"));
        assertTrue("'Request a Demo' button should be visible and clickable on Home page", demoButtonHome.isDisplayed() && demoButtonHome.isEnabled());
        System.out.println("Request Demo Button is avaialable on Home Page");
        // Check Our Story page
        WebElement ourStoryMenu = driver.findElement(By.linkText("Our Story"));
        ourStoryMenu.click();
        WebElement demoButtonOurStory = driver.findElement(By.xpath("//a[text()='Request A Demo']"));
        assertTrue("'Request a Demo' button should be visible and clickable on Our Story page", demoButtonOurStory.isDisplayed() && demoButtonOurStory.isEnabled());
        System.out.println("Request Demo Button is avaialable on Our Story");
        // Check Our Solution page
        WebElement ourSolutionMenu = driver.findElement(By.linkText("Our Solution"));
        ourSolutionMenu.click();
        WebElement demoButtonOurSolution = driver.findElement(By.xpath("//a[text()='Request A Demo']"));
        assertTrue("'Request a Demo' button should be visible and clickable on Our Solution page", demoButtonOurSolution.isDisplayed() && demoButtonOurSolution.isEnabled());
        System.out.println("Request Demo Button is avaialable on Our Solution");
        // Check Why Tendable page
        WebElement whyTendableMenu = driver.findElement(By.xpath("//body/header/div/nav/ul/li[3]/a"));
        whyTendableMenu.click();
        WebElement demoButtonWhyTendable = driver.findElement(By.xpath("//a[text()='Request A Demo']"));
        assertTrue("'Request a Demo' button should be visible and clickable on Why Tendable page", demoButtonWhyTendable.isDisplayed() && demoButtonWhyTendable.isEnabled());
        System.out.println("Request Demo Button is avaialable on Why Tendable Page");
    }

    @Test(priority = 3)
    public void testContactUsForm() throws InterruptedException {
        // Test the Contact Us form
        driver.findElement(By.xpath("//a[text()='Contact Us']")).click();
        driver.findElement(By.xpath("(//button[text()='Contact'])[1]")).click(); // Select "Marketing" option

        driver.findElement(By.xpath("(//input[@id='form-input-fullName'])[1]")).sendKeys("Deepak");
        driver.findElement(By.xpath("(//input[@id='form-input-email'])[1]")).sendKeys("test@gmail.com");
        //driver.findElement(By.xpath("//form[@id='contactMarketingPipedrive-163701']//input[@id='form-input-consentAgreed-0']")).click(); // radio button
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[contains(@data-loading-text,'Loading...')][normalize-space()='Submit']")).click(); // Click submit button

        String errorMessage = driver.findElement(By.xpath("//p[contains(text(),'Sorry, there was an error submitting the form. Ple')]")).getText(); // Check for error message
        //assertTrue("Error message should show when 'Message' field is empty", errorMessage.isDisplayed());
        Assert.assertEquals(errorMessage, "Sorry, there was an error submitting the form. Please try again.");
        System.out.println("Error message should show when 'Message' field is empty");
    }

    @AfterClass
    public void tearDown() {
        // Clean up after tests
        if (driver != null) {
            driver.quit();
        }
    }
}
    
