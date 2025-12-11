package com.springtesting.auth_service;

import com.springtesting.auth_service.dao.UserRepository;
import com.springtesting.auth_service.model.entity.dto.AppUser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.TimeZone;

@SpringBootApplication
//@EnableDiscoveryClient // <-- ADD THIS ANNOTATION
public class AuthServiceApplication {
    public static void main(String[] args) {
        // FIX: Override timezone BEFORE Spring starts
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));
        System.out.println("Final JVM TZ = " + TimeZone.getDefault().getID());

        SpringApplication.run(AuthServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner run(UserRepository repo, PasswordEncoder encoder) {
        return args -> {
            if (repo.count() == 0) {
                repo.save(AppUser.builder()
                        .username("test")
                        .password(encoder.encode("1234"))
                        .role("USER")
                        .build());
            }
        };
    }
}
