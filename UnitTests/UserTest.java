import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserTest {
	@BeforeEach
	public void setup() {
		//Intentionally Empty
	}

	@AfterEach
	public void tearDown() {
		//Intentionally Empty
	}

	/**
	 * Tested by: Bradley Grose
	 * Passed: True
	 */
	@Test
	void testUser() {
		UUID testUUID = UUID.randomUUID();
		User user = new User("test", "test", "test", "tesr", false, testUUID);
		assertEquals("test", user.getName());
	}

}
