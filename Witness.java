
/**
 * @description Class that creates Witness
 * @author Bradley Grose, Eleanor Barry, David Keen, David Morrison
 */

 import java.util.UUID;

public class Witness extends Person {

    private String statement;

    /**
     * Constructor method that sets up the class
     * @param name of the witness
     * @param livingStatus of the witness
     * @param statement of the witness
     * @param UUID of the witness
     */
    public Witness(String name, boolean livingStatus, String statement, UUID UUID) {
        super(name, livingStatus, UUID);
        this.statement = statement;
    }

    /**
     * Constructor method that sets up the class
     * @param name of the witness
     * @param livingStatus of the witness
     * @param statement of the witness
     */
    public Witness(String name, boolean livingStatus, String statement) {
        super(name, livingStatus);
        this.statement = statement;
    }

    /**
     * Method that returns the variables of the class as a string
     * @return String of class variables
     */
    public String toString() {
        return super.toString() + "\nStatement: " + this.statement + "\n";
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

}
