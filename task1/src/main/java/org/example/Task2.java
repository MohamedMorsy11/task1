package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class Task2 {
    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        Dimension perefaredSize = new Dimension(1024, 768);
        driver.manage().window().setSize(perefaredSize);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://ksrtc.in/oprs-web/guest/home.do?h=1");

        // Choose route from "CHIKKAMAGALURU" to "BENGALURU"
        WebElement fromRoute = driver.findElement(By.linkText("CHIKKAMAGALURU"));
        fromRoute.click();
        WebElement toRoute = driver.findElement(By.linkText("BENGALURU"));
        toRoute.click();

        // Choose the arrival date
        WebElement dateInput = driver.findElement(By.id("txtJourneyDate"));
        dateInput.click();
        // Assuming the current date is selected for simplicity; adjust the selector as needed
        WebElement selectedDate = driver.findElement(By.cssSelector(".ui-datepicker-current-day a"));
        selectedDate.click();

        // Click "Search for bus"
        WebElement searchBusButton = driver.findElement(By.xpath("//button[text()='Search for Bus']"));
        searchBusButton.click();

        // Select a seat
        // Note: Adjust the selector as needed to correctly identify a seat element
        WebElement seatSelectButton = driver.findElement(By.cssSelector(".seat-available"));
        seatSelectButton.click();

        // Choose the boarding point and dropping point
        WebElement boardingPoint = driver.findElement(By.id("boardingPointId"));
        boardingPoint.click();
        WebElement boardingOption = driver.findElement(By.cssSelector("#boardingPointId option[value='1']")); // Adjust the value as needed
        boardingOption.click();

        WebElement droppingPoint = driver.findElement(By.id("droppingPointId"));
        droppingPoint.click();
        WebElement droppingOption = driver.findElement(By.cssSelector("#droppingPointId option[value='2']")); // Adjust the value as needed
        droppingOption.click();

        // Fill the "Customer" and "Passenger" details
        WebElement customerName = driver.findElement(By.id("customerName"));
        customerName.sendKeys("John Doe");

        WebElement customerPhone = driver.findElement(By.id("mobileNo"));
        customerPhone.sendKeys("6789125987");

        WebElement customerEmail = driver.findElement(By.id("email"));
        customerEmail.sendKeys("johndoe@example.com");

        WebElement passengerName = driver.findElement(By.id("passengerName"));
        passengerName.sendKeys("John Doe");

        WebElement passengerGender = driver.findElement(By.id("genderCodeId"));
        passengerGender.click();
        WebElement genderOption = driver.findElement(By.cssSelector("#genderCodeId option[value='M']")); // M for Male
        genderOption.click();

        WebElement passengerAge = driver.findElement(By.id("passengerAge"));
        passengerAge.sendKeys("30");

        // Click on "make payment"
        WebElement makePaymentButton = driver.findElement(By.id("makePayment"));
        makePaymentButton.click();

        // Fill all fields in the payment section without submitting the payment
        // Note: Adjust selectors as needed for your specific implementation
        WebElement cardNumber = driver.findElement(By.id("cardNumber"));
        cardNumber.sendKeys("1234567812345678");

        WebElement cardName = driver.findElement(By.id("cardName"));
        cardName.sendKeys("John Doe");

        WebElement cardExpiryMonth = driver.findElement(By.id("expiryMonth"));
        cardExpiryMonth.sendKeys("12");

        WebElement cardExpiryYear = driver.findElement(By.id("expiryYear"));
        ((WebElement) cardExpiryYear).sendKeys("2025");

        WebElement cardCvv = driver.findElement(By.id("cvv"));
        cardCvv.sendKeys("123");

        // Verify that we are on the payment page by checking for the presence of the "Submit" button
        WebElement submitButton = driver.findElement(By.id("submit"));
        Assert.assertTrue(submitButton.isDisplayed(), "Submit button is not displayed");
        if (driver != null) {
            driver.quit();
        }

    }
}
