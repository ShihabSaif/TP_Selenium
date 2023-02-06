package rocket_add_money;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
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

    public void accountAndPinInput()
    {
        WebElement mobileAccount = driver.findElement(By.xpath("/html/body/div/form/div[2]/div[2]/div[1]/div/table/tbody/tr[3]/td[2]/input"));
        mobileAccount.sendKeys(propFile.get("account"));

        WebElement pin = driver.findElement(By.xpath("/html/body/div/form/div[2]/div[2]/div[1]/div/table/tbody/tr[5]/td[2]/input"));
        pin.sendKeys(propFile.get("pin"));
    }

    @Test
    public void rocketTxn() throws SQLException, ClassNotFoundException, InterruptedException {

        //navigate to rocket link
        driver.navigate().to(propFile.get("url"));

        accountAndPinInput();

        WebElement submitBtn = driver.findElement(By.xpath("/html/body/div/form/div[2]/div[2]/div[1]/div/table/tbody/tr[10]/td/table/tbody/tr/td[2]/div/input"));
        submitBtn.submit();

        Thread.sleep(5000);

        if(checkStatus() == true)
        {
            System.out.println("PASSED");
        }
        else {
            System.out.println("FAILED");
        }
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
        String query = String.format("select * from dbbl_transaction dt ORDER BY id DESC LIMIT 1");
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
}

