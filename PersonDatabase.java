
/**
 * @description Class that creates a database to store Person objects (Criminals, POIs, and Witnesses)
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
     * 
     * @param person
     */
    public void addPerson(Suspects person) {
        personList.add(person);
        DataWriter.DataUpdate();
    }

    /**
     * 
     * @param person
     */
    public void removePerson(Suspects person) {
        personList.remove(person);
        DataWriter.DataUpdate();
    }


    /**
     * 
     */
    public void printDatabase() {

    }

    /**
     * 
     * @return
     */
    public static PersonDatabase getInstance() {
        if (personDatabase == null)
            personDatabase = new PersonDatabase();
        return personDatabase;
    }

    /**
     * 
     */
    private PersonDatabase() {
        personList = DataLoader.getPerson();
    }

    /**
     * 
     * @return
     */
    public ArrayList<Suspects> getDatabase() {
        return personList;
    }

}
