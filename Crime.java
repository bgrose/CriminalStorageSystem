
/**
 * @description Class that creates a Crime
 * @author Bradley Grose, Eleanor Barry, David Keen, David Morrison
 */

import java.util.*;

public class Crime {

    private ArrayList<Evidence> evidenceList;
    private ArrayList<Person> anyonePersonList;
    private ArrayList <User> officers;
    private String description;
    private String name;
    private Boolean solved;
    private int date;
    private String evidenceListReturn; // Used in toString
    private String anyonePersonListReturn; // Used in toString
    private String UUID;

    /**
     * Constructor method that sets up the Crime
     * @param ArrayList<Evidence> evidenceList, ArrayList<Person> anyonePersonList, String description,
            String name, Boolean solved, int date
     */
    public void Crime(ArrayList<Evidence> evidenceList, ArrayList<Person> anyonePersonList, String description,
            String name, Boolean solved, int date) {
        this.evidenceList = evidenceList;
        this.anyonePersonList = anyonePersonList;
        this.description = description;
        this.name = name;
        this.solved = solved;
        this.date = date;
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
     * @param anyonePersonList ArrayList<Person> of the people of the Crime
     */
    public void setAnyonePersonList(ArrayList<Person> anyonePersonList) {
        this.anyonePersonList = anyonePersonList;
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
    public void setName(String name) {
        this.name = name;
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
    public void setDate(int date) {
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
    public ArrayList<Person> getAnyonePersonList() {
        return anyonePersonList;
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
    public String getName() {
        return name;
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
    public void addPerson(Person person) {
        anyonePersonList.add(person);
    }

    /**
     * Method that removes a Person from the Crime
     * @param person Person that is removed from the Crime
     */
    public void removePerson(Person person) {
        anyonePersonList.remove(person);
    }

    /**
     * Method that prints out the details of the Crime class
     */
    public String toString() {
        for (Evidence evidence : evidenceList) {
            evidenceListReturn += evidence;
        }
        for (Person person : anyonePersonList) {
            anyonePersonListReturn += person;
        }
        return "Name: " + name + "Description: " + description + "Solved: " + solved + "Date: " + date
                + "Evidence List: " + evidenceListReturn + "People Involved List" + anyonePersonListReturn;
    }

    public ArrayList<User> getOfficers() {
        return this.officers;
    }

    public String getUUID() {
        return this.UUID;
    }
}

