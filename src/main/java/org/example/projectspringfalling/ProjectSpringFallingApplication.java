package org.example.projectspringfalling;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectSpringFallingApplication {

    public static void main(String[] args) {
        // Dotenv를 사용하여 환경 변수 설정
        Dotenv dotenv = Dotenv.load();
        System.setProperty("REDIS_HOST", dotenv.get("REDIS_HOST"));
        System.setProperty("REDIS_PORT", dotenv.get("REDIS_PORT"));

        // Spring Boot 애플리케이션 시작
        SpringApplication.run(ProjectSpringFallingApplication.class, args);
    }

}
