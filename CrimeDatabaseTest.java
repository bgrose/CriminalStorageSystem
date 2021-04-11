import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CrimeDatabaseTest {
    
    private CrimeDatabase crimeDatabase;
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
     * Passed: True
     */
    @Test
    void testAddCrime() {
        crimeList.add(new Crime(null, null, null, "description", "caseID", false, "date"));
        assertEquals("description", crimeList.get(0).getDescription());
    }

    /**
     * Tested by: David Morrison
     * Passed: True
     */
    @Test
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
    void testPrintDatabase() {
        crimeDatabase.printDatabase("yes");
    }

    /**
     * Tested by: David Morrison
     * Passed: True
     */
    @Test
    void testgetInstance() {
        crimes.printDatabase("yes");

    }

    /**
     * Tested by: David Morrison
     * Passed:
     */
    @Test
    void testCrimeDatabase() {

    }

}
