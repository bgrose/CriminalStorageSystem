
/**
 * @description Class that creates Witness
 * @author Bradley Grose, Eleanor Barry, David Keen, David Morrison
 */

 import java.util.UUID;

public class Witness extends Person {

    private String statement;
    private boolean isVictem;

    /**
     * Constructor method that sets up the class
     * @param name of the witness
     * @param livingStatus of the witness
     * @param statement of the witness
     * @param UUID of the witness
     */
    public Witness(String name, boolean livingStatus, String statement, UUID UUID, String Gender, boolean isVictem) {
        super(name, livingStatus, UUID, Gender);
        this.statement = statement;
        this.isVictem = isVictem;
    }

    /**
     * Constructor method that sets up the class
     * @param name of the witness
     * @param livingStatus of the witness
     * @param statement of the witness
     */
    public Witness(String name, boolean livingStatus, String statement, String Gender, boolean isVictem) {
        super(name, livingStatus, Gender);
        this.statement = statement;
        this.isVictem = isVictem;
    }

    /**
     * Method that returns the variables of the class as a string
     * @return String of class variables
     */
    public String toString() {
        return super.toString() + "\nStatement: " + this.statement + "\nIs a Victim: "+this.isVictem+"\n";
    }

    /**
     * Method that gets the statement
     * @return String statement
     */
    public String getStatement() {
        return this.statement;
    }

    /**
     * Method that sets the statement
     * @param String statement
     */
    public void setStatement(String statement) {
        this.statement = statement;
    }

    public void setIsVictem(boolean isVictem)
    {
        this.isVictem = isVictem;
    }

    public boolean getisVictem()
    {
        return this.isVictem;
    }

}
