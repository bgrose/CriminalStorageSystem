
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CrimeFascadeTest {

    private CrimeDatabase crimeDatabase = CrimeDatabase.getInstance();
    private UserDatabase userDatabase = UserDatabase.getInstance();
    private CrimeFacade facade = new CrimeFacade();

    private ArrayList<Evidence> evidenceList;
    private ArrayList<Suspects> personList;
    private ArrayList<Witness> witnessList;

    @BeforeEach
    public void setup() {
        DataWriter.saveCrimes();
        DataWriter.saveUsers();
        DataWriter.savePersons();
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
        //verify printed correctly


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
     * Passed:
     */
    @Test
    void testPrintCriminal() {
        facade.printCriminal("no");
    }

    /**
     * Tested by: Passed:
     */
    @Test
    void testAddUser() {
        User me = new User("Test", "Password", "TestUser", "Officer", true);
        facade.addUser(me);
        assertEquals(userDatabase.getDatabase().get(0).getName(), me.getName());

    }

    /**
     * Tested by: Passed:
     */
    @Test
    void testRemoveUser() {
        User me = new User("Test", "Password", "TestUser", "Officer", true);
        facade.addUser(me);
        facade.removeUser("TestUser");
        assertNull(facade.findOfficer("TestUser"));

    }

    /**
     * Tested by: Passed:
     */
    @Test
    void testLogout() {
        facade.logout();
        //verify methods ran
        //saveUsers();
        //savePersons();
        //saveCrimes();

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
        Crime crime = new Crime(evidenceList, personList, witnessList, "description", "caseID", false, "date");
        facade.printCrimeTerminal("caseID");
        //verify printed correctly

    }

}
