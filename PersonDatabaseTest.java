
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonDatabaseTest {

    private static PersonDatabase persons =  PersonDatabase.getInstance();
    private ArrayList<Suspects> personList = persons.getDatabase();

    @BeforeEach
    public void setup() {
        personList.clear();
    }

    @AfterEach
    public void tearDown() {
        // Intentionally Empty
    }

    /**
     * Tested by: Eleanor Barry
     * Passed: True
     */
    @Test
    void testAddPerson() {
        personList.add(new Suspects("Suspect", true, "person", "na", "Brown", "Brown", "false", "skin color", "nationality", 120, 60, "na", 18, true, "death", "na", "left", "bad", true, "female", "address", "1234567890"));
        assertEquals(1, personList.size());        
    }

    /**
     * Tested by: Eleanor Barry
     * Passed: True
     */
    @Test
    void testRemovePerson() {
        Suspects suspect = new Suspects("Suspect", true, "person", "na", "Brown", "Brown", "false", "skin color", "nationality", 120, 60, "na", 18, true, "death", "na", "left", "bad", true, "female", "address", "1234567890");
        persons.addPerson(suspect);
        persons.removePerson(suspect);
        personList = persons.getDatabase();
        assertEquals(0, personList.size());
    }

    /**
     * Tested by: Eleanor Barry
     * Passed: True
     */
    @Test
    void testGetInstance() {
       assertNotEquals(PersonDatabase.getInstance(), null);
    }

}
