package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

public class TendableTest {

    private WebDriver driver;
    private HomePage homePage;
    private OurStoryPage ourStoryPage;
    private OurSolutionPage ourSolutionPage;
    private WhyTendablePage whyTendablePage;
    private ContactUsPage contactUsPage;

    @BeforeClass
    public void setUp() {
        // Set up the WebDriver for Chrome
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tendable.com");

        // Initialize the page objects
        homePage = new HomePage(driver);
        ourStoryPage = new OurStoryPage(driver);
        ourSolutionPage = new OurSolutionPage(driver);
        whyTendablePage = new WhyTendablePage(driver);
        contactUsPage = new ContactUsPage(driver);
    }

    @Test(priority = 1)
    public void testTopLevelMenus() {
        Assert.assertTrue(homePage.getHomeLogo().isDisplayed(), "Home menu should be visible");
        System.out.println("Home(tendable) menu is visible.");
        System.out.println("========================================");
    }

    @Test(priority = 2)
    public void testRequestDemoButton() {
        homePage.clickRequestDemoButton();
        Assert.assertTrue(homePage.getRequestDemoButton().isDisplayed() && homePage.getRequestDemoButton().isEnabled(), "Request a Demo button should be visible and clickable on Home page");
        System.out.println("Request Demo Button is avaialable on Home Page");
    }

    @Test(priority = 3)
    public void testContactUsForm() throws InterruptedException {
        contactUsPage.clickContactUs();
        contactUsPage.clickMarketingButton();
        contactUsPage.fillFullName("Deepak");
        contactUsPage.fillEmail("test@gmail.com");
        Thread.sleep(3000);
        contactUsPage.clickSubmit();
        Assert.assertEquals(contactUsPage.getErrorMessage(), "Sorry, there was an error submitting the form. Please try again.");
        System.out.println("Error message should show when 'Message' field is empty");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
