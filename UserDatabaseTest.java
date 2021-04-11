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
		usersList.clear();
		DataWriter.saveUsers();
	}

	@AfterEach
	public void tearDown() {
		usersList.clear();
		DataWriter.saveUsers();
	}

	/**
	 * Tested by:
	 * Passed:
	 */
	@Test
	void testGetUser() {

	}

	/**
	 * Tested by:
	 * Passed:
	 */
	@Test
	void testAddUser() {

	}

	/**
	 * Tested by: Passed:
	 */
	@Test
	void testRemoveUser() {

	}

	/**
	 * Tested by:
	 * Passed:
	 */
	@Test
	void testGetInstance() {

	}

}
