
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CrimeFascadeTest {

    private CrimeDatabase crimeDatabase = CrimeDatabase.getInstance();
    private UserDatabase userDatabase = UserDatabase.getInstance();
    private PersonDatabase personDatabase = PersonDatabase.getInstance();
    private CrimeFacade facade = new CrimeFacade();

    private ArrayList<Evidence> evidenceList;
    private ArrayList<Suspects> personList;
    private ArrayList<Witness> witnessList;

    @BeforeEach
    public void setup() {
        userDatabase.getInstance().getDatabase().clear();
        crimeDatabase.getInstance().getDatabase().clear();
        personDatabase.getInstance().getDatabase().clear();
        DataWriter.saveCrimes();
        DataWriter.saveUsers();
        DataWriter.savePersons();

        //login
    }

    @AfterEach
    public void tearDown() {
        userDatabase.getInstance().getDatabase().clear();
        crimeDatabase.getInstance().getDatabase().clear();
        personDatabase.getInstance().getDatabase().clear();
        DataWriter.saveCrimes();
        DataWriter.saveUsers();
        DataWriter.savePersons();

        //logout
    }

    /**
     * Tested by: Passed:
     */
    @Test
    void testCrimeFascadeExists() {
        assertNotNull(facade);
    }

    /**
     * Tested by: David Keen
     * Passed: Passed
     */
    @Test
    void testValidLogin() {
        facade.createAccount("Test", "Password", "Test User", "Officer", true);
        facade.login("Test", "Password");
        User me = facade.getCurrentUser();
        assertEquals("Test User", me.getName());
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
     * Tested by: Passed:
     */
    @Test
    void TestAddCrime() {
        Crime crime = new Crime(evidenceList, personList, witnessList, "description", "caseID", false, "date");
        facade.addCrime(crime);
        Crime expected = crimeDatabase.getCrime("caseID");
        assertEquals(expected, crime);
    }

    /**
     * Tested by: Passed:
     */
    @Test
    void testSearchCrimeTrue() {
        Crime crime = new Crime(evidenceList, personList, witnessList, "description", "caseID", false, "date");
        facade.addCrime(crime);
        boolean actual = facade.searchCrime("caseID");
        assertTrue(actual);
    }

    /**
     * Tested by: Passed:
     */
    @Test
    void testPrintCrimes() {
        //need to finish
        facade.printCrimes("yes");
    }

    /**
     * Tested by: Passed:
     */
    @Test
    void testPrintResTerminal() {

    }

    /**
     * Tested by: Passed:
     */
    @Test
    void testSearchCriminalByName() {
        int command = 0;
        Suspects suspect = new Suspects("bob", true, "goat", "Maddie Smith", "blue", "brown", "dove", "white", "American", 150, 72, "Katie Lynch", 33, false, "none", "none", "right", "robbery", false, UUID.randomUUID(), "male", "302 Capstone Road", "5552222222");
        facade.addSuspect(suspect);
        personList.add(suspect);
        ArrayList<Suspects> actual = facade.searchCriminal(command, "bob");
        assertEquals(personList, actual);
    }

    /**
     * Tested by: Passed:
     */
    @Test
    void testPrintCriminal() {

    }

    /**
     * Tested by: Passed:
     */
    @Test
    void testAddUser() {

    }

    /**
     * Tested by: Passed:
     */
    @Test
    void testRemoveUser() {

    }

    /**
     * Tested by: Passed:
     */
    @Test
    void testLogout() {

    }

    /**
     * Tested by: Passed:
     */
    @Test
    void testFindOfficer() {
        User user = new User("Test", "Password", "TestUser", "Police Officer", false, UUID.randomUUID());
        facade.addUser(user);
        User actual = facade.findOfficer("TestUser");
        assertEquals(user, actual);

    }

    /**
     * Tested by: Passed:
     */
    @Test
    void testPrintCrimeTerminal() {

    }
}
