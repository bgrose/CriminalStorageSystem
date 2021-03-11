/**
 * @description 
 * @author Bradley Grose, Ellie Barry, David Keen, David Morrison
 */
public class User {
        
    private String username;
    private String password;
    private String name;
    private String position;
    private boolean admin;
    private String UUID;

    public boolean isValid()
    {
        return true;
    }

    public boolean isAdmin()
    {
        return true;
    }

    public String getName()
    {
        return "";
    }

    public User(String un, String pw, String nam, String posit, String ad)
    {

    }

    public User getUser()
    {
        return null;
    }

    public String getUUID()
    {
        return this.UUID;
    }

    public String getUsername()
    {
        return this.username;
    }

    public String getPassword()
    {
        return this.password;
    }

    public boolean getAdmin()
    {
        return this.admin;
    }

    public String getPosition()
    {
        return this.position;
    }

    public void changeUser(User change) 
    {

    }

    public User()
    {

    }


}
