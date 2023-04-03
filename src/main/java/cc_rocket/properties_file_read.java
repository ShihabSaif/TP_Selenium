package cc_rocket;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class properties_file_read {
    public static Properties propMain = new Properties();

    public static Map<String, String> envAndFile() throws IOException {
        Map<String, String> fileAndEnv = new HashMap<String ,String>();
        FileInputStream fisDev = new FileInputStream("D:/nobopay/CreditCollection/src/main/java/cc_rocket/rocket.properties");
        propMain.load(fisDev);
        fileAndEnv.put("url", propMain.getProperty("url"));
        fileAndEnv.put("amount", propMain.getProperty("amount"));
        fileAndEnv.put("account", propMain.getProperty("account"));
        fileAndEnv.put("pin", propMain.getProperty("pin"));
        return fileAndEnv;
    }
}
