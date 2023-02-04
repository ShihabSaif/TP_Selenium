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

    public static Map<String, String> propFile = new HashMap<String ,String>();

    properties_file_read prop = new properties_file_read();

    public rocket() throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Progoti/Downloads/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        propFile = prop.envAndFile();
    }

    @Test
    public void rocketTxn()
    {

        //navigate to rocket link
        driver.navigate().to(propFile.get("url"));

        WebElement mobileAccount = driver.findElement(By.xpath("/html/body/div/form/div[2]/div[2]/div[1]/div/table/tbody/tr[3]/td[2]/input"));
        mobileAccount.sendKeys(propFile.get("account"));

        WebElement pin = driver.findElement(By.xpath("/html/body/div/form/div[2]/div[2]/div[1]/div/table/tbody/tr[5]/td[2]/input"));
        pin.sendKeys(propFile.get("pin"));

        WebElement submitBtn = driver.findElement(By.xpath("/html/body/div/form/div[2]/div[2]/div[1]/div/table/tbody/tr[10]/td/table/tbody/tr/td[2]/div/input"));
        submitBtn.submit();
    }

}
