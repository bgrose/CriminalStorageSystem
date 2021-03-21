import java.util.Scanner;
import java.util.ArrayList;

/**
 * @description creates the main driver of CrimeUI
 * @author Bradley Grose, Ellie Barry, David Keen, David Morrison
 */
public class CrimeUI {

    private static final String WELCOME_MSG = "Welcome to the Criminal Storage System!: Please login or create an account.";
    private String[] menuOptions = { "Add Crime", "Search Crime", "Modify Crime", "Print Crimes", "Search Criminal",
            "Modify Criminal", "Print Criminals", "Logout" };
    private String[] AdminMenuOptions = { "Add Crime", "Search Crime", "Modify Crime", "Print Crimes",
            "Search Criminal", "Modify Criminal", "Print Criminals", "Remove Crime", "Add User", "Remove User",
            "Logout" };
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
                    System.out.println("Not a valid option");
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
                    modifyCrime();
                    break;
                case (3):
                    printCrimes();
                    break;
                case (4):
                    searchCriminal();
                    break;
                case (5):
                    modifyCriminal();
                    break;
                case (6):
                    removeCrimes();
                    break;
                case (8):
                    addUser();
                    break;
                case (9):
                    removeUser();
                    break;
                }
            }

        } else {
            while (true) {
                displayMenu();

                int command = getCommand(menuOptions.length);

                if (command == -1) {
                    System.out.println("Not a valid option");
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
                    modifyCrime();
                    break;
                case (3):
                    printCrimes();
                    break;
                case (4):
                    searchCriminal();
                    break;
                case (5):
                    modifyCriminal();
                    break;
                case (6):
                    printCriminal();
                    break;
                }
            }
        }
        System.out.println("Logging Out......Complete. Have a good day");
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
     * 
     * @param numCommands
     * @return
     */
    private int getCommand(int numCommands) {
        System.out.print("What would you like to do?: ");

        String input = scanner.nextLine();
        int command = Integer.parseInt(input) - 1;

        if (command >= 0 && command <= numCommands - 1)
            return command;

        return -1;
    }

    /**
     * Method that creates an account
     */
    private void createAccount() {
        String userName = getField("Username");
        String password = getField("Passord");
        String name = getField("Name");
        String position = getField("Position");
        UserDatabase uDatabase = UserDatabase.getInstance();
        // add whether we're an admin
        boolean isAdmin = false;

        boolean userNameUsed = false;

        for (int i = 0; i < uDatabase.getDatabase().size(); i++) {
            if (uDatabase.getDatabase().get(i).getUsername().equals(userName))
                userNameUsed = true;
        }
        if (userNameUsed) {
            System.out.println("Sorry, an account with that username already exits");
        } else {
            crimeFacade.createAccount(userName, password, name, position, isAdmin);
            System.out.println("You have successfully created an account");
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
                System.out.println("Sorry, invalid username or password");
            }

        }
        return null;
    }

    /**
     * 
     * @param prompt
     * @return
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
        String caseID = getField("Please Enter the Case ID");
        String date = getField("Please Enter the Date of the Crime");
        String description = getField("Please Enter a Description");
        String solvedString = getField("Has This Case been Solved(y/n)");
        boolean solved = false;
        if (solvedString.equals("y"))
            solved = true;
        int num = Integer.valueOf(getField("How many Witnesses are there"));
        ArrayList<Witness> witness = createWitnessList(num);
        num = Integer.valueOf(getField("How many Evidence items are there"));
        ArrayList<Evidence> evidenceList = createEvidenceList(num);
        num = Integer.valueOf(getField("How many Suspects are there"));
        ArrayList<Suspects> suspect = createSuspectList(num);
        Crime crime = new Crime(evidenceList, suspect, witness, description, caseID, solved, date);
        crimeFacade.addCrime(crime);
    }

    private ArrayList<Witness> createWitnessList(int num) {
        ArrayList<Witness> witnessList = new ArrayList<Witness>();
        for (int i = 0; i < num; i++) {
            String name = getField("Please Enter the " + (i + 1) + " Witness Name");
            String answer = getField("Is the " + (i + 1) + " Witness Living(y/n");
            boolean livingStatus = true;
            if (answer.equals("n"))
                livingStatus = false;
            String statement = getField("Please Enter the " + (i + 1) + " Witness Statement");
            Witness witness = new Witness(name, livingStatus, statement);
            witnessList.add(witness);
        }
        return witnessList;
    }

    private ArrayList<Suspects> createSuspectList(int num)
    {
        ArrayList<Suspects> suspectList = new ArrayList<Suspects>();
            for(int i=0; i<num; i++)
            {
                String name = getField("Please Enter the " + (i + 1) + " Suspect Name");
                String answer = getField("Is the " + (i + 1) + " Suspect Living(y/n");
                boolean livingStatus = true;
                if (answer.equals("n"))
                    livingStatus = false;
                String alias = getField("Please Enter any of the " + (i + 1) + " Suspect Aliases");
                String accomplice = getField("Please Enter any of the " + (i + 1) + " Suspect Accomplices");
                String acquaintance = getField("Please Enter any of the " + (i + 1) + " Suspect Acquaintance");
                String hairColor = getField("Please Enter the " + (i + 1) + " Suspect Hair Color");
                String eyeColor = getField("Please Enter the " + (i + 1) + " Suspect Eye Color");
                String tatoo = getField("Please Enter the " + (i + 1) + " Suspects Tattoo");
                String skinColor = getField("Please Enter the " + (i + 1) + " Suspects Skin Color");
                String nationality = getField("Please Enter the " + (i + 1) + " Suspects Nationality");
                int weight = Integer.valueOf(getField("Please Enter the " + (i + 1) + " Suspect weight or an estimate in pounds"));
                int height = Integer.valueOf(getField("Please Enter the " + (i + 1) + " Suspect height or an estimate in inches"));
                int age = Integer.valueOf(getField("Please Enter the " + (i + 1) + " Suspect age or an estimate"));
                answer = getField("Does the " + (i + 1) + " Suspect wear glasses (y/n)");
                boolean glasses = true;
                if (answer.equals("n"))
                    glasses = false;
                String disability = getField("Please Enter the " + (i + 1) + " Suspects Disability if any");
                String handness = getField("Please Enter the " + (i + 1) + " Suspects Handness");
                answer = getField("Has Suspect "+ (i + 1) +"Been arrested/charged(y/n)");
                String punishment, crimeType;
                User arrestingOfficer;
                Boolean inJail;
                if(answer.equals("y"))
                {
                    punishment = getField("Please Enter the " + (i + 1) + " Criminal Punishment");
                    crimeType = getField("Please Enter the " + (i + 1) + " Criminal Crime Charge");
                    inJail = true;
                    answer = getField("Please Enter the " + (i + 1) + " Arresting Officer Name");
                    arrestingOfficer = crimeFacade.findOfficer(answer);
                }
                else
                {
                    punishment = "None.";
                    crimeType = "None.";
                    inJail = false;
                    arrestingOfficer = null;
                }

                
                Suspects suspect = new Suspects(name, livingStatus, alias, accomplice, hairColor, 
                eyeColor, tatoo, skinColor, nationality, weight, height, acquaintance, age, glasses, 
                punishment, disability, handness, crimeType, arrestingOfficer, inJail);
                suspectList.add(suspect);
            }
        return suspectList;
    }

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
     * Methods to search for Crime
     */
    private void searchCrime() {
        System.out.println("\n------------- Searching for a Crime -------------");
        // Crime crime = getUserCrime();
        /*
         * if (crime == null) return;
         * 
         * if (crimeFacade.searchCrime(crime.getcaseID()) == null) {
         * System.out.println("Sorry the type of crime is not found \n"); return; }
         * 
         * System.out.println(crime.toString());
         */
    }

    /**
     * Methods to edit Crimes
     * 
     */
    private void modifyCrime() {
        System.out.println("\n------------- editing crime -------------");
        
    }

    /**
     * Methods to print Crimes
     */
    private void printCrimes() {
        System.out.println("\n------------- printing crimes -------------");
        crimeFacade.printCrimes();
    }

    /**
     * Methods to search criminals
     */
    private void searchCriminal() {
        System.out.println("\n------------- searching criminal -------------");
        String criminalName = getUserCriminal();

        if (criminalName == null)
            return;

        if (crimeFacade.searchCriminal(criminalName)) {
            System.out.println("Sorry the criminal your searching is not found \n");
            return;
        }
        System.out.println("The criminal you're looking for is in library\n");
    }

    /**
     * Methods to edit criminals
     */
    private void modifyCriminal() {
        System.out.println("\n------------- editing criminal -------------");
        // crimeFacade.modifyCriminal(crime, caseID);
    }

    /**
     * Methods to print the criminal
     */
    private void printCriminal() {
        System.out.println("\n------------- printing criminal -------------");
        crimeFacade.printCriminal();
    }

    /**
     * Methods to remove crimes
     */
    private void removeCrimes() {
        System.out.println("\n------------- removing crime -------------");
        System.out.print("Please enter the Case ID to be removed: ");
        String choice = scanner.nextLine();
        boolean removed = crimeFacade.removeCrime(choice);
        if (removed)
            System.out.println("Crime Removed Successfully");
        else
            System.out.println("No Crime Found.");
    }

    /**
     * Methods to add Users
     */
    private void addUser() {
        System.out.println("\n------------- adding user -------------");
        createAccount();
    }

    /**
     * Methods to remove Users
     */
    private void removeUser() {
        System.out.println("\n------------- removing user -------------");
        System.out.print("Please enter the Username of the user to be removed: ");
        String userName = scanner.nextLine();
        boolean removed = crimeFacade.removeUser(userName);
        if (removed)
            System.out.println("User Removed Successfully");
        else
            System.out.println("No User Found.");
    }

    /**
     * 
     * @return
     */
    private String getUserCriminal() {
        System.out.print("Enter User Criminals: ");

        while (true) {
            String criminalName = scanner.nextLine().trim().toLowerCase();

            if (!criminalName.contentEquals(""))
                return criminalName;

            System.out.println("You need to enter the actual content");
            System.out.print("Would you like to enter criminal again (y) or return to main menu (n): ");
            String command = scanner.nextLine().trim().toLowerCase();
            if (command == "n")
                return null;
        }
    }

    /**
     * 
     * @return
     */
    private String getUserCrime() {
        System.out.print("Enter User Crimes: ");

        while (true) {
            String crimeName = scanner.nextLine().trim().toLowerCase();

            if (!crimeName.contentEquals(""))
                return crimeName;

            System.out.println("You need to enter the actual content");
            System.out.print("Would you like to enter crime again (y) or return to main menu (n): ");
            String command = scanner.nextLine().trim().toLowerCase();
            if (command == "n")
                return null;
        }
    }

    /**
     * The main method
     */
    public static void main(String[] args) {
        CrimeUI crimeInterface = new CrimeUI();
        crimeInterface.run();
    }

}
