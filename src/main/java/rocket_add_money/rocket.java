package rocket_add_money;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

public class rocket {

    WebDriver driver;

    public static Properties propMain = new Properties();
    public static Map<String, String> fileAndEnv = new HashMap<String ,String>();
    public static Map<String, String> envAndFile() throws IOException {
        FileInputStream fisDev = new FileInputStream("D:/nobopay/CreditCollection/src/main/java/rocket_add_money/rocket.properties");
        propMain.load(fisDev);
        fileAndEnv.put("url", propMain.getProperty("url"));
        fileAndEnv.put("account", propMain.getProperty("account"));
        fileAndEnv.put("pin", propMain.getProperty("pin"));
        return fileAndEnv;
    }

    public rocket() throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Progoti/Downloads/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        envAndFile();
    }

    @Test
    public void rocketTxn()
    {

        //navigate to rocket link
        driver.navigate().to(fileAndEnv.get("url"));

        WebElement mobileAccount = driver.findElement(By.xpath("/html/body/div/form/div[2]/div[2]/div[1]/div/table/tbody/tr[3]/td[2]/input"));
        mobileAccount.sendKeys(fileAndEnv.get("account"));

        WebElement pin = driver.findElement(By.xpath("/html/body/div/form/div[2]/div[2]/div[1]/div/table/tbody/tr[5]/td[2]/input"));
        pin.sendKeys(fileAndEnv.get("pin"));

        WebElement submitBtn = driver.findElement(By.xpath("/html/body/div/form/div[2]/div[2]/div[1]/div/table/tbody/tr[10]/td/table/tbody/tr/td[2]/div/input"));
        submitBtn.submit();
    }

}
