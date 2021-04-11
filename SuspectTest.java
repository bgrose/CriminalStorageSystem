import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SuspectTest {
	
	@BeforeEach
	public void setup() {
                //Intentionally Empty
	}

	@AfterEach
	public void tearDown() {
                //Intentionally Empty
	}

	/**
	 * Tested by: David Morrsion
     * Passed: True
	 */
	@Test
	void testSuspect() {
	    Suspects suspects = new Suspects("name", true, "alias", "accomplice", "hairColor", "eyeColor", "tatoo", "skinColor",
            "nationality", 100, 100, "acquaintance", 1, true, "punishment", "disability", "handness", "crimeType",
            true, "Gender", "address", "phone");
            assertEquals("name", suspects.getName());
	}

	/**
	 * Tested by: David Morrsion
     * Passed: True
	 */
	@Test
	void testToString() {
            Suspects suspects = new Suspects("name", true, "alias", "accomplice", "hairColor", "eyeColor", "tatoo", "skinColor",
            "nationality", 100, 100, "acquaintance", 1, true, "punishment", "disability", "handness", "crimeType",
            true, "Gender", "address", "phone");        
            String ret = suspects.toString();
            assertTrue(ret.contains("Name:"));
	}
}
