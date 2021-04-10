
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CrimeTest {

    private ArrayList<Evidence> evidenceList;
    private ArrayList<Suspects> personList;
    private ArrayList<Witness> witnessList;
    Crime crime = new Crime(evidenceList, personList, witnessList, "description", "caseID", false, "date");
    private static final String LINE_BREAK = "\n--------------------------------------\n";


    @BeforeEach
    public void setup() {
        evidenceList.clear();
        personList.clear();
        witnessList.clear();
    }

    @AfterEach
    public void tearDown() {
        evidenceList.clear();
        personList.clear();
        witnessList.clear();
    }

    /**
     * Tested by: David Keen
     * Passed: True
     */
    @Test
    void TestValidCrimeDate() {
        Crime testCrime = new Crime(evidenceList, personList, witnessList, "description", "caseID", false, "date");
        assertEquals("date", testCrime.getDate());
    }

    /**
     * Tested by: Passed:
     */
    @Test
    void testAddEvidence() {
        Evidence evidence = new Evidence("hammer", " rusty and red");
        crime.addEvidence(evidence);
        assertEquals(crime.getEvidenceList().get(0), evidence);
    }

    /**
     * Tested by: Passed:
     */
    @Test
    void testRemoveEvidence() {
        Evidence evidence = new Evidence("hammer", " rusty and red");
        crime.addEvidence(evidence);
        crime.removeEvidence(evidence);
        assertNull(evidenceList);
    }

    /**
     * Tested by: Passed:
     */
    @Test
    void testAddPerson() {
        Suspects suspect = new Suspects("bob", true, "goat", "Maddie Smith", "blue", "brown", "dove", "white", "American", 150, 72, "Katie Lynch", 33, false, "none", "none", "right", "robbery", false, UUID.randomUUID(), "male", "302 Capstone Road", "5552222222");
        crime.addPerson(suspect);
        assertEquals(personList.get(0), suspect);
    }

    /**
     * Tested by: Passed:
     */
    @Test
    void testRemovePerson() {
        Suspects suspect = new Suspects("bob", true, "goat", "Maddie Smith", "blue", "brown", "dove", "white", "American", 150, 72, "Katie Lynch", 33, false, "none", "none", "right", "robbery", false, UUID.randomUUID(), "male", "302 Capstone Road", "5552222222");
        crime.addPerson(suspect);
        crime.removePerson(suspect);
        assertNull(personList);
    }

    /**
     * Tested by: Passed:
     */
    @Test
    void testToString() {
        String actual = crime.toString();
        //need to add arrayLists too
        String expected =  "\nCase ID: caseID \nDescription: description \nSolved: fales \nDate: date ";
        assertEquals(expected, actual);
    }

    /**
     * Tested by: Passed:
     */
    @Test
    void testGetWitnessString() {
        Witness witness = new Witness("Conor Raymond", true, "I saw a white man stab and Asian man", "Male", false, "222 Cleveland Avenue", "7084848400");
        //we have to addWitness method for the witnessList;
        crime.addPerson(witness);
        String expected = "Name: Conor Raymond\nLiving Status: true\nGender: Male\nAddress: 222Cleveland Avenue\nPhone Number: 7084848400\nStatement: I saw a white man stab and Asian man\nIs a Victim: false\n" + LINE_BREAK;
        String actual = crime.getWitnessString();
        assertEquals(expected, actual);
    }

    /**
     * Tested by: Passed:
     */
    @Test
    void testGetSuspectString() {
        Suspects suspect = new Suspects("bob", true, "goat", "Maddie Smith", "blue", "brown", "dove", "white", "American", 150, 72, "Katie Lynch", 33, false, "none", "none", "right", "robbery", false, UUID.randomUUID(), "male", "302 Capstone Road", "5552222222");
        crime.addPerson(suspect);
        String expected = "";
        String actual = crime.getSuspectString();
        assertEquals(expected, actual);
    }

    /**
     * Tested by: Passed:
     */
    @Test
    void testGetEvidenceString() {
        Evidence evidence = new Evidence("hammer", " rusty and red");
        crime.addEvidence(evidence);
        String expected = "";
        String actual = crime.getEvidenceString();
        assertEquals(expected, actual);

    }

}
