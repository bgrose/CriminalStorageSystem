/**
 * @description Class the creates PersonOfInterest
 * @author Bradley Grose, Ellie Barry, David Keen, David Morrison
 */

import java.util.ArrayList;
 
public class PersonOfInterest extends Person {

    private String alias;
    private String accomplice;
    private String hairColor;
    private String eyeColor;
    private String tatoo;
    private String skinColor;
    private String nationality;
    private double weight;
    private int height;
    private String acquaintance;
    private int age;
    private boolean glasses;
    private String disability;
    private String handness;
    private String statement;

    /**
     * Constructor method that sets up the PersonOfInterest
     * @param
     */
    public PersonOfInterest(String name, ArrayList<Crime> crimeList, boolean livingStatus, String alias, String accomplice, String
    hairColor, String eyeColor, String tatoo, String skinColor, String nationality, double weight, int height, String acquaintance,
    int age, boolean glasses, String disability, String handness, String statement, String UUID) {
        super(name, crimeList, livingStatus, UUID);
        this.alias = alias;
        this.accomplice = accomplice;
        this.hairColor = hairColor;
        this.eyeColor = eyeColor;
        this.tatoo = tatoo;
        this.skinColor = skinColor;
        this.nationality = nationality;
        this.weight = weight;
        this.height = height;
        this.acquaintance = acquaintance;
        this.age = age;
        this.glasses = glasses;
        this.disability = disability;
        this.handness = handness;
        this.statement = statement;
    }

    /**
     * Method that prints out the details of the PersonOfInterest class
     */
    public String toString() {
        return super.toString() +
        "\nAlias: " + this.alias + 
        "\nAccomplice: " + this.accomplice + 
        "\nHair Color: " + this.hairColor +
        "\nEye Color: " + this.eyeColor + 
        "\nTatoo: " + this.tatoo + 
        "\nSkin Color: " + skinColor + 
        "\nNationality: " + this.nationality + 
        "\nWeight: " + this.weight + 
        "\nHeight: " + this.height + 
        "\nAcquaintance: " + this.acquaintance + 
        "\nAge: " + this.age + 
        "\nGlasses: " + this.glasses + 
        "\nDisability: " + this.disability + 
        "\nHandness: " + this.handness + 
        "\nStatement: " + this.statement;
    }

    /**
     * Method that gets the person's alias
     * @return String alias
     */
    public String getAlias() {
        return this.alias;
    }

    /**
     * Method that sets out alias
     * @param alias String alias
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     * Method that gets if the person's had another person involved with crime
     * @return String accomplice
     */
    public String getAccomplice() {
        return this.accomplice;
    }

    /**
     * Method that sets out accomplice
     * @param accomplice String accomplice
     */
    public void setAccomplice(String accomplice) {
        this.accomplice = accomplice;
    }

    /**
     * Method that gets what the person's hair color is
     * @return String hairColor
     */
    public String getHairColor() {
        return this.hairColor;
    }

    /**
     * Method that sets out hair color
     * @param hairColor String hair color of person
     */
    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    /**
     * Method that gets what the person's eye color is
     * @return String eyeColor
     */
    public String getEyeColor() {
        return this.eyeColor;
    }

    /**
     * Method that sets out eye color
     * @param eyeColor String eye color of person
     */
    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    /**
     * Method that gets if person has tattoos or not
     * @return String tatoo
     */
    public String getTattoo() {
        return this.tatoo;
    }

    /**
     * Method that sets out tattoo
     * @param tatto String tatto
     */
    public void setTatoo(String tatoo) {
        this.tatoo = tatoo;
    }

    /**
     * Method that gets what the person's skin color is
     * @return String skinColor
     */
    public String getSkinColor() {
        return this.skinColor;
    }

    /**
     * Method that sets out skin color
     * @param skinColor String Skin color of person
     */
    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }

    /**
     * Method that gets what country the person is from
     * @return String nationlity
     */
    public String getNationality() {
        return this.nationality;
    }

    /**
     * Method that sets out nationality
     * @param nationality String nationlity
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    /**
     * Method that gets the weight of person
     * @return double weight
     */
    public double getWeight() {
        return this.weight;
    }

    /**
     * Method that sets out weight
     * @param weight double weight
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Method that gets the height of person
     * @return int height
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * Method that sets out height
     * @param height int height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Method that gets if the person is acquitted
     * @return String acquaintance
     */
    public String getAccquaintance() {
        return this.acquaintance;
    }

    /**
     * Method that sets out accquaintance
     * @param accquaintance String accquaintance
     */
    public void setAccquaintance(String acquaintance) {
        this.acquaintance = acquaintance;
    }

    /**
     * Method that gets the age of person
     * @return int age
     */
    public int getAge() {
        return this.age;
    }

    /**
     * Method that sets out age
     * @param age int age of person
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Method that gets if a person wears glasses or not
     * @return boolean glasses
     */
    public boolean getGlasses() {
        return this.glasses;
    }

    /**
     * Method that sets glasses
     * @param glasses String glasses
     */
    public void setGlasses(boolean glasses) {
        this.glasses = glasses;
    }

    /**
     * Method that gets if the person has a disability
     * @return String disability
     */
    public String getDisability() {
        return this.disability;
    }

    /**
     * Method that sets if disabilities are involved
     * @param disability String of an disability
     */
    public void setDisability(String disability) {
        this.disability = disability;
    }

    /**
     * Method that gets if being left or right handed
     * @return String handness
     */
    public String getHandness() {
        return this.handness;
    }

    /**
     * Method that sets Hand ness
     * @param handness String of left or right handed
     */
    public void setHandness(String handness) {
        this.handness = handness;
    }

    /**
     * Method that gets the statement
     * @return String statement
     */
    public String getStatement() {
        return this.statement;
    }

    /**
     * Method that sets the statement
     * @param String statement
     */
    public void setStatement(String statement) {
        this.statement = statement;
    }
    
}
