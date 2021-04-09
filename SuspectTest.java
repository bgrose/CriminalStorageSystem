
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SuspectTest {
	
	private String name;
        private String livingStatus;
        private String alias;
        private String accomplice;
        private String hairColor;
        private String eyeColor;
        private String tatoo;
        private String skinColor;
        private String nationality;
        private double weight;
        private int height;
        private String acquaintance;
        private int age;
        private boolean glasses;
        private String punishment;
        private String disability;
        private String handness;
        private String crimeType;
        private boolean inJail;
        private String Gender;
        private String address;
        private int phone;
	
	@BeforeEach
	public void setup() {

	}

	@AfterEach
	public void tearDown() {

	}

	/**
	 * Tested by: Passed:
	 */
	@Test
	void testSuspect() {
	    Suspects suspects = new Suspects("name", true, "alias", "accomplice", "hairColor", "eyeColor", "tatoo", "skinColor",
            "nationality", 100, 100, "acquaintance", 1, true, "punishment", "disability", "handness", "crimeType",
            true, "Gender", "address", "phone");
            assertEquals("test", suspects.getName());
	}

	/**
	 * Tested by: Passed:
	 */
	@Test
	void testToString() {
            Suspects suspects = new Suspects("name", true, "alias", "accomplice", "hairColor", "eyeColor", "tatoo", "skinColor",
            "nationality", 100, 100, "acquaintance", 1, true, "punishment", "disability", "handness", "crimeType",
            true, "Gender", "address", "phone");        
            String ret = suspects.toString();
            assertTrue(ret.contains("Statement:"));
	}
}
