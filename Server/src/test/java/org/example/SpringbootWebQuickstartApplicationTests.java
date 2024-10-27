package org.example;

import org.example.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootWebQuickstartApplicationTests {

    @Autowired
    UserService userService;

    @Test
    void contextLoads() {
    }

}
