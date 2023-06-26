package com.api.crud;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class CrudApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void validateEncoderPassword() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		String pass = "1986";
		String passEncoder = encoder.encode(pass);
		System.out.println(passEncoder);

//		boolean matches = encoder.matches(pass, passEncoder);
		boolean matches = encoder.matches(pass, "$2a$10$/dHQEC6l/ttKU1oXT35vy.p2Xv8WPYxknO3iMDoNhMK2Bt5bBY7UG");
		Assertions.assertTrue(matches);
	}

}
