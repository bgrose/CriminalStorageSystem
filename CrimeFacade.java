/**
 * 
 * @author Bradley Grose, Eleanor Barry, David Keen, David Morrison
 */
public class CrimeFacade {

    private CrimeDatabase crimeDatabase;
    private UserDatabase userDatabase;
    private PersonDatabase personDatabase;
    private User currentUser;

    /**
     * 
     */
    public CrimeFacade() {
        crimeDatabase = CrimeDatabase.getInstance();
        userDatabase = UserDatabase.getInstance();
        personDatabase = PersonDatabase.getInstance();
    }

    /**
     * 
     * @param username
     * @param password
     * @param name
     * @param position
     * @param isAdmin
     */
    public void createAccount(String username, String password, String name, String position, boolean isAdmin) {
        userDatabase.addUser(new User(username, password, name, position, isAdmin));
    }

    /**
     * 
     * @param username
     * @return
     */
    public boolean login(String username, String password) {
        if (userDatabase.getUser(username, password) == null || password  == null) {
            return false;
        }
        currentUser = userDatabase.getUser(username, password);
        return true;
    }

    /**
     * 
     * @return
     */
    public User getCurrentUser() {
        return currentUser;
    }

    /**
     * 
     * @param crime
     * @return
     */
    public void addCrime(Crime crime) {
        crimeDatabase.addCrime(crime);
    }

    /**
     * 
     * @param crime
     * @return
     */
    public Crime searchCrime(String crimeID) {
        return crimeDatabase.getCrime(crimeID);

    }

    /**
     * 
     * @param crime
     * @return
     */
    public boolean modifyCrime(Crime crime) {
        return true;
    }

    /**
     * 
     * @return
     */
    public void printCrimes() {
        crimeDatabase.printDatabase();
    }

    /**
     * 
     * @return
     */
    public boolean searchCriminal() {
        return true;
    }

    /**
     * 
     * @return
     */
    public boolean modifyCriminal() {
        return true;
    }

    /**
     * 
     * @return
     */
    public void printCriminal() {
        // criminal.printCriminal();
    }

    /**
     * 
     * @return
     */
    public void removeCrime(Crime crime) {
        crimeDatabase.removeCrime(crime);
    }

    /**
     * 
     * @return
     */
    public void addUser(User user) {
        userDatabase.addUser(user);
    }

    /**
     * 
     * @return
     */
    public void removeUser(User user) {
        userDatabase.removeUser(user);
    }

    /**
     * 
     */
    public void logout() {
        DataWriter.DataUpdate();
    }
}
