package cc_card;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class cc_by_card {
    WebDriver driver;

    public cc_by_card() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Progoti\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void cc_card_txn() throws InterruptedException {
        //navigate to credit collection link
        driver.navigate().to("https://tally.pe/VX6A");
        String title = driver.getTitle();

        WebElement amountField = driver.findElement(By.name("amount"));
        amountField.sendKeys("34");

        WebElement submitButton = driver.findElement(By.xpath("/html/body/div/div[1]/form/div[4]/button"));
        submitButton.submit();

        WebElement CardMedia = driver.findElement(By.xpath("/html/body/div/div[1]/div[6]/div[1]/button/div[2]/div"));
        CardMedia.click();

        Thread.sleep(20000);

        WebElement cardHolderName = driver.findElement(By.id("nameOnCard"));
        cardHolderName.sendKeys("shihab");
    }
}
