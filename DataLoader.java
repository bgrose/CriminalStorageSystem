import java.io.FileReader;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * @description
 * @author Bradley Grose, Ellie Barry, David Keen, David Morrison
 */
public class DataLoader extends DataConstants {

    public static ArrayList<Crime> getCrimes() {
        ArrayList<Crime> crimes = new ArrayList<Crime>();

        try {
            FileReader reader = new FileReader(USER_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray crimesJSON = (JSONArray) parser.parse(reader);

            for (int i = 0; i < crimesJSON.size(); i++) {
                JSONObject crimeJSON = (JSONObject) crimesJSON.get(i);

                //TODO
                ArrayList<Evidence> evidenceList = null;
                ArrayList<Suspects> personLists = null;
                ArrayList<Witness> witness = null;

                String description = (String) crimeJSON.get(CRIME_DESCRIPTION);
                String name = (String) crimeJSON.get(CRIME_NAME);
                Boolean solved = (Boolean) crimeJSON.get(CRIME_SOLVED);
                int date = (int) crimeJSON.get(CRIME_DATE);
                String UUID = (String) crimeJSON.get(CRIME_UUID);

                Crime newCrime = new Crime(evidenceList, personLists, witness, description, name, solved, date, UUID);
                crimes.add(newCrime);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return crimes;
    }

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
                
                //Find Officers
                String UUIDofOfficers = (String) personJSON.get(USER_UUID);
                ArrayList<User> Users = UserDatabase.getInstance();
                User arrestingOfficer = null;
                for(int j=0; i<Users.size(); j++)
                {
                    User user = Users.get(j);
                    if(user.getUUID() == UUIDofOfficers) 
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

}
