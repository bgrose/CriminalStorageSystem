/**
 * @description Class that creates Person
 * @author Bradley Grose, Ellie Barry, David Keen, David Morrison
 */

import java.util.UUID;

public class Person {
    
    private String name;
    private boolean livingStatus;
    private UUID UUID;

    /**
     * 
     * @param name
     * @param livingStatus
     * @param _UUID
     */
    public Person(String name, boolean livingStatus, UUID _UUID) {
        this.name = name;
        this.livingStatus = livingStatus;
        this.UUID = _UUID;
    }

        /**
     * 
     * @param name
     * @param livingStatus
     */
    public Person(String name, boolean livingStatus) {
        this.name = name;
        this.livingStatus = livingStatus;
        this.UUID = UUID.randomUUID();
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
    public UUID getUUID(){
        return this.UUID;
    }

    /**
     * Method that gets who's the witness
     * @return true if there is a witness
     */
    public boolean isWitness() {
        return this instanceof Witness;
    }

    /**
     * Method that gets who's the criminal
     * @return true if there is a criminal
     */
    public boolean isCriminal() {
        return this instanceof Suspects;
    }
}
