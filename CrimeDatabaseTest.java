import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CrimeDatabaseTest {
    
    private static CrimeDatabase crimeDatabase;
    private CrimeDatabase crimes = CrimeDatabase.getInstance();
    private ArrayList<Crime> crimeList = crimes.getDatabase();

    @BeforeEach
    public void setup() {
        crimeList.clear();
        DataWriter.saveUsers();
        DataWriter.saveCrimes();
    }

    @AfterEach
    public void tearDown() {
        crimeDatabase.getInstance().getDatabase().clear();
        DataWriter.saveUsers();
        DataWriter.saveCrimes();
    }

    /**
     * Tested by: Passed:
     */
    @Test
    void testAddCrime() {
        crimeList.add(new Crime(null, null, null, "description", "caseID", false, "date"));
        DataWriter.saveCrimes();
        ArrayList<Crime> crimesRet = DataLoader.getCrimes();
    }

    /**
     * Tested by: Passed:
     */
    @Test
    void testRemoveCrime() {
        crimeList.remove(new Crime(null, null, null, "description", "caseID", false, "date"));
        DataWriter.saveCrimes();
        ArrayList<Crime> crimesRet = DataLoader.getCrimes();

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
