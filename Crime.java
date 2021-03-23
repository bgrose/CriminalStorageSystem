/**
 * @description Class that creates a Crime
 * @author Bradley Grose, Eleanor Barry, David Keen, David Morrison
 */

import java.util.ArrayList;
import java.util.UUID;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Crime {

    private ArrayList<Evidence> evidenceList;
    private ArrayList<Suspects> personList;
    private ArrayList<Witness> witnessList;
    private String description;
    private String caseID;
    private Boolean solved;
    private String date;
    private UUID uuid;
    private static final String LINE_BREAK = "\n--------------------------------------\n";

    /**
     * Creates a Crime object with a UUID
     * @param evidenceList Arraylist with evidence for a crime
     * @param _personLists Arraylist with Suspects and Criminals
     * @param witness      Arraylist with witnesses of the crime
     * @param description  String with Description of the crime
     * @param caseID       String with the name of the Crime
     * @param solved       Boolean if its solved or not
     * @param date         String with date of crime
     * @param _UUID        Unique ID
     */
    public Crime(ArrayList<Evidence> evidenceList, ArrayList<Suspects> _personLists, ArrayList<Witness> witness,
            String description, String caseID, Boolean solved, String date, UUID _UUID) {
        this.evidenceList = evidenceList;
        this.personList = _personLists;
        this.witnessList = witness;
        this.description = description;
        this.caseID = caseID;
        this.solved = solved;
        this.date = date;
        this.uuid = _UUID;
    }

    /**
     * Creates a Crime object without a UUID
     * @param evidenceList Arraylist with evidence for a crime
     * @param _personLists Arraylist with Suspects and Criminals
     * @param witness      Arraylist with witnesses of the crime
     * @param description  String with Description of the crime
     * @param caseID       String with the name of the Crime
     * @param solved       Boolean if its solved or not
     * @param date         String with date of crime
     */
    public Crime(ArrayList<Evidence> evidenceList, ArrayList<Suspects> _personLists, ArrayList<Witness> witness,
            String description, String caseID, Boolean solved, String date) {
        this.evidenceList = evidenceList;
        this.personList = _personLists;
        this.witnessList = witness;
        this.description = description;
        this.caseID = caseID;
        this.solved = solved;
        this.date = date;
        this.uuid = UUID.randomUUID();
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
    public void setPersonList(ArrayList<Suspects> anyonePersonList) {
        this.personList = anyonePersonList;
    }

    /**
     * Method that sets the anyone person list of the Crime
     * @param WitnessList ArrayList<Suspects> of the people of the Crime
     */
    public void setWitnessList(ArrayList<Witness> WitnessList) {
        this.witnessList = WitnessList;
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
    public void setDate(String date) {
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
    public ArrayList<Suspects> getPersonList() {
        return personList;
    }

    /**
     * Method that gets the people involved list
     * @return ArrayList of people involved in the crime
     */
    public ArrayList<Witness> getUserList() {
        return witnessList;
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
     * @return String date
     */
    public String getDate() {
        return this.date;
    }

    /**
     * Returns the Witness List for a Crime
     * @return ArrayList of type Witness with Witnesses/Suspects
     */
    public ArrayList<Witness> getWitnessList() {
        return this.witnessList;
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
    public void addPerson(Suspects person) {
        personList.add(person);
    }

    /**
     * Method that removes a Person from the Crime
     * @param person Person that is removed from the Crime
     */
    public void removePerson(Suspects person) {
        personList.remove(person);
    }

    /**
     * Creates a String to Print out to User
     * @return the string to print out
     */
    public String toString() {
        String ret = "\nCase ID: " + caseID + "\nDescription: " + description + "\nSolved: " + solved + "\nDate: "
                + date;
        String suspects = "\nSuspects/Criminals:" + getSuspectString();
        String evidence = "\nEvidence:" + getEvidenceString();
        String witness = "\nWitnesses:" + getWitnessString();
        ;

        ret = ret.concat(suspects).concat(evidence).concat(witness);
        return ret;
    }

    /**
     * Gets the witness object String
     * @return the string for each witness
     */
    public String getWitnessString() {
        String witness = "";
        for (int i = 0; i < this.witnessList.size(); i++) {
            Witness witnessOb = this.witnessList.get(i);
            String witString = witnessOb.toString();
            witness = witness + witString;
        }
        witness = LINE_BREAK + witness + LINE_BREAK;

        return witness;
    }

    /**
     * Gets the suspect object String
     * @return the string for each suspect
     */
    public String getSuspectString() {
        String suspect = "";
        for (int i = 0; i < this.personList.size(); i++) {
            Suspects suspectOb = this.personList.get(i);
            String susString = suspectOb.toString();
            suspect = suspect + susString;
        }
        suspect = LINE_BREAK + suspect + LINE_BREAK;

        return suspect;
    }

    /**
     * Gets the evidence object String
     * @return the string for each evidence
     */
    public String getEvidenceString() {
        String evidence = "";
        for (int i = 0; i < this.evidenceList.size(); i++) {
            Evidence evidenceOb = this.evidenceList.get(i);
            String evidenceString = evidenceOb.toString();
            evidence = evidence + evidenceString;
        }
        evidence = LINE_BREAK + evidence + LINE_BREAK;

        return evidence;
    }

    /**
     * Method that returns the UUID
     * @return UUID of this class
     */
    public UUID getUUID() {
        return this.uuid;
    }

    /**
     * Wties a Crime to File
     */
    public void crimeToFile() {
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd_HH.mm.ss");
            LocalDateTime now = LocalDateTime.now();
            String timeString = dtf.format(now);
            String fileName = "TextFiles/Crime" + timeString + ".txt";
            File myObj = new File(fileName);
            if (myObj.createNewFile()) {
                FileWriter fileWriter = new FileWriter(fileName);
                PrintWriter printWriter = new PrintWriter(fileWriter);
                printWriter.println(toString());
                printWriter.close();
                System.out.println("Crime Printed to " + fileName);
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
