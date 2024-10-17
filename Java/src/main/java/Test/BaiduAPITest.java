import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import java.io.InputStream;
import java.util.Properties;

class ConfigLoader {
    private Properties properties = new Properties();

    public ConfigLoader() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
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


public class BaiduAPITest {
    public static void main(String[] args) {
        try {
            // 百度地图API的URL
            ConfigLoader configLoader=new ConfigLoader();
            String address = "广东省广州市华南理工大学大学城校区";
            String ak = configLoader.getApiKey();  // 替换为你的AK
            String url = "http://api.map.baidu.com/geocoding/v3/?address=" + address + "&output=json&ak=" + ak;

            // 创建URL对象
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // 设置请求方法
            con.setRequestMethod("GET");

            // 获取响应代码
            int responseCode = con.getResponseCode();
            System.out.println("响应代码: " + responseCode);

            // 读取响应内容
            if (responseCode == HttpURLConnection.HTTP_OK) {  // 200表示成功
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // 输出响应结果
                System.out.println(response.toString());
            } else {
                System.out.println("请求失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
