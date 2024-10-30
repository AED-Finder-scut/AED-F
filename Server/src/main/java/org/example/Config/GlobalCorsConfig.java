package org.example.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class GlobalCorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // 允许所有路径的跨域请求
                registry.addMapping("/**")  // 如果只想允许部分路径，可以用 "/api/**"
                        // 允许所有来源
                        .allowedOrigins("*")
                        // 允许的请求方法
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        // 允许的请求头
                        .allowedHeaders("*")
                        // 禁用认证信息（由于 allowCredentials 为 true 时，allowedOrigins 不能为 "*"）
                        .allowCredentials(false)
                        // 预检请求的缓存时间（以秒为单位）
                        .maxAge(3600);
            }
        };
    }
}

