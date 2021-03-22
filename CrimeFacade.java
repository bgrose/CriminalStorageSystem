import java.util.ArrayList;

/**
 * @description Class that creates the crimeFacade for the criminal UI to call
 * @author Bradley Grose, Eleanor Barry, David Keen, David Morrison
 */
public class CrimeFacade {

    private CrimeDatabase crimeDatabase;
    private UserDatabase userDatabase;
    private PersonDatabase personDatabase;
    private User currentUser;

    /**
     * Constructor method that sets up the CrimeFacade
     */
    public CrimeFacade() {
        crimeDatabase = CrimeDatabase.getInstance();
        userDatabase = UserDatabase.getInstance();
        personDatabase = PersonDatabase.getInstance();
    }

    /**
     * Method that creates a new account
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
     * Method that checks if the user can login
     * @param username
     * @return boolean for if the user can login
     */
    public boolean login(String username, String password) {
        if (userDatabase.getUser(username, password) == null) {
            return false;
        }
        currentUser = userDatabase.getUser(username, password);
        return true;
    }

    /**
     * Method that returns the current user
     * @return User the current user
     */
    public User getCurrentUser() {
        return currentUser;
    }

    /**
     * Method that adds a crime to the crimeDatabase
     * @param crime to be added to the crimeDatabase
     */
    public void addCrime(Crime crime) {
        crimeDatabase.addCrime(crime);
    }

    /**
     * Method that returns if the crime is in the crimeDatabase
     * @param crime to be searched for
     * @return boolean that represents if the crime is in the database
     */
    public boolean searchCrime(String caseID) {
        for (int i = 0; i < crimeDatabase.getDatabase().size(); i++) {
            if (crimeDatabase.getDatabase().get(i).getcaseID().equals(caseID)) {
                return true;
            }
        }
        return false;

    }

    /**
     * Method that prints the crimes in the crimeDatabase
     */
    public void printCrimes() {
        crimeDatabase.printDatabase();
    }

    /**
     * Method that returns if the criminal is in the crimeDatbase
     * @param name to be searched for
     * @return boolean that represents if the crime is in the database
     */
    public boolean searchCriminal(String name) {
        for (int i = 0; i < personDatabase.getDatabase().size(); i++) {
            if (personDatabase.getDatabase().get(i).getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method that prints the criminals in the personDatabase
     */
    public void printCriminal() {
        personDatabase.printDatabase();
    }

    /**
     * Method that removes a crime from the database
     * @param caseID String that is used to represent the crime
     * @return Boolean of if the crime was removed sucessfully
     */
    public boolean removeCrime(String caseID) {
        ArrayList<Crime> crimes = crimeDatabase.getDatabase();
        for (int i = 0; i < crimes.size(); i++) {
            if (crimes.get(i).getcaseID().equals(caseID)) {
                crimeDatabase.removeCrime(crimes.get(i));
                return true;
            }
        }
        return false;
    }

    /**
     * Method that adds a user to the userDatabase
     * @param user User to be added to the database
     */
    public void addUser(User user) {
        userDatabase.addUser(user);
    }

    /**
     * Method that removes a user from the userDatabase
     * @param username of the user being removed
     * @return Boolean of if the user was removed sucessfully
     */
    public boolean removeUser(String username) {
        ArrayList<User> users = userDatabase.getDatabase();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(username)) {
                userDatabase.removeUser(users.get(i));
                return true;
            }
        }
        return false;
    }

    /**
     * Method that logs out the current user
     */
    public void logout() {
        DataWriter.DataUpdate();
    }

    /**
     * Method that finds an officer in the userDatabase
     * @param name of the user being searched for
     * @return User that was being searched for
     */
    public User findOfficer(String name) {
        for (int i = 0; i < userDatabase.getDatabase().size(); i++) {
            if (userDatabase.getDatabase().get(i).getName().equals(name))
                return userDatabase.getDatabase().get(i);
        }
        return null;
    }

    public void addSuspect(Suspects suspect)
    {
        personDatabase.addPerson(suspect);
    }
}
