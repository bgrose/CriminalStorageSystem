
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonTest {

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
	void testPerson() {
        //Using Witness as it will call super
		Witness test = new Witness("name", true, "test", "test", false, "address", "phone");
		assertEquals(test.getName(), "name");
	}

	/**
	 * Tested by: Bradley Grose
	 * Passed: True
	 */
	@Test
	void testToString() {
        //Using Witness as it will call super
		Witness test = new Witness("name", true, "test", "test", false, "address", "phone");
		String ret = test.toString();
        assertTrue(ret.contains("Name:"));
	}

}
