package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OurSolutionPage {
    WebDriver driver;

    By requestDemoButton = By.xpath("//a[text()='Request A Demo']");

    public OurSolutionPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getRequestDemoButton() {
        return driver.findElement(requestDemoButton);
    }

    public void clickRequestDemoButton() {
        getRequestDemoButton().click();
    }
}
