package hr.fer.oop.lab2;

import hr.fer.oop.lab2.welcomepack.PlayingPosition;
import hr.fer.oop.lab2.welcomepack.SimpleFootballPlayerCollection;

public class SearchUtil {

    public static SimpleFootballPlayerCollection retrieveAboveMedianSkillPlayers(SimpleFootballPlayerCollection players){
        ResizableSimpleFootballPlayerCollectionImpl aboveMedianPlayers = new ResizableSimpleFootballPlayerCollectionImpl(20);
        FootballPlayer[] allPlayers =  players.getPlayers();
        double medianSkill = players.calculateSkillSum() / players.size();
        int i = 0;
        for (FootballPlayer player1:allPlayers) {
            if(player1 == null){
                break;
            }
            if(player1.getPlayingSkill()>medianSkill){
                aboveMedianPlayers.add(player1);
            }
        }
        return aboveMedianPlayers;
    }

    public static FootballPlayer retrieveLowSkilledPlayer(SimpleFootballPlayerCollection players, PlayingPosition playingPos){
        FootballPlayer[] allPlayers = players.getPlayers();
        int minSkill = 100;
        for (FootballPlayer player1:allPlayers) {
            if(player1 == null){
                break;
            }
            if(player1.getPlayingPosition() == playingPos && player1.getPlayingSkill()<minSkill){
                minSkill = player1.getPlayingSkill();
            }
        }

        for (FootballPlayer player2:allPlayers) {
            if(player2 == null){
                break;
            }
            if(player2.getPlayingSkill() == minSkill){
                return player2;
            }
        }
        //Ako je lista prazna vrača null ili njega po defaultu ako on ima najmanji skill
        return allPlayers[0];
    }

    public static SimpleFootballPlayerCollection retrievePlayingPositionPlayers(SimpleFootballPlayerCollection players, PlayingPosition playingPos){
        ResizableSimpleFootballPlayerCollectionImpl playersOnPosition = new ResizableSimpleFootballPlayerCollectionImpl(20);
        FootballPlayer[] allPlayers = players.getPlayers();
        for (FootballPlayer player3:allPlayers) {
            if(player3 == null){
                break;
            }
            else {
                if(player3.getPlayingPosition() == playingPos){
                    playersOnPosition.add(player3);
                }
            }
        }
        return playersOnPosition;
    }
}
