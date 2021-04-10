
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

    }

    /**
     * Tested by: Eleanor Barry
     * Passed:
     */
    @Test
    void testRemovePerson() {

    }

    /**
     * Tested by: 
     * Passed:
     */
    @Test
    void testPrintDatabase() {

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
