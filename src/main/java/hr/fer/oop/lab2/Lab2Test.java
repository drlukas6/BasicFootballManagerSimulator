package hr.fer.oop.lab2;

import hr.fer.oop.lab2.welcomepack.PlayingPosition;
import hr.fer.oop.lab2.SearchUtil;

public class Lab2Test {
    public static void main(String[] args){
        ResizableSimpleFootballPlayerCollectionImpl test = new ResizableSimpleFootballPlayerCollectionImpl(3);
        FootballPlayer LukaModric = new FootballPlayer("Luka Modric","Croatia",70,90, PlayingPosition.FW);
        FootballPlayer Ronaldinho = new FootballPlayer("Ronaldinho","Brazil",80,91,PlayingPosition.FW);
        FootballPlayer Buffon = new FootballPlayer("Buffon","Italy",70,92,PlayingPosition.GK);
        FootballPlayer TitusBramble = new FootballPlayer("Titus Bramble","Ivory Coast",60,40,PlayingPosition.DF);

        test.add(LukaModric);
        System.out.println(test.getMaxSize());
        test.add(Ronaldinho);
        System.out.println(test.getMaxSize());
        test.add(Buffon);
        System.out.println(test.getMaxSize());
        test.add(TitusBramble);
        System.out.println(test.getMaxSize());

        FootballPlayer[] aboveMed = SearchUtil.retrieveAboveMedianSkillPlayers(test).getPlayers();
        for (FootballPlayer player:aboveMed) {
            if(player == null){
                break;
            }
            System.out.println(player.getName());
        }

        FootballPlayer worstPlayer = SearchUtil.retrieveLowSkilledPlayer(test,PlayingPosition.DF);
        System.out.println(worstPlayer.getName());

        FootballPlayer[] allOnPosition = SearchUtil.retrievePlayingPositionPlayers(test,PlayingPosition.DF).getPlayers();
        for (FootballPlayer player:allOnPosition) {
            if(player == null){
                break;
            }
            System.out.println("Player on position selected position is: " + player.getName());
        }
    }
}
