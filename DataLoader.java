/**
 *  Loads in Data from JSON Files and Populates Obejcts
 * @author Bradley Grose, Ellie Barry, David Keen, David Morrison
 */
import java.io.FileReader;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

@SuppressWarnings("unchecked")

public class DataLoader extends DataConstants {

    /**
     * Creates an ArrayList of the Crimes to Set as Crime Database
     * @return Thje Full Array List
     */
    public static ArrayList<Crime> getCrimes() {
        ArrayList<Crime> crimes = new ArrayList<Crime>();
        ArrayList<Witness> grabWitt = getWitness();
        ArrayList<Evidence> grabEvidence = getEvidence();

        try {
            FileReader reader = new FileReader(USER_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray crimesJSON = (JSONArray) parser.parse(reader);

            for (int i = 0; i < crimesJSON.size(); i++) {
                JSONObject crimeJSON = (JSONObject) crimesJSON.get(i);
                ArrayList<Evidence> evidenceList = new ArrayList<Evidence>();
                JSONArray evidenceArray = (JSONArray) crimeJSON.get(CRIME_EVIDENCE_LIST);
                for (int j = 0; j < evidenceArray.size(); i++) {
                    String evidenceUUID = (String) evidenceArray.get(j);
                    for (int k = 0; k < grabEvidence.size(); k++) {
                        String UUIDEvi = grabEvidence.get(k).getUUID();
                        if (evidenceUUID.equals(UUIDEvi))
                            evidenceList.add(grabEvidence.get(k));
                    }
                }

                ArrayList<Witness> witness = new ArrayList<Witness>();
                JSONArray witnessArray = (JSONArray) crimeJSON.get(CRIME_WITNESSLIST);
                for (int j = 0; j < witnessArray.size(); i++) {
                    String witnessUUID = (String) witnessArray.get(j);
                    for (int k = 0; k < grabWitt.size(); k++) {
                        String UUIDWitt = grabWitt.get(k).getUUID();
                        if (witnessUUID.equals(UUIDWitt))
                            witness.add(grabWitt.get(k));
                    }
                }

                ArrayList<Suspects> personLists = new ArrayList<Suspects>();
                JSONArray personArray = (JSONArray) crimeJSON.get(CRIME_PERSONLIST);
                for (int j = 0; j < personArray.size(); i++) {
                    String personUUID = (String) personArray.get(j);
                    ArrayList<Suspects> suspects = PersonDatabase.getInstance().getDatabase();
                    for (int k = 0; k < suspects.size(); k++) {
                        if (personUUID.equals(suspects.get(k).getUUID()))
                            personArray.add(suspects.get(k));
                    }
                }

                String description = (String) crimeJSON.get(CRIME_DESCRIPTION);
                String name = (String) crimeJSON.get(CRIME_NAME);
                Boolean solved = (Boolean) crimeJSON.get(CRIME_SOLVED);
                int date = (int) crimeJSON.get(CRIME_DATE);
                String UUID = (String) crimeJSON.get(CRIME_UUID);

                Crime newCrime = new Crime(evidenceList, personLists, witness, description, name, solved, date, UUID);
                crimes.add(newCrime);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return crimes;
    }

    /**
     * Creates an Arraylist of the Users
     * @return Arraylist populated with users
     */
    public static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<User>();

        try {
            FileReader reader = new FileReader(USER_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray peopleJSON = (JSONArray) parser.parse(reader);

            for (int i = 0; i < peopleJSON.size(); i++) {
                JSONObject personJSON = (JSONObject) peopleJSON.get(i);
                String UUID = (String) personJSON.get(USER_UUID);
                String username = (String) personJSON.get(USER_USERNAME);
                String password = (String) personJSON.get(USER_PASSWORD);
                String name = (String) personJSON.get(USER_NAME);
                String position = (String) personJSON.get(USER_POSITION);
                Boolean admin = (Boolean) personJSON.get(USER_ADMIN);

                users.add(new User(username, password, name, position, admin, UUID));
            }

            return users;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Creates an Arraylist of all people for people database
     * @return an arraylist for people database populated
     */
    public static ArrayList<Suspects> getPerson() {
        ArrayList<Suspects> Persons = new ArrayList<Suspects>();

        try {
            FileReader reader = new FileReader(CRIMINAL_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray peopleJSON = (JSONArray) parser.parse(reader);

            for (int i = 0; i < peopleJSON.size(); i++) {
                JSONObject personJSON = (JSONObject) peopleJSON.get(i);
                String name = (String) personJSON.get(CRIMINAL_NAME);
                boolean livingStatus = (Boolean) personJSON.get(CRIMINAL_LIVING);
                String alias = (String) personJSON.get(CRIMINAL_ALIAS);
                String accomplice = (String) personJSON.get(CRIMINAL_ACCOMPLACE);
                String hairColor = (String) personJSON.get(CRIMINAL_HAIR);
                String eyeColor = (String) personJSON.get(CRIMINAL_EYE);
                String tatoo = (String) personJSON.get(CRIMINAL_TATTOO);
                String skinColor = (String) personJSON.get(CRIMINAL_SKIN);
                String nationality = (String) personJSON.get(CRIMINAL_NATIONALITY);
                double weight = (double) personJSON.get(CRIMINAL_WEIGHT);
                int height = (int) personJSON.get(CRIMINAL_HEIGHT);
                String acquaintance = (String) personJSON.get(CRIMINAL_ACQUANTANCES);
                int age = (int) personJSON.get(CRIMINAL_AGE);
                boolean glasses = (Boolean) personJSON.get(CRIMINAL_GLASSES);
                String punishment = (String) personJSON.get(CRIMINAL_PUNISHMENT);
                String disability = (String) personJSON.get(CRIMINAL_DISABILITY);
                String handness = (String) personJSON.get(CRIMINAL_HANDNESS);
                String crimeType = (String) personJSON.get(CRIMINAL_CRIME_TYPE);

                // Find Officers
                String UUIDofOfficers = (String) personJSON.get(USER_UUID);
                ArrayList<User> Users = UserDatabase.getInstance();
                User arrestingOfficer = null;
                for (int j = 0; i < Users.size(); j++) {
                    User user = Users.get(j);
                    if (user.getUUID() == UUIDofOfficers)
                        arrestingOfficer = user;
                }
                boolean inJail = (Boolean) personJSON.get(CRIMINAL_JAIL_STATUS);
                String UUID = (String) personJSON.get(CRIMINAL_UUID);

                Suspects suspect = new Suspects(name, livingStatus, alias, accomplice, hairColor, eyeColor, tatoo,
                        skinColor, nationality, weight, height, acquaintance, age, glasses, punishment, disability,
                        handness, crimeType, arrestingOfficer, inJail, UUID);
                Persons.add(suspect);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return Persons;
    }

    /**
     * Creates an arraylist of Evidence to be used to populate crimes
     * @return The arraylist of populated evidence
     */
    public static ArrayList<Evidence> getEvidence() {
        ArrayList<Evidence> evidence = new ArrayList<Evidence>();
        try {
            FileReader reader = new FileReader(EVIDENCE_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray evidenceJSON = (JSONArray) parser.parse(reader);

            for (int i = 0; i < evidenceJSON.size(); i++) {
                JSONObject evidenceJSONObject = (JSONObject) evidenceJSON.get(i);
                String name = (String) evidenceJSONObject.get(EVIDENCE_NAME);
                String description = (String) evidenceJSONObject.get(EVIDENCE_DESCRIPTION);
                String UUID = (String) evidenceJSONObject.get(EVIDENCE_UUID);

                Evidence item = new Evidence(name, description, UUID);
                evidence.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return evidence;
    }

    /**
     * Creates an arraylist of of Witnesses to be used to populate Crimes
     * @return arraylist populated with witnesses
     */
    public static ArrayList<Witness> getWitness() {
        ArrayList<Witness> witnessList = new ArrayList<Witness>();
        try {
            FileReader reader = new FileReader(EVIDENCE_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray witnessSON = (JSONArray) parser.parse(reader);

            for (int i = 0; i < witnessSON.size(); i++) {
                JSONObject witnesssJSONObject = (JSONObject) witnessSON.get(i);
                String name = (String) witnesssJSONObject.get(WITNESS_NAME);
                Boolean livingStatus = (Boolean) witnesssJSONObject.get(WITNESS_LIVING);
                String statement = (String) witnesssJSONObject.get(WITNESS_STATEMENT);
                String UUID = (String) witnesssJSONObject.get(WITNESS_UUID);

                Witness item = new Witness(name, livingStatus, statement, UUID);
                witnessList.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return witnessList;
    }

}
