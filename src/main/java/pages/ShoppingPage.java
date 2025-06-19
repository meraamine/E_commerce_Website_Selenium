package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShoppingPage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;


    public ShoppingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.actions = new Actions(driver);
    }

    public void navigateToHoodieProduct() throws InterruptedException {
        WebElement womenMenu = driver.findElement(By.xpath("//span[text()='Women']"));
        actions.moveToElement(womenMenu).perform();
        Thread.sleep(500);

        WebElement topsMenu = driver.findElement(By.xpath("//span[text()='Tops']"));
        actions.moveToElement(topsMenu).perform();
        Thread.sleep(500);

        WebElement hoodiesMenu = driver.findElement(By.xpath("//span[text()='Hoodies & Sweatshirts']"));
        hoodiesMenu.click();
        Thread.sleep(500);

        driver.findElement(By.xpath("//img[contains(@src, 'wh11-blue')]")).click();
    }

    public void customizeProduct() throws InterruptedException {
        WebElement color = driver.findElement(By.xpath("//div[@option-tooltip-value='#1857f7']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", color);
        Thread.sleep(1000);

        WebElement sizeXS = driver.findElement(By.xpath("//*[@option-label='XS']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sizeXS);
        Thread.sleep(1000);

        WebElement qtyInput = driver.findElement(By.id("qty"));
        qtyInput.clear();
        qtyInput.sendKeys("7");
        Thread.sleep(1000);

    }

    public void addToCartAndGoToCheckout() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // 1. Add to cart
        WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("product-addtocart-button")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCartBtn);

        // 2. Wait for success message
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.message-success")));

        // 3. Open mini-cart
        WebElement cartIcon = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(@class, 'action showcart')]")));
        cartIcon.click();

        // 4. Wait for mini-cart to open
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.block-minicart")));

        // 5. Try clicking "View and Edit Cart", fallback if needed
        try {
            WebElement viewCartLink = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.action.viewcart")));
            viewCartLink.click();
        } catch (TimeoutException e) {
            System.out.println("View Cart not clickable, navigating directly.");
            driver.get("https://yourdomain.com/checkout/cart");
        }

        // 6. Wait for cart page and click "Proceed to Checkout"
        // التأكد من الوصول لصفحة الكارت
        wait.until(ExpectedConditions.urlContains("/checkout/cart"));

// انتظار وجود الزر
        WebElement proceedBtn = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("button.action.primary.checkout")
        ));

// تمرير الشاشة للزر
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", proceedBtn);

// تأخير بسيط اختياري
        Thread.sleep(1000);

// الضغط على الزر بالـ JavaScript لتجاوز أي مشاكل overlay أو CSS
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", proceedBtn);


    }




}





