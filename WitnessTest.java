
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WitnessTest {
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
	void testWitness() {
		Witness test = new Witness("name", true, "test", "test", false, "address", "phone");
		assertEquals(test.getAddress(), "address");
	}

	/**
	 * Tested by: Bradley Grose
	 * Passed: True
	 */
	@Test
	void testToString() {
		Witness test = new Witness("name", true, "test", "test", false, "address", "phone");
		String ret = test.toString();
        assertTrue(ret.contains("Statement:"));
	}
}
