package nagad_add_money;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
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
        System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver_win32_113_version\\chromedriver.exe");
        ChromeOptions chromeOpt = new ChromeOptions();
        chromeOpt.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOpt);
        propFile = prop.envAndFile();
    }

    public Connection dbConnection() throws ClassNotFoundException, SQLException {
        Connection conn = null;

        Class.forName("org.postgresql.Driver");
        conn = DriverManager.getConnection("jdbc:postgresql://10.9.0.77:5432/nobopay_payment_gw", "shihab", "shihab@123");

        if (conn != null)
        {
            System.out.println("connection established" + "\n");
        }
        else {
            System.out.println("connection failed");
        }
        return conn;
    }

    public Connection dbConnectionForNpTxnLog() throws ClassNotFoundException, SQLException {
        Connection conn = null;

        Class.forName("org.postgresql.Driver");
        conn = DriverManager.getConnection("jdbc:postgresql://10.9.0.77:5432/backend_db", "shihab", "shihab@123");

        if (conn != null)
        {
            System.out.println("connection established for np_txn_log table" + "\n");
        }
        else {
            System.out.println("connection failed for np_txn_log table" + "\n");
        }
        return conn;
    }

    @Test(priority = 0)
    public void navigate_to_nagad_checkout_page_01()
    {
        driver.navigate().to(propFile.get("nagad_add_money_url"));
        WebElement checkout = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]"));
        Assert.assertEquals("Sandbox Merchant", checkout.getText());
    }

    @Test(priority = 1)
    public void account_Input_and_proceed_02()
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

        WebElement egiyeJanBtn = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[3]/button[1]"));
        egiyeJanBtn.click();
    }

    @Test(priority = 2)
    public void otp_input_and_proceed_03() throws IOException, ParseException, InterruptedException {
        Thread.sleep(20000);
        JSONParser otpParse = new JSONParser();
        Object obj = otpParse.parse(new FileReader("D:/Self_Study/CreditCollection/src/main/java/nagad_add_money/otp.json"));
        JSONObject jsonObject = (JSONObject)obj;
        String otp = (String)jsonObject.get("otp");
        System.out.println("otp is : " + otp);

        WebElement otpInput = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/input"));
        otpInput.sendKeys(otp);

        WebElement egiyeJanBtn = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[3]/button[1]"));
        egiyeJanBtn.submit();
    }

    @Test(priority = 3)
    public void pin_input_and_submit_04() throws InterruptedException {
        Thread.sleep(3000);
        WebElement pin_1 = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/div/input[1]"));
        pin_1.sendKeys(propFile.get("pin_1"));

        WebElement pin_2 = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/div/input[2]"));
        pin_2.sendKeys(propFile.get("pin_2"));

        WebElement pin_3 = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/div/input[3]"));
        pin_3.sendKeys(propFile.get("pin_3"));

        WebElement pin_4 = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/div/input[4]"));
        pin_4.sendKeys(propFile.get("pin_4"));

        WebElement egiyeJanBtn_after_pin = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[3]/button[1]"));
        egiyeJanBtn_after_pin.submit();
    }

    String nagad_txn_table_status = "";
    String nagad_txn_table_txn_number = "";
    @Test(priority = 4)
    public void check_nagad_txn_table_Status_05() throws SQLException, ClassNotFoundException, InterruptedException {
        Thread.sleep(4000);
        Connection conn = dbConnection();
        Statement statement;
        ResultSet rs;
        String query = "";

        query = String.format("select * from nagad_txn pr ORDER BY id DESC LIMIT 1");

        statement = conn.createStatement();
        rs = statement.executeQuery(query);
        while (rs.next())
        {
            nagad_txn_table_status = rs.getString("status");
            nagad_txn_table_txn_number = rs.getString("tp_transaction_number");
            System.out.println("nagad_txn table status is : " + nagad_txn_table_status);
            System.out.println("nagad_txn table tp_transaction_number is : " + nagad_txn_table_txn_number);
        }
    }

    @Test(priority = 5)
    public void check_np_txn_log_table_Status_06() throws SQLException, ClassNotFoundException, InterruptedException {
        Thread.sleep(4000);
        Connection conn = dbConnectionForNpTxnLog();
        Statement statement;
        ResultSet rs;
        statement = conn.createStatement();
        String query = "";
        if(nagad_txn_table_status.contentEquals("SUCCESS"))
        {
            query = String.format("select * from np_txn_log pr where pr.transaction_number = '%s'", nagad_txn_table_txn_number);

            rs = statement.executeQuery(query);
            while (rs.next())
            {
                System.out.println("np_txn_log table status is : " + rs.getString("status"));
            }
        }
        else
        {
            System.out.println("Failed Txn");
        }
    }

