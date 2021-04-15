import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CrimeTest {

    private ArrayList<Evidence> evidenceList = new ArrayList<Evidence>();
    private ArrayList<Suspects> personList = new ArrayList<Suspects>();
    private ArrayList<Witness> witnessList = new ArrayList<Witness>();
    Crime crime = new Crime(evidenceList, personList, witnessList, "description", "caseID", false, "date");

    @BeforeEach
    public void setup() {
        //Intentionally Empty
    }

    @AfterEach
    public void tearDown() {
        //Intentionally Empty
    }

    /**
     * Tested by: Bradley Grose 
     * Passed: True
     */
    @Test
    void TestValidCrimeDate() {
        Crime testCrime = new Crime(null, null, null, "description", "caseID", false, "date");
        assertEquals("date", testCrime.getDate());
    }

    /**
     * Tested by: Bradley Grose 
     * Passed: True
     */
    @Test
    void testAddEvidence() {

        Evidence evidence = new Evidence("hammer", " rusty and red");
        crime.addEvidence(evidence);
        assertEquals(crime.getEvidenceList().get(0), evidence);
    }

    /**
     * Tested by: Bradley Grose 
     * Passed: True
     */
    @Test
    void testRemoveEvidence() {
        Evidence evidence = new Evidence("hammer", " rusty and red");
        crime.addEvidence(evidence);
        crime.removeEvidence(evidence);
        assertFalse(crime.getEvidenceList().contains(evidence));
    }

    /**
     * Tested by: Bradley Grose
     * Passed: True
     */
    @Test
    void testAddPerson() {
        Suspects suspect = new Suspects("bob", true, "goat", "Maddie Smith", "blue", "brown", "dove", "white",
                "American", 150, 72, "Katie Lynch", 33, false, "none", "none", "right", "robbery", false, "male",
                "302 Capstone Road", "5552222222");
        crime.addPerson(suspect);
        assertEquals(personList.get(0), suspect);
    }

    /**
     * Tested by: Bradley Grose 
     * Passed: True
     */
    @Test
    void testRemovePerson() {
        Suspects suspect = new Suspects("bob", true, "goat", "Maddie Smith", "blue", "brown", "dove", "white",
                "American", 150, 72, "Katie Lynch", 33, false, "none", "none", "right", "robbery", false, "male",
                "302 Capstone Road", "5552222222");
        crime.addPerson(suspect);
        crime.removePerson(suspect);
        assertFalse(crime.getPersonList().contains(suspect));
    }

    /**
     * Tested by: Bradley Grose 
     * Passed: True
     */
    @Test
    void testToString() {
        String actual = crime.toString();
        assertTrue(actual.contains("Description:"));
    }

    /**
     * Tested by: Bradley Grose 
     * Passed: True
     */
    @Test
    void testGetWitnessString() {
        ArrayList<Witness> wit = new ArrayList<Witness>();
        wit.add(new Witness("Conor Raymond", true, "I saw a white man stab and Asian man", "Male", false,
                "222 Cleveland Avenue", "7084848400"));
        Crime newCrime = new Crime(null, null, wit, "description", "caseID", true, "date");
        String actual = newCrime.getWitnessString();
        assertTrue(actual.contains("Conor Raymond"));
    }

    /**
     * Tested by: Bradley Grose 
     * Passed: True
     */
    @Test
    void testGetSuspectString() {
        ArrayList<Suspects> sus = new ArrayList<Suspects>();
        sus.add(new Suspects("bob", true, "goat", "Maddie Smith", "blue", "brown", "dove", "white", "American", 150, 72,
                "Katie Lynch", 33, false, "none", "none", "right", "robbery", false, "male", "302 Capstone Road",
                "5552222222"));
        Crime newCrime = new Crime(null, sus, null, "description", "caseID", true, "date");
        String actual = newCrime.getSuspectString();
        assertTrue(actual.contains("bob"));
    }

    /**
     * Tested by: Bradley Grose 
     * Passed: True
     */
    @Test
    void testGetEvidenceString() {
        ArrayList<Evidence> evi = new ArrayList<Evidence>();
        evi.add(new Evidence("hammer", " rusty and red"));
        Crime newCrime = new Crime(evi, null, null, "description", "caseID", true, "date");
        String actual = newCrime.getEvidenceString();
        assertTrue(actual.contains("hammer"));
    }

}
