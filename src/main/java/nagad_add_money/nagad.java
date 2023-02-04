package nagad_add_money;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

public class nagad {
    WebDriver driver;

    public static Properties propMain = new Properties();
    public static Map<String, String> fileAndEnv = new HashMap<String ,String>();
    public static Map<String, String> envAndFile() throws IOException {
        FileInputStream fisDev = new FileInputStream("D:\\nobopay\\CreditCollection\\src\\main\\java\\cc_nagad\\nagad.properties");
        propMain.load(fisDev);
        fileAndEnv.put("nagad_add_money_url", propMain.getProperty("nagad_add_money_url"));
        fileAndEnv.put("amount", propMain.getProperty("amount"));
        fileAndEnv.put("mobileAccount_01", propMain.getProperty("mobileAccount_01"));
        fileAndEnv.put("mobileAccount_02", propMain.getProperty("mobileAccount_02"));
        fileAndEnv.put("mobileAccount_03", propMain.getProperty("mobileAccount_03"));
        fileAndEnv.put("mobileAccount_04", propMain.getProperty("mobileAccount_04"));
        fileAndEnv.put("mobileAccount_05", propMain.getProperty("mobileAccount_05"));
        fileAndEnv.put("mobileAccount_06", propMain.getProperty("mobileAccount_06"));
        fileAndEnv.put("mobileAccount_07", propMain.getProperty("mobileAccount_07"));
        fileAndEnv.put("mobileAccount_08", propMain.getProperty("mobileAccount_08"));
        fileAndEnv.put("mobileAccount_09", propMain.getProperty("mobileAccount_09"));
        fileAndEnv.put("mobileAccount_10", propMain.getProperty("mobileAccount_10"));
        fileAndEnv.put("mobileAccount_11", propMain.getProperty("mobileAccount_11"));
        fileAndEnv.put("pin_1", propMain.getProperty("pin_1"));
        fileAndEnv.put("pin_2", propMain.getProperty("pin_2"));
        fileAndEnv.put("pin_3", propMain.getProperty("pin_3"));
        fileAndEnv.put("pin_4", propMain.getProperty("pin_4"));
        return fileAndEnv;
    }

    public nagad() throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Progoti\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        envAndFile();
    }

    @Test
    public void nagadTxn() throws InterruptedException, IOException, ParseException {
        driver.navigate().to(fileAndEnv.get("nagad_add_money_url"));

        WebElement mobileAccount_01 = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/div[1]/input[1]"));
        mobileAccount_01.sendKeys(fileAndEnv.get("mobileAccount_01"));

        WebElement mobileAccount_02 = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/div[1]/input[2]"));
        mobileAccount_02.sendKeys(fileAndEnv.get("mobileAccount_02"));

        WebElement mobileAccount_03 = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/div[1]/input[3]"));
        mobileAccount_03.sendKeys(fileAndEnv.get("mobileAccount_03"));

        WebElement mobileAccount_04 = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/div[1]/input[4]"));
        mobileAccount_04.sendKeys(fileAndEnv.get("mobileAccount_04"));

        WebElement mobileAccount_05 = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/div[1]/input[5]"));
        mobileAccount_05.sendKeys(fileAndEnv.get("mobileAccount_05"));

        WebElement mobileAccount_06 = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/div[1]/input[6]"));
        mobileAccount_06.sendKeys(fileAndEnv.get("mobileAccount_06"));

        WebElement mobileAccount_07 = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/div[1]/input[7]"));
        mobileAccount_07.sendKeys(fileAndEnv.get("mobileAccount_07"));

        WebElement mobileAccount_08 = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/div[1]/input[8]"));
        mobileAccount_08.sendKeys(fileAndEnv.get("mobileAccount_08"));

        WebElement mobileAccount_09 = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/div[1]/input[9]"));
        mobileAccount_09.sendKeys(fileAndEnv.get("mobileAccount_09"));

        WebElement mobileAccount_10 = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/div[1]/input[10]"));
        mobileAccount_10.sendKeys(fileAndEnv.get("mobileAccount_10"));

        WebElement mobileAccount_11 = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/div[1]/input[11]"));
        mobileAccount_11.sendKeys(fileAndEnv.get("mobileAccount_11"));

        WebElement submitBtn = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[3]/button[1]"));
        submitBtn.submit();

        Thread.sleep(180000);

        JSONParser otpParse = new JSONParser();
        Object obj = otpParse.parse(new FileReader("D:/nobopay/CreditCollection/src/main/java/nagad_add_money/otp.json"));
        JSONObject jsonObject = (JSONObject)obj;
        String otp = (String)jsonObject.get("otp");
        System.out.println("otp is : " + otp);

        WebElement otpInput = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/input"));
        otpInput.sendKeys(otp);

        WebElement egiyeJanBtn = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[3]/button[1]"));
        egiyeJanBtn.submit();

        WebElement pin_1 = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/div/input[1]"));
        pin_1.sendKeys(fileAndEnv.get("pin_1"));

        WebElement pin_2 = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/div/input[2]"));
        pin_2.sendKeys(fileAndEnv.get("pin_2"));

        WebElement pin_3 = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/div/input[3]"));
        pin_3.sendKeys(fileAndEnv.get("pin_3"));

        WebElement pin_4 = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/div/input[4]"));
        pin_4.sendKeys(fileAndEnv.get("pin_4"));

        WebElement egiyeJanBtn_after_pin = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[3]/button[1]"));
        egiyeJanBtn_after_pin.submit();


    }
}
