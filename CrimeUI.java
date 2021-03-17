import java.util.Scanner;

/**
 * @description creates the main driver of CrimeUI
 * @author Bradley Grose, Ellie Barry, David Keen, David Morrison
 */
public class CrimeUI {

    private static final String WELCOME_MSG = "Welcome to the Criminal Storage System!: Please login";
    private String[] mainMenuOptions = {"Add Crime", "Search Crime", "Modify Crime", "Print Crimes", "Search Criminal", "Modify Criminal", "Print Criminals", "Logout"} ;
    private Scanner scanner;
    private Facade crimeFacade;

    CrimeUI(){
        scanner = new Scanner(System.in);
        crimeFacade = new Facade();
    }
    
    /* 
    * Method that will run the program
    */
    public void run() 
    {
        System.out.println(WELCOME_MSG);

        login();

        while(true) {
            displayMenu();

            int command = getCommand(mainMenuOptions.length);

            if(command == -1) {
				System.out.println("Not a valid option");
				continue;
            }
            
            if(command == mainMenuOptions.length -1) {
				break;
            }

            switch(command) {
                case(0):
                    addCrime();
                    break;
                case(1):
                    searchCrime();
                    break;
                case(2):
                    modifyCrime();
                    break;
                case(3):
                    printCrimes();
                    break;
                case(4):
                    searchCriminal();
                    break;
                case(5):
                    modifyCriminal();
                    break;
                case(6):
                    printCriminals();
                    break;
            }
            
        }
        System.out.println("Logging Out......Complete. Have a good day");
    }

    private int getCommand(int numCommands) {
		System.out.print("What would you like to do?: ");
		
		String input = scanner.nextLine();
		int command = Integer.parseInt(input) - 1;
		
		if(command >= 0 && command <= numCommands -1) return command;
		
		return -1;
	}

    private void login()
    {

    }

    /* 
    * Method that will open the Main menu
    */
    private void displayMenu() 
    {
        System.out.println("\n************ Main Menu *************");
		for(int i=0; i< mainMenuOptions.length; i++) {
			System.out.println((i+1) + ". " + mainMenuOptions[i]);
		}
		System.out.println("\n");
    }

    /* 
    * Method that will open the Admin menu
    */
    private void displayAdmin() 
    {

    }

    private void addCrime() 
    {
        System.out.println("\n------------- adding crime -------------");
    }

    private void searchCrime() 
    {
        System.out.println("\n------------- searching crime -------------");
    }

    private void modifyCrime() 
    {
        System.out.println("\n------------- editing crime -------------");
    }

    private void printCrimes() 
    {
        System.out.println("\n------------- printing crimes -------------");
    }

    private void searchCriminal() 
    {
        System.out.println("\n------------- searching criminal -------------");
    }

    private void printCriminal() 
    {
        System.out.println("\n------------- printing criminal -------------");
    }

    private void removeCrimes() 
    {
        System.out.println("\n------------- removing crime -------------");
    }

    private void addUser() 
    {
        System.out.println("\n------------- adding user -------------");
    }

    private void removeUser() 
    {
        System.out.println("\n------------- removing user -------------");
    }
    public static void main(String[] args) 
    {
        CrimeUI crimeInterface = new CrimeUI();
        crimeInterface.run();
    }

}
