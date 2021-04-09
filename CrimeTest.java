
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CrimeTest {


    Crime crime = new Crime(null, null, null, "description", "caseID", false, "date");

    @BeforeEach
    public void setup() {

    }

    @AfterEach
    public void tearDown() {

    }

    /**
     * Tested by: David Keen
     * Passed: True
     */
    @Test
    void TestCrime() {
        Crime testCrime = new Crime(null, null, null, "description", "caseID", false, "date");
        assertEquals("date", testCrime.getDate());
    }

    /**
     * Tested by: Passed:
     */
    @Test
    void testAddEvidence() {

    }

    /**
     * Tested by: Passed:
     */
    @Test
    void testRemoveEvidence() {

    }

    /**
     * Tested by: Passed:
     */
    @Test
    void testAddPerson() {

    }

    /**
     * Tested by: Passed:
     */
    @Test
    void testRemovePerson() {

    }

    /**
     * Tested by: Passed:
     */
    @Test
    void testToString() {

    }

    /**
     * Tested by: Passed:
     */
    @Test
    void testGetWitnessString() {

    }

    /**
     * Tested by: Passed:
     */
    @Test
    void testGetSuspectString() {

    }

    /**
     * Tested by: Passed:
     */
    @Test
    void testGetEvidenceString() {

    }

}
