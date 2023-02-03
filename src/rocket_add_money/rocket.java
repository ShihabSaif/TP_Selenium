package rocket_add_money;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Scanner;

public class rocket {

    WebDriver driver;

    public rocket() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Progoti\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void rocketTxn()
    {

        //navigate to rocket link
        driver.navigate().to("http://10.9.0.77:6060/np-payment-gateway/api/payment/dbbl/create-txn/6/01943352555/23.19");

        WebElement mobileAccount = driver.findElement(By.xpath("/html/body/div/form/div[2]/div[2]/div[1]/div/table/tbody/tr[3]/td[2]/input"));
        mobileAccount.sendKeys("016704946645");

        WebElement pin = driver.findElement(By.xpath("/html/body/div/form/div[2]/div[2]/div[1]/div/table/tbody/tr[5]/td[2]/input"));
        pin.sendKeys("5696");

        WebElement submitBtn = driver.findElement(By.xpath("/html/body/div/form/div[2]/div[2]/div[1]/div/table/tbody/tr[10]/td/table/tbody/tr/td[2]/div/input"));
        submitBtn.submit();
    }

}
