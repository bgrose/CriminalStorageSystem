
/**
 * @description Class that creates the Evidence class
 * @author Bradley Grose, Eleanor Barry, David Keen, David Morrison
 */
import java.util.UUID;

public class Evidence {

    private String name;
    private String description;
    private UUID uuid;
    private static final String LINE_BREAK = "\n--------------------------------------\n";

    /**
     * Method that creates an Evidence Object with a UUID
     * @param name of the evidence
     * @param description  of the evidence
     * @param UUID The unique identfier
     */
    public Evidence(String name, String description, UUID UUID) {
        this.name = name;
        this.description = description;
        this.uuid = UUID;
    }

    /**
     * Method that creates an Evidence Object without a UUID
     * @param name of the evidence
     * @param description of the evidence
     */
    public Evidence(String name, String description) {
        this.name = name;
        this.description = description;
        this.uuid = UUID.randomUUID();
    }

    /**
     * Method that sets the name
     * @param name String name of the Evidence
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method that sets the description
     * @param description String description of the Evidence
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Method that gets the name
     * @return String name of the Evidence
     */
    public String getName() {
        return name;
    }

    /**
     * Method that gets the description
     * @return String description of the Evidence
     */
    public String getDescription() {
        return description;
    }

    /**
     * Method that returns the details of the Evidence
     * @return String with the details of the Evidence
     */
    public String toString() {
        return "Name: " + name + "\nDescription: " + description+LINE_BREAK ;
    }

    /**
     * Returns the UUID of evidence
     * @return the Unique UUID
     */
    public UUID getUUID() {
        return this.uuid;
    }

}
