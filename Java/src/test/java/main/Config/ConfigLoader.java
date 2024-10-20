package main.Config;

import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    private Properties properties = new Properties();

    public ConfigLoader() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("main/resources/config.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }
            // 加载属性文件
            properties.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getApiKey() {
        return properties.getProperty("baidu.map.ak");
    }
}