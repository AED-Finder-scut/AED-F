package org.example.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/navigation")
public class NavigationController {

    @Value("${baidu.map.ak}")
    private String baiduMapApiKey;

    @GetMapping("/path")
    public String getNavigationPath(@RequestParam double startLat, @RequestParam double startLon,
                                    @RequestParam double endLat, @RequestParam double endLon) {
        String url = String.format("https://api.map.baidu.com/direction/v2/driving?origin=%f,%f&destination=%f,%f&ak=%s",
                startLat, startLon, endLat, endLon, baiduMapApiKey);
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
