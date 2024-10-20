package main.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MapController {

    @Value("${baidu.map.ak}")
    private String baiduMapApiKey;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("baiduMapApiKey", baiduMapApiKey);
        return "index";
    }
}
