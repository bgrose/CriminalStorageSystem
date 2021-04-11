
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DataLoaderTest {
    private UserDatabase users = UserDatabase.getInstance();
    private ArrayList<User> userList = users.getDatabase();
    private CrimeDatabase crimes = CrimeDatabase.getInstance();
    private ArrayList<Crime> crimeList = crimes.getDatabase();

    @BeforeEach
    public void setup() {
        UserDatabase.getInstance().getDatabase().clear();
        CrimeDatabase.getInstance().getDatabase().clear();
        PersonDatabase.getInstance().getDatabase().clear();
        DataWriter.saveUsers();
    }

    @AfterEach
    public void tearDown() {
        UserDatabase.getInstance().getDatabase().clear();
        CrimeDatabase.getInstance().getDatabase().clear();
        PersonDatabase.getInstance().getDatabase().clear();
        DataWriter.saveUsers();
    }

    /**
     * Tested by: Bradley grose 
     * Passed: True
     */
    @Test
    void testGetCrimes() {
        crimeList.add(new Crime(null, null, null, "description", "caseID", false, "date"));
        DataWriter.saveCrimes();
        ArrayList<Crime> crimesRet = DataLoader.getCrimes();
        assertEquals(crimesRet.size(), 1);
    }

    /**
     * Tested by: Bradley grose 
     * Passed: True
     */
    @Test
    void testGetUsers() {

        userList.add(new User("test", "password", "name", "position", false));
        DataWriter.saveUsers();
        ArrayList<User> userRet = DataLoader.getUsers();
        assertEquals(userRet.size(), 1);
    }

    /**
     * Tested by: Braldey Grose
     * Passed: True
     */
    @Test
    void testGetPerson() {
        ArrayList<Suspects> suspects = new ArrayList<Suspects>();
        suspects.add(new Suspects("name", true, "alias", "accomplice", "hairColor", "eyeColor", "tatoo", "skinColor",
                "nationality", 100, 100, "acquaintance", 1, true, "punishment", "disability", "handness", "crimeType",
                true, "Gender", "address", "phone"));
        crimeList.add(new Crime(null, suspects, null, "description", "caseID", false, "date"));
        DataWriter.saveCrimes();
        ArrayList<Suspects> sussRet = DataLoader.getPerson();
        assertEquals(sussRet.size(), 9);
    }

    /**
     * Tested by: Bradley Grosse 
     * Passed: True
     */
    @Test
    void testGetEvidence() {
        ArrayList<Evidence> evidence = new ArrayList<Evidence>();
        evidence.add(new Evidence("name", "description"));
        crimeList.add(new Crime(evidence, null, null, "description", "caseID", false, "date"));
        DataWriter.saveCrimes();
        ArrayList<Evidence> evidenceRet = DataLoader.getEvidence();
        assertEquals(evidenceRet.size(), 1);
    }

    /**
     * Tested by: Bradley Grose 
     * Passed: True
     */
    @Test
    void testGetWitness() {
        ArrayList<Witness> witnesses = new ArrayList<Witness>();
        witnesses.add(new Witness("name", true, "statement", "Gender", false, "address", "phone"));
        crimeList.add(new Crime(null, null, witnesses, "description", "caseID", false, "date"));
        DataWriter.saveCrimes();
        ArrayList<Witness> witnessRet = DataLoader.getWitness();
        assertEquals(witnessRet.size(), 1);
    }
}
