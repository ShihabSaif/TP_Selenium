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
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

public class nagad {
    WebDriver driver;

    public static Properties propMain = new Properties();

    public static Map<String, String> propFile = new HashMap<String ,String>();

    properties_file_read prop = new properties_file_read();

    public nagad() throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Progoti\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        propFile = prop.envAndFile();
    }

    public void accountInput()
    {
        WebElement mobileAccount_01 = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/div[1]/input[1]"));
        mobileAccount_01.sendKeys(propFile.get("mobileAccount_01"));

        WebElement mobileAccount_02 = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/div[1]/input[2]"));
        mobileAccount_02.sendKeys(propFile.get("mobileAccount_02"));

        WebElement mobileAccount_03 = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/div[1]/input[3]"));
        mobileAccount_03.sendKeys(propFile.get("mobileAccount_03"));

        WebElement mobileAccount_04 = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/div[1]/input[4]"));
        mobileAccount_04.sendKeys(propFile.get("mobileAccount_04"));

        WebElement mobileAccount_05 = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/div[1]/input[5]"));
        mobileAccount_05.sendKeys(propFile.get("mobileAccount_05"));

        WebElement mobileAccount_06 = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/div[1]/input[6]"));
        mobileAccount_06.sendKeys(propFile.get("mobileAccount_06"));

        WebElement mobileAccount_07 = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/div[1]/input[7]"));
        mobileAccount_07.sendKeys(propFile.get("mobileAccount_07"));

        WebElement mobileAccount_08 = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/div[1]/input[8]"));
        mobileAccount_08.sendKeys(propFile.get("mobileAccount_08"));

        WebElement mobileAccount_09 = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/div[1]/input[9]"));
        mobileAccount_09.sendKeys(propFile.get("mobileAccount_09"));

        WebElement mobileAccount_10 = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/div[1]/input[10]"));
        mobileAccount_10.sendKeys(propFile.get("mobileAccount_10"));

        WebElement mobileAccount_11 = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/div[1]/input[11]"));
        mobileAccount_11.sendKeys(propFile.get("mobileAccount_11"));
    }

    public void pinInput()
    {
        WebElement pin_1 = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/div/input[1]"));
        pin_1.sendKeys(propFile.get("pin_1"));

        WebElement pin_2 = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/div/input[2]"));
        pin_2.sendKeys(propFile.get("pin_2"));

        WebElement pin_3 = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/div/input[3]"));
        pin_3.sendKeys(propFile.get("pin_3"));

        WebElement pin_4 = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/div/input[4]"));
        pin_4.sendKeys(propFile.get("pin_4"));
    }

    public void pinInputForFailed()
    {
        WebElement pin_1 = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/div/input[1]"));
        pin_1.sendKeys(propFile.get("pin_1"));

        WebElement pin_2 = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/div/input[2]"));
        pin_2.sendKeys(propFile.get("pin_2"));

        WebElement pin_3 = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/div/input[3]"));
        pin_3.sendKeys(propFile.get("pin_3"));

        WebElement wrong_pin_4 = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/div/input[4]"));
        wrong_pin_4.sendKeys(propFile.get("wrong_pin_4"));
    }

    public Connection dbConnection() throws ClassNotFoundException, SQLException {
        Connection conn = null;

        Class.forName("org.postgresql.Driver");
        conn = DriverManager.getConnection("jdbc:postgresql://10.9.0.77:5432/nobopay_payment_gw", "shihab", "shihab@007!");

        if (conn != null)
        {
            System.out.println("connection established" + "\n");
        }
        else {
            System.out.println("connection failed");
        }
        return conn;
    }

    public boolean checkStatus() throws SQLException, ClassNotFoundException {
        Connection conn = dbConnection();
        Statement statement;
        ResultSet rs;
        String query = String.format("select * from nagad_txn nt ORDER BY id DESC LIMIT 1");
        statement = conn.createStatement();
        rs = statement.executeQuery(query);
        while (rs.next())
        {
            System.out.println(rs.getString("status"));
            System.out.println(rs.getString("id"));
            if(rs.getString("status") == "SUCCESS")
            {
                return true;
            }
            else {
                return false;
            }
        }
        return true;
    }

    public boolean checkStatusForFailed() throws SQLException, ClassNotFoundException {
        Connection conn = dbConnection();
        Statement statement;
        ResultSet rs;
        String query = String.format("select * from nagad_txn nt ORDER BY id DESC LIMIT 1");
        statement = conn.createStatement();
        rs = statement.executeQuery(query);
        while (rs.next())
        {
            System.out.println(rs.getString("status"));
            System.out.println(rs.getString("id"));
            if(rs.getString("status").contentEquals("FAILED"))
            {
                return true;
            }
            else {
                return false;
            }
        }
        return true;
    }

    @Test
    public void nagadTxn() throws InterruptedException, IOException, ParseException, SQLException, ClassNotFoundException {
        driver.navigate().to(propFile.get("nagad_add_money_url"));

        accountInput();

        WebElement submitBtn = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[3]/button[1]"));
        submitBtn.submit();

        Thread.sleep(10000);

        JSONParser otpParse = new JSONParser();
        Object obj = otpParse.parse(new FileReader("D:/nobopay/CreditCollection/src/main/java/nagad_add_money/otp.json"));
        JSONObject jsonObject = (JSONObject)obj;
        String otp = (String)jsonObject.get("otp");
        System.out.println("otp is : " + otp);

        WebElement otpInput = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/input"));
        otpInput.sendKeys(otp);

        WebElement egiyeJanBtn = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[3]/button[1]"));
        egiyeJanBtn.submit();

        pinInput();

        WebElement egiyeJanBtn_after_pin = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[3]/button[1]"));
        egiyeJanBtn_after_pin.submit();

        if(checkStatus() == true)
        {
            System.out.println("PASSED");
        }
        else
        {
            System.out.println("FAILED");
        }
    }

    @Test
    public void nagadTxnForFailed() throws InterruptedException, IOException, ParseException, SQLException, ClassNotFoundException {
        driver.navigate().to(propFile.get("nagad_add_money_url"));

        accountInput();

        WebElement submitBtn = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[3]/button[1]"));
        submitBtn.submit();

        Thread.sleep(10000);

        JSONParser otpParse = new JSONParser();
        Object obj = otpParse.parse(new FileReader("D:/nobopay/CreditCollection/src/main/java/nagad_add_money/otp.json"));
        JSONObject jsonObject = (JSONObject)obj;
        String otp = (String)jsonObject.get("otp");
        System.out.println("otp is : " + otp);

        WebElement otpInput = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/input"));
        otpInput.sendKeys(otp);

        WebElement egiyeJanBtn = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[3]/button[1]"));
        egiyeJanBtn.submit();

        pinInputForFailed();

        WebElement egiyeJanBtn_after_pin = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[3]/button[1]"));
        egiyeJanBtn_after_pin.submit();

        if(checkStatusForFailed() == true)
        {
            System.out.println("FAILED, expected");
        }
        else
        {
            System.out.println("Not FAILED, unexpected");
        }
    }

}
