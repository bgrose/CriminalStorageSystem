import java.util.ArrayList;
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
        if (userDatabase.getUser(username, password) == null) {
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
    public boolean searchCriminal(String Name) {
        for(int i=0; i<personDatabase.getDatabase().size(); i++)
        {
            if(personDatabase.getDatabase().get(i).getName().equals(Name)) return true;
        }
        return false;
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
    public boolean removeCrime(String caseID) {
        ArrayList<Crime> crimes = crimeDatabase.getDatabase();
        for (int i = 0; i < crimes.size(); i++)
        { 
            if(crimes.get(i).getcaseID().equals(caseID))
            {
                crimeDatabase.removeCrime(crimes.get(i));
                return true;
            }
        }
        return false;
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
    public boolean removeUser(String userName) {
        ArrayList<User> users = userDatabase.getDatabase();
        for (int i = 0; i < users.size(); i++)
        { 
            if(users.get(i).getUsername().equals(userName))
            {
                userDatabase.removeUser(users.get(i));
                return true;
            }
        }
        return false;
    }

    /**
     * 
     */
    public void logout() {
        DataWriter.DataUpdate();
    }

    public User findOfficer(String name)
    {
        for(int i=0; i<userDatabase.getDatabase().size(); i++)
        {
            if(userDatabase.getDatabase().get(i).getName().equals(name)) return userDatabase.getDatabase().get(i);
        }
        return null;
    }
}
