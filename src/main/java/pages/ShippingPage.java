package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShippingPage {

    WebDriver driver;
    WebDriverWait wait;


    public ShippingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    }

    public void addAdShippingDetails(String streetName) {
        WebElement streetInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='street[0]']")));
        streetInput.clear();
        streetInput.sendKeys(streetName);
        WebElement cityInput = driver.findElement(By.xpath("//input[@name='city']"));
        cityInput.sendKeys("Cairo");
        WebElement regionDropdown = driver.findElement(By.xpath("//select[@name='region_id']"));
        Select select = new Select(regionDropdown);
        select.selectByVisibleText("California");
        WebElement postcodeInput = driver.findElement(By.xpath("//input[@name='postcode']"));
        postcodeInput.clear();
        postcodeInput.sendKeys("123456");
        WebElement countryDropdown = driver.findElement(By.xpath("//select[@name='country_id']"));
        Select selectCountry = new Select(countryDropdown);
        selectCountry.selectByVisibleText("Egypt");
        WebElement phoneInput = driver.findElement(By.xpath("//input[@name='telephone']"));
        phoneInput.clear();
        phoneInput.sendKeys("01000000000");

    }
    public void selectFlatRateShipping() {
        WebElement flatRate = driver.findElement(By.xpath("//input[@type='radio' and @value='flatrate_flatrate']"));
        if (!flatRate.isSelected()) {
            flatRate.click();
        }
    }
    public void clickNextAfterShipping() throws InterruptedException {
        WebElement nextButton = driver.findElement(By.xpath("//button[@data-role='opc-continue']"));
        nextButton.click();
        Thread.sleep(1000);
    }

    public void clickPlaceOrder() throws InterruptedException {
        WebElement placeOrderBtn = driver.findElement(By.xpath("//button[.//span[text()='Place Order']]"));
        placeOrderBtn.click();
        Thread.sleep(1000);
    }
}




