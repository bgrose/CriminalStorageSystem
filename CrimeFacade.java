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
     * @param userName
     * @param password
     * @param name
     * @param position
     * @param isAdmin
     */
    public void createAccount(String userName, String password, String name, String position, boolean isAdmin) {
        userDatabase.addUser(new User(userName, password, name, position, isAdmin));
    }

    /**
     * 
     * @param userName
     * @return
     */
    public boolean login(String userName) {
        if (userDatabase.getUser(userName) == null)
            return false;

        currentUser = userDatabase.getUser(username);
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
    public boolean addCrime(Crime crime) {
        return crimeDatabase.addCrime(crime);
    }

    /**
     * 
     * @param crime
     * @return
     */
    public boolean searchCrime(Crime crime) {
        return crimeDatabase.getCrime(crime);
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
    public boolean printCrimes() {
        return true;
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
    public boolean printCriminal() {
        return true;
    }

    /**
     * 
     * @return
     */
    public boolean removeCrimes() {
        return true;
    }

    /**
     * 
     * @return
     */
    public boolean addUser() {
        return true;
    }

    /**
     * 
     * @return
     */
    public boolean removeUser() {
        return true;
    }

    /**
     * 
     */
    public void logout() {
        DataWriter.DataUpdate();
    }
}
