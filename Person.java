/**
 * @description Class that creates Person
 * @author Bradley Grose, Ellie Barry, David Keen, David Morrison
 */

import java.util.UUID;

public abstract class Person {
    
    private String name;
    private boolean livingStatus;
    private UUID uuid;

    /**
     * Creates a Person as a called super with UUID
     * @param name Name of the Person
     * @param livingStatus Boolean if living 
     * @param _UUID The unique UUID to be used
     */
    public Person(String name, boolean livingStatus, UUID _UUID) {
        this.name = name;
        this.livingStatus = livingStatus;
        this.uuid = _UUID;
    }

        /**
     * Creates a Person as a called super without UUID
     * @param name Name of the Person
     * @param livingStatus Boolean if living 
     */
    public Person(String name, boolean livingStatus) {
        this.name = name;
        this.livingStatus = livingStatus;
        this.uuid = UUID.randomUUID();
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
        return this.uuid;
    }

    public String toString(){
        return "\nName: " + name + "\nLiving Status: " + livingStatus;
    }

}
