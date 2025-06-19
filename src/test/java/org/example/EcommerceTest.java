package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.CreateAccountPage;
import pages.ShoppingPage;
import pages.ShippingPage;



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
        CreateAccountPage accountPage = new CreateAccountPage(driver);
        accountPage.enterFirstName("laGGGscccttMMest");
        accountPage.enterLastName("lasHGccGtlaMMst");
        accountPage.enterEmail("lastGGlascct1MM@test.com");
        accountPage.enterPassword("laGGstlaccsMMt22226655@@$$S");
        accountPage.clickCreateAccountButton();
        Thread.sleep(500); // optional

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
