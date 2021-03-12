
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

    public static void saveCrimes() {
        CrimeDatabase crimes = CrimeDatabase.getInstance();
        ArrayList<Crime> crimeList = crimes.getDatabase();
        JSONArray jsonCrimes = new JSONArray();
        for (int i = 0; i < crimeList.size(); i++) {
            jsonCrimes.add(getCrimeJSON(crimeList.get(i)));
        }

        try (FileWriter file = new FileWriter(CRIME_FILE_NAME)) {
            file.write(jsonCrimes.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getCrimeJSON(Crime crime) {
        JSONObject jsonObject = new JSONObject();
        //TODO Create Objects and call Criminals

        return jsonObject;
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
