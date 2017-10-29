package hr.fer.oop.lab2;

        import hr.fer.oop.lab2.welcomepack.Constants;
        import hr.fer.oop.lab2.welcomepack.Formation;
        import hr.fer.oop.lab2.welcomepack.ManageableTeam;
        import hr.fer.oop.lab2.welcomepack.SimpleFootballPlayerCollection;

/**
 * Class ClubTeam represents club based football team (eg. FC Barcelona, FC Bayern Munich,...).
 * @author Lukas Šestič
 */
public class ClubTeam extends Team implements ManageableTeam{
    private int reputation = Constants.DEFAULT_REPUTATION;

    /**
     * Constructor for ClubTeam class. ClubTeam extends abstract class Team and implements ManageableTeam interface.
     * @param reputation Value that represents clubs reputation. Value must be within the range of [1,100] or it will automatically
     *                  be set to its default value.
     * @param country Value that represents clubs country of origin
     * @param name Value that represents clubs name
     * @param formation Value that represents clubs default formation
     */
    public ClubTeam(int reputation, String country, String name, Formation formation){
        super(name,formation,Constants.MAX_NO_PLAYERS_NATIONAL);
        if(reputation<Constants.MIN_REPUTATION || reputation>Constants.MAX_REPUTATION){
            System.err.println("Reputation has to be within the range of [1,100]");
        }
        this.reputation = Constants.DEFAULT_REPUTATION;
    }

    /**
     * Default constructor for ClubTeam class. If there are no parameters all values are set to its default value.
     */
    public ClubTeam(){
        super(Constants.DEFAULT_TEAM_NAME,Constants.DEFAULT_FORMATION,Constants.MAX_NO_PLAYERS_NATIONAL);
        this.reputation = Constants.DEFAULT_REPUTATION;
    }


    /**
     * Method for setting(changing) clubs reputation value
     * @param reputation Value that represents new reputation value
     */
    public void setReputation(int reputation){
        if(reputation<Constants.MIN_REPUTATION || reputation>Constants.MAX_REPUTATION){
            System.err.println("Reputation has to be within the range of [1,100]");
            return;
        }
        this.reputation = reputation;
    }

    /**
     * Method for getting(reading) clubs reputation
     * @return Clubs reputation
     */
    public int getReputation(){
        return reputation;
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
        if(registeredPlayers.size()<Constants.MAX_NO_PLAYERS_NATIONAL && player.getPlayingSkill()>=reputation){
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
        return (Constants.SEVENTY_PERCENT * registeredPlayers.calculateSkillSum() + Constants.THIRTY_PERCENT * registeredPlayers.calculateEmotionSum());

    }
}
