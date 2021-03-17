import java.io.FileReader;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * @description
 * @author Bradley Grose, Ellie Barry, David Keen, David Morrison
 */
public class DataLoader extends DataConstants{
    
    public static ArrayList<Crime> getCrimes() {
        return new ArrayList<Crime>();
    }

    public static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<User>();
       
        try {
			FileReader reader = new FileReader(USER_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONArray peopleJSON = (JSONArray)parser.parse(reader);
			
			for(int i=0; i < peopleJSON.size(); i++) {
				JSONObject personJSON = (JSONObject)peopleJSON.get(i);
				String UUID = (String)personJSON.get(USER_UUID);
				String username = (String)personJSON.get(USER_USERNAME);
				String password = (String)personJSON.get(USER_PASSWORD);
                String name = (String)personJSON.get(USER_NAME);
                String position = (String)personJSON.get(USER_POSITION);
                Boolean admin = (Boolean)personJSON.get(USER_ADMIN);

                users.add(new User(username, password, name, position, admin, UUID));

			}
			
			return users;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
    }
    
}
