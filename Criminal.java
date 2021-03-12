/**
 * @description 
 * @author Bradley Grose, Ellie Barry, David Keen, David Morrison
 */

 import java.util.ArrayList;

public class Criminal extends Person{

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
    private String punishment;
    private String disability;
    private String handness;
    private String crimeType;
    private User arrestingOfficer;
    private boolean inJail;

    public Criminal(String name, ArrayList<Crime> crimeList, boolean livingStatus, String alias, String accomplice, String
    hairColor, String eyeColor, String tatoo, String skinColor, String nationality, double weight, int height, String acquaintance,
    int age, boolean glasses, String punishment, String disability, String handness, String crimeType, User arrestingOfficer, boolean inJail) {
        super(name, crimeList, livingStatus);
        this.alias = alias;
        this.accomplice = accomplice;
        this.hairColor = hairColor;
        this.eyeColor = eyeColor;
        this.tatoo = tatoo;
        this.skinColor = skinColor;
        this.nationality = nationality;
        this.weight = weight;
        this.height = height;
        this. acquaintance = acquaintance;
        this.age = age;
        this.glasses = glasses;
        this.punishment = punishment;
        this.disability = disability;
        this.handness = handness;
        this.crimeType = crimeType;
        this.arrestingOfficer = arrestingOfficer;
        this.inJail = inJail;
    }

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
        "\nPunishment: " + this.punishment + 
        "\nDisability: " + this.disability + 
        "\nHandness: " + this.handness + 
        "\nCrime Type: " + this.crimeType + 
        "\nArresting Officer: " + this.arrestingOfficer + 
        "\nIn Jail: " + this.inJail;
    }

    public String getAlias() {
        return this.alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getAccomplice() {
        return this.accomplice;
    }

    public void setAccomplice(String accomplice) {
        this.accomplice = accomplice;
    }

    public String getHairColor() {
        return this.hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getEyeColor() {
        return this.eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getTattoo() {
        return this.tatoo;
    }

    public void setTatoo(String tatoo) {
        this.tatoo = tatoo;
    }

    public String getSkinColor() {
        return this.skinColor;
    }

    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }

    public String getNationality() {
        return this.nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getAccquaintance() {
        return this.acquaintance;
    }

    public void setAccquaintance(String accquaintance) {
        this.acquaintance = accquaintance;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean getGlasses() {
        return this.glasses;
    }

    public void setGlasses(boolean glasses) {
        this.glasses = glasses;
    }

    public String getPunishment() {
        return this.punishment;
    }

    public void setPunishment(String punishment) {
        this.punishment = punishment;
    }

    public String getDisability() {
        return this.disability;
    }

    public void setDisability(String disability) {
        this.disability = disability;
    }

    public String getHandness() {
        return this.handness;
    }

    public void setHandness(String handness) {
        this.handness = handness;
    }

    public String getCrimeType() {
        return this.crimeType;
    }

    public void setCrimeType(String crimeType) {
        this.crimeType = crimeType;
    }

    public User getArrestingOfficer() {
        return arrestingOfficer;
    }

    public void setArrestingOfficer(User officer) {
        this.arrestingOfficer = officer;
    }

    public boolean getInJail() {
        return this.inJail;
    }

    public void setInJail(boolean inJail) {
        this.inJail = inJail;
    }

}
