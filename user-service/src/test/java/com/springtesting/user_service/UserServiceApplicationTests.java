package com.springtesting.user_service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.TimeZone;

@SpringBootTest
class UserServiceApplicationTests {


	@Test
	void contextLoads() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));
	}

}
