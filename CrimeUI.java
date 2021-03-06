/**
 * @description Class that creates the main driver of CrimeUI
 * @author Bradley Grose, Eleanor Barry, David Keen, David Morrison
 */

import java.util.Scanner;
import java.util.ArrayList;

public class CrimeUI {

    private static final String WELCOME_MSG = "Welcome to the Criminal Storage System! Please login or create an account.";
    private String[] menuOptions = { "Add Crime", "Search Crime", "Print Crimes", "Search Criminals", "Print Criminals",
            "Logout" };
    private String[] AdminMenuOptions = { "Add Crime", "Search Crime", "Print Crimes", "Search Criminals",
            "Print Criminals", "Remove Crime", "Add User", "Remove User", "Logout" };
    private String[] criminalSearchOptions = { "Name", "Living Status", "UUID", "Gender", "Address", "Phone Number",
            "Alias", "Accomplice", "Hair Color", "Eye Color", "Tatoo", "Skin Color", "Nationality", "Weight", "Height",
            "Aquaintance", "Age", "Glasses", "Punishment", "Disability", "In Jail", "Address" };
    private Scanner scanner;
    private CrimeFacade crimeFacade;

    /**
     * Constructor method that sets up the CrimeUI
     */
    CrimeUI() {
        scanner = new Scanner(System.in);
        crimeFacade = new CrimeFacade();
    }

    /*
     * Method that will run the program
     */
    public void run() {
        System.out.println(WELCOME_MSG);

        User user = login();

        if (user.isAdmin()) {
            while (true) {
                displayAdminMenu();

                int command = getCommand(AdminMenuOptions.length);

                if (command == -1) {
                    System.out.println("Not a valid option.");
                    continue;
                }

                if (command == AdminMenuOptions.length - 1) {
                    crimeFacade.logout();
                    break;
                }

                switch (command) {
                case (0):
                    addCrime();
                    break;
                case (1):
                    searchCrime();
                    break;
                case (2):
                    printCrimes();
                    break;
                case (3):
                    searchCriminal();
                    break;
                case (4):
                    printCriminal();
                    break;
                case (5):
                    removeCrimes();
                    break;
                case (6):
                    addUser();
                    break;
                case (7):
                    removeUser();
                    break;
                }
            }

        } else {
            while (true) {
                displayMenu();

                int command = getCommand(menuOptions.length);

                if (command == -1) {
                    System.out.println("Not a valid option.");
                    continue;
                }

                if (command == menuOptions.length - 1) {
                    crimeFacade.logout();
                    break;
                }

                switch (command) {
                case (0):
                    addCrime();
                    break;
                case (1):
                    searchCrime();
                    break;
                case (2):
                    printCrimes();
                    break;
                case (3):
                    searchCriminal();
                    break;
                case (4):
                    printCriminal();
                    break;
                }
            }
        }
        System.out.println("Logging Out......Complete. Have a good day!");
    }

    /*
     * Method that will open the Main menu
     */
    private void displayMenu() {

        System.out.println("\n************ Main Menu *************");
        for (int i = 0; i < menuOptions.length; i++) {
            System.out.println((i + 1) + ". " + menuOptions[i]);
        }
        System.out.println("\n");
    }

    /*
     * Method that will open the Admin menu
     */
    private void displayAdminMenu() {
        System.out.println("\n************ Main Menu *************");
        for (int i = 0; i < AdminMenuOptions.length; i++) {
            System.out.println((i + 1) + ". " + AdminMenuOptions[i]);
        }
        System.out.println("\n");
    }

    /**
     * Method that asks and scans what the user would like to do
     * @param numCommands
     * @return
     */
    private int getCommand(int numCommands) {
        System.out.print("What would you like to do?: ");

        String input = scanner.nextLine();
        int command = Integer.parseInt(input) - 1;

        if (command >= 0 && command <= numCommands - 1) {
            return command;
        }

        return -1;
    }

