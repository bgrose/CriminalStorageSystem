/**
 * @description
 * @author Bradley Grose, Eleanor Barry, David Keen, David Morrison
 */
public class User {

    private String username;
    private String password;
    private String name;
    private String position;
    private boolean admin;
    private String UUID;

    /**
     * Constructor method that sets up User
     */
    public User() {

    }

    /**
     * Method that sets the username
     * @param username String username of User
     */
    public void setUsername(String username) {

    }

    /**
     * Method that sets the password
     * @param password String password of User
     */
    public void setPassword(String password) {

    }

    /**
     * Method that sets the name
     * @param name String name of User
     */
    public void setName(String name) {

    }

    /**
     * Method that sets the position
     * @param position String position of User
     */
    public void setPosition(String position) {

    }

    /**
     * Method that sets the admin status
     * @param admin String admin status of User
     */
    public void setAdmin(String admin) {

    }

    /**
     * Method that returns the username
     * @return String username
     */
    public String getUsername() {
        return username;
    }

<<<<<<< HEAD
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
=======
    /**
     * Method that returns the password
     * @return String password
     */
    public String getPassword() {
        return password;
    }
>>>>>>> c168054c46c63cbf3a8965b062e29a7c8aca76f0

    /**
     * Method that returns the name
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * Method that returns the position
     * @return String position
     */
    public String getPosition() {
        return position;
    }

    /**
     * Method that returns the admin status
     * @return String admin status
     */
    public String getAdmin() {
        return admin;
    }

    /**
     * Method that checks if it is a new username and new password to create a User
     * @return Boolean of if the User is valid
     */
    public Boolean isValid() {
        return true;
    }

    /**
     * Method that returns if the User is an admin
     * @return Boolean of admin status
     */
    public Boolean isAdmin() {
        return true;
    }

    /**
     * Method that returns the User
     * @return User
     */
    public User getUser() {
        return null;
    }

    /**
     * Method that modify's the User
     * @param user User to be modified
     */
    public void modifyUser(User user) {

    }

}
