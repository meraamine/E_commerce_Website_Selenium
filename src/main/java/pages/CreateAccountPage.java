package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateAccountPage {

    WebDriver driver;

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterFirstName(String firstName) {
        driver.findElement(By.id("firstname")).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(By.id("lastname")).sendKeys(lastName);
    }

    public void enterEmail(String email) {
        driver.findElement(By.id("email_address")).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("password-confirmation")).sendKeys(password);
    }

    public void clickCreateAccountButton() {
        driver.findElement(By.xpath("//*[@title='Create an Account']")).click();
    }
}

