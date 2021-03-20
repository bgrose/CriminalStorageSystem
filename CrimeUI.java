import java.util.Scanner;


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
     * 
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

        login();

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
            // how to differentiate between admin and normal user?
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
        String password = getField("Prompt");
        String name = getField("Name");
        String position = getField("Position");
        Boolean isAdmin = false;

       // if (crimeFacade.createAccount(userName, password, name, position, isAdmin)) {
       //     System.out.println("You have successfully created an account");
       // } else {
      //      System.out.println("Sorry, an account with that username already exits");
        //}
    }

    /**
     * Method that will provide a login
     */
    private void login() {


            String username = getField("Username");
            String password = getField("Password");

            if (crimeFacade.login(username, password)) {
                User currentUser = crimeFacade.getCurrentUser();
                System.out.println("Welcome " + currentUser.getName() + "!");
            } else {
                System.out.println("Sorry, invalid username or password");
        }

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
        String Crime = getUserCrime();
        //crimeFacade.addCrime(Crime);
    }

    /**
     * Methods to search for Crime
     */
    private void searchCrime() {
        System.out.println("\n------------- Searching for a Crime -------------");
        String crime = getUserCrime();

        if (crime == null)
            return;

        //if (!crimeFacade.searchCrime(crime)) {
            System.out.println("Sorry the type of crime is not found \n");
            return;
      //  }

        //System.out.println("The crime you're looking for is in library\n");
    }

    /**
     * Methods to edit Crimes
     *  
     */
    private void modifyCrime() {
        System.out.println("\n------------- editing crime -------------");
        //crimeFacade.modifyCrime();

    }

    /**
     * Methods to print Crimes
     */
    private void printCrimes() {
        System.out.println("\n------------- printing crimes -------------");
    }

    /**
     * Methods to search criminals
     */
    private void searchCriminal() {
        System.out.println("\n------------- searching criminal -------------");
        String criminal = getUserCriminal();

        if (criminal == null)
            return;
            /*
        if (crimeFacade.searchCriminal(criminal) == null) {
            System.out.println("Sorry the criminal your searching is not found \n");
            return;
        }
        */
        System.out.println("The criminal you're looking for is in library\n");
    }

    /**
     * Methods to edit criminals
     */
    private void modifyCriminal() {
        System.out.println("\n------------- editing criminal -------------");
        crimeFacade.modifyCriminal();
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
        //crimeFacade.removeCrimes();
    }

    /**
     * Methods to add Users
     */
    private void addUser() {
        System.out.println("\n------------- adding user -------------");
        //crimeFacade.addUser();
    }

    /**
     * Methods to remove Users
     */
    private void removeUser() {
        System.out.println("\n------------- removing user -------------");
        //crimeFacade.removeUser();
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
        CrimeFacade crimeFacade = new CrimeFacade();
        CrimeUI crimeInterface = new CrimeUI();
        crimeInterface.run();
    }

}
