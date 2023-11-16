package com.ktc.matgpt;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.TimeZone;

@EnableScheduling
@EnableJpaAuditing
@SpringBootApplication
public class MatgptApplication {

    public static void main(String[] args) {
        SpringApplication.run(MatgptApplication.class, args);
    }

    @PostConstruct
    public void setTimeZone(){
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
    }


}
