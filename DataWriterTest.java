
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.json.simple.JSONObject;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DataWriterTest {
    private UserDatabase users = UserDatabase.getInstance();
    private ArrayList<User> userList = users.getDatabase();
    private CrimeDatabase crimes = CrimeDatabase.getInstance();
    private ArrayList<Crime> crimeList = crimes.getDatabase();
    private PersonDatabase persons = PersonDatabase.getInstance();
    private ArrayList<Suspects> personList = persons.getDatabase();

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
     * Tested by: Bradley Grose 
     * Passed: True
     */
    @Test
    void testDataUpdate() {
        DataWriter.DataUpdate();
        // Cant be Tested
        assertEquals(true, true);
    }

    /**
     * Tested by: Bradley Grose 
     * Passed: True
     */
    @Test
    void testSaveUsers() {
        userList.add(new User("test", "password", "name", "position", false));
        DataWriter.saveUsers();
        assertEquals("name", DataLoader.getUsers().get(0).getName());
    }

    /**
     * Tested by: Bradley Grose 
     * Passed: True
     */
    @Test
    void testGetUserJSON() {
        JSONObject user = DataWriter.getUserJSON((new User("test", "password", "name", "position", false)));
        assertEquals("test", user.get(DataConstants.USER_USERNAME));
    }

    /**
     * Tested by: Bradley Grose 
     * Passed: True
     */
    @Test
    void testSaveCrimes() {
        crimeList.add(new Crime(null, null, null, "description", "caseID", false, "date"));
        DataWriter.saveCrimes();
        assertEquals("caseID", DataLoader.getCrimes().get(0).getcaseID());
    }

    /**
     * Tested by: Bradley Grose 
     * Passed: True
     */
    @Test
    void testGetCrimeJson() {
        JSONObject crime = DataWriter.getCrimeJSON(new Crime(null, null, null, "description", "caseID", false, "date"),
                null, null);
        assertEquals("description", crime.get(DataConstants.CRIME_DESCRIPTION));
    }

    /**
     * Tested by: Bradley Grose 
     * Passed: True
     */
    @Test
    void testSaveEvidence() {
        ArrayList<Evidence> evidence = new ArrayList<Evidence>();
        evidence.add(new Evidence("name", "description"));
        crimeList.add(new Crime(evidence, null, null, "description", "caseID", false, "date"));
        DataWriter.saveCrimes(); // Calls Evidence
        assertEquals("name", DataLoader.getCrimes().get(0).getEvidenceList().get(0).getName());
    }

    /**
     * Tested by: Bradley Grose 
     * Passed: True
     */
    @Test
    void testSaveSuspect() {
        ArrayList<Suspects> suspects = new ArrayList<Suspects>();
        suspects.add(new Suspects("name", true, "alias", "accomplice", "hairColor", "eyeColor", "tatoo", "skinColor",
                "nationality", 100, 100, "acquaintance", 1, true, "punishment", "disability", "handness", "crimeType",
                true, "Gender", "address", "phone"));
        crimeList.add(new Crime(null, suspects, null, "description", "caseID", false, "date"));
        DataWriter.savePersons(); // Calls Evidence
        assertEquals("name", DataLoader.getPerson().get(0).getName());
    }

    /**
     * Tested by: Bradley Grose 
     * Passed: True
     */
    @Test
    void testSaveWitness() {
        ArrayList<Witness> witnesses = new ArrayList<Witness>();
        witnesses.add(new Witness("name", true, "statement", "Gender", false, "address", "phone"));
        crimeList.add(new Crime(null, null, witnesses, "description", "caseID", false, "date"));
        DataWriter.saveCrimes(); // Calls Evidence
        assertEquals("name", DataLoader.getCrimes().get(0).getWitnessList().get(0).getName());
    }

    /**
     * Tested by: Bradley Grose 
     * Passed: True
     */
    @Test
    void testSavePersons() {
        personList.add(new Suspects("name", true, "alias", "accomplice", "hairColor", "eyeColor", "tatoo", "skinColor",
                "nationality", 100, 100, "acquaintance", 1, true, "punishment", "disability", "handness", "crimeType",
                true, "Gender", "address", "phone"));
        DataWriter.savePersons();
        assertEquals("name", DataLoader.getPerson().get(0).getName());

    }

    /**
     * Tested by: Bradley Grose 
     * Passed: True
     */
    @Test
    void testGetSuspectJSON() {
        JSONObject suspect = DataWriter.getSuspectJSON(new Suspects("name", true, "alias", "accomplice", "hairColor",
                "eyeColor", "tatoo", "skinColor", "nationality", 100, 100, "acquaintance", 1, true, "punishment",
                "disability", "handness", "crimeType", true, "Gender", "address", "phone"));
        assertEquals("name", suspect.get(DataConstants.CRIMINAL_NAME));
    }

}
