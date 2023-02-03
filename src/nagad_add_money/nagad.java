package nagad_add_money;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Scanner;

public class nagad {
    WebDriver driver;

    public nagad() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Progoti\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void nagadTxn() throws InterruptedException {
        driver.navigate().to("http://10.9.0.77:6060/np-payment-gateway/api/payment/nagad/checkout/01943352555/26.30");

        WebElement mobileAccount_01 = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/div[1]/input[1]"));
        mobileAccount_01.sendKeys("0");

        WebElement mobileAccount_02 = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/div[1]/input[2]"));
        mobileAccount_02.sendKeys("1");

        WebElement mobileAccount_03 = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/div[1]/input[3]"));
        mobileAccount_03.sendKeys("4");

        WebElement mobileAccount_04 = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/div[1]/input[4]"));
        mobileAccount_04.sendKeys("0");

        WebElement mobileAccount_05 = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/div[1]/input[5]"));
        mobileAccount_05.sendKeys("1");

        WebElement mobileAccount_06 = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/div[1]/input[6]"));
        mobileAccount_06.sendKeys("7");

        WebElement mobileAccount_07 = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/div[1]/input[7]"));
        mobileAccount_07.sendKeys("9");

        WebElement mobileAccount_08 = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/div[1]/input[8]"));
        mobileAccount_08.sendKeys("7");

        WebElement mobileAccount_09 = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/div[1]/input[9]"));
        mobileAccount_09.sendKeys("7");

        WebElement mobileAccount_10 = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/div[1]/input[10]"));
        mobileAccount_10.sendKeys("8");

        WebElement mobileAccount_11 = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/div[1]/input[11]"));
        mobileAccount_11.sendKeys("3");

        WebElement submitBtn = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[3]/button[1]"));
        submitBtn.submit();

        System.out.println("Give OTP: ");
        Scanner otpInput = new Scanner(System.in);
        String otpInputString = otpInput.nextLine();

        WebElement otp = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/input"));
        otp.sendKeys(otpInputString);
    }
}
