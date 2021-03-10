
/**
 * @description Class that creates a Crime
 * @author Bradley Grose, Ellie Barry, David Keen, David Morrison
 */

import java.util.*;

public class Crime {

    private ArrayList<Evidence> evidenceList;
    private ArrayList<Person> anyonePersonList;
    private String description;
    private String name;
    private Boolean solved;
    private int date;

    /**
     * Constructor method that sets up the Crime
     * @param str
     */
    public void Crime() {

    }

    /**
     * Method that sets the evidence list of the Crime
     * @param evidenceList ArrayList<evidence>  of the evidence of the Crime
     */
    public void setEvidenceList(ArrayList<Evidence> evidenceList) {

    }

    /**
     * Method that sets the anyone person list of the Crime
     * @param anyonePersonList ArrayList<Person> of the people of the Crime
     */
    public void setAnyonePersonList(ArrayList<Person> anyonePersonList) {

    }

    /**
     * Method that sets the description of the Crime
     * @param description String description of the Crime
     */
    public void setDescription(String description) {

    }

    /**
     * Method that sets the name of the Crime
     * @param name String name of the Crime
     */
    public void setName(String name) {

    }

    /**
     * Method that sets the solved Boolean of the Crime
     * @param solved Boolean that shows if the Crime is solved or not
     */
    public void setSolved(Boolean solved){

    }

    /**
     * Method that sets the date of the Crime
     * @param date Int date of the Crime
     */
    public void setDate(int date){

    }

    public ArrayList<Evidence> getEvidenceList(){
        return evidenceList;
    }

    public ArrayList<Person> getAnyonePersonList(){
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
        return date;
    }

    /**
     * Method that mofidy's if the Crime has been solved
     * @param solved Boolean that states if the Crime has been solved
     */
    public void motifySolved(boolean solved) {

    }

    /**
     * Method that adds Evidence to the Crime
     * @param evidence Evidence to be added from the crime
     */
    public void addEvidence(Evidence evidence) {

    }

    /**
     * Method that removes Evidence from the Crime
     * @param evidence Evidence to be removed from the crime
     */
    public void removeEvidence(Evidence evidence) {

    }

    /**
     * Method that adds a Person to the Crime
     * @param person Person that is added to the Crime
     */
    public void addPerson(Person person) {

    }

    /**
     * Method that removes a Person from the Crime
     * @param person Person that is removed from the Crime
     */
    public void removePerson(Person person) {

    }

    /**
     * Method that prints out the details of the Crime class
     */
    public String toString() {
        return "";
    }
}
