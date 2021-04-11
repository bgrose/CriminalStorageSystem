import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CrimeDatabaseTest {
    
    private CrimeDatabase crimes = CrimeDatabase.getInstance();
    private ArrayList<Crime> crimeList = crimes.getDatabase();

    @BeforeEach
    /** 
	 * method creates a setup code
	 */
    public void setup() {
        crimeList.clear();
    }

    @AfterEach
    /** 
	 * method creates a teardown code
	 */
    public void tearDown() {
        //Intentionally Empty
    }

    /**
     * Tested by: David Morrison
     * Passed: True
     */
    @Test
    /** 
	 * method creates a test for adding crimes
	 */
    void testAddCrime() {
        crimeList.add(new Crime(null, null, null, "description", "caseID", false, "date"));
        assertEquals("description", crimeList.get(0).getDescription());
    }

    /**
     * Tested by: David Morrison
     * Passed: True
     */
    @Test
    /** 
	 * method creates a test for removing crimes
	 */
    void testRemoveCrime() {
        Crime testCrime = (new Crime(null, null, null, "description", "caseID", false, "date"));
        crimeList.add(testCrime);
        crimeList.remove(testCrime);
        assertFalse(crimeList.contains(testCrime));
    }


    /**
     * Tested by: David Morrison
     * Passed: True
     */
    @Test
    /** 
	 * method creates a test to get instance
	 */
    void testgetInstance() {
       CrimeDatabase crimedB = CrimeDatabase.getInstance();
       assertNotEquals(crimedB, null);
    }

}
