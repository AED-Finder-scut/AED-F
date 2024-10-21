package org.example.Controller;

import org.example.entities.AED;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/aed")
public class AEDController {
    private static List<AED> aeds = new ArrayList<>();

    // 静态代码块，用于初始化真实的AED数据
    static {
        aeds.add(new AED(1L,"C17", "C17教师公寓一楼大厅",  23.057886, 113.408575));
        aeds.add(new AED(2L, "生活区操场","中国邮政旁/生活区运动场器材室门口",  23.056992, 113.408629));
        aeds.add(new AED(3L,"校医院", "校医院门诊部一楼", 113.410232,23.058651));
        aeds.add(new AED(4L, "C5","C5学生宿舍一楼大厅",  113.407973,23.054573));
        aeds.add(new AED(5L,"D2", "D2教师公寓物业服务中心门口",  113.408984,23.053347));
        aeds.add(new AED(6L,"教学区操场", "教学区操场架空厅",  113.409896,23.051589));
        aeds.add(new AED(7L, "B6","B6生物中心后座一楼",  113.409896,23.051589));
        aeds.add(new AED(8L,"正门", "正门东侧保安室",  113.415923,23.050445));
        aeds.add(new AED(9L, "图书馆","图书馆二楼后门", 113.411858,23.052927));
        aeds.add(new AED(10L, "A3","A3教学楼一楼大厅", 113.41193,23.055791));
        aeds.add(new AED(11L, "B10","B10北座一楼",  113.4148,23.056298));
    }

    @GetMapping("/nearby")
    public List<AED> getNearbyAeds(@RequestParam double lat, @RequestParam double lon, @RequestParam double radius) {
        List<AED> nearbyAeds = new ArrayList<>();
        for (AED aed : aeds) {
            radius=0.5; //默认查找半径500米内.当且仅当距离小于半径的才会被添加至最终显示的AED列表nearbyAeds中.
            double distance = haversine(lat, lon, aed.getLatitude(), aed.getLongitude());
            if (distance <= radius) {
                nearbyAeds.add(aed);
            }
        }
        return nearbyAeds;
    }

    // Haversine公式计算两点之间的距离.
    private double haversine(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371; // 地球半径，单位：公里
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c; // 返回距离，单位：公里
    }
}





