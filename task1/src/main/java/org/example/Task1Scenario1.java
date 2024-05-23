package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;

public class Task1Scenario1 {
    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        Dimension perefaredSize = new Dimension(1024, 768);
        driver.manage().window().setSize(perefaredSize);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com/");

        // Search for "car accessories"
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("car accessories");
        searchBox.submit();
        // Select the first item
        WebElement firstItem = driver.findElement(By.cssSelector("div.s-main-slot div.s-result-item"));
        firstItem.click();

        // Add item to cart
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
