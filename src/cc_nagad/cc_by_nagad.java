package cc_nagad;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class cc_by_nagad {
    WebDriver driver;

    public cc_by_nagad() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Progoti\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void cc_nagad_txn() throws InterruptedException {
        //navigate to credit collection link
        driver.navigate().to("https://tally.pe/VX6A");
        String title = driver.getTitle();

        WebElement amountField = driver.findElement(By.name("amount"));
        amountField.sendKeys("34");

        WebElement submitButton = driver.findElement(By.xpath("/html/body/div/div[1]/form/div[4]/button"));
        submitButton.submit();

        WebElement NagadMedia = driver.findElement(By.xpath("/html/body/div/div[1]/div[6]/div[3]/button/div[2]"));
        NagadMedia.click();

        Thread.sleep(5000);

        WebElement mobileAccount_01 = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/div[1]/input[1]"));
        mobileAccount_01.sendKeys("0");
    }
}
