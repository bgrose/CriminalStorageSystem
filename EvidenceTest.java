
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EvidenceTest {
    @BeforeEach
    public void setup() {

    }

    @AfterEach
    public void tearDown() {

    }

    /**
     * Tested by: Bradley Grose
     * Passed: True
     */
    @Test
    void testEvidence() {
        Evidence test = new Evidence("Test", "Test");
        assertEquals(test.getName(), "Test");
    }

    /**
     * Tested by: Bradley Grose
     * Passed: True
     */
    @Test
    void testToString() {
        Evidence test = new Evidence("Test", "Test");
        String ret = test.toString();
        assertTrue(ret.contains("Name:"));
    }
}
