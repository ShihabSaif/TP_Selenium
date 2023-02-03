import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ByIdOrName;
import rocket_add_money.rocket;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Progoti\\Downloads\\chromedriver_win32\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//
//        //navigate to credit collection link
//        driver.navigate().to("https://tally.pe/VX6A");
//        String title = driver.getTitle();
//
//        WebElement amountField = driver.findElement(By.name("amount"));
//        amountField.sendKeys("34");
//
//        WebElement submitButton = driver.findElement(By.xpath("/html/body/div/div[1]/form/div[4]/button"));
//        submitButton.submit();
//
//        WebElement CardMedia = driver.findElement(By.xpath("/html/body/div/div[1]/div[6]/div[1]/button/div[2]/div"));
//        CardMedia.click();
//
//        Thread.sleep(20000);
//
//        WebElement cardHolderName = driver.findElement(By.id("nameOnCard"));
//        cardHolderName.sendKeys("shihab");

        System.out.println("Give OTP: ");
        Scanner otpInput = new Scanner(System.in);
        String otpInputString = otpInput.nextLine();
        System.out.println(otpInputString);


        // FOR NAGAD ADD MONEY
//        driver.navigate().to("http://10.9.0.77:6060/np-payment-gateway/api/payment/nagad/checkout/01943352555/26.30");
//        WebElement mobileAccount = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/div[1]/input[1]"));
//        mobileAccount.sendKeys("0");

    }
}