//    public void pinInputForFailed()
//    {
//        WebElement pin_1 = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/div/input[1]"));
//        pin_1.sendKeys(propFile.get("pin_1"));
//
//        WebElement pin_2 = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/div/input[2]"));
//        pin_2.sendKeys(propFile.get("pin_2"));
//
//        WebElement pin_3 = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/div/input[3]"));
//        pin_3.sendKeys(propFile.get("pin_3"));
//
//        WebElement wrong_pin_4 = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/div/input[4]"));
//        wrong_pin_4.sendKeys(propFile.get("wrong_pin_4"));
//    }
//
//    public boolean checkStatus() throws SQLException, ClassNotFoundException {
//        Connection conn = dbConnection();
//        Statement statement;
//        ResultSet rs;
//        String query = String.format("select * from nagad_txn nt ORDER BY id DESC LIMIT 1");
//        statement = conn.createStatement();
//        rs = statement.executeQuery(query);
//        while (rs.next())
//        {
//            System.out.println(rs.getString("status"));
//            System.out.println(rs.getString("id"));
//            if(rs.getString("status") == "SUCCESS")
//            {
//                return true;
//            }
//            else {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public boolean checkStatusForFailed() throws SQLException, ClassNotFoundException {
//        Connection conn = dbConnection();
//        Statement statement;
//        ResultSet rs;
//        String query = String.format("select * from nagad_txn nt ORDER BY id DESC LIMIT 1");
//        statement = conn.createStatement();
//        rs = statement.executeQuery(query);
//        while (rs.next())
//        {
//            System.out.println(rs.getString("status"));
//            System.out.println(rs.getString("id"));
//            if(rs.getString("status").contentEquals("FAILED"))
//            {
//                return true;
//            }
//            else {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public void nagadTxn() throws InterruptedException, IOException, ParseException, SQLException, ClassNotFoundException {
//        driver.navigate().to(propFile.get("nagad_add_money_url"));
//
//        accountInput();
//
//        WebElement submitBtn = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[3]/button[1]"));
//        submitBtn.submit();
//
//        Thread.sleep(10000);
//
//        JSONParser otpParse = new JSONParser();
//        Object obj = otpParse.parse(new FileReader("D:/nobopay/CreditCollection/src/main/java/nagad_add_money/otp.json"));
//        JSONObject jsonObject = (JSONObject)obj;
//        String otp = (String)jsonObject.get("otp");
//        System.out.println("otp is : " + otp);
//
//        WebElement otpInput = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/input"));
//        otpInput.sendKeys(otp);
//
//        WebElement egiyeJanBtn = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[3]/button[1]"));
//        egiyeJanBtn.submit();
//
//        pinInput();
//
//        WebElement egiyeJanBtn_after_pin = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[3]/button[1]"));
//        egiyeJanBtn_after_pin.submit();
//
//        if(checkStatus() == true)
//        {
//            System.out.println("PASSED");
//        }
//        else
//        {
//            System.out.println("FAILED");
//        }
//    }
//
//    public void nagadTxnForFailed() throws InterruptedException, IOException, ParseException, SQLException, ClassNotFoundException {
//        driver.navigate().to(propFile.get("nagad_add_money_url"));
//
//        accountInput();
//
//        WebElement submitBtn = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[3]/button[1]"));
//        submitBtn.submit();
//
//        Thread.sleep(10000);
//
//        JSONParser otpParse = new JSONParser();
//        Object obj = otpParse.parse(new FileReader("D:/nobopay/CreditCollection/src/main/java/nagad_add_money/otp.json"));
//        JSONObject jsonObject = (JSONObject)obj;
//        String otp = (String)jsonObject.get("otp");
//        System.out.println("otp is : " + otp);
//
//        WebElement otpInput = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/input"));
//        otpInput.sendKeys(otp);
//
//        WebElement egiyeJanBtn = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[3]/button[1]"));
//        egiyeJanBtn.submit();
//
//        pinInputForFailed();
//
//        WebElement egiyeJanBtn_after_pin = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[3]/button[1]"));
//        egiyeJanBtn_after_pin.submit();
//
//        if(checkStatusForFailed() == true)
//        {
//            System.out.println("FAILED, expected");
//        }
//        else
//        {
//            System.out.println("Not FAILED, unexpected");
//        }
//    }

}
