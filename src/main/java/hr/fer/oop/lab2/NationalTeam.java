package hr.fer.oop.lab2;

import hr.fer.oop.lab2.welcomepack.Constants;
import hr.fer.oop.lab2.welcomepack.Formation;
import hr.fer.oop.lab2.welcomepack.ManageableTeam;
import hr.fer.oop.lab2.welcomepack.SimpleFootballPlayerCollection;


/**
 * Class NationalTeam represents one countries football team(eg. Croatia, Brazil,...).
 * @author Lukas Šestić
 */
public class NationalTeam extends Team implements ManageableTeam {
    private String country = Constants.DEFAULT_COUNTRY;


    /**
     * Constructor for NationalTeam class. NationalTeam extends abstract class Team and implements ManageableTeam interface.
     * @param country Value that represents teams country
     * @param formation Value that represents teams formation
     * @param name Value that represents teams name
     */
    public NationalTeam(String country, Formation formation,String name){
        super(name,formation,Constants.MAX_NO_PLAYERS_NATIONAL);
        this.country = country;
    }


    /**
     * Default constructor for NationalTeam. If there are no parameters then everything will be set to default values
     */
    public NationalTeam(){
        super(Constants.DEFAULT_TEAM_NAME,Constants.DEFAULT_FORMATION,Constants.MAX_NO_PLAYERS_NATIONAL);
        this.country = Constants.DEFAULT_COUNTRY;
    }

    @Override
    public boolean addPlayerToStartingEleven(FootballPlayer player) {
        if(isPlayerRegistered(player) && startingEleven.size()<11){
            startingEleven.getPlayers()[startingEleven.size()] = player;
            return true;
        }
        return false;
    }

    @Override
    public boolean isPlayerRegistered(FootballPlayer player) {
        if(registeredPlayers.contains(player)){
            return true;
        }
        return false;
    }

    @Override
    public SimpleFootballPlayerCollection getRegisteredPlayers() {
        return registeredPlayers;
    }

    @Override
    public SimpleFootballPlayerCollection getStartingEleven() {
        return startingEleven;
    }

    @Override
    public boolean registerPlayer(FootballPlayer player) {
        if(registeredPlayers.size()<Constants.MAX_NO_PLAYERS_NATIONAL && player.getCountry().equals(country)){
            registeredPlayers.getPlayers()[registeredPlayers.size()] = player;
            return true;
        }
        return false;
    }

    @Override
    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    @Override
    public Formation getFormation() {
        return formation;
    }

    @Override
    public void clearStartingEleven() {
        startingEleven.clear();
    }

    @Override
    public double calculateRating() {
        return (Constants.THIRTY_PERCENT * registeredPlayers.calculateSkillSum() + Constants.SEVENTY_PERCENT * registeredPlayers.calculateEmotionSum());
    }
}
