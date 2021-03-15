import java.util.ArrayList;

/**
 * @description Class that creates Person
 * @author Bradley Grose, Ellie Barry, David Keen, David Morrison
 */
public class Person {
    
    private String name;
    private ArrayList<Crime> crimeList;
    private boolean livingStatus;
    private String UUID;

    /**
     * Constructor method that sets up the Person
     * @param
     */
    public Person(String name, ArrayList<Crime> crimeList, boolean livingStatus, String _UUID) {
        this.name = name;
        this.crimeList = crimeList;
        this.livingStatus = livingStatus;
        this.UUID = _UUID;
    }

    /**
     * Method that sets the name
     * @param name String name of the Person
     */
    public String getName() {
        return this.name;
    }

    /**
     * Method that gets the name
     * @return String name of the Person
     */
    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Crime> getCrimeList() {
        return this.crimeList;
    }

    /**
     * Method that sets the list of the Crime
     * @param evidenceList ArrayList<Crime>  of the Crime
     */
    public void setCrimeList(ArrayList<Crime> crimeList) {
        this.crimeList = crimeList;
    }

    /**
     * Method that gets the living status
     * @return livingStatus boolean livingStatus
     */
    public boolean getLivingStatus() {
        return this.livingStatus;
    }

    /**
     * Method that sets the living status
     * @param livingStatus boolean livingStatus of the person
     */
    public void setLivingStatus(boolean livingStatus) {
        this.livingStatus = livingStatus;
    }

    /**
     * Method that gets the person's UUID
     * @return person's UUID
     */
    public String getUUID(){
        return this.UUID;
    }

    /**
     * Method that gets who's the witness
     * @return true if there is a witness
     */
    public boolean isWitness() {
        return true;
    }

        /**
     * Method that gets who's the POI
     * @return true if there is a POI
     */
    public boolean isPOI() {
        return true;
    }

    /**
     * Method that gets who's the criminal
     * @return true if there is a criminal
     */
    public boolean isCriminal() {
        return true;
    }
}