    /**
     * Method that creates an account
     */
    private void createAccount() {
        String userName = getField("Username");
        String password = getField("Password");
        String name = getField("Name");
        String position = getField("Position");
        UserDatabase uDatabase = UserDatabase.getInstance();
        // add whether we're an admin
        boolean isAdmin = false;

        boolean userNameUsed = false;

        for (int i = 0; i < uDatabase.getDatabase().size(); i++) {
            if (uDatabase.getDatabase().get(i).getUsername().equals(userName)) {
                userNameUsed = true;
            }
        }
        if (userNameUsed) {
            System.out.println("Sorry, an account with that username already exits.");
        } else {
            crimeFacade.createAccount(userName, password, name, position, isAdmin);
            System.out.println("You have successfully created an account!");
        }
    }

    /**
     * Method that will provide a login
     */
    private User login() {
        boolean loggedIn = false;

        while (!loggedIn) {
            String username = getField("Username");
            String password = getField("Password");
            loggedIn = crimeFacade.login(username, password);

            if (loggedIn) {
                User currentUser = crimeFacade.getCurrentUser();
                System.out.println("Welcome " + currentUser.getName() + "!");
                return UserDatabase.getInstance().getUser(username, password);
            } else {
                System.out.println("Sorry, invalid username or password.");
            }

        }
        return null;
    }

    /**
     * Method that scans the string the user enters
     * @param prompt String that is printed
     * @return String that the user enters
     */
    private String getField(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextLine();
    }

    /**
     * Methods to add a Crime
     */
    private void addCrime() {
        System.out.println("\n------------- Adding a Crime -------------");
        String caseID = getField("Please enter the case ID");
        String date = getField("Please enter the date of the crime");
        String description = getField("Please enter a description");
        String solvedString = getField("Has this case been solved? (y/n)");
        boolean solved = false;
        if (solvedString.equals("y")) {
            solved = true;
        }
        int num = Integer.valueOf(getField("How many witnesses are there?"));
        ArrayList<Witness> witness = createWitnessList(num);
        num = Integer.valueOf(getField("How many evidence items are there?"));
        ArrayList<Evidence> evidenceList = createEvidenceList(num);
        num = Integer.valueOf(getField("How many suspects are there?"));
        ArrayList<Suspects> suspect = createSuspectList(num);
        Crime crime = new Crime(evidenceList, suspect, witness, description, caseID, solved, date);
        crimeFacade.addCrime(crime);
    }

    /**
     * Method that creates a list of witnesses
     * @param num the amount of witnesses being added
     * @return ArrayList<Witness> of the witnesses
     */
    private ArrayList<Witness> createWitnessList(int num) {
        ArrayList<Witness> witnessList = new ArrayList<Witness>();
        for (int i = 0; i < num; i++) {
            String name = getField("Please enter the " + (i + 1) + " Witness Name");
            String gender = getField("Please enter the " + (i + 1) + " Witness Gender");
            String address = getField("Please enter any of the " + (i + 1) + " Witness Address");
            String phone = getField("Please enter any of the " + (i + 1) + " Witness Phone Number");
            String answer = getField("Is the " + (i + 1) + " Witness Living(y/n");
            boolean livingStatus = true;
            if (answer.equals("n")) {
                livingStatus = false;
            }
            answer = getField("Is the " + (i + 1) + " witness a victim? (y/n");
            boolean isVictem = true;
            if (answer.equals("n")) {
                isVictem = false;
            }
            String statement = getField("Please enter the " + (i + 1) + " Witness Statement");
            Witness witness = new Witness(name, livingStatus, statement, gender, isVictem, address, phone);
            witnessList.add(witness);
        }
        return witnessList;
    }

