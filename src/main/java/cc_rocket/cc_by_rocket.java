package cc_rocket;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class cc_by_rocket {
    WebDriver driver;
    public static Map<String, String> propFile = new HashMap<String ,String>();

    properties_file_read prop = new properties_file_read();

    public cc_by_rocket() throws IOException {
        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32_version_111\\chromedriver.exe");
        ChromeOptions chromeOpt = new ChromeOptions();
        chromeOpt.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOpt);
        propFile = prop.envAndFile();
    }

    public void accountAndPinInputForFailed()
    {
        WebElement mobileAccount = driver.findElement(By.xpath("/html/body/div/form/div[2]/div[2]/div[1]/div/table/tbody/tr[3]/td[2]/input"));
        mobileAccount.sendKeys(propFile.get("account"));

        WebElement pin = driver.findElement(By.xpath("/html/body/div/form/div[2]/div[2]/div[1]/div/table/tbody/tr[5]/td[2]/input"));
        pin.sendKeys(propFile.get("wrong_pin"));
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
    public void select_rocket_media_and_proceed_04() throws InterruptedException {
        WebElement RocketMedia = driver.findElement(By.xpath("/html/body/div/div[1]/div[7]/div[2]/button/div[2]/div"));
        RocketMedia.click();

        Thread.sleep(7000);
    }

    @Test(priority = 4)
    public void account_and_pin_input_submit_05()
    {
        WebElement mobileAccount = driver.findElement(By.xpath("/html/body/div/form/div[2]/div[2]/div[1]/div/table/tbody/tr[3]/td[2]/input"));
        mobileAccount.sendKeys(propFile.get("account"));

        WebElement pin = driver.findElement(By.xpath("/html/body/div/form/div[2]/div[2]/div[1]/div/table/tbody/tr[5]/td[2]/input"));
        pin.sendKeys(propFile.get("pin"));

        WebElement submitBtn = driver.findElement(By.xpath("/html/body/div/form/div[2]/div[2]/div[1]/div/table/tbody/tr[10]/td/table/tbody/tr/td[2]/div/input"));
        submitBtn.submit();
    }

    String successIdValue="";
    @Test(priority = 5)
    public void check_success_page_06()
    {
        WebElement successId = driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[2]"));
        successIdValue = successId.getText();
        System.out.println(successIdValue);
    }

    @Test(priority = 6)
    public void check_rocket_txn_table_Status_07() throws SQLException, ClassNotFoundException {
        Connection conn = dbConnection();
        Statement statement;
        ResultSet rs;
        String query = String.format("select * from payment_rockettransactions pr where pr.rrn = '%s'", successIdValue);
        statement = conn.createStatement();
        rs = statement.executeQuery(query);
        while (rs.next())
        {
            System.out.println(rs.getString("status"));
        }
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
            System.out.println("connection failed");
        }
        return conn;
    }

}
