import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SuspectTest {
	
	@BeforeEach
	/** 
	* method creates a setup code
	*/
	public void setup() {
                //Intentionally Empty
	}

	@AfterEach
	/** 
	* method creates a teardown code
	*/
	public void tearDown() {
                //Intentionally Empty
	}

	/**
	 * Tested by: David Morrsion
         * Passed: True
	 */
	@Test
	/** 
	* method creates information for the suspect
	*/
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
	/** 
	* method creates full information for the suspect
	*/
	void testToString() {
            Suspects suspects = new Suspects("name", true, "alias", "accomplice", "hairColor", "eyeColor", "tatoo", "skinColor",
            "nationality", 100, 100, "acquaintance", 1, true, "punishment", "disability", "handness", "crimeType",
            true, "Gender", "address", "phone");        
            String ret = suspects.toString();
            assertTrue(ret.contains("Name:"));
	}
}
