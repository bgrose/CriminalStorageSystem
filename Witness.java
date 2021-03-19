
/**
 * @description Class that creates Witness
 * @author Bradley Grose, Ellie Barry, David Keen, David Morrison
 */

public class Witness extends Person {

    private String statement;

    /**
     * 
     * @param name
     * @param livingStatus
     * @param statement
     * @param UUID
     */
    public Witness(String name, boolean livingStatus, String statement, String UUID) {
        super(name, livingStatus, UUID);
        this.statement = statement;
    }

    /**
     * 
     * @return
     */
    public String toString() {
        return super.toString() + "\nStatement: " + this.statement;
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
