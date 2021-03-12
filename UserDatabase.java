import java.util.ArrayList;
/**
 * @description 
 * @author Bradley Grose, Ellie Barry, David Keen, David Morrison
 */
import java.util.ArrayList;

public class UserDatabase{
    
    private static UserDatabase userDatabase;
    private ArrayList<User> database;

    public User getUser()
    {
        return null;
    }

    public void addUser(User nw)
    {

    }

    public void removeUser(User delete)
    {

    }

    public void modifyUser(User edit)
    {

    }

    public ArrayList<User> getDatabase()
    {
        return null;
    }
    
    public void setDatabase(User Data)
    {

    }

    private UserDatabase()
    {
        database = DataLoader.getUsers();
    }

    public static UserDatabase getInstance()
    {
        if(userDatabase == null) userDatabase = new UserDatabase();
        return userDatabase;
    }
}
