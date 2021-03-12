
/**
 * @description
 * @author Bradley Grose, Ellie Barry, David Keen, David Morrison
 */

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {
    public static void DataUpdate() {
        saveUsers();
        saveCrimes();
        saveCriminal();
        saveEvidence();
        savePOI();
        saveWitness();
    }

    public static void saveUsers() {
        UserDatabase users = UserDatabase.getInstance();
        ArrayList<User> userList = users.getDatabase();
        JSONArray jsonUsers = new JSONArray();
        for (int i = 0; i < userList.size(); i++) {
            jsonUsers.add(getUserJSON(userList.get(i)));
        }

        try (FileWriter file = new FileWriter(USER_FILE_NAME)) {
            file.write(jsonUsers.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getUserJSON(User user) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(USER_UUID, user.getUUID());
        jsonObject.put(USER_USERNAME, user.getUsername());
        jsonObject.put(USER_PASSWORD, user.getPassword());
        jsonObject.put(USER_NAME, user.getName());
        jsonObject.put(USER_POSITION, user.getPosition());
        jsonObject.put(USER_ADMIN, user.getAdmin());

        return jsonObject;
    }

    /*
     * public static void saveUsers(ArrayList<User> Users) { JSONArray jsonUsers =
     * new JSONArray(); for(int i=0; i < Users.size(); i++) { User user =
     * Users.get(i); JSONObject jsonObject = new JSONObject();
     * jsonObject.put(USER_UUID, user.getUUID()); jsonObject.put(USER_USERNAME,
     * user.getUsername()); jsonObject.put(USER_PASSWORD, user.getPassword());
     * jsonObject.put(USER_NAME, user.getName()); jsonObject.put(USER_POSITION,
     * user.getPosition()); jsonObject.put(USER_ADMIN, user.getAdmin());
     * 
     * try { FileWriter file = new FileWriter("JSON\\User.JSON");
     * file.write(jsonObject.toJSONString()); file.close(); } catch(IOException e) {
     * e.printStackTrace(); }
     * 
     * } }
     */
    public static void saveCrimes() {

    }

    public static void saveCriminal() {

    }

    public static void saveEvidence() {

    }

    public static void savePOI() {

    }

    public static void saveWitness() {

    }

}
