
/**
 * @description
 * @author Bradley Grose, Ellie Barry, David Keen, David Morrison
 */


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@SuppressWarnings("unchecked")

public class DataWriter extends DataConstants {
    public static void DataUpdate() {
        saveUsers();
        saveCrimes();
    }

    /**
     * 
     */
    public static void saveUsers() {
        ArrayList<User> userList = UserDatabase.getInstance();
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

    /**
     * 
     * @param user
     * @return
     */
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

    /**
     * 
     */
    public static void saveCrimes() {
        CrimeDatabase crimes = CrimeDatabase.getInstance();
        ArrayList<Crime> crimeList = crimes.getDatabase();
        JSONArray jsonCrimes = new JSONArray();

        // Create Sub JSON
        JSONArray jsonPOI = new JSONArray();
        JSONArray jsonWitness = new JSONArray();
        JSONArray jsonCriminal = new JSONArray();
        JSONArray jsonEvidence = new JSONArray();

        for (int i = 0; i < crimeList.size(); i++) {
            jsonCrimes.add(getCrimeJSON(crimeList.get(i), jsonPOI, jsonCriminal, jsonEvidence, jsonWitness));
        }

        try (FileWriter file = new FileWriter(CRIME_FILE_NAME, false)) {
            file.write(jsonCrimes.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter file = new FileWriter(WITNESS_FILE_NAME, false)) {
            file.write(jsonWitness.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter file = new FileWriter(POI_FILE_NAME, false)) {
            file.write(jsonPOI.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter file = new FileWriter(CRIMINAL_FILE_NAME, false)) {
            file.write(jsonCriminal.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter file = new FileWriter(EVIDENCE_FILE_NAME, false)) {
            file.write(jsonEvidence.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 
     * @param crime
     * @return
     */
    public static JSONObject getCrimeJSON(Crime crime, JSONArray POI, JSONArray Criminal, JSONArray Evidence,
            JSONArray Witness) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(CRIME_DATE, crime.getDate());
        jsonObject.put(CRIME_DESCRIPTION, crime.getDescription());
        jsonObject.put(CRIME_EVIDENCE_LIST, saveEvidence(crime, Evidence));
        jsonObject.put(CRIME_NAME, crime.getName());
        jsonObject.put(CRIME_OFFICERLIST, saveOfficers(crime));
        jsonObject.put(CRIME_PERSONLIST, savePersons(crime, POI, Criminal, Witness));
        jsonObject.put(CRIME_SOLVED, crime.getSolved());
        jsonObject.put(CRIME_UUID, crime.getUUID());

        return jsonObject;
    }

    /**
     * 
     * @param crime
     * @return
     */
    public static JSONArray saveEvidence(Crime crime, JSONArray Evidence) {
        JSONArray jsonUUIDEvidence = new JSONArray();
        ArrayList<Evidence> evidenceList = crime.getEvidenceList();
        for (int i = 0; i < evidenceList.size(); i++) {
            Evidence evidence = evidenceList.get(i);
            jsonUUIDEvidence.add(evidence.getUUID());

            //Make Evidence JSON
            JSONObject jsonObject = new JSONObject();
            jsonObject.put(EVIDENCE_NAME, evidence.getName());
            jsonObject.put(EVIDENCE_UUID, evidence.getUUID());
            jsonObject.put(EVIDENCE_DESCRIPTION, evidence.getDescription());
            Evidence.add(jsonObject);
        }

        return jsonUUIDEvidence;
    }

    public static JSONArray savePersons(Crime crime, JSONArray POI, JSONArray Criminal, JSONArray Witness) {
        JSONArray jsonUUIDPerson = new JSONArray();
        ArrayList<Person> persons = crime.getAnyonePersonList();
        for (int i = 0; i < persons.size(); i++) {
            Person person = persons.get(i);
            jsonUUIDPerson.add(person.getUUID());
            if (person.isCriminal())
                saveCriminal(crime, Criminal);
            else if (person.isPOI())
                savePOI(crime, POI);
            else if (person.isWitness())
                saveWitness(crime, Witness);
        }
        return jsonUUIDPerson;
    }

    /**
     * 
     * @param crime
     * @param POIArray
     */
    public static void savePOI(Crime crime, JSONArray POIArray) {
    }

    /**
     * 
     * @param crime
     * @param WitnessArray
     */
    public static void saveWitness(Crime crime, JSONArray WitnessArray) {

    }

    /**
     * 
     * @param crime
     * @param CriminalArray
     */
    public static void saveCriminal(Crime crime, JSONArray CriminalArray) {

    }

    /**
     * 
     * @param crime
     * @return
     */
    public static JSONArray saveOfficers(Crime crime) {
        JSONArray jsonUUIDOfficer = new JSONArray();
        ArrayList<User> officers = crime.getOfficers();
        for (int i = 0; i < officers.size(); i++) {
            User officer = officers.get(i);
            jsonUUIDOfficer.add(officer.getUUID());
        }
        return jsonUUIDOfficer;
    }

}
