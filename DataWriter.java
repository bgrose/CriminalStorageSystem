
/**
 * @description Class that writes to JSON FIle for Object Storage
 * @author Bradley Grose, Eleanor Barry, David Keen, David Morrison
 */

import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.*;

@SuppressWarnings("unchecked")

public class DataWriter extends DataConstants {

    /**
     * Method that updates all JSON Data Stores
     */
    public static void DataUpdate() {
        saveUsers();
        savePersons();
        saveCrimes();
    }

    /**
     * Method that goes through all the users and saves them to a JSON FIle
     */
    public static void saveUsers() {
        ArrayList<User> userList = UserDatabase.getInstance().getDatabase();
        JSONArray jsonUsers = new JSONArray();
        for (int i = 0; i < userList.size(); i++) {
            jsonUsers.add(getUserJSON(userList.get(i)));
        }

        try (FileWriter file = new FileWriter(USER_FILE_NAME, false)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonParser jp = new JsonParser();
            JsonElement je = jp.parse(jsonUsers.toJSONString());
            String prettyJsonString = gson.toJson(je);
            file.write(prettyJsonString);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method that creates the JSON Object for a User
     * @param user User being converted
     * @return JSON Object of User
     */
    public static JSONObject getUserJSON(User user) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(USER_UUID, user.getUUID().toString());
        jsonObject.put(USER_USERNAME, user.getUsername());
        jsonObject.put(USER_PASSWORD, user.getPassword());
        jsonObject.put(USER_NAME, user.getName());
        jsonObject.put(USER_POSITION, user.getPosition());
        jsonObject.put(USER_ADMIN, user.getAdmin());

        return jsonObject;
    }

    /**
     * Method that writes to the file for the crimes and calls the different sub class to make
     * objects
     */
    public static void saveCrimes() {
        CrimeDatabase crimes = CrimeDatabase.getInstance();
        ArrayList<Crime> crimeList = crimes.getDatabase();
        JSONArray jsonCrimes = new JSONArray();

        // Create Sub JSON
        JSONArray jsonWitness = new JSONArray();
        JSONArray jsonEvidence = new JSONArray();

        for (int i = 0; i < crimeList.size(); i++) {
            jsonCrimes.add(getCrimeJSON(crimeList.get(i), jsonEvidence, jsonWitness));
        }

        try (FileWriter file = new FileWriter(CRIME_FILE_NAME, false)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonParser jp = new JsonParser();
            JsonElement je = jp.parse(jsonCrimes.toJSONString());
            String prettyJsonString = gson.toJson(je);
            file.write(prettyJsonString);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter file = new FileWriter(WITNESS_FILE_NAME, false)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonParser jp = new JsonParser();
            JsonElement je = jp.parse(jsonWitness.toJSONString());
            String prettyJsonString = gson.toJson(je);
            file.write(prettyJsonString);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileWriter file = new FileWriter(EVIDENCE_FILE_NAME, false)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonParser jp = new JsonParser();
            JsonElement je = jp.parse(jsonEvidence.toJSONString());
            String prettyJsonString = gson.toJson(je);
            file.write(prettyJsonString);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method that creates a JSON File for the Crimes
     * @param crime Crime that is being turned into a JSON FIle
     * @return JSON Object for the crime
     */
    public static JSONObject getCrimeJSON(Crime crime, JSONArray Evidence, JSONArray Witness) {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put(CRIME_DATE, crime.getDate());
        jsonObject.put(CRIME_DESCRIPTION, crime.getDescription());
        jsonObject.put(CRIME_EVIDENCE_LIST, saveEvidence(crime, Evidence));
        jsonObject.put(CRIME_NAME, crime.getcaseID());
        jsonObject.put(CRIME_PERSONLIST, saveSuspect(crime));
        jsonObject.put(CRIME_WITNESSLIST, saveWitness(crime, Witness));
        jsonObject.put(CRIME_SOLVED, crime.getSolved());
        jsonObject.put(CRIME_UUID, crime.getUUID().toString());

        return jsonObject;
    }

    /**
     * Method that saves all evidence items for the crime as well as write to JSON file for
     * evidence
     * @param crime Crime evidence is being pulled from
     * @return JSONArray with the evidence in it for the crime with UUID
     */
    public static JSONArray saveEvidence(Crime crime, JSONArray Evidence) {
        JSONArray jsonUUIDEvidence = new JSONArray();
        ArrayList<Evidence> evidenceList = crime.getEvidenceList();
        if (evidenceList != null) {
            for (int i = 0; i < evidenceList.size(); i++) {
                Evidence evidence = evidenceList.get(i);
                jsonUUIDEvidence.add(evidence.getUUID().toString());

                // Make Evidence JSON
                JSONObject jsonObject = new JSONObject();
                jsonObject.put(EVIDENCE_NAME, evidence.getName());
                jsonObject.put(EVIDENCE_UUID, evidence.getUUID().toString());
                jsonObject.put(EVIDENCE_DESCRIPTION, evidence.getDescription());
                Evidence.add(jsonObject);
            }
        }

        return jsonUUIDEvidence;
    }

    /**
     * Method that saves the Suspect to a JSON File for Crime by looping ang getting UUID
     * @param crime Takes in crime to loop through
     * @return JSONArray with Suspect UUID
     */
    public static JSONArray saveSuspect(Crime crime) {
        JSONArray jsonUUIDSuspect = new JSONArray();
        ArrayList<Suspects> suspects = crime.getPersonList();
        if (suspects != null) {
            for (int i = 0; i < suspects.size(); i++) {
                Suspects suspect = suspects.get(i);
                jsonUUIDSuspect.add(suspect.getUUID().toString());
            }
        }
        return jsonUUIDSuspect;
    }

    /**
     * Method that saves the Suspect to a JSON File for Crime by looping ang getting UUID
     * @param crime Takes in crime to loop through
     * @return JSONArray with Suspect UUID
     */
    public static JSONArray saveWitness(Crime crime, JSONArray Witness) {
        JSONArray jsonUUIDWitness = new JSONArray();
        ArrayList<Witness> witnesses = crime.getWitnessList();
        if (witnesses != null) {
            for (int i = 0; i < witnesses.size(); i++) {
                Witness witness = witnesses.get(i);
                jsonUUIDWitness.add(witness.getUUID().toString());
                JSONObject jsonObject = new JSONObject();
                jsonObject.put(WITNESS_UUID, witness.getUUID().toString());
                jsonObject.put(WITNESS_NAME, witness.getName());
                jsonObject.put(WITNESS_LIVING, witness.getLivingStatus());
                jsonObject.put(WITNESS_STATEMENT, witness.getStatement());
                Witness.add(jsonObject);
            }
        }
        return jsonUUIDWitness;
    }

    /**
     * Method that saves all of the Suspects to JSON
     */
    public static void savePersons() {
        PersonDatabase suspects = PersonDatabase.getInstance();
        ArrayList<Suspects> suspectList = suspects.getDatabase();
        JSONArray jsonSuspects = new JSONArray();
        if (suspectList != null) {
            for (int i = 0; i < suspectList.size(); i++) {
                jsonSuspects.add(getSuspectJSON(suspectList.get(i)));
            }

            try (FileWriter file = new FileWriter(CRIMINAL_FILE_NAME, false)) {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                JsonParser jp = new JsonParser();
                JsonElement je = jp.parse(jsonSuspects.toJSONString());
                String prettyJsonString = gson.toJson(je);
                file.write(prettyJsonString);
                file.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Method that creates a JSON Object for a suspect
     * @param suspects To make object
     * @return Object of the suspect
     */
    public static JSONObject getSuspectJSON(Suspects suspects) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(CRIMINAL_ACCOMPLACE, suspects.getAccomplice());
        jsonObject.put(CRIMINAL_ACQUANTANCES, suspects.getAccquaintance());
        jsonObject.put(CRIMINAL_AGE, suspects.getAge());
        jsonObject.put(CRIMINAL_ALIAS, suspects.getAlias());
        jsonObject.put(CRIMINAL_CRIME_TYPE, suspects.getCrimeType());
        jsonObject.put(CRIMINAL_DISABILITY, suspects.getDisability());
        jsonObject.put(CRIMINAL_EYE, suspects.getEyeColor());
        jsonObject.put(CRIMINAL_GLASSES, suspects.getGlasses());
        jsonObject.put(CRIMINAL_HAIR, suspects.getHairColor());
        jsonObject.put(CRIMINAL_HANDNESS, suspects.getHandness());
        jsonObject.put(CRIMINAL_HEIGHT, suspects.getHeight());
        jsonObject.put(CRIMINAL_JAIL_STATUS, suspects.getInJail());
        jsonObject.put(CRIMINAL_LIVING, suspects.getLivingStatus());
        jsonObject.put(CRIMINAL_NAME, suspects.getName());
        jsonObject.put(CRIMINAL_NATIONALITY, suspects.getNationality());
        jsonObject.put(CRIMINAL_PUNISHMENT, suspects.getPunishment());
        jsonObject.put(CRIMINAL_SKIN, suspects.getSkinColor());
        jsonObject.put(CRIMINAL_TATTOO, suspects.getTattoo());
        jsonObject.put(CRIMINAL_UUID, suspects.getUUID().toString());
        jsonObject.put(CRIMINAL_WEIGHT, suspects.getWeight());

        return jsonObject;
    }

}
