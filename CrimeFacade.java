public class CrimeFacade {
    
    private CrimeDatabase crimeDatabase;
    private UserDatabase userDatabase;
    private PersonDatabase personDatabase;
    private User currentUser;

    public CrimeFacade() {
        crimeDatabase = crimeDatabase.getInstance();
        userDatabase = userDatabase.getInstance();
        personDatabase = personDatabase.getInstance();
    }

    public boolean createAccount(userName, password, name, position, isAdmin) {
        return userDatabase.addUser(userName, password, name, position, isAdmin);
    }

    public boolean login(String userName) {
        if(userDatabase.getUser(username)== null) return false;

        currentUser = userDatabase.getUser(username);
        return true;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public boolean addCrime(Crime crime) {
        return crimeDatabase.addCrime(crime);
    }

    public boolean searchCrime(Crime crime) {
        return crimeDatabase.getCrime(crime);
    }

    public boolean modifyCrime(Crime crime) {
        return true;
    }

    public boolean printCrimes() {
        return true;
    }

    public boolean searchCriminal() {
        return true;
    }

    public boolean modifyCriminal() {
        return true;
    }

    public boolean printCriminal() {
        return true;
    }

    public boolean removeCrimes() {
        return true;
    }

    public boolean addUser() {
        return true;
    }

    public boolean removeUser() {
        return true;
    }
    
}
