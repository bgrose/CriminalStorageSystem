/**
 * @description Class that creates the crimeFacade for the criminal UI to call
 * @author Bradley Grose, Eleanor Barry, David Keen, David Morrison
 */

import java.util.ArrayList;
import java.util.UUID;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class CrimeFacade {

    private CrimeDatabase crimeDatabase;
    private UserDatabase userDatabase;
    private PersonDatabase personDatabase;
    private User currentUser;

    

    /**
     * Constructor method that sets up the CrimeFacade
     */
    public CrimeFacade() {
        crimeDatabase = CrimeDatabase.getInstance();
        userDatabase = UserDatabase.getInstance();
        personDatabase = PersonDatabase.getInstance();
    }

    /**
     * Method that creates a new account
     * @param username Username of User
     * @param password Password for User
     * @param name     Name of the Officer/User
     * @param position String of the officer position
     * @param isAdmin  Boolean if they are an admin
     */
    public void createAccount(String username, String password, String name, String position, boolean isAdmin) {
        userDatabase.addUser(new User(username, password, name, position, isAdmin));
    }

    /**
     * Method that checks if the user can login
     * @param username
     * @return boolean for if the user can login
     */
    public boolean login(String username, String password) {
        if (userDatabase.getUser(username, password) == null) {
            return false;
        }
        currentUser = userDatabase.getUser(username, password);
        return true;
    }

    /**
     * Method that returns the current user
     * @return User the current user
     */
    public User getCurrentUser() {
        return currentUser;
    }

    /**
     * Method that adds a crime to the crimeDatabase
     * @param crime to be added to the crimeDatabase
     */
    public void addCrime(Crime crime) {
        crimeDatabase.addCrime(crime);
    }

    /**
     * Method that returns if the crime is in the crimeDatabase
     * @param crime to be searched for
     * @return boolean that represents if the crime is in the database
     */
    public boolean searchCrime(String caseID) {
        for (int i = 0; i < crimeDatabase.getDatabase().size(); i++) {
            if (crimeDatabase.getDatabase().get(i).getcaseID().equalsIgnoreCase(caseID)) {
                return true;
            }
        }
        return false;

    }

    /**
     * Method that prints the crimes in the crimeDatabase
     */
    public void printCrimes(String answer) {
        crimeDatabase.printDatabase(answer);
    }

    /**
     * Prints the Results to a the terminal
     * @param res list of suspects
     */
    public void printResTerminal(ArrayList<Suspects> res) {
        for (Suspects suspect : res) {
            System.out.println(suspect.toString());
        }
    }

    /**
     * Prints the Results to a file
     * @param res list of suspects
     */
    public void printResFile(ArrayList<Suspects> res) {
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd_HH.mm.ss");
            LocalDateTime now = LocalDateTime.now();
            String timeString = dtf.format(now);
            String fileName = "TextFiles/Result" + timeString + ".txt";
            File myObj = new File(fileName);
            if (myObj.createNewFile()) {
                FileWriter fileWriter = new FileWriter(fileName);
                PrintWriter printWriter = new PrintWriter(fileWriter);
                for (Suspects suspect : res) {
                    printWriter.println(suspect.toString());
                }
                printWriter.close();
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Method that allows you to searh for a criminal by trait
     * @param command Int of the trait they want to search for
     * @param term String of the trait they want to search for
     * @return ArrayList<Sispects> of the criminals with the trait searched
     */
    public ArrayList<Suspects> searchCriminal(int command,  String term) {
        ArrayList<Suspects> ret = new ArrayList<Suspects>();
        switch (command) {
        case (1):
            for (Suspects suspect : personDatabase.personList) {
                if (suspect.getName().equals(term))
                    ret.add(suspect);
            }
            break;
        case (2):
            for (Suspects suspect : personDatabase.personList) {
                boolean termB = Boolean.parseBoolean(term);
                if (suspect.getLivingStatus() == termB)
                    ret.add(suspect);
            }
            break;
        case (3):
            for (Suspects suspect : personDatabase.personList) {
                UUID termU = UUID.fromString(term);
                if (suspect.getUUID() == termU)
                    ret.add(suspect);
            }
            break;
        case (4):
            for (Suspects suspect : personDatabase.personList) {
                if (suspect.getGender().equals(term))
                    ret.add(suspect);
            }
            break;
        case (5):
            for (Suspects suspect : personDatabase.personList) {
                if (suspect.getAddress().equals(term))
                    ret.add(suspect);
            }
            break;
        case (6):
            for (Suspects suspect : personDatabase.personList) {
                if (suspect.getPhone().equals(term))
                    ret.add(suspect);
            }
            break;
        case (7):
            for (Suspects suspect : personDatabase.personList) {
                if (suspect.getAlias().contains(term))
                    ret.add(suspect);
            }
            break;
        case (8):
            for (Suspects suspect : personDatabase.personList) {
                if (suspect.getAccomplice().contains(term))
                    ret.add(suspect);
            }
            break;
        case (9):
            for (Suspects suspect : personDatabase.personList) {
                if (suspect.getHairColor().contains(term))
                    ret.add(suspect);
            }
            break;
        case (10):
            for (Suspects suspect : personDatabase.personList) {
                if (suspect.getEyeColor().contains(term))
                    ret.add(suspect);
            }
            break;
        case (11):
            for (Suspects suspect : personDatabase.personList) {
                if (suspect.getTattoo().contains(term))
                    ret.add(suspect);
            }
            break;
        case (12):
            for (Suspects suspect : personDatabase.personList) {
                if (suspect.getSkinColor().contains(term))
                    ret.add(suspect);
            }
            break;
        case (13):
            for (Suspects suspect : personDatabase.personList) {
                if (suspect.getNationality().contains(term))
                    ret.add(suspect);
            }
            break;
        case (14):
            for (Suspects suspect : personDatabase.personList) {
                if (suspect.getWeight() == (Double.parseDouble(term)))
                    ret.add(suspect);
            }
            break;
        case (15):
            for (Suspects suspect : personDatabase.personList) {
                if (suspect.getHeight() == (Integer.parseInt(term)))
                    ret.add(suspect);
            }
            break;
        case (16):
            for (Suspects suspect : personDatabase.personList) {
                if (suspect.getAccomplice().contains(term))
                    ret.add(suspect);
            }
            break;
        case (17):
            for (Suspects suspect : personDatabase.personList) {
                if (suspect.getAge() == (Integer.parseInt(term)))
                    ret.add(suspect);
            }
            break;
        case (18):
            for (Suspects suspect : personDatabase.personList) {
                boolean termB = Boolean.parseBoolean(term);
                if (suspect.getGlasses() == termB)
                    ret.add(suspect);
            }
            break;
        case (19):
            for (Suspects suspect : personDatabase.personList) {
                if (suspect.getPunishment().contains(term))
                    ret.add(suspect);
            }
            break;
        case (20):
            for (Suspects suspect : personDatabase.personList) {
                if (suspect.getDisability().contains(term))
                    ret.add(suspect);
            }
            break;
        case (21):
            for (Suspects suspect : personDatabase.personList) {
                boolean termB = Boolean.parseBoolean(term);
                if (suspect.getInJail() == termB)
                    ret.add(suspect);
            }
            break;
        case (22):
            for (Suspects suspect : personDatabase.personList) {
                if (suspect.getAddress().contains(term))
                    ret.add(suspect);
            }
            break;
        }
        return ret;

    }

    /**
     * Method that prints the criminals in the personDatabase
     */
    public void printCriminal(String answer) {
        personDatabase.printDatabase(answer);
    }

    /**
     * Method that removes a crime from the database
     * @param caseID String that is used to represent the crime
     * @return Boolean of if the crime was removed sucessfully
     */
    public boolean removeCrime(String caseID) {
        ArrayList<Crime> crimes = crimeDatabase.getDatabase();
        for (int i = 0; i < crimes.size(); i++) {
            if (crimes.get(i).getcaseID().equals(caseID)) {
                crimeDatabase.removeCrime(crimes.get(i));
                return true;
            }
        }
        return false;
    }

    /**
     * Method that adds a user to the userDatabase
     * @param user User to be added to the database
     */
    public void addUser(User user) {
        userDatabase.addUser(user);
    }

    /**
     * Method that removes a user from the userDatabase
     * @param username of the user being removed
     * @return Boolean of if the user was removed sucessfully
     */
    public boolean removeUser(String username) {
        ArrayList<User> users = userDatabase.getDatabase();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(username)) {
                userDatabase.removeUser(users.get(i));
                return true;
            }
        }
        return false;
    }

    /**
     * Method that logs out the current user
     */
    public void logout() {
        DataWriter.DataUpdate();
    }

    /**
     * Method that finds an officer in the userDatabase
     * 
     * @param name of the user being searched for
     * @return User that was being searched for
     */
    public User findOfficer(String name) {
        for (int i = 0; i < userDatabase.getDatabase().size(); i++) {
            if (userDatabase.getDatabase().get(i).getName().equals(name))
                return userDatabase.getDatabase().get(i);
        }
        return null;
    }

    /**
     * Method that adds a suspect to the database
     * @param suspect Suspect to add
     */
    public void addSuspect(Suspects suspect) {
        personDatabase.addPerson(suspect);
    }

    /**
     * Method that prints the Crime to a File
     * @param name String of Crime Case ID
     */
    public void printCrimeFound(String name) {
        for (int i = 0; i < crimeDatabase.getDatabase().size(); i++) {
            if (crimeDatabase.getDatabase().get(i).getcaseID().equalsIgnoreCase(name)) {
                Crime crime = crimeDatabase.getDatabase().get(i);
                crime.crimeToFile();
            }
        }
    }

    /**
     * Method that prints out the Crime to Terminal
     * @param name Name of the Crime String
     */
    public void printCrimeTerminal(String name) {
        for (int i = 0; i < crimeDatabase.getDatabase().size(); i++) {
            if (crimeDatabase.getDatabase().get(i).getcaseID().equalsIgnoreCase(name)) {
                Crime crime = crimeDatabase.getDatabase().get(i);
                System.out.println(crime.toString());
            }
        }
    }
}
