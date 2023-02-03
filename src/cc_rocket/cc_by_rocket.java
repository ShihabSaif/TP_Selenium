package cc_rocket;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class cc_by_rocket {
    WebDriver driver;
    public cc_by_rocket() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Progoti\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void cc_rocket_txn() throws InterruptedException {
        //navigate to credit collection link
        driver.navigate().to("https://tally.pe/VX6A");
        String title = driver.getTitle();

        WebElement amountField = driver.findElement(By.name("amount"));
        amountField.sendKeys("34");

        WebElement submitButton = driver.findElement(By.xpath("/html/body/div/div[1]/form/div[4]/button"));
        submitButton.submit();

        WebElement RocketMedia = driver.findElement(By.xpath("/html/body/div/div[1]/div[6]/div[2]/button"));
        RocketMedia.click();

        Thread.sleep(5000);

        WebElement mobileAccount = driver.findElement(By.xpath("/html/body/div/form/div[2]/div[2]/div[1]/div/table/tbody/tr[3]/td[2]/input"));
        mobileAccount.sendKeys("016704946645");

        WebElement pin = driver.findElement(By.xpath("/html/body/div/form/div[2]/div[2]/div[1]/div/table/tbody/tr[5]/td[2]/input"));
        pin.sendKeys("5696");

        WebElement submitBtn = driver.findElement(By.xpath("/html/body/div/form/div[2]/div[2]/div[1]/div/table/tbody/tr[10]/td/table/tbody/tr/td[2]/div/input"));
        submitBtn.submit();
    }

}
