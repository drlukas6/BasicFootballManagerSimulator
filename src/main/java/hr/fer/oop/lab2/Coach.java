package hr.fer.oop.lab2;

import hr.fer.oop.lab2.welcomepack.*;

/**
 * Class that represents all coaches of the football team.
 * @author Lukas Šestić
 */
public class Coach extends Person implements Manager {
    private int coachingSkill = Constants.DEFAULT_COACHING_SKILL;
    private Formation favouriteFormation = Constants.DEFAULT_FORMATION;
    private ManageableTeam managingTeam;
    private ManageableTeam managingTeam2;


    /**
     * Constructor for object "Coach". "Coach" extends abstract class "Person".
     *
     * @param coachingSkill Value that represents coaches skill in managing players
     * @param favouriteFormation Value that represents coaches favourite and go-to formation
     * @param name Coaches name and surname
     * @param country Coaches country
     * @param emotion Coaches emotional state
     */
    public Coach(String name,String country,int coachingSkill,int emotion,Formation favouriteFormation){
        super(name,country,emotion);
        if(name == null){
            System.err.println("Name is not valid. Setting up default value.");

        }


        if(coachingSkill<Constants.MIN_EMOTION || coachingSkill>Constants.MAX_EMOTION){
            System.err.println("Skill has to be within the range of [1,100].Setting up default value.");
            this.coachingSkill = Constants.DEFAULT_PLAYING_SKILL;
        }
        else
            this.coachingSkill = coachingSkill;
        if(favouriteFormation == null){
            System.err.println("Position can not be null. Setting up default value.");
            this.favouriteFormation = Formation.F442;
        }
        else
            this.favouriteFormation = favouriteFormation;
    }


    /**
     * Default constructor for object "Coach". If there are no parameters all values are set to default.
     */
    public Coach(){
        super(Constants.DEFAULT_PLAYER_NAME,Constants.DEFAULT_COUNTRY,Constants.DEFAULT_EMOTION);
        this.coachingSkill = Constants.DEFAULT_COACHING_SKILL;
        this.favouriteFormation = Constants.DEFAULT_FORMATION;
    }




    //Setters

    /**
     * Method for setting(changing) coaches skill based on his performance. Has to be within the range of [0,100].
     * @param skill Value that represents coaches skill in managing players
     */
    public void setCoachingSkill(int skill){
        if(skill<Constants.MIN_COACHING_SKILL || skill>Constants.MAX_COACHING_SKILL){
            System.err.println("Skill has to be in the range of [0,100]!");
        }
        else {
            coachingSkill = skill;
        }
    }

    /**
     * Method for setting(changing) coaches favourite position.
     * @param form Enum value that enables us to choose only from a limited amount of formations
     */
    public void setPosition(Formation form){
        favouriteFormation = form;
    }

    //Getters:

    /**
     * Method for getting(reading) coaches skill.
     * @return Coaches skill based on his performance in the form of a number within the range of [0,100]
     */
    public int getCoachingSkill(){
        return coachingSkill;
    }

    /**
     * Method for getting(reading) coaches favourite formation.
     * @return Enum value "Formaton" of his favourite formation
     */
    public Formation getFavouriteFormation(){
        return favouriteFormation;
    }


    @Override
    public void pickStartingEleven() {
        int def=0,mid=0,fw=0,gk=0;
        switch(managingTeam.getFormation()){
            case F352:
                for (FootballPlayer player:managingTeam.getRegisteredPlayers().getPlayers()) {
                    if(player == null){
                        break;
                    }
                    if(player.getPlayingPosition() == PlayingPosition.DF){
                        if(def<3){
                            managingTeam.getStartingEleven().add(player);
                            def = def+1;
                        }
                    }
                    else if (player.getPlayingPosition() == PlayingPosition.MF){
                        if(mid<5){
                            managingTeam.getStartingEleven().add(player);
                            mid = mid+1;
                        }
                    }
                    else if (player.getPlayingPosition() == PlayingPosition.FW){
                        if(fw<2){
                            managingTeam.getStartingEleven().add(player);
                            fw = fw+1;
                        }
                    }
                    else if(player.getPlayingPosition() == PlayingPosition.GK){
                        if(gk<1){
                            managingTeam.getStartingEleven().add(player);
                        }
                    }
                }
                break;
            case F442:
                for (FootballPlayer player:managingTeam.getRegisteredPlayers().getPlayers()) {
                    if(player == null){
                        break;
                    }
                    if(player.getPlayingPosition() == PlayingPosition.DF){
                        if(def<4){
                            managingTeam.getStartingEleven().add(player);
                            def = def+1;
                        }
                    }
                    else if (player.getPlayingPosition() == PlayingPosition.MF){
                        if(mid<4){
                            managingTeam.getStartingEleven().add(player);
                            mid = mid+1;
                        }
                    }
                    else if (player.getPlayingPosition() == PlayingPosition.FW){
                        if(fw<2){
                            managingTeam.getStartingEleven().add(player);
                            fw = fw+1;
                        }
                    }
                    else if(player.getPlayingPosition() == PlayingPosition.GK){
                        if(gk<1){
                            managingTeam.getStartingEleven().add(player);
                        }
                    }
                }
                break;

            case F541:
                for (FootballPlayer player:managingTeam.getRegisteredPlayers().getPlayers()) {
                    if(player == null){
                        break;
                    }
                    if(player.getPlayingPosition() == PlayingPosition.DF){
                        if(def<5){
                            managingTeam.getStartingEleven().add(player);
                            def = def+1;
                        }
                    }
                    else if (player.getPlayingPosition() == PlayingPosition.MF){
                        if(mid<4){
                            managingTeam.getStartingEleven().add(player);
                            mid = mid+1;
                        }
                    }
                    else if (player.getPlayingPosition() == PlayingPosition.FW){
                        if(fw<1){
                            managingTeam.getStartingEleven().add(player);
                            fw = fw+1;
                        }
                    }
                    else if(player.getPlayingPosition() == PlayingPosition.GK){
                        if(gk<1){
                            managingTeam.getStartingEleven().add(player);
                        }
                    }
                }
                break;
        }
    }

    @Override
    public void forceMyFormation() {
        managingTeam.setFormation(favouriteFormation);
    }

    @Override
    public void setManagingTeam(ManageableTeam team) {
        this.managingTeam = team;
    }
}
