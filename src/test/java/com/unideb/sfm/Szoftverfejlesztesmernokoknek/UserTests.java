package com.unideb.sfm.Szoftverfejlesztesmernokoknek;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserTests {

	@Test
	void testUser() {
		com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.User user = new com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.User();
		user.setEmail("valaki@gmail.com");
		user.setFullName("Valaki Béla");
		user.setPassword("valaki");

		assertEquals("valaki@gmail.com", user.getEmail());
		assertEquals("Valaki Béla", user.getFullName());
		assertEquals("valaki", user.getPassword());
	}

}
