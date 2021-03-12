import java.util.ArrayList;

/**
 * @description 
 * @author Bradley Grose, Ellie Barry, David Keen, David Morrison
 */
public class Person {
    
    private String name;
    private ArrayList<Crime> crimeList;
    private boolean livingStatus;

    public Person(String name, ArrayList<Crime> crimeList, boolean livingStatus) {
        this.name = name;
        this.crimeList = crimeList;
        this.livingStatus = livingStatus;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Crime> getCrimeList() {
        return this.crimeList;
    }

    public void setCrimeList(ArrayList<Crime> crimeList) {
        this.crimeList = crimeList;
    }

    public boolean getLivingStatus() {
        return this.livingStatus;
    }

    public void setLivingStatus(boolean livingStatus) {
        this.livingStatus = livingStatus;
    }
}
