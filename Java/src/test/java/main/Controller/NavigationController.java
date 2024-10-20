package main.Controller;

import main.Config.ConfigLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
@RequestMapping("/api/navigation")
public class NavigationController {

    @GetMapping("/path")
    public String getNavigationPath(@RequestParam double startLat, @RequestParam double startLon,
                                    @RequestParam double endLat, @RequestParam double endLon) {
        ConfigLoader configLoader=new ConfigLoader();
        String ak = configLoader.getApiKey();
        String url = String.format("http://api.map.baidu.com/direction/v2/driving?origin=%f,%f&destination=%f,%f&ak=%s",
                startLat, startLon, endLat, endLon, ak);
        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                return response.toString();
            } else {
                return "请求失败";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "错误：" + e.getMessage();
        }
    }
}
