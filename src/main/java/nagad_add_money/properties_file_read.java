package nagad_add_money;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class properties_file_read {
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
}
