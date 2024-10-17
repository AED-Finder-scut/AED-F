package org.example.Controller;

import org.example.entities.AED;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/aed")
public class AEDController {

    @GetMapping("/nearby")
    public List<AED> getNearbyAeds(@RequestParam double lat, @RequestParam double lon, @RequestParam double radius) {
        List<AED> mockAeds = new ArrayList<>();
        // 模拟的AED数据
        mockAeds.add(new AED(1L, "AED 1", "Location 1", lat + 0.001, lon + 0.001));
        mockAeds.add(new AED(2L, "AED 2", "Location 2", lat - 0.001, lon - 0.001));
        return mockAeds;
    }
}


