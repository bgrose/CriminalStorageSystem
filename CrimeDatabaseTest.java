import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CrimeDatabaseTest {
    
    private CrimeDatabase crimes = CrimeDatabase.getInstance();
    private ArrayList<Crime> crimeList = crimes.getDatabase();

    @BeforeEach
    public void setup() {
        crimeList.clear();
    }

    @AfterEach
    public void tearDown() {
        //Intentionally Empty
    }

    /**
     * Tested by: David Morrison
     * Passed:
     */
    @Test
    void testAddCrime() {
        crimeList.add(new Crime(null, null, null, "description", "caseID", false, "date"));
        assertEquals("description", crimeList.get(0).getDescription());
    }

    /**
     * Tested by: David Morrison
     * Passed: 
     */
    @Test
    void testRemoveCrime() {
        Crime testCrime = (new Crime(null, null, null, "description", "caseID", false, "date"));
        crimeList.add(testCrime);
        crimeList.remove(testCrime);
        assertFalse(crimeList.contains(testCrime));

    }

    /**
     * Tested by: Passed:
     */
    @Test
    void testPrintDatabase() {

    }

    /**
     * Tested by: Passed:
     */
    @Test
    void testgetInstance() {

    }

    /**
     * Tested by: Passed:
     */
    @Test
    void testCrimeDatabase() {

    }

}
