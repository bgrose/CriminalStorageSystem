/**
 * @description 
 * @author Bradley Grose, Ellie Barry, David Keen, David Morrison
 */

 import java.util.ArrayList;
 
public class Witness extends Person {

    private String statement;

    public Witness(String name, ArrayList<Crime> crimeList, boolean livingStatus) {
        super(name, crimeList, livingStatus );
    }

    public String toString() {
        return "Name: " + this.getName() +
        "\nStatement: " + this.statement;
    }

    public String getStatement() {
        return this.statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }
    
}
