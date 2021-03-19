/**
 * @description Class to set up User Database
 * @author Bradley Grose, Ellie Barry, David Keen, David Morrison
 */
import java.util.ArrayList;

public class UserDatabase {

    private static ArrayList<User> database;

    /**
     * Method that gets the User
     * @param UUID UUID of User
     * @return null get User
     */
    public User getUser(String userName) {
        for (int i = 0; i < database.size(); i++) {
            User user = database.get(i);
            if (userName.equals(user.getUsername()))
                return user;
        }
        return null;
    }

    /**
     * Method that adds a new user
     * @param adds a new user
     */
    public void addUser(User nw) {
        database.add(nw);
        DataWriter.DataUpdate();
    }

    /**
     * Removes a user from the database
     * @param delete user to delete
     */
    public void removeUser(User delete) {
        database.remove(delete);
        DataWriter.DataUpdate();
    }

    /**
     * Method that gets the database
     * @return null set Database
     */
    public ArrayList<User> getDatabase() {
        return database;
    }

    /**
     * Method that gets the User
     * @return userDatabase to the user Database
     */
    public static ArrayList<User> getInstance() {
        if (database == null)
            database = DataLoader.getUsers();
        return database;
    }
}
