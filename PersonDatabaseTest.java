
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
