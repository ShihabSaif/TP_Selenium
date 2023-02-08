package cc_rocket;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Progoti\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        propFile = prop.envAndFile();
    }

    public void accountAndPinInput()
    {
        WebElement mobileAccount = driver.findElement(By.xpath("/html/body/div/form/div[2]/div[2]/div[1]/div/table/tbody/tr[3]/td[2]/input"));
        mobileAccount.sendKeys(propFile.get("account"));
        System.out.println("account : " + propFile.get("account"));

        WebElement pin = driver.findElement(By.xpath("/html/body/div/form/div[2]/div[2]/div[1]/div/table/tbody/tr[5]/td[2]/input"));
        pin.sendKeys(propFile.get("pin"));
        System.out.println("pin : " + propFile.get("pin"));

    }

    public void accountAndPinInputForFailed()
    {
        WebElement mobileAccount = driver.findElement(By.xpath("/html/body/div/form/div[2]/div[2]/div[1]/div/table/tbody/tr[3]/td[2]/input"));
        mobileAccount.sendKeys(propFile.get("account"));

        WebElement pin = driver.findElement(By.xpath("/html/body/div/form/div[2]/div[2]/div[1]/div/table/tbody/tr[5]/td[2]/input"));
        pin.sendKeys(propFile.get("wrong_pin"));
    }

    @Test
    public void cc_rocket_txn() throws InterruptedException, SQLException, ClassNotFoundException {
        //navigate to credit collection link
        driver.navigate().to(propFile.get("url"));
        String title = driver.getTitle();

        WebElement amountField = driver.findElement(By.name("amount"));
        amountField.sendKeys(propFile.get("amount"));

        WebElement submitButton = driver.findElement(By.xpath("/html/body/div/div[1]/form/div[4]/button"));
        submitButton.submit();

        //select payment media as ROCKET
        WebElement RocketMedia = driver.findElement(By.xpath("/html/body/div/div[1]/div[6]/div[2]/button"));
        RocketMedia.click();

        Thread.sleep(3000);

        accountAndPinInput();

        WebElement submitBtn = driver.findElement(By.xpath("/html/body/div/form/div[2]/div[2]/div[1]/div/table/tbody/tr[10]/td/table/tbody/tr/td[2]/div/input"));
        submitBtn.submit();

        WebElement successId = driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[2]"));
        String successIdValue = successId.getText();
        checkStatus(successIdValue);
    }

    @Test
    public void cc_rocket_txn_for_failed() throws InterruptedException, SQLException, ClassNotFoundException {
        //navigate to credit collection link
        driver.navigate().to(propFile.get("url"));
        String title = driver.getTitle();

        WebElement amountField = driver.findElement(By.name("amount"));
        amountField.sendKeys(propFile.get("amount"));

        WebElement submitButton = driver.findElement(By.xpath("/html/body/div/div[1]/form/div[4]/button"));
        submitButton.submit();

        //select payment media as ROCKET
        WebElement RocketMedia = driver.findElement(By.xpath("/html/body/div/div[1]/div[6]/div[2]/button"));
        RocketMedia.click();

        Thread.sleep(3000);

        accountAndPinInputForFailed();

        WebElement submitBtn = driver.findElement(By.xpath("/html/body/div/form/div[2]/div[2]/div[1]/div/table/tbody/tr[10]/td/table/tbody/tr/td[2]/div/input"));
        submitBtn.submit();

        if(checkStatusForFailed() == true)
        {
            System.out.println("FAILED, expected");
        }
        else
        {
            System.out.println("NOT FAILED, unexpected");
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

    public boolean checkStatus(String id) throws SQLException, ClassNotFoundException {
        Connection conn = dbConnection();
        Statement statement;
        ResultSet rs;
        String query = String.format("select * from payment_rockettransactions pr where pr.rrn = '%s'", id);
        statement = conn.createStatement();
        rs = statement.executeQuery(query);
        while (rs.next())
        {
            System.out.println(rs.getString("status"));
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
        String query = String.format("select * from payment_creditcollection ORDER BY id DESC LIMIT 1");
        statement = conn.createStatement();
        rs = statement.executeQuery(query);
        while (rs.next())
        {
            System.out.println(rs.getString("status"));
            if(rs.getInt("status") == 4)
            {
                return true;
            }
            else {
                return false;
            }
        }
        return true;
    }

}
