
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonDatabaseTest {

    private static PersonDatabase personDatabase;
    private PersonDatabase people = PersonDatabase.getInstance();
    private ArrayList<Suspects> personList = personDatabase.getDatabase();

    @BeforeEach
    public void setup() {
        personList.clear();
        DataWriter.savePersons();
    }

    @AfterEach
    public void tearDown() {
        personList.clear();
        DataWriter.savePersons();
    }

    /**
     * Tested by: Eleanor Barry
     * Passed:
     */
    @Test
    void testAddPerson() {
        personDatabase.addPerson(new Suspects("Suspect", true, "person", "na", "Brown", "Brown", "false", "skin color", "nationality", 120, 60, "na", 18, true, "death", "na", "left", "bad", true, "female", "address", "1234567890"));
        personList = personDatabase.getDatabase();
        assertEquals(1, personList.size());        
    }

    /**
     * Tested by: Eleanor Barry
     * Passed:
     */
    @Test
    void testRemovePerson() {
        Suspects suspect = new Suspects("Suspect", true, "person", "na", "Brown", "Brown", "false", "skin color", "nationality", 120, 60, "na", 18, true, "death", "na", "left", "bad", true, "female", "address", "1234567890");
        personDatabase.addPerson(suspect);
        personDatabase.removePerson(suspect);
        personList = personDatabase.getDatabase();
        assertEquals(0, personList.size());
    }

    /**
     * Tested by: Eleanor Barry
     * Passed:
     */
    @Test
    void testPrintDatabase() {
        personDatabase.printDatabase("yes");
    }

    /**
     * Tested by: 
     * Passed:
     */
    @Test
    void testGetInstance() {

    }

    /**
     * Tested by: 
     * Passed:
     */
    @Test
    void testPersonDatabase() {

    }

}
