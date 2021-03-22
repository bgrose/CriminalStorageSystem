/**
 * @description Class that creates a Person
 * @author Bradley Grose, Eleanor Barry, David Keen, David Morrison
 */

import java.util.UUID;

public abstract class Person {
    
    private String name;
    private boolean livingStatus;
    private UUID uuid;
    private String gender;
    private String address;
    private String phoneNumber;

    /**
     * Method that creates a Person as a called super with UUID
     * @param name Name of the Person
     * @param livingStatus Boolean if living 
     * @param _UUID The unique UUID to be used
     */
    public Person(String name, boolean livingStatus, UUID _UUID, String Gender, String address, String phoneNumber) {
        this.name = name;
        this.livingStatus = livingStatus;
        this.uuid = _UUID;
        this.gender = Gender;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    /**
     * Method that creates a Person as a called super without UUID
     * @param name Name of the Person
     * @param livingStatus Boolean if living 
     */
    public Person(String name, boolean livingStatus, String Gender, String address, String phoneNumber) {
        this.name = name;
        this.livingStatus = livingStatus;
        this.uuid = UUID.randomUUID();
        this.gender = Gender;
        this.phoneNumber = phoneNumber;
        this.address = address;
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
     * @return livingStatus boolean
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

    public String getGender()
    {
        return this.gender;
    }

    public String getPhone()
    {
        return this.phoneNumber;
    }

    public String getAddress()
    {
        return this.address;
    }

    public void setGender(String Gender)
    {
        this.gender = Gender;
    }

    /**
     * Method that returns the variables of the class as a string
     * @return String of the variables of the class
     */
    public String toString(){
        return "Name: " + name + "\nLiving Status: " + livingStatus + "\nGender: "+ gender
        + "\nAddress: "+address+"\nPhone Number"+phoneNumber;
    }

}
