/**
 * @description creates the Evidence class
 * @author Bradley Grose, Eleanor Barry, David Keen, David Morrison
 */
public class Evidence 
{

    private String name;
    private String description;
    private String UUID;

    /**
     * Constructor method that creates the Evidence
     */
    public Evidence(String name, String description, String UUID) 
    {
        this.name = name;
        this.description = description;
        this.UUID = UUID;
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
        return "";
    }

    public String getUUID() 
    {
        return this.UUID;
    }

}
