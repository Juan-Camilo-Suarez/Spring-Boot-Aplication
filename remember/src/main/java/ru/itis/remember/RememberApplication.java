package ru.itis.remember;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class RememberApplication {

    public static void main(String[] args) {
        SpringApplication.run(RememberApplication.class, args);
    }

}
