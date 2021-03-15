import java.util.ArrayList;
/**
 * @description Class to set up User Database
 * @author Bradley Grose, Ellie Barry, David Keen, David Morrison
 */
import java.util.ArrayList;

public class UserDatabase
{
    
    private static ArrayList<User> database;

    /**
     * Method that gets the User
     * @return null get User
     */
    public User getUser()
    {
        return null;
    }

    /**
     * Method that adds a new user
     * @param adds a new user
     */
    public void addUser(User nw)
    {

    }

    /**
     * Method that removes a user
     * @param delete a new user
     */
    public void removeUser(User delete)
    {

    }

    /**
     * Method that edits a user
     * @param edit modify users
     */
    public void modifyUser(User edit)
    {

    }

    /**
     * Method that gets the database
     * @return null set Database
     */
    public ArrayList<User> getDatabase()
    {
        return null;
    }

    /**
     * Method that sets up the database
     * @param Data set Database
     */
    public void setDatabase(User Data)
    {

    }

    /**
     * Constructor method that sets up the User Database
     * @param return the get users
     */
    public UserDatabase()
    {
        database = DataLoader.getUsers();
    }

    /**
     * Method that gets the User
     * @return userDatabase to the user Database
     */ 
    public static ArrayList<User> getInstance()
    {
        if(database == null) database = new ArrayList<User>();
        return database;
    }
}
