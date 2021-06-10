package ru.javalab.jbcache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableCaching
@EnableScheduling
@SpringBootApplication
public class JbcacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(JbcacheApplication.class, args);
    }

}
