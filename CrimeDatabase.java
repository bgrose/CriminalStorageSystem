/**
 * Class that creates a database to store crimes
 * @author Bradley Grose, Eleanor Barry, David Keen, David Morrison
 */
import java.util.ArrayList;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class CrimeDatabase {

    private static CrimeDatabase crimeDatabase;
    private static ArrayList<Crime> crimeList;

    /**
     * Method that returns a Crime from crimeDatabase
     * @return Crime from CrimeDatabase
     */
    public Crime getCrime(String caseNumber) {
        for (int i = 0; i < crimeList.size(); i++) {
            if (crimeList.get(i).getcaseID().equals(caseNumber))
                return crimeList.get(i);
        }
        return null;
    }

    /**
     * Method that adds a crime to the databaase
     * @param crime crime to be added
     */
    public void addCrime(Crime crime) {
        crimeList.add(crime);
        DataWriter.DataUpdate();

    }

    /**
     * Method that removes a crime from the database
     * @param crime crime to be removed
     */
    public void removeCrime(Crime crime) {
        crimeList.remove(crime);
        DataWriter.DataUpdate();
    }

    /**
     * Method that prints out the crimeDatabase
     * @param answer String with whether the database sohould be printed
     */
    public void printDatabase(String answer) {
        for (Crime crime : crimeList) {
            System.out.println(crime.toString());
        }
        if (answer.equalsIgnoreCase("yes")) {
            try {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd_HH.mm.ss");
                LocalDateTime now = LocalDateTime.now();
                String timeString = dtf.format(now);
                String fileName = "TextFiles/CrimeDatabase" + timeString + ".txt";
                File myObj = new File(fileName);
                if (myObj.createNewFile()) {
                    FileWriter fileWriter = new FileWriter(fileName);
                    PrintWriter printWriter = new PrintWriter(fileWriter);
                    for (Crime crime : crimeList) {
                        printWriter.println(crime.toString());
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
    }

    /**
     * Method that gets the crimeDatabase
     * @return CrimeDatabase
     */
    public static CrimeDatabase getInstance() {
        if (crimeDatabase == null)
            crimeDatabase = new CrimeDatabase();
        return crimeDatabase;
    }

    /**
     * Constructor method that sets up the CrimeDatabase, only if there hasn't been
     * one created already
     */
    private CrimeDatabase() {
        crimeList = DataLoader.getCrimes();
    }

    /**
     * Method that returns the CrimeDatabase
     * @returnArrayList<Crime> that contains all the crimes
     */
    public ArrayList<Crime> getDatabase() {
        return crimeList;
    }

}
