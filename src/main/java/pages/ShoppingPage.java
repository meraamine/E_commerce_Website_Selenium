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
        qtyInput.sendKeys("5");

    }
    public void addToCartAndGoToCheckout() {
        // الضغط على زر Add to Cart
        WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("product-addtocart-button")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCartBtn);

        // الضغط على أيقونة My Cart في الهيدر
        WebElement cartIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.action.showcart")));
        cartIcon.click();

        // الضغط على اللينك اللي بياخدنا لصفحة الكارت (checkout/cart)
        WebElement viewCartLink = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.action.viewcart")));
        viewCartLink.click();

        // التأكد إننا فعلاً على صفحة الكارت
        wait.until(ExpectedConditions.urlContains("/checkout/cart"));

        // الضغط على زر Proceed to Checkout من صفحة الكارت
        WebElement proceedBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.action.primary.checkout")));
        proceedBtn.click();
    }

}





