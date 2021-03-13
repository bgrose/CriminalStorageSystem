
/**
 * @description Class that creates Witness
 * @author Bradley Grose, Ellie Barry, David Keen, David Morrison
 */

import java.util.ArrayList;
 
public class Witness extends Person {

    private String statement;

    /**
     * Constructor method that sets up the Witness
     */
    public Witness(String name, ArrayList<Crime> crimeList, boolean livingStatus, String statement, String UUID) {
        super(name, crimeList, livingStatus, UUID);
        this.statement = statement;
    }

    /**
     * Method that prints out the details of the Witness class
     */
    public String toString() {
        return super.toString() +
        "\nStatement: " + this.statement;
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
