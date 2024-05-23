package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;

public class Task1Scenario2 {
    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        Dimension perefaredSize = new Dimension(1024, 768);
        driver.manage().window().setSize(perefaredSize);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com/");

        // Open today's deals
        WebElement todaysDealsLink = driver.findElement(By.linkText("Today's Deals"));
        todaysDealsLink.click();

        // Select "Headphones" filter
        WebElement headphonesFilter = driver.findElement(By.xpath("//span[text()='Headphones']/preceding-sibling::div"));
        headphonesFilter.click();

        // Select "Grocery" filter
        WebElement groceryFilter = driver.findElement(By.xpath("//span[text()='Grocery']/preceding-sibling::div"));
        groceryFilter.click();

        // Select "10% off or more" filter
        WebElement discountFilter = driver.findElement(By.xpath("//span[text()='10% off or more']/preceding-sibling::div"));
        discountFilter.click();

        // Go to the fourth page
        for (int i = 1; i < 4; i++) {
            WebElement nextPageButton = driver.findElement(By.cssSelector("li.a-last a"));
            nextPageButton.click();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }

        // Select any item from the fourth page
        WebElement firstItem = driver.findElement(By.cssSelector("div.s-main-slot div.s-result-item"));
        firstItem.click();

        // Add item to the cart
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        addToCartButton.click();

        // Go to cart
        WebElement cartButton = driver.findElement(By.id("nav-cart"));
        cartButton.click();

        // Verify item is added to cart
        WebElement cartItem = driver.findElement(By.cssSelector("div.sc-list-item-content"));
        Assert.assertTrue(cartItem.isDisplayed(), "Item is not added to the cart");
        if (driver != null) {
            driver.quit();
        }
    }
}
