
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CrimeFascadeTest {

    private CrimeDatabase crimeDatabase = CrimeDatabase.getInstance();
    private CrimeFacade facade = new CrimeFacade();

    private ArrayList<Evidence> evidenceList;
    private ArrayList<Suspects> personList;
    private ArrayList<Witness> witnessList;

    @BeforeEach
    public void setup() {
        DataWriter.saveCrimes();
        DataWriter.saveUsers();
        DataWriter.savePersons();

        //login
    }

    @AfterEach
    public void tearDown() {
        DataWriter.saveCrimes();
        DataWriter.saveUsers();
        DataWriter.savePersons();

        //logout
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
     * Passed: Passed
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
        //need to finish
        facade.printCrimes("no");
    }

    /**
     * Tested by:
     *  Passed:
     */
    @Test
    void testPrintResTerminal() {

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
        assertEquals(suspect.getAge(), actual.get(0).getAge());
    }

    /**
     * Tested by: 
     * Passed:
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

    }
}
