/**
 * @description
 * @author Bradley Grose, Eleanor Barry, David Keen, David Morrison
 */
public class User {

    private String username;
    private String password;
    private String name;
    private String position;
    private Boolean admin;

    /**
     * Constructor method that sets up User
     */
    public User(String username, String password, String name, String position, Boolean admin) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.position = position;
        this.admin = admin;
    }

    /**
     * Method that sets the username
     * @param username String username of User
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Method that sets the password
     * @param password String password of User
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Method that sets the name
     * @param name String name of User
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method that sets the position
     * @param position String position of User
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * Method that sets the admin status
     * @param admin String admin status of User
     */
    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    /**
     * Method that returns the username
     * @return String username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Method that returns the password
     * @return String password
     */
    public String getPassword() {
        return password;
    }

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
    public Boolean getAdmin() {
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
        return admin;
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
