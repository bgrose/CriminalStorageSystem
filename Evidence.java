/**
 * @description creates the Evidence class
 * @author Bradley Grose, Eleanor Barry, David Keen, David Morrison
 */
import java.util.UUID;

public class Evidence 
{

    private String name;
    private String description;
    private UUID uuid;

    /**
     * Creates an Evidence Object with a UUID
     * @param name Name of the evidence
     * @param description Description of the evidence.
     * @param UUID The unique identfier
     */
    public Evidence(String name, String description, UUID UUID) 
    {
        this.name = name;
        this.description = description;
        this.uuid = UUID;
    }

    /**
     * Creates an Evidence Object without a UUID
     * @param name Name of the evidence
     * @param description Description of the evidence.
     */
    public Evidence(String name, String description) 
    {
        this.name = name;
        this.description = description;
        this.uuid = UUID.randomUUID();
    }

    /**
     * Method that sets the name
     * @param name String name of the Evidence
     */
    public void setName(String name) 
    {
        this.name = name;
    }

    /**
     * Method that sets the description
     * @param description String description of the Evidence
     */
    public void setDescription(String description) 
    {
        this.description = description;
    }

    /**
     * Method that gets the name
     * @return String name of the Evidence
     */
    public String getName() 
    {
        return name;
    }

    /**
     * Method that gets the description
     * @return String description of the Evidence
     */
    public String getDescription() 
    {
        return description;
    }

    /**
     * Method that returns the details of the Evidence
     * @return String with the details of the Evidence
     */
    public String toString() 
    {
        return "Name: " + name + "Description: " + description;
    }

    /**
     * Returns the UUID of evidence
     * @return the Unique UUID
     */
    public UUID getUUID() 
    {
        return this.uuid;
    }

}
