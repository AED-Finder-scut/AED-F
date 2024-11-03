package org.example.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class BaiduAPITest {
    public static void main(String[] args) {
        try {
// 百度地图API的URL
            String address = "广东省广州市华南理工大学大学城校区";
            String ak = "9kPyMAbnuECcSH2aSP5q30ibB9hjdPbj"; // 替换为你的AK
            String url = "https://api.map.baidu.com/geocoding/v3/?address=" + address + "&output=json&ak=" + ak;

// 创建URL对象
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

// 设置请求方法
            con.setRequestMethod("GET");

// 获取响应代码
            int responseCode = con.getResponseCode();
            System.out.println("响应代码: " + responseCode);

// 读取响应内容
            if (responseCode == HttpURLConnection.HTTP_OK) { // 200表示成功
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