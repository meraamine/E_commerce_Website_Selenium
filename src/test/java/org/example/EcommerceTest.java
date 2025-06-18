package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.CreateAccountPage;
import pages.ShoppingPage;

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
        accountPage.enterFirstName("asaraAAMsaraA22");
        accountPage.enterLastName("SsaaaraAASaraMA22");
        accountPage.enterEmail("SarsaraaaSS2552@test.com");
        accountPage.enterPassword("saraacaSaraRAASALAMAA226655@@$$S");
        accountPage.clickCreateAccountButton();
        Thread.sleep(2000); // optional

        ShoppingPage shoppingPage = new ShoppingPage(driver);
        shoppingPage.navigateToHoodieProduct();
        shoppingPage.customizeProduct();
        shoppingPage.addToCartAndGoToCheckout();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
