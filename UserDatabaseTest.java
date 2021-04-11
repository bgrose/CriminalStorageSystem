import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserDatabaseTest {
	
	private static UserDatabase userDatabase;
    private UserDatabase users = UserDatabase.getInstance();
    private ArrayList<User> usersList = userDatabase.getDatabase();
	
	@BeforeEach
	public void setup() {
		//Intentionally Empty
	}

	@AfterEach
	public void tearDown() {
		//Intentionally Empty
	}

	/**
	 * Tested by: Eleanor Barry
	 * Passed:
	 */
	@Test
	void testGetUser() {
		User testUsers = new User("username", "password", "name", "position", false);
		userDatabase.addUser(testUsers);
		userDatabase.getUser("userame", "password");
	}

	/**
	 * Tested by: Eleanor Barry
	 * Passed:
	 */
	@Test
	void testAddUser() {

	}

	/**
	 * Tested by: Eleanor Barry
	 * Passed:
	 */
	@Test
	void testRemoveUser() {

	}

	/**
	 * Tested by: Eleanor Barry
	 * Passed:
	 */
	@Test
	void testGetInstance() {

	}

}
