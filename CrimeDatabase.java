
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
    public Crime getCrime() {
        return null;
    }

    /**
     * 
     * @param crime
     */
    public void addCrime(Crime crime) {
        crimeList.add(crime);
    }

   /**
    * 
    * @param crime
    */
    public void removeCrime(Crime crime) {
        crimeList.remove(crime);
    }

    /**
     * 
     * @param crime
     */
    public void modifyCrime(Crime crime) {

    }

    /**
     * Method that prints out the crimeDatabase
     */
    public void printDatabase() {
        for (Crime crime : crimeList) {
            // System.out.println(crime.getName());
        }
    }

    /**
     * 
     * @return
     */
    public static CrimeDatabase getInstance() {
        if (crimeDatabase == null)
            crimeDatabase = new CrimeDatabase();
        return crimeDatabase;
    }

    /**
     * 
     */
    private CrimeDatabase() {
        crimeList = DataLoader.getCrimes();
    }

    /**
     * 
     * @return
     */
    public ArrayList<Crime> getDatabase() {
        return crimeList;
    }

}
