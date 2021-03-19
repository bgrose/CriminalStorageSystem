/**
 * Class that creates a Crime
 * @author Bradley Grose, Eleanor Barry, David Keen, David Morrison
 */

import java.util.ArrayList;
import java.util.UUID;

public class Crime {

    private ArrayList<Evidence> evidenceList;
    private ArrayList<Suspects> personList;
    private ArrayList<Witness> witnessees;
    private ArrayList<User> officers;
    private String description;
    private String caseID;
    private Boolean solved;
<<<<<<< HEAD
    private int date;
    private String evidenceListReturn; // Used in toString
    private String anyonePersonListReturn; // Used in toString
    private String UUID;
    /**
     * Constructor method that sets up the Crime
     * @param str
     */
    public void Crime(ArrayList<Evidence> evidenceList, ArrayList<Person> anyonePersonList, String description,
            String name, Boolean solved, int date) {
        this.evidenceList = evidenceList;
        this.anyonePersonList = anyonePersonList;
=======
    private String date;
    private String evidenceListReturn; // Used in toString
    private String anyonePersonListReturn; // Used in toString
    private UUID uuid;

    /**
     * Creates a Crime object with a UUID
     * @param evidenceList The arraylist with evidence for a crime
     * @param _personLists  Arraylist with Suspects and Criminals
     * @param witness Arraylist with witnesses of the crime
     * @param description String with Description of the crime
     * @param caseID String with the name of the Crime
     * @param solved Boolean if its solved or not
     * @param date String with date of crime
     * @param _UUID Unique ID 
     */
    public Crime(ArrayList<Evidence> evidenceList, ArrayList<Suspects> _personLists, ArrayList<Witness> witness,
            String description, String caseID, Boolean solved, String date, UUID _UUID) {
        this.evidenceList = evidenceList;
        this.personList = _personLists;
        this.witnessees = witness;
>>>>>>> 59904edf858c08223b73aa7ad881623e38617287
        this.description = description;
        this.caseID = caseID;
        this.solved = solved;
        this.date = date;
<<<<<<< HEAD
=======
        this.uuid = _UUID;
    }

   /**
     * Creates a Crime object without a UUID
     * @param evidenceList The arraylist with evidence for a crime
     * @param _personLists  Arraylist with Suspects and Criminals
     * @param witness Arraylist with witnesses of the crime
     * @param description String with Description of the crime
     * @param caseID String with the name of the Crime
     * @param solved Boolean if its solved or not
     * @param date String with date of crime
     */
    public Crime(ArrayList<Evidence> evidenceList, ArrayList<Suspects> _personLists, ArrayList<Witness> witness,
        String description, String caseID, Boolean solved, String date) {
        this.evidenceList = evidenceList;
        this.personList = _personLists;
        this.witnessees = witness;
        this.description = description;
        this.caseID = caseID;
        this.solved = solved;
        this.date = date;
        this.uuid = UUID.randomUUID();
>>>>>>> 59904edf858c08223b73aa7ad881623e38617287
    }

    /**
     * Method that sets the evidence list of the Crime
     * @param evidenceList ArrayList<evidence> of the evidence of the Crime
     */
    public void setEvidenceList(ArrayList<Evidence> evidenceList) {
        this.evidenceList = evidenceList;
    }

    /**
     * Method that sets the anyone person list of the Crime
     * @param anyonePersonList ArrayList<Suspects> of the people of the Crime
     */
<<<<<<< HEAD
    public void setAnyonePersonList(ArrayList<Person> anyonePersonList) {
        this.anyonePersonList = anyonePersonList;
=======
    public void setPersonList(ArrayList<Suspects> anyonePersonList) {
        this.personList = anyonePersonList;
    }

    /**
     * Method that sets the anyone person list of the Crime
     * @param WitnessList ArrayList<Suspects> of the people of the Crime
     */
    public void setWitnessList(ArrayList<Witness> WitnessList) {
        this.witnessees = WitnessList;
>>>>>>> 59904edf858c08223b73aa7ad881623e38617287
    }

    /**
     * Method that sets the description of the Crime
     * @param description String description of the Crime
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Method that sets the name of the Crime
     * @param name String name of the Crime
     */
    public void setcaseID(String caseID) {
        this.caseID = caseID;
    }

    /**
     * Method that sets the solved Boolean of the Crime
     * @param solved Boolean that shows if the Crime is solved or not
     */
    public void setSolved(Boolean solved) {
        this.solved = solved;
    }

    /**
     * Method that sets the date of the Crime
     * @param date String date of the Crime
     */
<<<<<<< HEAD
    public void setDate(int date) {
=======
    public void setDate(String date) {
>>>>>>> 59904edf858c08223b73aa7ad881623e38617287
        this.date = date;
    }

    /**
     * Method that gets the evidence list
     * @return ArrayList of the crime evidence
     */
    public ArrayList<Evidence> getEvidenceList() {
        return evidenceList;
    }

    /**
     * Method that gets the people involved list
     * @return ArrayList of people involved in the crime
     */
<<<<<<< HEAD
    public ArrayList<Person> getAnyonePersonList() {
        return anyonePersonList;
=======
    public ArrayList<Suspects> getPersonList() {
        return personList;
    }

    /**
     * Method that gets the people involved list
     * @return ArrayList of people involved in the crime
     */
    public ArrayList<Witness> getUserList() {
        return witnessees;
>>>>>>> 59904edf858c08223b73aa7ad881623e38617287
    }

    /**
     * Method that gets the description of the Crime
     * @return String description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Method that gets the name of the crime
     * @return String name
     */
    public String getcaseID() {
        return caseID;
    }

    /**
     * Method that gets whether the Crime is solved or not
     * @return Boolean solved
     */
    public Boolean getSolved() {
        return solved;
    }

    /**
     * Method that gets the date the Crime was comitted
     * @return int date
     */
    public int getDate() {
        return this.date;
    }

<<<<<<< HEAD
=======
    public ArrayList<Witness> getWitnessList() {
        return this.witnessees;
    }

>>>>>>> 59904edf858c08223b73aa7ad881623e38617287
    /**
     * Method that adds Evidence to the Crime
     * @param evidence Evidence to be added from the crime
     */
    public void addEvidence(Evidence evidence) {
        evidenceList.add(evidence);
    }

    /**
     * Method that removes Evidence from the Crime
     * @param evidence Evidence to be removed from the crime
     */
    public void removeEvidence(Evidence evidence) {
        evidenceList.remove(evidence);
    }

    /**
     * Method that adds a Person to the Crime
     * @param person Person that is added to the Crime
     */
<<<<<<< HEAD
    public void addPerson(Person person) {
        anyonePersonList.add(person);
=======
    public void addPerson(Suspects person) {
        personList.add(person);
>>>>>>> 59904edf858c08223b73aa7ad881623e38617287
    }

    /**
     * Method that removes a Person from the Crime
     * @param person Person that is removed from the Crime
     */
<<<<<<< HEAD
    public void removePerson(Person person) {
        anyonePersonList.remove(person);
=======
    public void removePerson(Suspects person) {
        personList.remove(person);
>>>>>>> 59904edf858c08223b73aa7ad881623e38617287
    }

    /**
     * Method that prints out the details of the Crime class
     */
    public String toString() {
        for (Evidence evidence : evidenceList) {
            evidenceListReturn += evidence;
        }
<<<<<<< HEAD
        for (Person person : anyonePersonList) {
=======
        for (Suspects person : personList) {
>>>>>>> 59904edf858c08223b73aa7ad881623e38617287
            anyonePersonListReturn += person;
        }
        return "Case ID: " + caseID + "Description: " + description + "Solved: " + solved + "Date: " + date
                + "Evidence List: " + evidenceListReturn + "People Involved List" + anyonePersonListReturn;
    }

    /**
     * 
     * @return
     */
    public ArrayList<User> getOfficers() {
        return this.officers;
    }

    /**
     * 
     * @return
     */
    public UUID getUUID() {
        return this.uuid;
    }
}
