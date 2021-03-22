/**
 * @description Class that creates a database to store Person objects (Criminals, POIs)
 * @author Bradley Grose, Eleanor Barry, David Keen, David Morrison
 */
import java.util.ArrayList;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;

public class PersonDatabase {

    private static PersonDatabase personDatabase;
    ArrayList<Suspects> personList;

    /**
     * Method that returns a Person from person Database
     * @return Crime from CrimeDatabase
     */
    public Crime getPerson() {
        return null;
    }

    /**
     * Method that adds a person to database and calls for JSON update
     * @param person Person to add
     */
    public void addPerson(Suspects person) {
        personList.add(person);
        DataWriter.DataUpdate();
    }

    /**
     * Method that removes user from database and updates JSON
     * @param person Suspect to be removed
     */
    public void removePerson(Suspects person) {
        personList.remove(person);
        DataWriter.DataUpdate();
    }

    /**
     * Method that prints the personDatabase
     */
    public void printDatabase(String answer) {
        for (Person person : personList) {
            System.out.println(person.toString());
        }
        if(answer.equalsIgnoreCase("yes"))
        {
            try {
                String fileName = "TextFiles/SuspectDatabase.txt";
                File myObj = new File(fileName);
                if (myObj.createNewFile()) {
                    FileWriter fileWriter = new FileWriter(fileName);
                    PrintWriter printWriter = new PrintWriter(fileWriter);
                    for (Person person : personList) {
                        printWriter.println(person.toString());
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
     * Method that checks for an instance of PersonDatabase
     * @return New or current database
     */
    public static PersonDatabase getInstance() {
        if (personDatabase == null)
            personDatabase = new PersonDatabase();
        return personDatabase;
    }

    /**
     * Method that loads in the values of the JSON File
     */
    private PersonDatabase() {
        personList = DataLoader.getPerson();
    }

    /**
     * Method that returns the database Array
     * @return Array with Suspects
     */
    public ArrayList<Suspects> getDatabase() {
        return personList;
    }

}
