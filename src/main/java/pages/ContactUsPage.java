package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage {
    WebDriver driver;

    By contactUsLink = By.xpath("//a[text()='Contact Us']");
    By marketingButton = By.xpath("(//button[text()='Contact'])[1]");
    By fullNameField = By.xpath("(//input[@id='form-input-fullName'])[1]");
    By emailField = By.xpath("(//input[@id='form-input-email'])[1]");
    By submitButton = By.xpath("//button[contains(@data-loading-text,'Loading...')][normalize-space()='Submit']");
    By errorMessage = By.xpath("//p[contains(text(),'Sorry, there was an error submitting the form. Ple')]");

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickContactUs() {
        driver.findElement(contactUsLink).click();
    }

    public void clickMarketingButton() {
        driver.findElement(marketingButton).click();
    }

    public void fillFullName(String fullName) {
        driver.findElement(fullNameField).sendKeys(fullName);
    }

    public void fillEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void clickSubmit() {
        driver.findElement(submitButton).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}
