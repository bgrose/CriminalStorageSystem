/**
 * @description Class that creates a database to store Person objects (Criminals, POIs, and Witnesses)
 * @author Bradley Grose, Eleanor Barry, David Keen, David Morrison
 */
import java.util.*;

public class PersonDatabase {

    private static PersonDatabase personDatabase;
    ArrayList<Suspects> personList;


    /**
     * Method that returns a Person from person Database
     * @return Crime from CrimeDatabase
     */
    public Crime getPerson() {
        return null;
    }

    /**
     * Method that adds a Person to personDatabase
     */
    public void addPerson(Suspects person) {

    }

    /**
     * Method that removes a Person from personDatabase
     */
    public void removePerson(Suspects person) {

    }

    /**
     * Method that modifies a Person in personDatabase
     */
    public void modifyPerson(Suspects person) {

    }

    /**
     * Method that prints out the personDatabase
     */
    public void printDatabase() {

    }

    public static PersonDatabase getInstance()
    {
        if(personDatabase == null) personDatabase = new PersonDatabase();
        return personDatabase;
    }

    private PersonDatabase()
    {
        personList = DataLoader.getPerson();
    }

    public ArrayList<Suspects> getDatabase()
    {
        return personList;
    }
    

}
