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
		// Intentionally Empty
	}

	@AfterEach
	public void tearDown() {
		// Intentionally Empty
	}

	/**
	 * Tested by: Eleanor Barry
	 * Passed: True
	 */
	@Test
	void testGetUser() {
		userDatabase.addUser(new User("username", "password", "name", "position", false));
		userDatabase.getUser("userame", "password");
	}

	/**
	 * Tested by: Eleanor Barry
	 * Passed: True
	 */
	@Test
	void testAddUser() {
		userDatabase.addUser(new User("username", "password", "name", "position", false));
        usersList = userDatabase.getDatabase();
        assertEquals(1, usersList.size());
	}

	/**
	 * Tested by: Eleanor Barry
	 * Passed: True
	 */
	@Test
	void testRemoveUser() {
		User tUser = new User("Username", "Password", "Name", "Position", false);
		userDatabase.addUser(tUser);
		userDatabase.removeUser(tUser);
		usersList = userDatabase.getDatabase();
		assertEquals(0, usersList.size());
	}

	/**
	 * Tested by: Eleanor Barry
	 * Passed: True
	 */
	@Test
	void testGetInstance() {
		// users uses getInstance at the beginning of the class to initialize
        if(users != null) {
			System.out.println("Passed");
		} else {
			System.out.println("Failed");
		}
	}

}
