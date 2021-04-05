
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DataLoaderTest {


    @BeforeEach
    public void setup() {
        DataWriter.DataUpdate();
    }

    @AfterEach
    public void tearDown() {
        DataWriter.DataUpdate();
    }

    /**
     * Tested by: Bradley grose
     * Passed: True
     */
    @Test
    void testGetCrimes() {
        ArrayList<Crime> crimes = new ArrayList<Crime>();
        crimes = DataLoader.getCrimes();
        assertEquals(crimes.size(), 0);
    }

    /**
     * Tested by: Bradley grose
     * Passed: True
     */
    @Test
    void testGetUsers() {
        ArrayList<User> ussers = new ArrayList<User>();
        ussers = DataLoader.getUsers();
        assertEquals(ussers.size(), 0);
    }

    /**
     * Tested by: Braldey Grose
     * Passed: True
     */
    @Test
    void testGetPerson() {
        ArrayList<Suspects> suspects = new ArrayList<Suspects>();
        suspects = DataLoader.getPerson();
        assertEquals(suspects.size(), 0);
    }

    /**
     * Tested by: Bradley Grosse
     * Passed: True
     */
    @Test
    void testGetEvidence() {
        ArrayList<Evidence> evidence = new ArrayList<Evidence>();
        evidence = DataLoader.getEvidence();
        assertEquals(evidence.size(), 0);
    }

    /**
     * Tested by: Bradley Grose
     * Passed: True
     */
    @Test
    void testGetWitness() {
        ArrayList<Witness> witness = new ArrayList<Witness>();
        witness = DataLoader.getWitness();
        assertEquals(witness.size(), 0);
    }
}
