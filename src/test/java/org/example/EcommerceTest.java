package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.CreateAccountPage;
import pages.ShoppingPage;
import pages.ShippingPage;
import utils.DataGenerator;


@Listeners(utils.TestListener.class)
public class EcommerceTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
    }

    @Test
    public void testFullScenario() throws InterruptedException {
        driver.get("https://magento.softwaretestingboard.com/customer/account/create/");

        String firstName = DataGenerator.generateRandomName("Mera");
        String lastName = DataGenerator.generateRandomName("Amin");
        String email = DataGenerator.generateRandomEmail();
        String password = "Mera//@2@$MMt22226655@@$$S";

        CreateAccountPage accountPage = new CreateAccountPage(driver);
        accountPage.enterFirstName(firstName);
        accountPage.enterLastName(lastName);
        accountPage.enterEmail(email);
        accountPage.enterPassword(password);
        accountPage.clickCreateAccountButton();
        Thread.sleep(500);

        ShoppingPage shoppingPage = new ShoppingPage(driver);
        shoppingPage.navigateToHoodieProduct();
        shoppingPage.customizeProduct();
        shoppingPage.addToCartAndGoToCheckout();

        ShippingPage shippingPage = new ShippingPage(driver);
        shippingPage.addAdShippingDetails("123 Test Street");
        shippingPage.selectFlatRateShipping();
        shippingPage.clickNextAfterShipping();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
