
/**
 * @description Class that loads in Data from JSON Files and Populates Obejcts
 * @author Bradley Grose, Eleanor Barry, David Keen, David Morrison
 */
import java.io.FileReader;

import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

@SuppressWarnings("unchecked")

public class DataLoader extends DataConstants {

    /**
     * Method that creates an ArrayList of the Crimes to Set as Crime Database
     * @return The Full Array List
     */
    public static ArrayList<Crime> getCrimes() {
        ArrayList<Crime> crimes = new ArrayList<Crime>();
        ArrayList<Witness> grabWitt = getWitness();
        ArrayList<Evidence> grabEvidence = getEvidence();
        ArrayList<Suspects> grabSuspects = getPerson();

        try {
            FileReader reader = new FileReader(CRIME_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray crimesJSON = (JSONArray) parser.parse(reader);

            for (int i = 0; i < crimesJSON.size(); i++) {
                JSONObject crimeJSON = (JSONObject) crimesJSON.get(i);
                ArrayList<Evidence> evidenceList = new ArrayList<Evidence>();
                JSONArray evidenceArray = (JSONArray) crimeJSON.get(CRIME_EVIDENCE_LIST);
                if (evidenceArray != null) {
                    for (int j = 0; j < evidenceArray.size(); j++) {
                        UUID evidenceUUID = UUID.fromString((String) evidenceArray.get(j));
                        for (int k = 0; k < grabEvidence.size(); k++) {
                            UUID UUIDEvi = grabEvidence.get(k).getUUID();
                            if (evidenceUUID.equals(UUIDEvi)) {
                                evidenceList.add(grabEvidence.get(k));
                            }
                        }
                    }
                }


               
                ArrayList<Witness> witness = new ArrayList<Witness>();
                JSONArray witnessArray = (JSONArray) crimeJSON.get(CRIME_WITNESSLIST);
                if (witnessArray != null) {
                    for (int j = 0; j < witnessArray.size(); j++) {
                        UUID witnessUUID = UUID.fromString((String) witnessArray.get(j));
                        for (int k = 0; k < grabWitt.size(); k++) {
                            UUID UUIDWitt = grabWitt.get(k).getUUID();
                            if (witnessUUID.equals(UUIDWitt)) {
                                witness.add(grabWitt.get(k));
                            }
                        }
                    }
                }

                ArrayList<Suspects> personLists = new ArrayList<Suspects>();
                JSONArray personArray = (JSONArray) crimeJSON.get(CRIME_PERSONLIST);
                if (personArray != null) {
                    for (int j = 0; j < personArray.size(); j++) {
                        UUID personUUID = UUID.fromString((String) personArray.get(j));
                        for (int k = 0; k < grabSuspects.size(); k++) {
                            UUID UUIDSus= grabSuspects.get(k).getUUID();
                            if (personUUID.equals(UUIDSus)) {
                                personLists.add(grabSuspects.get(k));
                            }
                        }
                    }
                }

                String description = (String) crimeJSON.get(CRIME_DESCRIPTION);
                String name = (String) crimeJSON.get(CRIME_NAME);
                Boolean solved = (Boolean) crimeJSON.get(CRIME_SOLVED);
                String date = (String) crimeJSON.get(CRIME_DATE);
                UUID uuid = UUID.fromString((String) crimeJSON.get(CRIME_UUID));

                Crime newCrime = new Crime(evidenceList, personLists, witness, description, name, solved, date, uuid);
                crimes.add(newCrime);
            }
            return crimes;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    /**
     * Method that creates an Arraylist of the Users
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
                UUID uuid = UUID.fromString((String) personJSON.get(USER_UUID));
                String username = (String) personJSON.get(USER_USERNAME);
                String password = (String) personJSON.get(USER_PASSWORD);
                String name = (String) personJSON.get(USER_NAME);
                String position = (String) personJSON.get(USER_POSITION);
                Boolean admin = (Boolean) personJSON.get(USER_ADMIN);

                users.add(new User(username, password, name, position, admin, uuid));
            }

            return users;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Method that creates an Arraylist of all people for people database
     * @return ArrayList for people database populated
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
                int height = ((Long) personJSON.get(CRIMINAL_HEIGHT)).intValue();
                String acquaintance = (String) personJSON.get(CRIMINAL_ACQUANTANCES);
                int age = ((Long) personJSON.get(CRIMINAL_AGE)).intValue();
                boolean glasses = (Boolean) personJSON.get(CRIMINAL_GLASSES);
                String punishment = (String) personJSON.get(CRIMINAL_PUNISHMENT);
                String disability = (String) personJSON.get(CRIMINAL_DISABILITY);
                String handness = (String) personJSON.get(CRIMINAL_HANDNESS);
                String crimeType = (String) personJSON.get(CRIMINAL_CRIME_TYPE);
                String gender = (String) personJSON.get(CRIMINAL_GENDER);

                boolean inJail = (Boolean) personJSON.get(CRIMINAL_JAIL_STATUS);
                UUID uuid = UUID.fromString((String) personJSON.get(CRIMINAL_UUID));

                Persons.add(new Suspects(name, livingStatus, alias, accomplice, hairColor, eyeColor, tatoo, skinColor,
                        nationality, weight, height, acquaintance, age, glasses, punishment, disability, handness,
                        crimeType, inJail, uuid, gender));
            }
            return Persons;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Method that creates an arraylist of Evidence to be used to populate crimes
     * @return ArrayList of populated evidence
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
                UUID uuid = UUID.fromString((String) evidenceJSONObject.get(EVIDENCE_UUID));

                evidence.add(new Evidence(name, description, uuid));
            }

            return evidence;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Method that creates an arraylist of of Witnesses to be used to populate Crimes
     * @return arraylist populated with witnesses
     */
    public static ArrayList<Witness> getWitness() {
        ArrayList<Witness> witnessList = new ArrayList<Witness>();
        try {
            FileReader reader = new FileReader(WITNESS_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray witnessSON = (JSONArray) parser.parse(reader);

            for (int i = 0; i < witnessSON.size(); i++) {
                JSONObject witnesssJSONObject = (JSONObject) witnessSON.get(i);
                String name = (String) witnesssJSONObject.get(WITNESS_NAME);
                boolean livingStatus =((boolean) witnesssJSONObject.get(WITNESS_LIVING));
                String statement = (String) witnesssJSONObject.get(WITNESS_STATEMENT);
                UUID uuid = UUID.fromString((String) witnesssJSONObject.get(WITNESS_UUID));
                String gender = (String) witnesssJSONObject.get(WITNESS_GENDER);

                witnessList.add(new Witness(name, livingStatus, statement, uuid, gender));
            }
            return witnessList;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
