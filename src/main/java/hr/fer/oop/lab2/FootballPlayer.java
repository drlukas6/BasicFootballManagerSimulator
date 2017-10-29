package hr.fer.oop.lab2;

import hr.fer.oop.lab2.welcomepack.Formation;
import hr.fer.oop.lab2.welcomepack.PlayingPosition;
import hr.fer.oop.lab2.welcomepack.Constants;


/**
 *Class that represents every football player on the team
 * @author Lukas Šestić
 */
public class FootballPlayer extends Person {
    private int playingSkill = Constants.DEFAULT_PLAYING_SKILL;
    private PlayingPosition favouritePosition = Constants.DEFAULT_PLAYING_POSITION;


    /**
     * Constructor for object "FootballPlayer". "FootballPlayer" extends abstract class "Person".
     *
     * @param playingSkill Value that represents players skill
     * @param favForm Enum value of players favourite and go-to position on the field
     * @param name Players name and surname
     * @param country Players country
     * @param emotion Players emotional state
     */
    public FootballPlayer(String name,String country,int emotion,int playingSkill,PlayingPosition favForm){
        super(name,country,emotion);

        if(playingSkill<Constants.MIN_EMOTION || playingSkill>Constants.MAX_EMOTION){
            System.err.println("Skill has to be within the range of [1,100].Setting up default value.");
            this.playingSkill = Constants.DEFAULT_PLAYING_SKILL;
        }
        else
        this.playingSkill = playingSkill;
        if(favForm == null){
            System.err.println("Position can not be null. Setting up default value.");
            this.favouritePosition = PlayingPosition.MF;
        }
        else
        this.favouritePosition = favForm;

    }


    /**
     * Default constructor for object "FootballPlayer". If there are no parameters all values are set to default.
     */
    public FootballPlayer(){
        super(Constants.DEFAULT_PLAYER_NAME,Constants.DEFAULT_COUNTRY,Constants.DEFAULT_EMOTION);
        this.playingSkill = Constants.DEFAULT_PLAYING_SKILL;
        this.favouritePosition = Constants.DEFAULT_PLAYING_POSITION;
    }

    //Setters:

    /**
     * Method for setting(changing) players skill level based on his performance. Has to be within the range of [0,100].
     * @param skill     Value that represents players skill
     */
    public void setPlayingSkill(int skill){
        if(skill<Constants.MIN_PLAYING_SKILL || skill>Constants.MAX_PLAYING_SKILL){
            System.err.println("Skill has to be in the range of [0,100]!");
        }
        else {
            playingSkill = skill;
        }
    }

    /**
     * Method for setting(changing) players favourite position. Has to be within the range of [0,100].
     * @param position
     */
    public void setFavouritePosition(PlayingPosition position){
        favouritePosition = position;
    }

    //Getters:

    /**
     * Method for getting(reading) players skill level.
     * @return Players skill based on his performance in the form of a number within the range of [0,100]
     */
    public int getPlayingSkill(){
        return playingSkill;
    }

    /**
     * Method for getting(reading) players favourite position.
     * @return Enum value "PlayingPosition" of his favourite position
     */
    public PlayingPosition getPlayingPosition(){
        return favouritePosition;
    }

}
