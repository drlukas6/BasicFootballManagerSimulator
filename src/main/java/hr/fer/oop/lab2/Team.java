package hr.fer.oop.lab2;

import hr.fer.oop.lab2.welcomepack.Constants;
import hr.fer.oop.lab2.welcomepack.Formation;

/**
 * Class that represents base of all football teams.
 * @author Lukas Šestić
 */
public abstract class Team {
    private String name = Constants.DEFAULT_TEAM_NAME;
    protected Formation formation = Constants.DEFAULT_FORMATION;
    protected SimpleFootballPlayerCollectionImpl registeredPlayers;
    protected SimpleFootballPlayerCollectionImpl startingEleven;


    /**
     * Constructor for abstract class team inherited by both National and Club team.
     * @param teamName Value that represents the name of the team
     * @param formation Value that represents teams playing formation
     * @param maxRegisteredPlayers
     */
    public Team(String teamName, Formation formation, int maxRegisteredPlayers){
        this.name = teamName;
        this.formation = formation;
        registeredPlayers = new SimpleFootballPlayerCollectionImpl(maxRegisteredPlayers);
        startingEleven = new SimpleFootballPlayerCollectionImpl(Constants.STARTING_ELEVEN_SIZE);
    }



}
