
/**
 * Class that creates a database to store Crimes
 * @author Bradley Grose, Eleanor Barry, David Keen, David Morrison
 */
import java.util.ArrayList;

public class CrimeDatabase {

    private static CrimeDatabase crimeDatabase;
    ArrayList<Crime> crimeList;

    /**
     * Method that returns a Crime from crimeDatabase
     * @return Crime from CrimeDatabase
     */
    public Crime getCrime(String caseNumber) {
        for (int i = 0; i < crimeList.size(); i++) {
            if (crimeList.get(i).getcaseID().equals(caseNumber))
                return crimeList.get(i);
        }
        return null;
    }

    /**
     * Method that adds a crime to the databaase
     * @param crime crime to be added
     */
    public void addCrime(Crime crime) {
        crimeList.add(crime);
        for (int i = 0; i < crime.getPersonList().size(); i++)
            PersonDatabase.getInstance().addPerson(crime.getPersonList().get(i));
        DataWriter.DataUpdate();

    }

    /**
     * Method that removes a crime from the database
     * @param crime crime to be removed
     */
    public void removeCrime(Crime crime) {
        crimeList.remove(crime);
        DataWriter.DataUpdate();
    }

    /**
     * Method that prints out the crimeDatabase
     */
    public void printDatabase() {
        for (Crime crime : crimeList) {
            System.out.println(crime.toString());
        }
    }

    /**
     * Method that gets the crimeDatabase
     * @return CrimeDatabase
     */
    public static CrimeDatabase getInstance() {
        if (crimeDatabase == null)
            crimeDatabase = new CrimeDatabase();
        return crimeDatabase;
    }

    /**
     * Constructor method that sets up the CrimeDatabase
     */
    private CrimeDatabase() {
        this.crimeList = DataLoader.getCrimes();
    }

    /**
     * Method that returns the CrimeDatabase
     * @returnArrayList<Crime> that contains all the crimes
     */
    public ArrayList<Crime> getDatabase() {
        return crimeList;
    }

}
