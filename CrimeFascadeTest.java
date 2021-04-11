
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CrimeFascadeTest {

    private CrimeDatabase crimeDatabase = CrimeDatabase.getInstance();
    private CrimeFacade facade = new CrimeFacade();

    private ArrayList<Evidence> evidenceList = new ArrayList<Evidence>();
    private ArrayList<Suspects> personList = new ArrayList<Suspects>();
    private ArrayList<Witness> witnessList = new ArrayList<Witness>();
    private ArrayList<User> userList = new ArrayList<User>();

    @BeforeEach
    public void setup() {
        evidenceList.clear();
        personList.clear();
        witnessList.clear();
        userList.clear();
    }

    @AfterEach
    public void tearDown() {
        DataWriter.saveCrimes();
        DataWriter.saveUsers();
        DataWriter.savePersons();
    }

    /**
     * Tested by: David K
     * Passed: True
     */
    @Test
    void testCrimeFascadeExists() {
        assertNotNull(facade);
    }

    /**
     * Tested by: David Keen
     * Passed: True
     */
    @Test
    void testValidLogin() {
        facade.createAccount("Test", "Password", "TestUser", "Officer", true);
        facade.login("Test", "Password");
        User me = facade.getCurrentUser();
        assertEquals("TestUser", me.getName());
    }
     /**
     * Tested by: David Keen
     * Passed: True
     */
    @Test
    void testInValidLogin() {
        facade.createAccount("Test", "Password", "Test User", "Officer", true);
        boolean login = facade.login("Password", "Test");
        assertFalse(login);
    }
    

    /**
     * Tested by: David K
     *  Passed: True
     */
    @Test
    void TestAddCrime() {
        Crime crime = new Crime(evidenceList, personList, witnessList, "description", "caseID", false, "date");
        facade.addCrime(crime);
        Crime expected = crimeDatabase.getCrime("caseID");
        assertEquals(expected.getDate(), crime.getDate());
    }

    /**
     * Tested by: David K
     * Passed: True
     */
    @Test
    void testSearchCrimeTrue() {
        Crime crime = new Crime(evidenceList, personList, witnessList, "description", "caseID", false, "date");
        facade.addCrime(crime);
        boolean actual = facade.searchCrime("caseID");
        assertTrue(actual);
    }

    /**
     * Tested by:
     *  Passed:
     */
    @Test
    void testPrintCrimes() {
        facade.printCrimes("no");
        assertTrue(true); //Passed Without Errors
    }

    /**
     * Tested by:
     *  Passed:
     */
    @Test
    void testPrintResTerminal() {
        Suspects suspect = new Suspects("bob", true, "goat", "Maddie Smith", "blue", "brown", "dove", "white",
                "American", 150, 72, "Katie Lynch", 33, false, "none", "none", "right", "robbery", false, "male",
                "302 Capstone Road", "5552222222");
        personList.add(suspect);
        facade.printResTerminal(personList);
        assertTrue(true); //Passed Without Errors
    }

    /**
     * Tested by: David Keen
     * Passed: True
     */
    @Test
    void testSearchCriminalByName() {
        int command = 1;
        Suspects suspect = new Suspects("bob", true, "goat", "Maddie Smith", "blue", "brown", "dove", "white", "American", 150, 72, "Katie Lynch", 33, false, "none", "none", "right", "robbery", false, "male", "302 Capstone Road", "5552222222");
        facade.addSuspect(suspect);
        ArrayList<Suspects> actual = facade.searchCriminal(command, "bob");
        assertEquals(suspect.getName(), actual.get(0).getName());
    }

    /**
     * Tested by: 
     * Passed: True
     */
    @Test
    void testPrintCriminal() {
        facade.printCriminal("no");
        assertTrue(true); //Passed Without Errors
    }

    /**
     * Tested by: Passed:
     */
    @Test
    void testAddUser() {
        User me = new User("Test", "Password", "Test User", "Officer", true);
        facade.addUser(me);
        userList = UserDatabase.getInstance().getDatabase();
        assertTrue(userList.contains(me));

    }

    /**
     * Tested by: Passed:
     */
    @Test
    void testRemoveUser() {
        User me = new User("Test", "Password", "Test", "Officer", true);
        facade.addUser(me);
        facade.removeUser("Test");
        assertTrue(facade.removeUser("Test"));

    }


    /**
     * Tested by: David K
     * Passed: True
     */
    @Test
    void testFindOfficer() {
        User user = new User("Test", "Password", "TestUser", "Police Officer", false, UUID.randomUUID());
        facade.addUser(user);
        User actual = facade.findOfficer("TestUser");
        assertEquals(user.getName(), actual.getName());

    }

    /**
     * Tested by: Passed:
     */
    @Test
    void testPrintCrimeTerminal() {
        facade.printCrimeTerminal("caseID");
        assertTrue(true); //Passed Without Errors
    }

}
