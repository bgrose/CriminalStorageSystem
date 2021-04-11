
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonDatabaseTest {

    private static PersonDatabase personDatabase;
    private PersonDatabase people = PersonDatabase.getInstance();
    private ArrayList<Suspects> personList = new ArrayList<Suspects>();

    @BeforeEach
    public void setup() {
        //Intentionally Empty
    }

    @AfterEach
    public void tearDown() {
        //Intentionally Empty
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
     * Tested by: Eleanor Barry
     * Passed:
     */
    @Test
    void testGetInstance() {
        // people uses getInstance at the beginning of the class to initialize
        if(people != null) {
			System.out.println("Passed");
		} else {
			System.out.println("Failed");
		}
    }


}
