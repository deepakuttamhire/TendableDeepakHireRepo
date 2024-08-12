package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver;

    By homeLogo = By.xpath("//img[@alt='Tendable Logo']");
    By requestDemoButton = By.xpath("//a[text()='Request A Demo']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getHomeLogo() {
        return driver.findElement(homeLogo);
    }

    public WebElement getRequestDemoButton() {
        return driver.findElement(requestDemoButton);
    }

    public void clickRequestDemoButton() {
        getRequestDemoButton().click();
    }
}
