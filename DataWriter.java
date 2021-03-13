
/**
 * @description
 * @author Bradley Grose, Ellie Barry, David Keen, David Morrison
 */

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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

        try (FileWriter file = new FileWriter(USER_FILE_NAME, false)) {
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

        try (FileWriter file = new FileWriter(CRIME_FILE_NAME, false)) {
            file.write(jsonCrimes.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getCrimeJSON(Crime crime) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(CRIME_DATE, crime.getDate());
        jsonObject.put(CRIME_DESCRIPTION, crime.getDescription());
        
        //Evidence List
        JSONArray jsonUUIDEvidence = new JSONArray();
        ArrayList<Evidence> evidenceList = crime.getEvidenceList();
        for(int i=0; i<evidenceList.size(); i++)
        {
            Evidence evidence = evidenceList.get(i);
            jsonUUIDEvidence.add(evidence.getUUID());
        }
        jsonObject.put(CRIME_EVIDENCE_LIST, jsonUUIDEvidence);

        jsonObject.put(CRIME_NAME, crime.getName());

        //Officer List
        JSONArray jsonUUIDOfficer = new JSONArray();
        ArrayList<User> officers = crime.getOfficers();
        for(int i=0; i<officers.size(); i++)
        {
            User officer = officers.get(i);
            jsonUUIDEvidence.add(officer.getUUID());
        }
        jsonObject.put(CRIME_OFFICERLIST, jsonUUIDOfficer);

          //Person List
          JSONArray jsonUUIDPerson = new JSONArray();
          ArrayList<Person> persons = crime.getAnyonePersonList();
          for(int i=0; i<persons.size(); i++)
          {
              Person person  = persons.get(i);
              jsonUUIDEvidence.add(person.getUUID());
          }
          jsonObject.put(CRIME_PERSONLIST, jsonUUIDPerson);
          jsonObject.put(CRIME_SOLVED, crime.getSolved());
          jsonObject.put(CRIME_UUID, crime.getUUID());
        
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
