/**
 * @description Class that creates a database to store Person objects (Criminals, POIs)
 * @author Bradley Grose, Eleanor Barry, David Keen, David Morrison
 */
import java.util.ArrayList;

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
     * Adds a person to database and calls for JSON update
     * @param person person to add
     */
    public void addPerson(Suspects person) {
        personList.add(person);
        DataWriter.DataUpdate();
    }

    /**
     * Removes user from database and updates JSON
     * @param person Suspect to be removed
     */
    public void removePerson(Suspects person) {
        personList.remove(person);
        DataWriter.DataUpdate();
    }


    /**
     * 
     */
    public void printDatabase() {
        for(Person person : personList){
            System.out.println(person);
        }
    }

    /**
     * Checks for an instance of PersonDatabase
     * @return a new or current database
     */
    public static PersonDatabase getInstance() {
        if (personDatabase == null)
            personDatabase = new PersonDatabase();
        return personDatabase;
    }

    /**
     * Loads in the values of the JSON File
     */
    private PersonDatabase() {
        personList = DataLoader.getPerson();
    }

    /**
     * Returns the database Array
     * @return Array with Suspects
     */
    public ArrayList<Suspects> getDatabase() {
        return personList;
    }

}
