package rocket_add_money;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class properties_file_read {
    public static Properties propMain = new Properties();

    public static Map<String, String> envAndFile() throws IOException {
        Map<String, String> fileAndEnv = new HashMap<String ,String>();
        FileInputStream fisDev = new FileInputStream("D:\\nobopay\\CreditCollection\\src\\main\\java\\rocket_add_money\\rocket.properties");
        propMain.load(fisDev);
        fileAndEnv.put("url", propMain.getProperty("url"));
        fileAndEnv.put("account", propMain.getProperty("account"));
        fileAndEnv.put("pin", propMain.getProperty("pin"));
        return fileAndEnv;
    }
}
