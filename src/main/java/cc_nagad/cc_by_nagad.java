package cc_nagad;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class cc_by_nagad {
    WebDriver driver;

    public static Properties propMain = new Properties();

    public static Map<String, String> propFile = new HashMap<String ,String>();

    cc_nagad.properties_file_read prop = new properties_file_read();

    public cc_by_nagad() throws IOException {
        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32_version_111\\chromedriver.exe");
        ChromeOptions chromeOpt = new ChromeOptions();
        chromeOpt.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOpt);
        propFile = prop.envAndFile();
    }


    public Connection dbConnection() throws ClassNotFoundException, SQLException {
        Connection conn = null;

        Class.forName("org.postgresql.Driver");
        conn = DriverManager.getConnection("jdbc:postgresql://10.9.0.41:5432/tallykhta_tusi", "shihab", "shihab@123");

        if (conn != null)
        {
            System.out.println("connection established" + "\n");
        }
        else {
            System.out.println("connection failed" + "\n");
        }
        return conn;
    }

    @Test(priority = 0)
    public void navigate_to_cc_page_01() throws InterruptedException {
        driver.navigate().to(propFile.get("url"));
        String title = driver.getTitle();
        System.out.println("title is : " + title);

        Thread.sleep(3000);
    }

    @Test(priority = 1)
    public void tap_porishodh_kori_button_02() throws InterruptedException {
        WebElement porishodhKoriBtn = driver.findElement(By.xpath("/html/body/div[1]/div/div[5]/div[3]/a/span"));
        porishodhKoriBtn.click();

        Thread.sleep(3000);
    }

    @Test(priority = 2)
    public void give_amount_and_proceed_to_payment_media_03() throws InterruptedException {
        WebElement amountField = driver.findElement(By.name("amount"));
        amountField.sendKeys(propFile.get("amount"));

        WebElement submitButton = driver.findElement(By.xpath("/html/body/div/div[1]/form/div[4]/button"));
        submitButton.submit();

        Thread.sleep(3000);
    }

    @Test(priority = 3)
    public void select_nagad_media_and_proceed_04() throws InterruptedException {
        WebElement NagadMedia = driver.findElement(By.xpath("/html/body/div/div[1]/div[7]/div[3]/button/div[2]/div/span"));
        NagadMedia.click();

        Thread.sleep(4000);
    }

    @Test(priority = 4)
    public void account_Input_and_proceed_05()
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

    @Test(priority = 5)
    public void otp_input_and_proceed_06() throws IOException, ParseException, InterruptedException {
        Thread.sleep(18000);
        JSONParser otpParse = new JSONParser();
        Object obj = otpParse.parse(new FileReader("D:/nobopay/CreditCollection/src/main/java/nagad_add_money/otp.json"));
        JSONObject jsonObject = (JSONObject)obj;
        String otp = (String)jsonObject.get("otp");
        System.out.println("otp is : " + otp);

        WebElement otpInput = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[1]/input"));
        otpInput.sendKeys(otp);

        WebElement egiyeJanBtn = driver.findElement(By.xpath("/html/body/div/div/div[4]/form/div[3]/button[1]"));
        egiyeJanBtn.submit();
    }

    @Test(priority = 6)
    public void pin_input_and_submit_07()
    {
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

    String successID = "";
    @Test(priority = 7)
    public void success_page_check_08()
    {
        WebElement successPage = driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[2]"));
        successID = successPage.getText();
        System.out.println(successID);
    }

    @Test(priority = 8)
    public void check_nagad_txn_table_Status_09() throws SQLException, ClassNotFoundException {
        Connection conn = dbConnection();
        Statement statement;
        ResultSet rs;
        String query = String.format("select * from payment_nagadtransaction pr where pr.issuer_payment_reference = '%s'", successID);
        statement = conn.createStatement();
        rs = statement.executeQuery(query);
        while (rs.next())
        {
            System.out.println(rs.getString("status"));
        }
    }
}
