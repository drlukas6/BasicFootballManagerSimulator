package hr.fer.oop.lab2;

import hr.fer.oop.lab2.welcomepack.SimpleFootballPlayerCollection;

/**
 * Simple array based collection of football players
 * @author Lukas Šestić
 */
public class SimpleFootballPlayerCollectionImpl implements SimpleFootballPlayerCollection {

    private int maxPlayers;
    private FootballPlayer[] footballPlayerList; //= new FootballPlayer[maxPlayers];

    /**
     * Constructor for the array based football player collection.
     * @param maxPlayers represents the maximum number of players possible in collection
     */
    public SimpleFootballPlayerCollectionImpl(int maxPlayers){
        this.maxPlayers = maxPlayers;
        footballPlayerList = new FootballPlayer[maxPlayers];
        //this.footballPlayerList = footballPlayerList;
    }

    @Override
    public int size() {
        int size = 0;
        for(int i=0;i<maxPlayers;i++){
            if(footballPlayerList[i]==null){
                break;
            }
            else size = size + 1;
        }
        return size;
    }

    @Override
    public boolean contains(FootballPlayer player) {
        for(int i=0;i<size();i++){
            if(footballPlayerList[i].getName().equals(player.getName()) && footballPlayerList[i].getCountry().equals(player.getCountry())){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean add(FootballPlayer player) {
        if(size()<maxPlayers && !contains(player)){
            footballPlayerList[size()] = player;
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        for(int i=0;i<maxPlayers;i++){
            footballPlayerList[i] = null;
        }
    }

    @Override
    public int getMaxSize() {
        return maxPlayers;
    }

    @Override
    public int calculateEmotionSum() {
        int sum=0;
        for (FootballPlayer player:footballPlayerList) {
            if(player == null){
                break;
            }
            sum = sum + player.getEmotion();
        }
/*
        for(int i=0;i<size();i++){
            sum = sum + footballPlayerList[i].getEmotion();
        }
*/
        return sum;
    }

    @Override
    public int calculateSkillSum() {
        int sum=0;
        for (FootballPlayer player:footballPlayerList) {
            if(player == null){
                break;
            }
            sum = sum + player.getPlayingSkill();
        }
        /*for(int i=0;i<size();i++){
            sum = sum + footballPlayerList[i].getPlayingSkill();
        }*/
        return sum;
    }

    @Override
    public FootballPlayer[] getPlayers() {
        return footballPlayerList;
    }
}
