
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CrimeFascadeTest {

    private CrimeDatabase crimeDatabase = CrimeDatabase.getInstance();
    private UserDatabase userDatabase = UserDatabase.getInstance();
    private PersonDatabase personDatabase = PersonDatabase.getInstance();
    private CrimeFacade facade = new CrimeFacade();

    @BeforeEach
    public void setup() {
        userDatabase.getInstance().getDatabase().clear();
        crimeDatabase.getInstance().getDatabase().clear();
        personDatabase.getInstance().getDatabase().clear();
        DataWriter.saveCrimes();
        DataWriter.saveUsers();
        DataWriter.savePersons();
    }

    @AfterEach
    public void tearDown() {
        userDatabase.getInstance().getDatabase().clear();
        crimeDatabase.getInstance().getDatabase().clear();
        personDatabase.getInstance().getDatabase().clear();
        DataWriter.saveCrimes();
        DataWriter.saveUsers();
        DataWriter.savePersons();
    }

    /**
     * Tested by: Passed:
     */
    @Test
    void testCrimeFascade() {
        
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

    }

    /**
     * Tested by: Passed:
     */
    @Test
    void testSearchCrime() {

    }

    /**
     * Tested by: Passed:
     */
    @Test
    void testPrintCrimes() {

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
    void testSearchCriminal() {

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

    }

    /**
     * Tested by: Passed:
     */
    @Test
    void testPrintCrimeTerminal() {

    }
}