    /**
     * Method that creates a suspect list
     * @param num the amount of suspects being added
     * @return ArrayList<Suspects> of the suspects
     */
    private ArrayList<Suspects> createSuspectList(int num) {
        ArrayList<Suspects> suspectList = new ArrayList<Suspects>();
        for (int i = 0; i < num; i++) {
            String name = getField("Please Enter the " + (i + 1) + " Suspect Name");
            String answer = getField("Is the " + (i + 1) + " Suspect Living? (y/n");
            String gender = getField("Please Enter the " + (i + 1) + " Suspect Gender");
            boolean livingStatus = true;
            if (answer.equals("n")) {
                livingStatus = false;
            }
            String alias = getField("Please Enter any of the " + (i + 1) + " Suspect Aliases");
            String address = getField("Please Enter any of the " + (i + 1) + " Suspect Address");
            String phone = getField("Please Enter any of the " + (i + 1) + " Suspect Phone Number");
            String accomplice = getField("Please Enter any of the " + (i + 1) + " Suspect Accomplices");
            String acquaintance = getField("Please Enter any of the " + (i + 1) + " Suspect Acquaintance");
            String hairColor = getField("Please Enter the " + (i + 1) + " Suspect Hair Color");
            String eyeColor = getField("Please Enter the " + (i + 1) + " Suspect Eye Color");
            String tatoo = getField("Please Enter the " + (i + 1) + " Suspects Tattoo");
            String skinColor = getField("Please Enter the " + (i + 1) + " Suspects Skin Color");
            String nationality = getField("Please Enter the " + (i + 1) + " Suspects Nationality");
            int weight = Integer
                    .valueOf(getField("Please Enter the " + (i + 1) + " Suspect weight or an estimate in pounds"));
            int height = Integer
                    .valueOf(getField("Please Enter the " + (i + 1) + " Suspect height or an estimate in inches"));
            int age = Integer.valueOf(getField("Please Enter the " + (i + 1) + " Suspect age or an estimate in years"));
            answer = getField("Does the " + (i + 1) + " Suspect wear glasses? (y/n)");
            boolean glasses = true;
            if (answer.equals("n")) {
                glasses = false;
            }
            String disability = getField("Please Enter the " + (i + 1) + " Suspects Disability if any");
            String handness = getField("Please Enter the " + (i + 1) + " Suspects Handness");
            answer = getField("Has Suspect " + (i + 1) + " been arrested/charged? (y/n)");
            String punishment, crimeType;
            Boolean inJail = Boolean.valueOf(getField("Is " + (i + 1) + " Suspect In Jail?"));
            if (answer.equals("y")) {
                punishment = getField("Please Enter the " + (i + 1) + " Criminal Punishment");
                crimeType = getField("Please Enter the " + (i + 1) + " Criminal Crime Charge");
            } else {
                punishment = "None.";
                crimeType = "None.";
            }

            Suspects suspect = new Suspects(name, livingStatus, alias, accomplice, hairColor, eyeColor, tatoo,
                    skinColor, nationality, weight, height, acquaintance, age, glasses, punishment, disability,
                    handness, crimeType, inJail, gender, address, phone);
            suspectList.add(suspect);
            crimeFacade.addSuspect(suspect);
        }
        return suspectList;
    }

    /**
     * Method that creates an evidence list
     * @param num the amount of evidence being added
     * @return ArrayList<Evidence> of the evidence
     */
    private ArrayList<Evidence> createEvidenceList(int num) {
        ArrayList<Evidence> evidenceList = new ArrayList<Evidence>();
        for (int i = 0; i < num; i++) {
            String name = getField("Please Enter the " + (i + 1) + " Evidence Item Name");
            String description = getField("Please Enter the " + (i + 1) + " Evidence Item Description");
            Evidence evidence = new Evidence(name, description);
            evidenceList.add(evidence);
        }
        return evidenceList;
    }

