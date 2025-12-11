package com.springtesting.user_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.TimeZone;

@SpringBootApplication
//@EnableDiscoveryClient // <-- ADD THIS ANNOTATION
public class UserServiceApplication {

	public static void main(String[] args) {
        // FIX: Override timezone BEFORE Spring starts
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));
        System.out.println("Final JVM TZ = " + TimeZone.getDefault().getID());

        SpringApplication.run(UserServiceApplication.class, args);
	}
}
