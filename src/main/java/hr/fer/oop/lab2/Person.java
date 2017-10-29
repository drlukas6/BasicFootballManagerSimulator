package hr.fer.oop.lab2;
import hr.fer.oop.lab2.welcomepack.Constants;

/**
 * Class that represents base of of persons this application will observe.
 * @author Lukas Šestić
 */
public abstract class Person {
    private String name = Constants.DEFAULT_PLAYER_NAME;
    private String country = Constants.DEFAULT_COUNTRY;
    private int emotion = Constants.DEFAULT_EMOTION;

    /**Constructor for abstract class Person inherited by both the Coach and FootballPlayer.
     * If two people have the same name and country they are the same person.
     * @param nameValue Value that represents the name of the person
     * @param countryValue Value that represents the country of origin of the person
     * @param emotionValue Value that represents persons emotional state. Must be within the range of [1,100] or it will automatically be
     *                     shifted to its default value of 50
     */
    public Person(String nameValue, String countryValue, int emotionValue){
        if(nameValue == null){
            System.err.println("Invalid name. Setting up default value");
            this.name = Constants.DEFAULT_PLAYER_NAME;
        }
        else
        this.name = nameValue;
        if(countryValue == null){
            System.err.println("Invalid name. Setting up default value");
            this.name = Constants.DEFAULT_COUNTRY;
        }
        else
        this.country = countryValue;
        if(emotionValue<Constants.MIN_EMOTION || emotionValue>Constants.MAX_EMOTION){
            System.err.println("Emotion has to be within the range of [1,100]. Setting up default value.");
            this.emotion = Constants.DEFAULT_EMOTION;
        }
        else
        this.emotion = emotionValue;
    }

    //Setters:

    /**
     * Method for setting(changing) persons emotional state. ust be within the range of [1,100] or it will automatically be
     * shifted to its default value of 50.
     * @param emotion Value that represents new emotional state user wants player to be in
     */
    public void setEmotion(int emotion){
        if(emotion<Constants.MIN_EMOTION || emotion >Constants.MAX_EMOTION){
            System.err.println("Emotion has to be in the range of [0,100]!");
        }
        else {
            this.emotion = emotion;
        }
    }

    //Getters:

    /**
     * Method for getting(reading) players name.
     * @return Name of the player
     */
    public String getName(){
        return name;
    }


    /**
     * Method for getting(reading) players country.
     * @return Players country of origin
     */
    public String getCountry(){
        return country;
    }


    /**
     * Method for getting(reading) players emotional state.
     * @return Players emotional state
     */
    public int getEmotion(){
        return emotion;
    }


    /**
     * Method for comparing two people. If their name and country are the same then they are the same people.
     * @param toMatch Value that represents another person to be matched with
     * @return True or false based on their names and countries
     */
    public boolean equals(Person toMatch){
        if(name == toMatch.name && country == toMatch.country){
            return true;
        }
        return false;
    }

}