    /**
     * Method that searches for a Crime
     */
    private void searchCrime() {
        System.out.println("\n------------- Searching for a Crime -------------");
        String crimeName = getUserCrime();

        if (crimeName == null) {
            return;
        }
        if (crimeFacade.searchCrime(crimeName)) {
            System.out.println("The crime you're looking for is in the library\n");
            String answer = getField("Would you like to print to a file");
            if (answer.equalsIgnoreCase("yes"))
                crimeFacade.printCrimeFound(crimeName);
            answer = getField("Would you like to print to terminal?");
            if (answer.equalsIgnoreCase("yes"))
                crimeFacade.printCrimeTerminal(crimeName);
            return;
        } else {
            System.out.println("Sorry, the crime you are looking for is not in the library.\n");
        }
    }

    /**
     * Method that prints Crimes
     */
    private void printCrimes() {
        String answer = getField("Would You Like to Print to Text File");
        System.out.println("\n------------- printing crimes -------------");
        crimeFacade.printCrimes(answer);
    }

    /**
     * Method that searches for a criminal
     */
    private void searchCriminal() {
        ArrayList<Suspects> results = new ArrayList<Suspects>();
        boolean answer = true;
        System.out.println("\n------------- Searching for a Criminal -------------");

        while (answer) {
            for (int i = 0; i < criminalSearchOptions.length; i++) {
                System.out.println((i + 1) + ". " + criminalSearchOptions[i]);
            }
            System.out.print("What criteria would you like to search by?: \n");

            String input = scanner.nextLine();
            int command = Integer.parseInt(input);

            String term = getField("What Value Are You Looking For");

            if (command <= 0 || command > criminalSearchOptions.length) {
                System.out.println("Not a valid search option");
            }
            results = crimeFacade.searchCriminal(command, term);

            System.out.println("There were " + results.size() + " results.");
            if (results.size() == 0)
                break;
            String answerFileString = getField("Would you like to print results to a file? (y/n)");
            if (answerFileString.equals("y"))
                crimeFacade.printResFile(results);
            String answerTerminalString = getField("Would you like to print results to terminal? (y/n)");
            if (answerTerminalString.equals("y"))
                crimeFacade.printResTerminal(results);
            String answerString = getField("Would you like to search further? (y/n)");
            if (answerString.equals("n"))
                break;
        }
    }

    /**
     * Method that prints the criminals
     */
    private void printCriminal() {
        String answer = getField("Would You Like to Print to Text File");
        System.out.println("\n------------- printing criminal -------------");
        crimeFacade.printCriminal(answer);
    }

    /**
     * Method that removed a crime
     */
    private void removeCrimes() {
        System.out.println("\n------------- removing crime -------------");
        System.out.print("Please enter the Case ID to be removed: ");
        String choice = scanner.nextLine();
        boolean removed = crimeFacade.removeCrime(choice);
        if (removed) {
            System.out.println("Crime Removed Successfully");
        } else {
            System.out.println("No Crime Found.");
        }
    }

    /**
     * Methods that adds a user
     */
    private void addUser() {
        System.out.println("\n------------- adding user -------------");
        createAccount();
    }

    /**
     * Methods that removes a user
     */
    private void removeUser() {
        System.out.println("\n------------- removing user -------------");
        System.out.print("Please enter the Username of the user to be removed: ");
        String userName = scanner.nextLine();
        boolean removed = crimeFacade.removeUser(userName);
        if (removed) {
            System.out.println("User Removed Successfully");
        } else {
            System.out.println("No User Found.");
        }
    }

    /**
     * Method that scans in a crime and returns the name of the crime
     * @return crimeName of the crime added
     */
    private String getUserCrime() {
        System.out.print("Enter Crime ID: ");

        while (true) {
            String crimeName = scanner.nextLine();

            if (crimeName.contentEquals("")) {
                System.out.println("You need to enter the actual content");
                System.out.print("Would you like to enter crime again (y) or return to main menu (n): ");
                String command = scanner.nextLine();
                if (command.equalsIgnoreCase("n")) {
                    return null;
                }
            } else
                return crimeName;
        }
    }

    /**
     * Main method
     */
    public static void main(String[] args) {
        CrimeUI crimeInterface = new CrimeUI();
        crimeInterface.run();
    }

}